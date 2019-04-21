package com.arshiner.service;

import com.arshiner.model.Zlsjddb;

import java.math.BigDecimal;
import java.util.List;

public interface ZlsjddbService {
	int countByExample();

	int deleteByExample(Zlsjddb record);

	int insert(Zlsjddb record);

	int insertSelective(Zlsjddb record);

	List<Zlsjddb> selectByExample(Zlsjddb record);

	int updateByExampleSelective(Zlsjddb record);

	int updateByExample(Zlsjddb record);

	List<Zlsjddb> selectBysbzt(Zlsjddb record);

	void saveOrupdate(Zlsjddb zlsjddb);

	String selScnByJgxt(String jgxtlb);

	BigDecimal selectNewSeq(String jgxtlb);
}
