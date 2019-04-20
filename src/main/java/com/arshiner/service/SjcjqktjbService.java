package com.arshiner.service;

import com.arshiner.model.Sjcjqktjb;
import java.util.List;


public interface SjcjqktjbService {
    int countByExample();

    int deleteByExample(Sjcjqktjb record);

    int insert(Sjcjqktjb record);

    int insertSelective(Sjcjqktjb record);

    List<Sjcjqktjb> selectByExample(Sjcjqktjb record);

    int updateByExampleSelective(Sjcjqktjb record);

    int updateByExample(Sjcjqktjb record);

	void saveOrupdate(Sjcjqktjb sjcjqk);
}
