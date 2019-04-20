/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srv;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 通过解析capture产生的数据日志，转换成LogRecord，再转换成OraRecord
 * OraRecord内含两个list，一个保存事务，一个保存dml或ddl
 * 该对象作为写xml方法的入口参数，给sax来创建用户所需的xml文件
 *
 * @author william 2018-10-31
 */
public class OraRecord {

    private String ora_type = "";   //文件类型2 表示增量数据日志解析文件
    private String ora_xtlb = "";   //系统类别10 表示综合应用平台工作库
    private String ora_azdm = "";   //安装代码
    private int irecnum = 0;        //新建一个事务时，该值清0，便于在dml对象中存放recnum
    public ArrayList<OraTransObject> translist = new ArrayList<>();     //事务信息list
    public ArrayList<OraDMLObject> dmllist = new ArrayList<>();         //dml信息list
    public int insertCount = 0;                 //对象中insert的个数
    public int deleteCount = 0;
    public int updateCount = 0;
    public String startSCN = "";                //对象中开始的scn号
    public String startTrans = "";
    public String stopSCN = "";
    public String stopTrans = "";

    //重置该对象中的事务和dml信息 
    public void resetOraRecord() {
        translist.clear();
        dmllist.clear();
        this.irecnum = 0;
        this.insertCount = 0;
        this.deleteCount = 0;
        this.updateCount = 0;
        this.startSCN = "";
        this.startTrans = "";
        this.stopSCN = "";
        this.stopTrans = "";
    }
    
    //设置oracle数据日志类型
    public void setType(String sin) {
        this.ora_type = sin;
    }

    public void setXtlb(String sin) {
        this.ora_xtlb = sin;
    }
    
    public void setAzdm(String sin) {
        this.ora_azdm = sin;
    }

    public String getType() {
        return this.ora_type;
    }

    public String getXtlb() {
        return this.ora_xtlb;
    }
    
    public String getAzdm() {
        return this.ora_azdm;
    }

    //向list中新增一个事务对象
    public void addTransObj(String stx, String stype, String sid, String serial, String ora_user, String ora_client, String ora_time, String ora_program) {
        translist.add(new OraTransObject(translist.size(), stx, stype, sid, serial, ora_user, ora_client, ora_time, ora_program));
        this.irecnum = 0;   //新增事务则清零
    }

    //向list中增加dml对象，list序号，事务序号，dml序号，通过序号可以找到唯一的dml对象
    public void addDMLObj(String ora_schema, String tab_name, String tab_action, String ssession, HashMap<String, String> where_value, HashMap<String, String> new_value, HashMap<String, String> old_value) {
        dmllist.add(new OraDMLObject(dmllist.size(), translist.size() - 1, this.irecnum, ssession, ora_schema, tab_name, tab_action, where_value, new_value, old_value));
        this.irecnum++;   //顺序递增
    }

}
