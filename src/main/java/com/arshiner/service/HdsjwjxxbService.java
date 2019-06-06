package com.arshiner.service;

import com.arshiner.model.Hdsjwjxxb;
import java.util.List;

public interface HdsjwjxxbService {
    int countByExample(Hdsjwjxxb record);

    int deleteByExample(Hdsjwjxxb record);

    int insert(Hdsjwjxxb record);

    int insertSelective(Hdsjwjxxb record);

    List<Hdsjwjxxb> selectByExample(Hdsjwjxxb record);
    List<Hdsjwjxxb> selectBywjzt(Hdsjwjxxb record);

    int updateByExampleSelective(Hdsjwjxxb record);

    int updateByExample(Hdsjwjxxb record);
    
    void saveOrupdate(Hdsjwjxxb record);

	List<Hdsjwjxxb> selectByAllwjzt(Hdsjwjxxb record);
}