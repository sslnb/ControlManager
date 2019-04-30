package com.arshiner;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException{
		//如果session参数不为空，说明已经登录，拥有权限，返回true继续访问。
//		if(request.getSession().getAttribute("session参数")!=null){
//			return true;
//		}
//		//如果session参数为空，说明没有登录，返回false,可配置重定向跳转到登录页面
//		response.sendRedirect("/");
		return false;
	}
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,ModelAndView modelAndView){
		System.out.println("在请求不报异常，顺利完成后执行");
	}
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex){
		System.out.println("无论请求是否异常，最后都会执行。用于清理资源，关闭连接等");
	}
}


///**
// * 删除
// */
//public void removeFile(){
//	//如果磁盘使用率高于80%
//	File  file = new File(FilePathName.ROOT);
//	if (Math.ceil((file.getTotalSpace()-file.getFreeSpace())*100/file.getTotalSpace())>70.0) {
//		dbConpro = dbconProService.selectByExample();
//		// 遍历
//		if (dbConpro.isEmpty()) {
//			logger.info("没有连接参数-----size"+dbConpro.size());
//			return;
//		}
//		for (Dbconpro dbconpro2 : dbConpro) {
//			StringBuffer buffer = new StringBuffer(FilePathName.ROOT);// 项目上级目录
//			buffer.append(dbconpro2.getJgxtlb());// 节点目录 /jgxtlb
//			buffer.append(FilePathName.FileSepeartor);
//			/**
//			 * 已入库删除
//			 */
//			String cldid = buffer.toString() + FilePathName.CLDIDPath+ FilePathName.FileSepeartor;
//			remove(cldid);
//			String zldid = buffer.toString() + FilePathName.ZLDIDPath+ FilePathName.FileSepeartor;
//			remove(zldid);
//			Agent asd = new Agent();
//			asd.setJgxtlb(dbconpro2.getJgxtlb());
//			agent = agentService.selectByExample(asd);
//			if (agent.isEmpty()) {
//				logger.info("没有agent连接-----size"+agent.size());
//				continue;
//			}
//			/**
//			 * 归档删除
//			 */
//			for (Iterator<Agent> iterator = agent.iterator(); iterator.hasNext();) {
//				Agent agent2 = (Agent) iterator.next();
//				String jd = buffer.toString() + agent2.getKip() + FilePathName.FileSepeartor;
//				String GD= jd + "log" + FilePathName.FileSepeartor;
//				remove(GD);
//			}
//		}
//	}else{
//		logger.info("硬盘空间充足状态良好！！！！！---------:{}" + sdf.format(getTime()));
//	};
//}
//public void remove(String filepath){
//	List<File> files = Arrays.asList(new File(filepath).listFiles());
//	Collections.sort(files, new Comparator<File>() {
//		@Override
//		public int compare(File o1, File o2) {
//			long diff = o1.lastModified()- o2.lastModified();
//			if (diff>0) {
//				return 1;
//			}else if (diff==0) {
//				return 0;
//			}else{
//				return -1;
//			}
//		}
//	});
//	for (int i = 0; i < files.size()-10; i++) {
//		FilePathName.deleteFile(files.get(i).getAbsolutePath());
//	}
//}