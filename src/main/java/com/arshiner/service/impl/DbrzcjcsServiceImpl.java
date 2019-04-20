package com.arshiner.service.impl;

import com.arshiner.common.ConfigFile;
import com.arshiner.common.FilePathName;
import com.arshiner.dao.DbrzcjcsMapper;
import com.arshiner.model.Agent;
import com.arshiner.model.Clsjclzt;
import com.arshiner.model.Clsjkddb;
import com.arshiner.model.Clsjwjb;
import com.arshiner.model.Dbrzcjcs;
import com.arshiner.model.DbrzcjcsExample;
import com.arshiner.model.Rzcjqjcs;
import com.arshiner.model.ScheduleJob;
import com.arshiner.quartz.service.ScheduleJobInService;
import com.arshiner.quartz.service.SchedulerJobService;
import com.arshiner.service.AgentService;
import com.arshiner.service.ClsjclztService;
import com.arshiner.service.ClsjkddbService;
import com.arshiner.service.ClsjwjbService;
import com.arshiner.service.DbrzcjcsService;
import com.arshiner.service.RzcjqjcsService;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 单表日志采集全局参数服务层
 * 
 * @author 士林
 *
 */
@Service("dbrzcjcsService")
public class DbrzcjcsServiceImpl implements DbrzcjcsService {

	@Autowired
	ClsjkddbService clsjkddbService;
	@Autowired
	ClsjwjbService clsjwjbService;
	@Resource
	private DbrzcjcsMapper dbrzcjcsMapper;
	@Autowired
	ClsjclztService clsjclztService;
	@Autowired
	RzcjqjcsService rzcjqjcsService;
	@Autowired
	AgentService agentService;
	@Autowired
	SchedulerJobService schedulerJobService;
	@Autowired
	ScheduleJobInService scheduleJobInService;

	@Override
	public int countByExample() {
		DbrzcjcsExample example = new DbrzcjcsExample();
		return dbrzcjcsMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(Dbrzcjcs record) {
		DbrzcjcsExample example = new DbrzcjcsExample();
		example.createCriteria().andBmEqualTo(record.getBm()).andJgxtlbEqualTo(record.getJgxtlb());
		return dbrzcjcsMapper.deleteByExample(example);
	}

	@Override
	public int insert(Dbrzcjcs record) {
		return dbrzcjcsMapper.insert(record);
	}

	@Override
	public int insertSelective(Dbrzcjcs record) {
		return dbrzcjcsMapper.insertSelective(record);
	}

	@Override
	public List<Dbrzcjcs> selectByExample(Dbrzcjcs record) {
		DbrzcjcsExample example = new DbrzcjcsExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb());
		return dbrzcjcsMapper.selectByExample(example);
	}

	/**
	 * 查询通过交管系统类别
	 */
	@Override
	public List<Dbrzcjcs> selectByJgxtlb(Dbrzcjcs record) {
		DbrzcjcsExample example = new DbrzcjcsExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb());
		return dbrzcjcsMapper.selectByExample(example);
	}

	@Override
	public int updateByExampleSelective(Dbrzcjcs record) {
		DbrzcjcsExample example = new DbrzcjcsExample();
		example.createCriteria().andBmEqualTo(record.getBm()).andJgxtlbEqualTo(record.getJgxtlb());
		return dbrzcjcsMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Dbrzcjcs record) {
		DbrzcjcsExample example = new DbrzcjcsExample();
		example.createCriteria().andBmEqualTo(record.getBm()).andJgxtlbEqualTo(record.getJgxtlb());
		return dbrzcjcsMapper.updateByExample(record, example);
	}

	@Override
	public List<Dbrzcjcs> selAllSingleTable(int before, int after) {
		return dbrzcjcsMapper.selAllSingleTable(before, after);
	}

	@Override
	public int countSingleTable() {
		return dbrzcjcsMapper.countSingleTable();
	}

	@Override
	public List<Dbrzcjcs> selSingTabByParam(int before, int after, String param1) {
		return dbrzcjcsMapper.selSingTabByParam(before, after, param1);
	}

	@Override
	public int countSingleTableByParam(String param1) {
		return dbrzcjcsMapper.countSingleTableByParam(param1);
	}

	@Override
	public boolean saveorupdate(Dbrzcjcs record) {
		boolean flag = false;
		List<Dbrzcjcs> dblist = selectByBMANDJGXTLB(record);
		if (dblist == null || dblist.isEmpty()) {
//			// 插入一条单表参数，此时，Alivedb应及时添加到相应的Alivedb.conf
//			List<Agent> agentlist = agentService.selectByDbJG(record.getJgxtlb());
//			StringBuffer buffer = new StringBuffer(FilePathName.ROOT);// 项目上级目录
//			for (Iterator<Agent> iterator = agentlist.iterator(); iterator.hasNext();) {
//				Agent agent = (Agent) iterator.next();
//				String jd = buffer.toString() + agent.getJgxtlb() + FilePathName.FileSepeartor+ agent.getKip() + FilePathName.FileSepeartor;
//				File  alivedb = new File(jd+"Alivedb.conf");
//				if (alivedb.exists()) {
//					String bm = ConfigFile.getIniValue(jd + "Alivedb.conf", "User1", "Tables");
//					ConfigFile.setIniValue(jd + "Alivedb.conf", "User1", "Tables",bm+","+record.getBm());
//				}
//			}
			insertSelective(record);
		} else {
			Dbrzcjcs db = dblist.get(0);
			if (!record.getClcjbj().equals(db.getClcjbj()) && !record.getClcjbj().equals("0")) {
				renew(db.getJgxtlb(), db.getBm());
			}
			updateByExampleSelective(record);
		}
		return flag;
	}

	/**
	 * 清除断点和文件表以及存量数据处理状态表
	 * 
	 * @param jgxtlb
	 * @param bm
	 */
	public void renew(String jgxtlb, String bm) {
		Clsjkddb sjk = new Clsjkddb();
		sjk.setBm(bm);
		sjk.setJgxtlb(jgxtlb);
		Clsjwjb wjb = new Clsjwjb();
		wjb.setBm(bm);
		wjb.setJgxtlb(jgxtlb);
		Clsjclzt clzt = new Clsjclzt();
		clzt.setBm(bm);
		clzt.setJgxtlb(jgxtlb);
		Rzcjqjcs rz = new Rzcjqjcs();
		rz.setGjz("JGXTLB");
		rz.setMrz(jgxtlb);
		List<Rzcjqjcs> rzcjqjcs = rzcjqjcsService.selectByGjzandLikeJgxtlb(rz);
		try {
			for (Iterator<Rzcjqjcs> iterator = rzcjqjcs.iterator(); iterator.hasNext();) {
				Rzcjqjcs rzcjqjcs2 = (Rzcjqjcs) iterator.next();
				// 此处不对应调整
				String jobName = rzcjqjcs2.getMrz() + bm + "CLTASK";
				String jobGroup = "CLTASK";
				ScheduleJob scheduleJob = new ScheduleJob();
				scheduleJob.setJobName(jobName);
				scheduleJob.setJobGroup(jobGroup);
				scheduleJob.setJobStatus("NORMAL");
				schedulerJobService.pauseJob(jobName, jobGroup);
				clsjkddbService.deleteBylikeJgxtlb(sjk);
				clsjwjbService.deleteBylikeJgxtlb(wjb);
				clsjclztService.deleteBylikeJgxtlb(clzt);
				schedulerJobService.runOneJob(jobName, jobGroup);
			}
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Dbrzcjcs> selectByBMANDJGXTLB(Dbrzcjcs record) {
		DbrzcjcsExample example = new DbrzcjcsExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb()).andBmEqualTo(record.getBm());
		return dbrzcjcsMapper.selectByExample(example);
	}

	@Override
	public int deleteNotIn(List<Dbrzcjcs> record,String jgxtlb) {
		DbrzcjcsExample example = new DbrzcjcsExample();
		List<String>  bmlist = new ArrayList<>();
		for (Iterator<Dbrzcjcs> iterator = record.iterator(); iterator.hasNext();) {
			Dbrzcjcs dbrzcjcs = (Dbrzcjcs) iterator.next();
			bmlist.add(dbrzcjcs.getBm());
		}
		example.createCriteria().andBmNotIn(bmlist).andJgxtlbEqualTo(jgxtlb);
		return dbrzcjcsMapper.deleteByExample(example);
	}

}
