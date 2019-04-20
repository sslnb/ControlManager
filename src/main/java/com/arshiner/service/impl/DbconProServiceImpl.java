package com.arshiner.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arshiner.common.ConfigFile;
import com.arshiner.common.FilePathName;
import com.arshiner.dao.DbconproMapper;
import com.arshiner.model.Dbconpro;
import com.arshiner.model.DbconproExample;
import com.arshiner.service.DbconProService;
import com.arshiner.service.DbrzcjcsService;

/**
 * 目标数据连接 配置 service层
 * 
 * @author 士林
 *
 */
@Service("dbconProService")
public class DbconProServiceImpl implements DbconProService {
	StringBuffer buffer = new StringBuffer(FilePathName.ROOT);//项目上级目录
	/**
	 * 获取Alivedbconf并对其修改复制
	 */
	ConfigFile configFile = new ConfigFile();
	/**
	 * 单表日志采集参数
	 */
	@Autowired
	DbrzcjcsService dbrzcjcsService;
	@Autowired
	DbconproMapper dbconproMapper;

	/**
	 * 总条数
	 */
	@Override
	public int countByExample() {
		// TODO Auto-generated method stub
		DbconproExample example = new DbconproExample();
		return dbconproMapper.countByExample(example);
	}

	/**
	 * 删除记录 通过 ip port sid 进行删除
	 */
	@Override
	public int deleteByExample(Dbconpro record) {
		// TODO Auto-generated method stub
		DbconproExample example = new DbconproExample();
		example.createCriteria().andIpEqualTo(record.getIp()).andPortEqualTo(record.getPort())
				.andSidEqualTo(record.getSid()).andSchemaEqualTo(record.getSchema());
		return dbconproMapper.deleteByExample(example);
	}

	/**
	 * 插入数据，并创建节点
	 */
	@Override
	public int insert(Dbconpro record) {
		// 插入数据
		return dbconproMapper.insertSelective(record);
	}

	/**
	 * 插入
	 */
	@Override
	public int insertSelective(Dbconpro record) {
		// TODO Auto-generated method stub
		// 从前端传来对象，，获取并开始复制整合和创建一个节点

		// 插入数据
		return dbconproMapper.insertSelective(record);
	}

	/**
	 * 根据 azdm和交管系统类别查询记录
	 */
	@Override
	public List<Dbconpro> selectByExample(Dbconpro record) {
		// TODO Auto-generated method stub
		DbconproExample example = new DbconproExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb());
		return dbconproMapper.selectByExample(example);
	}

	/**
	 * 修改
	 */
	@Override
	public int updateByExampleSelective(Dbconpro record) {
		// TODO Auto-generated method stub
		DbconproExample example = new DbconproExample();
		example.createCriteria().andJgxtlbEqualTo(record.getJgxtlb());
		return dbconproMapper.updateByExampleSelective(record, example);
	}

	/**
	 * 根据交管系统类别和ip
	 */
	@Override
	public int updateByExample(Dbconpro record) {
		// TODO Auto-generated method stub
		DbconproExample example = new DbconproExample();
		example.createCriteria().andIpEqualTo(record.getIp()).andJgxtlbEqualTo(record.getJgxtlb());
		return dbconproMapper.updateByExampleSelective(record, example);
	}

	@Override
	public List<Dbconpro> selectByExample() {
		// TODO Auto-generated method stub
		DbconproExample example = new DbconproExample();
		return dbconproMapper.selectByExample(example);
	}


	@Override
	public List<Dbconpro> selAimsData(int before, int after) {
		return dbconproMapper.selAimsData(before, after);
	}

	@Override
	public int countAimsData() {
		return dbconproMapper.countAimsData();
	}

	@Override
	public List<Dbconpro> selAimsDataByParam(int before,int after,String param1, String param2) {
		return dbconproMapper.selAimsDataByParam(before,after,param1, param2);
	}

	@Override
	public int countByParam(String param1, String param2) {
		return dbconproMapper.countByParam(param1, param2);
	}

    @Override
    public int insAimsData(Dbconpro dbconpro) {
        return dbconproMapper.insertSelective(dbconpro);
    }

    @Override
    public int updAimsData(Dbconpro dbconpro) {
    	DbconproExample example = new DbconproExample();
		example.createCriteria().andJgxtlbEqualTo(dbconpro.getJgxtlb());
        return dbconproMapper.updateByExampleSelective(dbconpro, example);
    }
	
}
