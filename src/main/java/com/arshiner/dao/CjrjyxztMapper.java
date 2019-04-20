package com.arshiner.dao;

import com.arshiner.model.Cjrjyxzt;
import com.arshiner.model.CjrjyxztExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CjrjyxztMapper {
    int countByExample(CjrjyxztExample example);

    int deleteByExample(CjrjyxztExample example);

    int insert(Cjrjyxzt record);

    int insertSelective(Cjrjyxzt record);

    List<Cjrjyxzt> selectByExample(CjrjyxztExample example);

    int updateByExampleSelective(@Param("record") Cjrjyxzt record, @Param("example") CjrjyxztExample example);

    int updateByExample(@Param("record") Cjrjyxzt record, @Param("example") CjrjyxztExample example);
}