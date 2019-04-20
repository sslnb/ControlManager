package com.arshiner.common;
/**
 * 按照单表参数缓存增量文件
 * 一次添加多张表，有其中一张表完成上报此表
 * 其它表照常进行
 * @author MSI-PC
 *
 */

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import srv.OraDMLObject;
import srv.OraTransObject;

public class RedisHct{
			 //bm  事务 和  dml  
	public static LinkedHashMap<String, LinkedHashMap<OraTransObject, List<OraDMLObject>>> bmhc = new LinkedHashMap<>();
	
	public static HashMap<String, Integer>  insertCount = new HashMap<>();
	public static HashMap<String, Integer>  updateCount = new HashMap<>();
	public static HashMap<String, Integer>  deleteCount = new HashMap<>();
	
}
