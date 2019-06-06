/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srv;

/**
 *
 * @author william 2018-10-31
 */
public class TestLogToOraRecord {

    static LogToOraRecord log2orarec = new LogToOraRecord();
    static int isite = 2;

    public static void main(String[] args) {
        analysisLogFile();
    }

    //每个日志文件调用一次该方法，获取一个或者多个OraRecord
    public static void analysisLogFile() {
        int iloop = 0;
        //站点总数，当前scn起始点，日志池路径
        log2orarec.LogToOraRecord(isite, "0x0000.00000000", "C:\\Users\\MSI-PC\\Desktop\\Desktop\\1");     //初始化2站点
        log2orarec.getOraRecord().setType("2");              //增量为2
        log2orarec.getOraRecord().setXtlb("10");             //用参数替代
        log2orarec.getOraRecord().setAzdm("111");            //设置安装代码
        //循环调用，获取日志数据并排序装载到outoraobj.getOraRecord()中
        while (log2orarec.getNextOraRecord()) {
            System.out.println("**********************************事务"
                    + String.valueOf(iloop) + ":" + log2orarec.getCurrentSCN() + " 日志文件:" + log2orarec.getCurrentLogfile());
            printOraRecord(log2orarec.getOraRecord());
        }
        System.out.println("解析的日志文件成功！");
        
        //可以打印查看对象内容
        //日志断点
        System.out.println("解析的日志文件断点：" + log2orarec.getOraRecord().stopSCN);

        //对象重置，可循环使用
        log2orarec.getOraRecord().resetOraRecord();

    }

    //打印xml对象例子，实际环境下调用sax写xml文件而已
    public static void printOraRecord(OraRecord mytest) {
        System.out.println("*****打印对象内容*****");
        System.out.println("文件类型：" + mytest.getType());
        System.out.println("系统类别：" + mytest.getXtlb());
        System.out.println("安装代码：" + mytest.getAzdm());
        System.out.println("起始SCN：" + mytest.startSCN);
        System.out.println("起始事务：" + mytest.startTrans);
        System.out.println("终止SCN：" + mytest.stopSCN);
        System.out.println("终止事务：" + mytest.stopTrans);
        System.out.println("插入总数：" + mytest.insertCount);
        System.out.println("删除总数：" + mytest.deleteCount);
        System.out.println("修改总数：" + mytest.updateCount);
        int icurrent = 0;
        System.out.println("------------------------");
        for (int i = 0; i < mytest.translist.size(); i++) {
            System.out.println("第" + mytest.translist.get(i).tidx + "个Transaction信息：" + mytest.translist.get(i).tx);
            System.out.println("sid:" + mytest.translist.get(i).sid);
            System.out.println("serial:" + mytest.translist.get(i).serial);
            System.out.println("ora_client:" + mytest.translist.get(i).ora_client);
            System.out.println("ora_program:" + mytest.translist.get(i).ora_program);
            System.out.println("ora_time:" + mytest.translist.get(i).ora_time);
            System.out.println("ora_user:" + mytest.translist.get(i).ora_user);
            System.out.println("opartion_type:" + getOprationType(mytest.translist.get(i).type));
            System.out.println("------------------------");
            for (int j = icurrent; j < mytest.dmllist.size(); j++) {
                if (i == mytest.dmllist.get(j).tidx) {
                    System.out.println("第" + mytest.dmllist.get(j).recnum + "个DML信息：");
                    System.out.println("ora_schema:" + mytest.dmllist.get(j).ora_schema);
                    System.out.println("tab_name:" + mytest.dmllist.get(j).tab_name);
                    System.out.println("tab_action:" + mytest.dmllist.get(j).tab_action);
                    System.out.println("--------");
                    System.out.println("where_value:" + mytest.dmllist.get(j).where_value.toString());
                    System.out.println("--------");
                    System.out.println("data_value:" + mytest.dmllist.get(j).data_value.toString());
                    System.out.println("--------");
                    System.out.println("old_value:" + mytest.dmllist.get(j).old_value.toString());
                    System.out.println("------------------------");
                } else if (icurrent + 1 == mytest.dmllist.get(j).tidx) {        //下一个事务的事务的第一个dml
                    icurrent = j;
                    break;
                }
            }
        }
        System.out.println("*********************");
    }

    public static String getOprationType(String sin) {
        //操作类型
        if ("1".equals(sin)) {
            return "DML";
        }
        if ("2".equals(sin)) {
            return "DDL";
        } else {
            return "unknow";
        }
    }
}
