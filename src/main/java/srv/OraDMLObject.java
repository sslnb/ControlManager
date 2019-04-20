/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srv;

import java.util.HashMap;

/**
 * 定义Oracle的dml信息 解析数据日志时，将dml通过list保存到OraRecord对象中 给sax写xml使用
 *
 * @author william 2018-10-31
 */
public class OraDMLObject {

    //dml信息
    public int sidx = 0;            //list中的dml序号
    public int tidx = 0;            //list中的事务序号
    public int recnum = 0;          //表示事务中的record num
    public String session = "";     //新增的会话信息，如<Session>000c0045</Session>  表示sid=12， serial#=69
    public String ora_schema = "";      //用户
    public String tab_name = "";        //表名
    public String tab_action = "";      //操作类型，0为插入，1为删除，2为修改
    public HashMap<String, String> where_value = new HashMap<>();
    public HashMap<String, String> data_value = new HashMap<>();
    public HashMap<String, String> old_value = new HashMap<>();

    public OraDMLObject(int sidx, int tidx, int recnum, String sessionid, String ora_schema, String tab_name, String tab_action, HashMap<String, String> where_value, HashMap<String, String> data_value, HashMap<String, String> old_value) {

        this.sidx = sidx;                 
        this.tidx = tidx;                
        this.session = sessionid;        
        this.recnum = recnum;             
        this.ora_schema = ora_schema;
        this.tab_name = tab_name;
        this.tab_action = tab_action;
        this.where_value.putAll(where_value);
        this.data_value.putAll(data_value);
        this.old_value.putAll(old_value);
    }

	public int getSidx() {
		return sidx;
	}

	public void setSidx(int sidx) {
		this.sidx = sidx;
	}

	public int getTidx() {
		return tidx;
	}

	public void setTidx(int tidx) {
		this.tidx = tidx;
	}

	public int getRecnum() {
		return recnum;
	}

	public void setRecnum(int recnum) {
		this.recnum = recnum;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public String getOra_schema() {
		return ora_schema;
	}

	public void setOra_schema(String ora_schema) {
		this.ora_schema = ora_schema;
	}

	public String getTab_name() {
		return tab_name;
	}

	public void setTab_name(String tab_name) {
		this.tab_name = tab_name;
	}

	public String getTab_action() {
		return tab_action;
	}

	public void setTab_action(String tab_action) {
		this.tab_action = tab_action;
	}

	public HashMap<String, String> getWhere_value() {
		return where_value;
	}

	public void setWhere_value(HashMap<String, String> where_value) {
		this.where_value = where_value;
	}

	public HashMap<String, String> getData_value() {
		return data_value;
	}

	public void setData_value(HashMap<String, String> data_value) {
		this.data_value = data_value;
	}

	public HashMap<String, String> getOld_value() {
		return old_value;
	}

	public void setOld_value(HashMap<String, String> old_value) {
		this.old_value = old_value;
	}
    
}
