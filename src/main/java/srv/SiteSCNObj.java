/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package srv;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import static srv.LogToOraRecord.curscn;

/**
 * 2019-2-22 为了将日志文件中的事务按SCN排序（RAC，每个SCN为一个事务），特此将site封装为对象
 * LogToOraRecord类中的getNexeOraRecord循环调用时，会遍历所有站点的getSiteElement
 * SiteSCNObj对象中包含各自站点关于日志文件（xml）的遍历器，当前scn元素等 在rac环境下，每次获取下一个要输出的事务，必须满足两个条件：
 * 1、每个站点中都有大于当前scn的日志数据 2、找到最小的scn（且大于当前scn）
 * 
 * @author William
 * 
 *         注意！！！！！！！日志文件扩展名是xml！！！！！！不对的话要改！！！！！！！！
 */

public class SiteSCNObj {
	private static final Logger logger = Logger.getLogger(SiteSCNObj.class);
	private int isite = 0; // 站点号
	private String sitescn = ""; // 站点遍历到的当前scn
	private Iterator scniterator = null; // scn遍历器
	private Element scnelement = null; // 当前scn节点元素
	private String curfile = ""; // 当前装载的文件
	private String deletescn = "";
	// static
	List<List> sitefilelist = new ArrayList<List>(); // 站点日志文件列表，列表排序后缓存起来，减少排序开销
	private String sdir = ""; // 日志目录，每个站点可以不同

	// 构造函数，通过方法设置当前文件和遍历器等
	public SiteSCNObj(int site, String scn, String dir) {
		this.isite = site;
		this.sdir = dir;
		this.deletescn = scn;
		for (int i = 0; i <= site; i++) {
			sitefilelist.add(null); // 给每个站点添加list
		}
	}

	// 获取站点的遍历器
	public Iterator getSiteIterator() {
		return scniterator;
	}

	// 获取站点的SCN元素
	public Element getSiteElement() {
		return scnelement;
	}

	// 获取站点的当前scn
	public String getSiteSCN() {
		return sitescn;
	}

	// 获取站点的下一个scn元素
	// 调用取下一个元素是时，无需考虑遍历器是否存在，无需考虑日志文件列表是否获取，无需考虑日志文件是否合法
	// 调用成功时，遍历器可用，当前scn可用
	public Element getSiteNextElement() {
		String sfile = "";
		scnelement = null;
		sitescn = "";
		if (null == scniterator) {
			// 没有xml遍历器，则重新装载文件，以期获得遍历器
			sfile = getSiteNextFile(isite);
			if (!"".equals(sfile)) {
				if (null != setSiteFile(sfile)) {
					scnelement = (Element) scniterator.next();
					sitescn = scnelement.elementText("ID");
				}
			}
		} else if (scniterator.hasNext()) {
			scnelement = (Element) scniterator.next();
			sitescn = scnelement.elementText("ID");
		} else { // 没有下一个了的时候，需要自动切换到下一个文件
			// 装载下一个文件，以期获得遍历器
			sfile = getSiteNextFile(isite);
			if (!"".equals(sfile)) {
				if (null != setSiteFile(sfile)) {
					scnelement = (Element) scniterator.next();
					sitescn = scnelement.elementText("ID");
				}
			}
		}
		return scnelement;
	}

	// 获取当前站点装载的文件
	public String getSiteFile() {
		return this.curfile;
	}

	// 设置当前站点文件，设置站点文件后，不取下一个scn元素，避免循环多跳一个
	public Iterator setSiteFile(String sfile) {
		// 参数合法性校验
		if ("".equals(sfile)) {
			return null;
		}
		this.curfile = sfile;
		File xmlfile = new File(sdir + File.separator + sfile);
		if (!xmlfile.exists()) {
			return null;
		}
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(xmlfile);
			Element rootelement = doc.getRootElement();
			if (rootelement.elementIterator("SCN").hasNext()) {
				scniterator = rootelement.elementIterator("SCN");
			} else {
				scniterator = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("SiteSCNObj----文件格式异常" + e);
			scniterator = null;
			return null;
		}
		return scniterator;
	}

	// 过滤文件，以站点为首字母，以xml为文件扩展名
	private class FileNameSelector implements FilenameFilter {

		String extension = ".";
		String firstchr = "";

		public FileNameSelector(String fileExtensionNoDot, String sFirstChr) {
			extension += fileExtensionNoDot;
			firstchr = sFirstChr;
		}

		@Override
		public boolean accept(File dir, String name) {
			return ((name.endsWith(extension)) && (name.startsWith(firstchr)));
		}
	}

	// 从站点list中获取下一个日志文件，若没有，则
	public String getSiteNextFile(int site) {
		String sfile = "";
		// 没有列表
		if (null == sitefilelist.get(site)) {
			sfile = getSiteFileList(site);
		}
		// 有列表则在列表中找下一个
		if (null == sitefilelist.get(site)) {
			return "";
		}
		if (!curfile.equals("")) {
			if (sitefilelist.get(site).size() > sitefilelist.get(site).indexOf(curfile) + 1) {
				sfile = sitefilelist.get(site).get(sitefilelist.get(site).indexOf(curfile) + 1).toString();
			} else {
				sfile = getSiteFileList(site);
			}
		} else {
			logger.info(sfile + "----============555555=======------------------------" + curfile);
		}
		return sfile;
	}

	public boolean jiaoyan(String filepath) {
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(filepath);
			Element e = doc.getRootElement();
			if (e.elementIterator().hasNext()) {
				return true;
			} else {
				deleteFile(filepath);
				return false;
			}
		} catch (DocumentException e) {
			logger.info("异常文件----------"+filepath);
			return false;
		}
	}

	// 根据站点及当前scn号,定位当前需要装载的文件及下一个文件
	// 同时可获取过时的文件并删除之
	// 若能在sitefilelist中找到需要的文件,则不重新更新列表sitefilelist,避免重复更新
	public String getSiteFileList(int index) {
		String currentfile = "";
		String nextfile = "";
		String ssite = "";
		int j = 0;
		if (0 > index) {
			return "";
		} else {
			ssite = (char) (index + 65) + ""; // ABCDEFGH
		}

		// 如果sitefilelist为空，那么需要重新读取sitefilelist
		if (null == sitefilelist.get(index)) {
			logger.info("Site[" + index + "] log pool is empty, getting file list...");
			List<File> files = Arrays.asList(new File(sdir).listFiles(new FileNameSelector("log", ssite)));
			Collections.sort(files, new Comparator<File>() {
				@Override
				public int compare(File o1, File o2) {
					if (o1.isDirectory() && o2.isFile()) {
						return -1;
					}
					if (o1.isFile() && o2.isDirectory()) {
						return 1;
					}
					return o1.getName().compareTo(o2.getName());
				}
			});
			if (0 == files.size()) {
				logger.info("==========------------No file!");
				sitefilelist.set(index, null);
				return "";
			} else {
				List<String> lfile = new ArrayList<String>();
				for (int i = 0; i < files.size(); i++) {
					if (jiaoyan(files.get(i).getAbsolutePath())) {
						lfile.add(files.get(i).getName());
						if (files.get(i).getName().compareTo(ssite + curscn + ".log") < 0) {
							j++;
						}
					}
				}
				sitefilelist.set(index, lfile);
			}
		}
		for (int i = 0; i < j - 3; i++) {
			if (sitefilelist.get(index).get(i).toString().compareTo(ssite + deletescn + ".log") < 0) {
				deleteFile(sdir + File.separator + sitefilelist.get(index).get(i).toString());
				logger.info("删除文件----------delete--------" + sitefilelist.get(index).get(i).toString());
			} else {
				break;
			}
		}

		// 获得了列表之后，根据scn定位文件
		for (int i = 0; i < sitefilelist.get(index).size(); i++) {
			if ((sitefilelist.get(index).get(i).toString().compareTo(ssite + curscn + ".log") > 0)
					&& ("".equals(currentfile))) {
				if (0 < i) {
					currentfile = sitefilelist.get(index).get(i - 1).toString();
					nextfile = sitefilelist.get(index).get(i).toString();
				} else {
					currentfile = sitefilelist.get(index).get(i).toString();
					if (1 < (sitefilelist.get(index).size())) {
					} else {
						nextfile = "";
						break;
					}
				}
				continue;
			}

			// 现在文件list长度
			if (!"".equals(currentfile)) {
				nextfile = nextfile + sitefilelist.get(index).get(i).toString();
				// 最多给出20个文件(每个文件名长度为20)
				if (50 * 20 < nextfile.length()) {
					break;
				}
			}
		}
		// 如果找不到当前文件了,则置列表为空,以便下次能重新更新列表
		if ("".equals(currentfile)) {
			System.out.println("Site[" + index + "] log pool is empty.");
			if (sitefilelist.get(index).size()!=0) {
				currentfile = sitefilelist.get(index).get(sitefilelist.get(index).size() - 1).toString();
			}
			sitefilelist.set(index, null);
		}
		return currentfile; // + nextfile;
	}

	public static boolean deleteFile(String sPath) {
		boolean flag = false;
		File file = new File(sPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = true;
		}
		return flag;
	}

}
