/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package srv;

import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class DmlCache {

    public String schema = "";         //�û�
    public String tab = "";            //����
    public String act = "";            //����
    public String session = "";        //�Ự��Ϣ
    public String rowid = "";           //rowid
    public HashMap<String, String> wherevalue;
    public HashMap<String, String> newvalue;
    public HashMap<String, String> oldvalue;
    
    //��ʱ���dml����
    public DmlCache DmlCache() {
        this.schema = "";
        this.tab = "";
        this.act = "";
        this.rowid = "";
        this.session = "";
        this.rowid = "";
        this.wherevalue = null;
        this.newvalue = null;
        this.oldvalue = null;
        return this;
    }

    //��ʱ���dml����
    public DmlCache setDmlCache(String sschema, String stab, String sact, String ssession, String srowid, HashMap<String, String> wvalue, HashMap<String, String> nvalue, HashMap<String, String> ovalue) {
        this.schema = sschema;
        this.tab = stab;
        this.act = sact;
        this.rowid = srowid;
        this.session = ssession;
        this.wherevalue = wvalue;
        this.newvalue = nvalue;
        this.oldvalue = ovalue;
        return this;
    }
   
    //���ö������
    public void resetDmlCache() {
        schema = "";
        tab = "";
        act = "";
        session = "";
        wherevalue.clear();
        newvalue.clear();
        oldvalue.clear();
    }

}
