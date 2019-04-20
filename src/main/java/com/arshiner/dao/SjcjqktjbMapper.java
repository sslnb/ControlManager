package com.arshiner.dao;

import com.arshiner.model.Sjcjqktjb;
import com.arshiner.model.SjcjqktjbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SjcjqktjbMapper {
    int countByExample(SjcjqktjbExample example);

    int deleteByExample(SjcjqktjbExample example);

    int insert(Sjcjqktjb record);

    int insertSelective(Sjcjqktjb record);

    List<Sjcjqktjb> selectByExample(SjcjqktjbExample example);

    int updateByExampleSelective(@Param("record") Sjcjqktjb record, @Param("example") SjcjqktjbExample example);

    int updateByExample(@Param("record") Sjcjqktjb record, @Param("example") SjcjqktjbExample example);
}