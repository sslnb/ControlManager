package com.arshiner.service.impl;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arshiner.dao.AsessionMapper;
import com.arshiner.model.Asession;
import com.arshiner.model.AsessionExample;
import com.arshiner.service.AsessionService;

@Service("asessionService")
public class AsessionServiceImpl implements AsessionService {

	private static final Logger logger = Logger.getLogger(AsessionServiceImpl.class);
	@Autowired
	AsessionMapper asessionMapper;
	@Override
	public Asession selsession1(String jgxtlb, String sid, String serial,String t) {
		// TODO Auto-generated method stub
		logger.info("jgxtlb:"+jgxtlb+"; sid"+sid+"; serial:"+serial+"; t:"+t);
		AsessionExample example = new AsessionExample();
		example.createCriteria().andJgxtlbEqualTo(jgxtlb).andSidEqualTo(sid).andSerialEqualTo(serial).andTLessThanOrEqualTo(t);
		example.setOrderByClause(" t desc");
		List<Asession> asession = asessionMapper.selectByExample(example);//条件，jgxtlb相同，sid相同，serial相同，t时间戳小于当前时间
		Asession asessions = null ;
		if (null!=asession&&!asession.isEmpty()) {//精确查
			asessions= asession.get(0);
		}else{
			logger.info("jgxtlb:"+jgxtlb+"; sid"+sid+"; serial:"+serial+"; t:"+t);
			asessions=selsession2(jgxtlb, sid, t);//sid和t查
			if (null==asessions) {
				asessions=selsession3(jgxtlb, t);//t查
				if (null==asessions) {
					logger.info("查无session");
				}
			}
			
		}
		delsession(jgxtlb, t);//t-10删
		return asessions;
	}
	@Override
	public void delsession(String jgxtlb, String t) {
		asessionMapper.deletesession(jgxtlb);
	}
	@Override
	public Asession selsession2(String jgxtlb, String sid, String t) {
		AsessionExample example = new AsessionExample();
		logger.info("jgxtlb:"+jgxtlb+"; sid"+sid+"; t:"+t);
		example.createCriteria().andJgxtlbEqualTo(jgxtlb).andSidEqualTo(sid);
		example.setOrderByClause(" t desc");
		List<Asession> asession = asessionMapper.selectByExample(example);
		Asession asessions = null ;
		if (null!=asession&&!asession.isEmpty()) {
			asessions= asession.get(0);
			return asessions;
		}else{
			return asessions;
		}
	}
	@Override
	public Asession selsession3(String jgxtlb, String t) {
		AsessionExample example = new AsessionExample();
		example.createCriteria().andJgxtlbEqualTo(jgxtlb).andTLessThanOrEqualTo(t);
		example.setOrderByClause("t desc");
		List<Asession> asession = asessionMapper.selectByExample(example);
		Asession asessions = null ;
		if (null!=asession&&!asession.isEmpty()) {
			asessions= asession.get(0);
			return asessions;
		}else{
			return asessions;
		}
	}
}
