/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srv;

import java.sql.*;


import com.arshiner.common.ConfigManager;

/**
 *
 * @author William
 */
public class Jdbc {
	public String user;
	public String pwd;
	public String url;
    Connection conn = null;
    Statement stmt;
    ResultSet rs = null;
    ConfigManager config = new ConfigManager(ConfigManager.jdbc);
    public Jdbc() {
    	user = config.properties.getProperty("user");
    	pwd = config.properties.getProperty("pwd");
    	url = config.properties.getProperty("url");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            DriverManager.setLoginTimeout(15);
            conn = DriverManager.getConnection("jdbc:oracle:thin:@" + url + ":" + "1521" + ":" + "orcl", user, pwd);
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("  Create database connection error ...");
        }
    }

    public boolean executeUpdate(String sql) {
        try {
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet executeQuery(String sql) {
        rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void close() {
        try {
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
