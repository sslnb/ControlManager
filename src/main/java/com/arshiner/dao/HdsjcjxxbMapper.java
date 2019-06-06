package com.arshiner.dao;

import com.arshiner.model.Hdsjcjxxb;
import com.arshiner.model.HdsjcjxxbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HdsjcjxxbMapper {
    int countByExample(HdsjcjxxbExample example);

    int deleteByExample(HdsjcjxxbExample example);

    int insert(Hdsjcjxxb record);

    int insertSelective(Hdsjcjxxb record);

    List<Hdsjcjxxb> selectByExample(HdsjcjxxbExample example);

    int updateByExampleSelective(@Param("record") Hdsjcjxxb record, @Param("example") HdsjcjxxbExample example);

    int updateByExample(@Param("record") Hdsjcjxxb record, @Param("example") HdsjcjxxbExample example);
}