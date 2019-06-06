package com.arshiner.service;

import java.util.List;


import com.arshiner.model.Sjltjdjb;

public interface SjltjdjbService {
    int countByExample(Sjltjdjb record);

    int deleteByExample(Sjltjdjb record);

    int insert(Sjltjdjb record);

    int insertSelective(Sjltjdjb record);

    List<Sjltjdjb> selectByExample(Sjltjdjb record);

    int updateByExampleSelective(Sjltjdjb record);

    int updateByExample(Sjltjdjb record);
    
    void saveOrupdate(Sjltjdjb record);
}
