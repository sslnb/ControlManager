package com.arshiner.dao;

import com.arshiner.model.Sjltjjg;
import com.arshiner.model.SjltjjgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SjltjjgMapper {
    int countByExample(SjltjjgExample example);

    int deleteByExample(SjltjjgExample example);

    int insert(Sjltjjg record);

    int insertSelective(Sjltjjg record);

    List<Sjltjjg> selectByExample(SjltjjgExample example);

    int updateByExampleSelective(@Param("record") Sjltjjg record, @Param("example") SjltjjgExample example);

    int updateByExample(@Param("record") Sjltjjg record, @Param("example") SjltjjgExample example);
}