package com.arshiner.service;

import com.arshiner.model.Ddlsjsjb;

import java.util.List;


/**
 * @Author: MDK
 * @Description: TODO
 * @Date: 2018-10-24 10:40
 * @Version: 1.0
 */
public interface DdlsjsjbService {
    int countByExample();

    int deleteByExample(Ddlsjsjb record);

    int insert(Ddlsjsjb record);

    int insertSelective(Ddlsjsjb record);

    List<Ddlsjsjb> selectByJGXTLBAndORAUSER(Ddlsjsjb record);
    List<Ddlsjsjb> selectByJGXTLB(Ddlsjsjb record);

    int updateByExampleSelective(Ddlsjsjb record);

    int updateByExample(Ddlsjsjb record);

    /*无参数分页*/
    List<Ddlsjsjb> selAllDdlsjsj(int before,int after);

    int countDdlsjsj();

    /*有参数查询*/
    List<Ddlsjsjb> selDdlsjsjByParam(int before,int after,String param1,String param2,String param3);

    int countDdlsjsjByParam(String param1,String param2,String param3);

	List<Ddlsjsjb> selectBysbzt(Ddlsjsjb ddlsjsj);

	void saveorupdate(Ddlsjsjb record);
}
