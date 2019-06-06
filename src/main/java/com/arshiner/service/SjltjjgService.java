package com.arshiner.service;

import com.arshiner.model.Sjltjjg;
import java.util.List;

public interface SjltjjgService {
    int countByExample(Sjltjjg record);

    int deleteByExample(Sjltjjg record);

    int insert(Sjltjjg record);

    int insertSelective(Sjltjjg record);

    List<Sjltjjg> selectByExample(Sjltjjg record);

    int updateByExampleSelective(Sjltjjg record);

    int updateByExample(Sjltjjg record);

	List<Sjltjjg> selectBySbzt(Sjltjjg record);

	int saveOrupdate(Sjltjjg record);
}