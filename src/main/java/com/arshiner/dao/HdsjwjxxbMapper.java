package com.arshiner.dao;

import com.arshiner.model.Hdsjwjxxb;
import com.arshiner.model.HdsjwjxxbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HdsjwjxxbMapper {
    int countByExample(HdsjwjxxbExample example);

    int deleteByExample(HdsjwjxxbExample example);

    int insert(Hdsjwjxxb record);

    int insertSelective(Hdsjwjxxb record);

    List<Hdsjwjxxb> selectByExample(HdsjwjxxbExample example);

    int updateByExampleSelective(@Param("record") Hdsjwjxxb record, @Param("example") HdsjwjxxbExample example);

    int updateByExample(@Param("record") Hdsjwjxxb record, @Param("example") HdsjwjxxbExample example);
}