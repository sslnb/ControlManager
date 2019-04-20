package com.arshiner.dao;

import com.arshiner.model.Totalsysinfo;
import com.arshiner.model.TotalsysinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TotalsysinfoMapper {
    int countByExample(TotalsysinfoExample example);

    int deleteByExample(TotalsysinfoExample example);

    int insert(Totalsysinfo record);

    int insertSelective(Totalsysinfo record);

    List<Totalsysinfo> selectByExample(TotalsysinfoExample example);

    int updateByExampleSelective(@Param("record") Totalsysinfo record, @Param("example") TotalsysinfoExample example);

    int updateByExample(@Param("record") Totalsysinfo record, @Param("example") TotalsysinfoExample example);

	List<Totalsysinfo> allInfo();
}