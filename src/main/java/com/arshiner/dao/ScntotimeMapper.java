package com.arshiner.dao;

import com.arshiner.model.Scntotime;
import com.arshiner.model.ScntotimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScntotimeMapper {
    int countByExample(ScntotimeExample example);

    int deleteByExample(ScntotimeExample example);

    int insert(Scntotime record);

    int insertSelective(Scntotime record);

    List<Scntotime> selectByExample(ScntotimeExample example);

    int updateByExampleSelective(@Param("record") Scntotime record, @Param("example") ScntotimeExample example);

    int updateByExample(@Param("record") Scntotime record, @Param("example") ScntotimeExample example);
}