package com.arshiner.controller;

import com.alibaba.fastjson.JSONArray;
import com.arshiner.common.FtpUtils;
import com.arshiner.common.JDBCUtil;
import com.arshiner.common.RdsStatus;
import com.arshiner.common.TestRestSafeOutAccess;
import com.arshiner.model.Agent;
import com.arshiner.model.Dbconpro;
import com.arshiner.model.Rzcjqjcs;
import com.arshiner.service.AgentService;
import com.arshiner.service.DbconProService;
import com.arshiner.service.RzcjqjcsService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
* 目标数据库
* @author MDK
* */
@Controller
@RequestMapping(value = "/dbconProController")
public class DbconProController {

	/**
	 * 目标数据库和FTP配置服务层119033
	 */
	@Autowired
	private DbconProService dbconProService;
	@Autowired
	AgentService agentService;
	@Autowired
	RzcjqjcsService rzcjqjcsService;

	// 查询所有连接信息，，并且获取目标数据库连接状态
	@ResponseBody
	@RequestMapping(value = "/list", produces = "text/plain;charset=utf-8")
	public Object selAllAimsData(@RequestParam("page") String page1, @RequestParam("limit") String limit1) {
		HashMap<String, Object> dbconproMap = new HashMap<String, Object>();
		int page = Integer.valueOf(page1);
		int limit = Integer.valueOf(limit1);
		int before = limit * (page - 1) + 1;
		int after = page * limit;
		List<Dbconpro> dbconprolist = dbconProService.selAimsData(before, after);
		for (int i = 0; i < dbconprolist.size(); i++) {
			Dbconpro dbconpro = dbconprolist.get(i);
			JDBCUtil jdbc = new JDBCUtil(dbconpro.getUsername(), dbconpro.getPassword(), dbconpro.getIp(),
					dbconpro.getPort(), dbconpro.getSid());
			boolean flag = jdbc.getConnection();
			if (flag) {
				dbconpro.setSyljas("连接正常");
				jdbc.closeDB();
			} else {
				dbconpro.setSyljas("连接失败");
			}
		}
		dbconproMap.put("code", 0);
		dbconproMap.put("msg", "");
		dbconproMap.put("count", dbconProService.countAimsData());
		Object obj = JSONArray.toJSON(dbconprolist);
		dbconproMap.put("data", obj);
		return JSONArray.toJSONString(dbconproMap);
	}

	// 添加连接信息，页面上需要说明添加失败原因，，jdbc连接，插入失败
	@ResponseBody
	@RequestMapping(value = "/insAimsData")
	public Object insAimsData(Dbconpro dbconpro) {
		HashMap<String, Object> dbConMap = new HashMap<String, Object>();
		JDBCUtil jdbc = new JDBCUtil(dbconpro.getUsername(), dbconpro.getPassword(), dbconpro.getIp(),
				dbconpro.getPort(), dbconpro.getSid());
		// 连接成功
		boolean flag = jdbc.getConnection();
		int pd = 0;
		if (flag) {
			jdbc.closeDB();
			pd = dbconProService.insAimsData(dbconpro);
//			Agent  agent = new Agent();
//			agent.setJgxtlb(dbconpro.getJgxtlb());
//			List<Agent> agentlist = agentService.selectByExample(agent);
//			String jd = FilePathName.ROOT+dbconpro.getJgxtlb()+FilePathName.FileSepeartor;
//			 for (Iterator<Agent> iterator = agentlist.iterator(); iterator.hasNext();) {
//				Agent agent1 = (Agent) iterator.next();
//				jd = jd + agent1.getKip() + FilePathName.FileSepeartor;
//				File alivedb = new File(jd + "Alivedb.conf");
//				
//			}
		}
		if (pd != 0) {
			dbConMap.put("judge", "true");
		} else {
			dbConMap.put("judge", "false");
		}
		return JSONArray.toJSONString(dbConMap);
	}

	/*
	 * 修改
	 */
	@ResponseBody
	@RequestMapping(value = "/updAimsData")
	public Object updAimsData(Dbconpro dbconpro) {
		Map<String, Object> updAimsMap = new HashMap<String, Object>();
		JDBCUtil jdbc = new JDBCUtil(dbconpro.getUsername(), dbconpro.getPassword(), dbconpro.getIp(),
				dbconpro.getPort(), dbconpro.getSid());
		// 连接成功
		boolean flag = jdbc.getConnection();
		int pd = 0;
		if (flag) {
			jdbc.closeDB();
			pd = dbconProService.updAimsData(dbconpro);
		}
		if (pd != 0) {
			updAimsMap.put("judge", "true");
		} else {
			updAimsMap.put("judge", "false");
		}
		return JSONArray.toJSONString(updAimsMap);
	}

	// 查询所有连接信息(带参数)
	@ResponseBody
	@RequestMapping(value = "/selAimsDataByParam")
	public Object selAimsDataByParam(@RequestParam("page") String page1, @RequestParam("limit") String limit1,
			String param1, String param2) {
		HashMap<String, Object> dbconproMap = new HashMap<String, Object>();
		int page = Integer.valueOf(page1);
		int limit = Integer.valueOf(limit1);
		int before = limit * (page - 1) + 1;
		int after = page * limit;
		List<Dbconpro> dbConProList = dbconProService.selAimsDataByParam(before, after, param1, param2);
		dbconproMap.put("code", 0);
		dbconproMap.put("msg", "");
		dbconproMap.put("count", dbconProService.countByParam(param1, param2));
		Object obj = JSONArray.toJSON(dbConProList);
		dbconproMap.put("data", obj);
		return JSONArray.toJSONString(dbconproMap);
	}

	/**
	 * 监控所有的配置是否都是正常的连接状态 监控所有Agent状态 监控ftp
	 * 
	 * @return
	 */
	/**
	 * 获取ftp信息和状态
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/selFtpStatus", produces = "text/plain;charset=utf-8")
	public Object selAgentStatus() {
		HashMap<String, Object> agent = new HashMap<String, Object>();
		Rzcjqjcs cs = new Rzcjqjcs();
		cs.setGjz("FSIP");
		cs = rzcjqjcsService.selectByGjz(cs).get(0);
		String ftpip = cs.getMrz();
		agent.put("ip", ftpip);
		cs.setGjz("FSPORT");
		cs = rzcjqjcsService.selectByGjz(cs).get(0);
		String ftpport = cs.getMrz();
		agent.put("port", ftpport);
		cs.setGjz("FSUSERPASS");
		cs = rzcjqjcsService.selectByGjz(cs).get(0);
		String ftpPwd = cs.getMrz();
		agent.put("ftpPwd", ftpPwd);
		cs.setGjz("FSUSER");
		cs = rzcjqjcsService.selectByGjz(cs).get(0);
		String ftpUser = cs.getMrz();
		agent.put("ftpUser", ftpUser);
		FtpUtils ftp = new FtpUtils();
		ftp.setHostname(ftpip);
		ftp.setPassword(ftpPwd);
		ftp.setPort(new Integer(ftpport));
		ftp.setUsername(ftpUser);
		if (ftp.initFtpClient()) {
			if (ftp.getFtpClient().isConnected()) {
				try {
					ftp.getFtpClient().disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			agent.put("status", "连接状态正常");
		} else {
			agent.put("status", "连接状态失败");
		}
		return JSONArray.toJSONString(agent);
	}

	/* Agent 信息 */
	@ResponseBody
	@RequestMapping(value = "/selAgentInfo", produces = "text/plain;charset=utf-8")
	public Object selAgentInfo(@RequestParam("page") String page1, @RequestParam("limit") String limit1) {
		Map<Object, Object> agentMap = new HashMap<Object, Object>();
		int page = Integer.valueOf(page1);
		int limit = Integer.valueOf(limit1);
		int before = limit * (page - 1) + 1;
		int after = page * limit;
		List<Agent> agentList = agentService.selAgentByPage(before, after);
		agentMap.put("code", 0);
		agentMap.put("msg", "");
		agentMap.put("count", agentService.countAgent()); // 调用方法查询全部
		Object arry = JSONArray.toJSON(agentList);
		agentMap.put("data", arry);
		return JSONArray.toJSONString(agentMap);
	}

	/**
	 * 接口状态信息
	 */
	@ResponseBody
	@RequestMapping(value = "/selRDSInfo", produces = "text/plain;charset=utf-8")
	public Object selRDSInfo() {
		Map<Object, Object> rdsMap = new HashMap<Object, Object>();
		List<RdsStatus> rdslist = new ArrayList<>();
		Map<String, String> map = TestRestSafeOutAccess.rdsStatus();
		for (Iterator<Entry<String, String>> it = map.entrySet().iterator(); it.hasNext();) {
			Entry<String, String> entry = it.next();
			RdsStatus status = new RdsStatus();
			status.setJkid(entry.getKey());
			status.setStr(entry.getValue());
			if (!entry.getValue().equals("200")) {
				status.setJkstatus("连接失败");
			} else {
				status.setJkstatus("连接正常");
			}
			rdslist.add(status);
		}
		rdsMap.put("code", 0);
		rdsMap.put("msg", "");
		rdsMap.put("count", rdslist.size());
		Object arry = JSONArray.toJSON(rdslist);
		rdsMap.put("data", arry);
		return JSONArray.toJSONString(rdsMap);
	}
}
