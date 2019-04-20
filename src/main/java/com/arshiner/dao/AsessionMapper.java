package com.arshiner.dao;

import com.arshiner.model.Asession;
import com.arshiner.model.AsessionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * select * from ( select * from ( select * from ( select * from asession where
 * t>=#{t} and jgxtlb=#{jgxtlb} and sid=#{sid} and serial=#{serial} ) union
 * select * from ( select * from asession where t&lt;=#{t} and jgxtlb=#{jgxtlb}
 * and sid=#{sid} and serial=#{serial} ) ) order by t desc )where rownum=1
 * 
 * @author Administrator
 *
 */
public interface AsessionMapper {
	int countByExample(AsessionExample example);

	int deleteByExample(AsessionExample example);

	int insert(Asession record);

	int insertSelective(Asession record);

	List<Asession> selectByExample(AsessionExample example);

	int updateByExampleSelective(@Param("record") Asession record, @Param("example") AsessionExample example);

	int updateByExample(@Param("record") Asession record, @Param("example") AsessionExample example);

	Asession selectAsession(@Param("jgxtlb") String jgxtlb, @Param("sid") String sid, @Param("serial") String serial,
			@Param("t") String t);

	void deletesession(@Param("jgxtlb") String jgxtlb, @Param("t") String t);
}