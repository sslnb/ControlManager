/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srv;

/**
 * 定义Oracle事务日志信息 解析数据日志时，将事务信息通过list保存到OraRecord对象中 给sax写xml使用
 *
 * @author william 2018-10-31
 */
public class OraTransObject {

    //事务信息
    public int tidx = 0;            //list维度序号
    public String tx = "";          //事务号
    public String sid = "";         //会话id
    public String serial = "";      //会话序号
    public String ora_user = "";    //审计账户
    public String ora_client = "";  //机器名
    public String ora_time = "";    //事务时间
    public String ora_program = ""; //客户端程序
    public String type = "";        //dml  1,  ddl  2

    public OraTransObject(int tidx, String stx, String stype, String ssid, String sserial, String ora_user, String ora_client, String ora_time, String ora_program) {
        this.tidx = tidx;             
        this.tx = stx;
        this.sid = ssid;
        this.serial = sserial;
        this.ora_user = ora_user;
        this.ora_client = ora_client;
        this.ora_time = ora_time;
        this.ora_program = ora_program;
        this.type = stype;
    }

	public int getTidx() {
		return tidx;
	}

	public void setTidx(int tidx) {
		this.tidx = tidx;
	}

	public String getTx() {
		return tx;
	}

	public void setTx(String tx) {
		this.tx = tx;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getOra_user() {
		return ora_user;
	}

	public void setOra_user(String ora_user) {
		this.ora_user = ora_user;
	}

	public String getOra_client() {
		return ora_client;
	}

	public void setOra_client(String ora_client) {
		this.ora_client = ora_client;
	}

	public String getOra_time() {
		return ora_time;
	}

	public void setOra_time(String ora_time) {
		this.ora_time = ora_time;
	}

	public String getOra_program() {
		return ora_program;
	}

	public void setOra_program(String ora_program) {
		this.ora_program = ora_program;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
