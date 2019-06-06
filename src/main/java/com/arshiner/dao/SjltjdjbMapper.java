package com.arshiner.dao;

import com.arshiner.model.Sjltjdjb;
import com.arshiner.model.SjltjdjbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SjltjdjbMapper {
    int countByExample(SjltjdjbExample example);

    int deleteByExample(SjltjdjbExample example);

    int insert(Sjltjdjb record);

    int insertSelective(Sjltjdjb record);

    List<Sjltjdjb> selectByExample(SjltjdjbExample example);

    int updateByExampleSelective(@Param("record") Sjltjdjb record, @Param("example") SjltjdjbExample example);

    int updateByExample(@Param("record") Sjltjdjb record, @Param("example") SjltjdjbExample example);
}