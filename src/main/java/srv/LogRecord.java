/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srv;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.dom4j.Element;

/**
 * 解析逻辑复制生成的log文件，用于存放每一个dml操作记录
 * 通过getNextLogRecord给LogRecord对象赋值 
 * 用此类来封装OraRecord对象(含事务信息)，是为了让程序对日志文本的解析更加清晰，方便以后的格式修改
 * 2018-11-20
 *
 * @author William
 */
public class LogRecord {

    public String scn;
    public String type;
    public String tx;
    public String session;    //新增会话信息
    public String time;
    public String schema;
    public String tab;
    public String act;
    public String rowid;
    public String data;
    public String where;

    public void LogRecord() {
        this.scn = "";
        this.type = "";
        this.tx = "";
        this.session = "";
        this.time = "";
        this.schema = "";
        this.tab = "";
        this.act = "";
        this.rowid = "";
        this.data = "";
        this.where = "";
    }


    //获取xml元素，给LogRecord赋值
    public boolean getNextLogRecord(Element dmlelement, LogRecord dmlrec) {

        dmlrec.schema = dmlelement.elementText("schema");
        dmlrec.tab = dmlelement.elementText("tab");
        dmlrec.act = dmlelement.elementText("act");
        dmlrec.rowid = dmlelement.elementText("rowid");
        if ("2".equals(dmlrec.type)) {    //ddl
            dmlrec.data = dmlelement.elementText("data");
        } else {
            dmlrec.data = getElementString(dmlelement, "data");
        }
        if (("1".equals(dmlrec.act)) || ("2".equals(dmlrec.act))) {   //删除、修改
            dmlrec.where = getElementString(dmlelement, "where");
        } else {
            dmlrec.where = "";
        }
        return true;
    }

    //遍历keywd下的列，拼接列明和列值
    public String getElementString(Element ele, String keywd) {
        Element lstkey;
        Element lstcol;
        String sret = "";
        for (Iterator i = ele.elementIterator(keywd); i.hasNext();) {
            lstkey = (Element) i.next();
            for (Iterator j = lstkey.elementIterator("cols"); j.hasNext();) {
                lstcol = (Element) j.next();
                sret = sret + lstcol.elementText("name") + "=" + lstcol.elementText("value") + ",";
            }
        }
        return sret;
    }

    //翻译操作类型，返回insert，delete，update三种
    public String getDMLType(String stype) {
        if ("0".equals(stype)) {
            return "insert";
        } else if ("1".equals(stype)) {
            return "delete";
        } else if ("2".equals(stype)) {
            return "update";
        } else {
            return "ddl";
        }
    }

    //获取操作类型
    public String getDDLCZLX(String sin) {
        sin = sin.toUpperCase();
        if (sin.contains("CREATE ")) {
            return "01";
        } else if (sin.contains("DROP ")) {
            return "02";
        } else if (sin.contains("ALTER ")) {
            return "03";
        } else if (sin.contains("RENAME ")) {
            return "04";
        } else if (sin.contains("TRUNCATE ")) {
            return "05";
        } else if (sin.contains("REVOKE ")) {
            return "06";
        } else {
            return "99";
        }
    }

    //获取操作类型对象
    public String getDDLDXLX(String sin) {
        sin = sin.toUpperCase();
        if (sin.contains("TABLE ")) {
            return "01";
        } else if (sin.contains("VIEW ")) {
            return "02";
        } else if (sin.contains("PROCEDURE ")) {
            return "03";
        } else if (sin.contains("TABLESPACE ")) {
            return "04";
        } else if (sin.contains("FUNCTION ")) {
            return "05";
        } else if (sin.contains("TRIGER ")) {
            return "06";
        } else if (sin.contains("INDEX ")) {
            return "07";
        } else if (sin.contains("PACKAGE ")) {
            return "08";
        } else if (sin.contains("PACKAGE BODY ")) {
            return "09";
        } else if (sin.contains("SEQUENCE ")) {
            return "10";
        } else if (sin.contains("SYNONYM ")) {
            return "11";
        } else if (sin.contains("ROLE ")) {
            return "12";
        } else {
            return "99";
        }
    }

    //重置对象的值
    public void resetOraTrans() {
        this.tx = "";
        this.session = "";
        this.scn = "";
        this.time = "";
        this.type = "";
    }

    //重置对象的dml
    public void resetOraDML() {
        this.schema = "";
        this.tab = "";
        this.act = "";
        this.rowid = "";
        this.data = "";
        this.where = "";
    }

    //把串值写入hash表
    public boolean setHashValue(String sin, HashMap<String, String> newmap) {
        //校验传入数据
        if (!sin.contains("=")) {
            return false;
        }
        String scol = "";
        String svalue = "";
        String[] strarray1;
        String[] strarray = sin.split(",");
        for (int i = 0; i < strarray.length; i++) {
            strarray1 = strarray[i].split("=");
            scol = strarray1[0].replace("\"", "");
            if (2 == strarray1.length) {
                svalue = strarray1[1];
                newmap.put(scol, svalue);  //去掉列的引号
            }else{
            	newmap.put(scol, "");  //去掉列的引号
            }
        }
        return true;
    }

    //将串值写入hash表
    public boolean setUpdateValue(String sdata, String swhere, HashMap<String, String> oldmap, HashMap<String, String> newmap, HashMap<String, String> wheremap) {
        //校验传入数据
//        if ((!sdata.contains("=")) || (!swhere.contains("="))) {
//            return false;
//        }
        String scol = "";
        String svalue = "";
        String[] strarray1;
        String[] strarray = swhere.split(",");
        for (int i = 0; i < strarray.length; i++) {
            strarray1 = strarray[i].split("=");
            scol = strarray1[0].replace("\"", "");
            if (2 == strarray1.length) {
                svalue = strarray1[1];
                wheremap.put(scol, svalue);  //去掉列的引号
            }else{
            	svalue="";
            	wheremap.put(scol, svalue);  //去掉列的引号
            }
        }
        /**
         * 0416
         * 1，where 不为空   data为空
         * 对data复制为空 对old复制为where
         * 2，where 为空   data不为空
         */
        if (sdata.equals("")) {
        	for (Entry<String, String> entry1 : wheremap.entrySet()) {
        		newmap.put(entry1.getKey(), "");
        		oldmap.put(entry1.getKey(), entry1.getValue());
        	}
		}else{
			strarray = sdata.split(",");
			for (int i = 0; i < strarray.length; i++) {
				strarray1 = strarray[i].split("=");
				scol = strarray1[0].replace("\"", "");
				if (2 == strarray1.length) {
					svalue = strarray1[1];
					newmap.put(scol.replace("\"", ""), svalue);  //去掉列的引号
					//替换更新
					if (!wheremap.containsKey(scol.replace("\"", ""))) {
						wheremap.put(scol.replace("\"", ""), "");
						oldmap.put(scol.replace("\"", ""), "");
					}
					oldmap.put(scol.replace("\"", ""), "");
					if (null != wheremap.get(scol)) {
						oldmap.put(scol, wheremap.get(scol));
					}
				}else{
					svalue="";
					newmap.put(scol.replace("\"", ""), svalue);  //去掉列的引号
					//替换更新
					if (!wheremap.containsKey(scol.replace("\"", ""))) {
						wheremap.put(scol.replace("\"", ""), "");
						oldmap.put(scol.replace("\"", ""), "");
					}
					oldmap.put(scol.replace("\"", ""), "");
					if (null != wheremap.get(scol)) {
						oldmap.put(scol, wheremap.get(scol));
					}
				}
			}
		}
        return true;
    }

    //create table tb_test(col1 varchar(10), col2 datetime)
    public boolean setDDLValue(String sin, HashMap<String, String> new_value) {
        //判断格式
        if (10 > sin.length()) {
            return false;
        }
        new_value.put("DDL", sin);
        //系统类别，scn，sequence，数据库名，表名，操作类型，操作对象类型，操作内容
        return true;
    }

}
