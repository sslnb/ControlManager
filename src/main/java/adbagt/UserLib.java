/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adbagt;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
/**
 *
 * @author William
 */
public class UserLib {
    //写日志
    public static boolean WriteLog(boolean b_flag, String s_type, String s_msg) {
        if (b_flag) {
            Logger logger =  Logger.getLogger((s_type + "    ").substring(0, 8));   
            PropertyConfigurator.configure("ADBAgt.properties");
            //输出优先级，即DEBUG，INFO，WARN，ERROR，FATAL。如果是调用debug()输出的，则为DEBUG
            //Log4j建议只使用FATAL ,ERROR ,WARN ,INFO ,DEBUG这五个级别。
            /*if ("DEBUG".equals(s_type.toUpperCase())) {
                logger.debug(s_msg);
                System.out.println(s_type);
            } else if ("INFO".equals(s_type.toUpperCase())) {
                logger.info(s_msg);
                System.out.println(s_type);
            } else if ("WARN".equals(s_type.toUpperCase())) {
                logger.warn(s_msg);
                System.out.println(s_type);
            } else if ("ERROR".equals(s_type.toUpperCase())) {
                logger.error(s_msg);
                System.out.println(s_type);
            } else if ("FATAL".equals(s_type.toUpperCase())) {
                logger.fatal(s_msg);
                System.out.println(s_type);
            } else {
                logger.info(s_msg);
            }*/
            logger.debug(s_msg);
        }
        return true;
    }
}
