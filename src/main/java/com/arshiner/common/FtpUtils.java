package com.arshiner.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Comparator;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;


/**
 * FTP上传修改删除文件的API
 * 
 * @author 士林
 *
 */
public class FtpUtils {
	private FTPClient ftpClient = null;
	// ftp服务器地址
	private String hostname = "192.168.8.138";
	// ftp服务器端口号默认为21
	private Integer port = 21;
	// ftp登录账号
	private String username = "admin";
	// ftp登录密码
	private String password = "welcome";
	// ftp上传路径
	private String ftpDir = "FTP";
	// 已上传的文件转移的目录
	private String diduploadPath = "";

	public enum FTPStatus {
		File_Exits(0), Create_Directory_Success(1), Create_Directory_Fail(2), Upload_From_Break_Success(
				3), Upload_From_Break_Faild(4), Download_From_Break_Success(
						5), Download_From_Break_Faild(6), Upload_New_File_Success(7), Upload_New_File_Failed(
								8), Delete_Remote_Success(9), Delete_Remote_Faild(10), Remote_Bigger_Local(
										11), Remote_smaller_local(12), Not_Exist_File(13), Remote_Rename_Success(
												14), Remote_Rename_Faild(15), File_Not_Unique(16);

		private int status;

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		FTPStatus(int status) {
			this.status = status;
		}
	}

	/**
	 * //按生成日期排序并遍历，
	 * 
	 * @param fliePath
	 *            文件目录
	 * @throws IOException
	 */
	public void orderByDate(String fliePath, String model) throws IOException {
		File file = new File(fliePath);
		File[] fs = file.listFiles();
		Arrays.sort(fs, new Comparator<File>() {
			public int compare(File f1, File f2) {
				long diff = f1.lastModified() - f2.lastModified();
				if (diff > 0)
					return -1;
				else if (diff == 0)
					return 0;
				else
					return 1;
			}

			public boolean equals(Object obj) {
				return true;
			}
		});
		for (int i = fs.length - 1; i > -1; i--) {
			System.out.println(fs[i].getName());
			// 上传文件
			uploadFile(ftpDir, fs[i].getName(), fs[i].getAbsolutePath());
			// 上传成功
			if (model.equals("cl")) {

			} else {

			}
			// 将文件移动到已上传的目录
			File file1 = new File(diduploadPath + "\\" + fs[i].getName());
			if (file1.exists()) {
				file1.delete();
			}
			fs[i].renameTo(file1);
		}
	}

	/**
	 * //按生成日期排序并遍历，
	 * 
	 * @param fliePath
	 *            文件目录
	 * @throws IOException
	 */
	public void orderByDate(String fliePath) throws IOException {
		File file = new File(fliePath);
		File[] fs = file.listFiles();
		Arrays.sort(fs, new Comparator<File>() {
			public int compare(File f1, File f2) {
				long diff = f1.lastModified() - f2.lastModified();
				if (diff > 0)
					return -1;
				else if (diff == 0)
					return 0;
				else
					return 1;
			}

			public boolean equals(Object obj) {
				return true;
			}
		});
		for (int i = fs.length - 1; i > -1; i--) {
			System.out.println(fs[i].getName());
			// 上传文件
			uploadFile(ftpDir, fs[i].getName(), fs[i].getAbsolutePath());
			// 上传成功
			// 将文件移动到已上传的目录
			File file1 = new File(diduploadPath + "\\" + fs[i].getName());
			if (file1.exists()) {
				file1.delete();
			}
			fs[i].renameTo(file1);
		}
	}

	/**
	 * 上传文件BINARY_FILE_TYPE 二进制形式上传,必须是二进制上传，否则文件易损坏
	 * 
	 * @param pathname
	 *            ftp服务保存地址
	 * @param fileName
	 *            上传到ftp的文件名
	 * @param originfilename
	 *            待上传文件的名称（绝对地址） *
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	public boolean uploadFile(String pathname, String fileName, String originfilename) throws IOException {
		boolean flag = false;
		InputStream inputStream = null;
		System.out.println("开始上传文件");
		File file = new File(originfilename);
		inputStream = new FileInputStream(file);
		ftpClient.setFileType(ftpClient.BINARY_FILE_TYPE);
		CreateDirecroty(pathname);
		ftpClient.changeWorkingDirectory(pathname);
		ftpClient.storeFile(fileName + ".tmp", inputStream);
		inputStream.close();
		ftpClient.rename(fileName + ".tmp", fileName);
		ftpClient.logout();
		flag = true;
		System.out.println("上传文件成功");
		if (ftpClient.isConnected()) {
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (null != inputStream) {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	@SuppressWarnings("static-access")
	public boolean uploadFile1(String pathname, String fileName, String originfilename) {
		boolean flag = false;
		InputStream inputStream = null;
		try {
			System.out.println("开始上传文件");
			inputStream = new FileInputStream(new File(originfilename));
			ftpClient.setFileType(ftpClient.BINARY_FILE_TYPE);
			CreateDirecroty(pathname);
			ftpClient.changeWorkingDirectory(pathname);
			ftpClient.storeFile(fileName + ".tmp", inputStream);
			inputStream.close();
			ftpClient.rename(fileName + ".tmp", fileName);
			ftpClient.logout();
			flag = true;
			System.out.println("上传文件成功");
		} catch (Exception e) {
			System.out.println("上传文件失败");
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != inputStream) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	public void logout() throws IOException {
		if (ftpClient.isConnected()) {
			ftpClient.logout();
			ftpClient.disconnect();
		}
	}

	// 改变目录路径
	public boolean changeWorkingDirectory(String directory) {
		boolean flag = true;
		try {
			flag = ftpClient.changeWorkingDirectory(directory);
			if (flag) {
				System.out.println("进入文件夹" + directory + " 成功！");

			} else {
				System.out.println("进入文件夹" + directory + " 失败！开始创建文件夹");
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return flag;
	}

	// 创建多层目录文件，如果有ftp服务器已存在该文件，则不创建，如果无，则创建
	public boolean CreateDirecroty(String remote) throws IOException {
		boolean success = true;
		String directory = remote + "/";
		// 如果远程目录不存在，则递归创建远程服务器目录
		if (!directory.equalsIgnoreCase("/") && !changeWorkingDirectory(new String(directory))) {
			int start = 0;
			int end = 0;
			if (directory.startsWith("/")) {
				start = 1;
			} else {
				start = 0;
			}
			end = directory.indexOf("/", start);
			String path = "";
			String paths = "";
			while (true) {
				String subDirectory = new String(remote.substring(start, end).getBytes("GBK"), "iso-8859-1");
				path = path + "/" + subDirectory;
				if (!existFile(path)) {
					if (makeDirectory(subDirectory)) {
						changeWorkingDirectory(subDirectory);
					} else {
						System.out.println("创建目录[" + subDirectory + "]失败");
						changeWorkingDirectory(subDirectory);
					}
				} else {
					changeWorkingDirectory(subDirectory);
				}

				paths = paths + "/" + subDirectory;
				start = end + 1;
				end = directory.indexOf("/", start);
				// 检查所有目录是否创建完毕
				if (end <= start) {
					break;
				}
			}
		}
		return success;
	}

	// 判断ftp服务器文件是否存在
	public boolean existFile(String path) throws IOException {
		boolean flag = false;
		System.out.println("existFile" + path);
		FTPFile[] ftpFileArr = ftpClient.listFiles(path);
		if (ftpFileArr.length > 0) {
			flag = true;
		}
		return flag;
	}

	// 创建目录
	public boolean makeDirectory(String dir) {
		boolean flag = true;
		try {
			flag = ftpClient.makeDirectory(dir);
			if (flag) {
				System.out.println("创建文件夹" + dir + " 成功！");

			} else {
				System.out.println("创建文件夹" + dir + " 失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * * 下载文件 *
	 * 
	 * @param pathname
	 *            FTP服务器文件目录 *
	 * @param filename
	 *            文件名称 *
	 * @param localpath
	 *            下载后的文件路径 *
	 * @return
	 */
	public boolean downloadFile(String pathname, String filename, String localpath) {
		boolean flag = false;
		OutputStream os = null;
		try {
			System.out.println("开始下载文件");
			initFtpClient();
			// 切换FTP目录
			ftpClient.changeWorkingDirectory(pathname);
			FTPFile[] ftpFiles = ftpClient.listFiles();
			for (FTPFile file : ftpFiles) {
				if (filename.equalsIgnoreCase(file.getName())) {
					File localFile = new File(localpath + "/" + file.getName());
					os = new FileOutputStream(localFile);
					ftpClient.retrieveFile(file.getName(), os);
					os.close();
				}
			}
			ftpClient.logout();
			flag = true;
			System.out.println("下载文件成功");
		} catch (Exception e) {
			System.out.println("下载文件失败");
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != os) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	/**
	 * * 删除文件 *
	 * 
	 * @param pathname
	 *            FTP服务器保存目录 *
	 * @param filename
	 *            要删除的文件名称 *
	 * @return
	 */
	public boolean deleteFile(String pathname, String filename) {
		boolean flag = false;
		try {
			System.out.println("开始删除文件");
			initFtpClient();
			// 切换FTP目录
			ftpClient.changeWorkingDirectory(pathname);
			ftpClient.dele(filename);
			ftpClient.logout();
			flag = true;
			System.out.println("删除文件成功");
		} catch (Exception e) {
			System.out.println("删除文件失败");
			e.printStackTrace();
		} finally {
			if (ftpClient.isConnected()) {
				try {
					ftpClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}

	/**
	 * 遍历所要上传的文件夹
	 * 
	 * @param path
	 */
	public static void traverseFolder2(String path) {

		File file = new File(path);
		if (file.exists()) {
			File[] files = file.listFiles();
			if (null == files || files.length == 0) {
				System.out.println("文件夹是空的!");
				return;
			} else {
				for (File file2 : files) {
					if (file2.isDirectory()) {
						System.out.println("文件夹:" + file2.getAbsolutePath());
						traverseFolder2(file2.getAbsolutePath());
					} else {
						System.out.println("文件:" + file2.getAbsolutePath());
					}
				}
			}
		} else {
			System.out.println("文件不存在!");
		}
	}


	public static void main(String[] args) throws IOException {
		FtpUtils ftp = new FtpUtils();
		ftp.setHostname("10.2.42.94");
		ftp.setPassword("ftpuser");
		ftp.setPort(21);
		ftp.setUsername("ftpuser");
		System.out.println(ftp.initFtpClient());
	}

	public String getDiduploadPath() {
		return diduploadPath;
	}

	public void setDiduploadPath(String diduploadPath) {
		this.diduploadPath = diduploadPath;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFtpDir() {
		return ftpDir;
	}

	public void setFtpDir(String ftpDir) {
		this.ftpDir = ftpDir;
	}

	/**
	 * 初始化ftp服务器
	 * 
	 * @throws IOException
	 * @throws SocketException
	 */
	public boolean initFtpClient() {
		ftpClient = new FTPClient();
		ftpClient.setConnectTimeout(400);;
		ftpClient.setControlEncoding("utf-8");
		try {
			ftpClient.connect(hostname, port);
			ftpClient.login(username, password); // 登录ftp服务器
			int replyCode = ftpClient.getReplyCode(); // 是否成功登录服务器
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				System.out.println("connect failed...ftp服务器:" + this.hostname + ":" + this.port);
				return false;
			} else {
				System.out.println("connect successfu...ftp服务器:" + this.hostname + ":" + this.port);
				return true;
			}
		} catch (IOException e) {
			return false;
		} 
	}

	public FTPClient getFtpClient() {
		return ftpClient;
	}

	public void setFtpClient(FTPClient ftpClient) {
		this.ftpClient = ftpClient;
	}
	
	
}
