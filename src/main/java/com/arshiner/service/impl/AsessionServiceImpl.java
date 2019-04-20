package com.arshiner.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arshiner.dao.AsessionMapper;
import com.arshiner.model.Asession;
import com.arshiner.model.AsessionExample;
import com.arshiner.service.AsessionService;
@Service("asessionService")
public class AsessionServiceImpl implements AsessionService {

	@Autowired
	AsessionMapper asessionMapper;
	@Override
	public Asession selsession(String jgxtlb, String sid, String serial,String t) {
		// TODO Auto-generated method stub
		AsessionExample example = new AsessionExample();
		example.createCriteria().andJgxtlbEqualTo(jgxtlb).andSidEqualTo(sid).andSerialEqualTo(serial);
		List<Asession> asession = asessionMapper.selectByExample(example);
		Asession asessions ;
		if (null!=asession&&!asession.isEmpty()) {
			asessions= asession.get(0);
			return asessions;
		}else{
			return null;
		}
	}
	@Override
	public void delsession(String jgxtlb, String t) {
		asessionMapper.deletesession(jgxtlb, t);
	}
}
