package com.arshiner.common;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import com.sun.jna.platform.win32.Netapi32Util.User;

/**
 * JDBC工具类
 * 
 * @author 士林
 *
 */

public class JDBCUtil {
	private SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private SimpleDateFormat forma = new SimpleDateFormat("yyyyMMddHHmmss");
	// 表示定义数据库的用户名
	private String USERNAME;// = "root";
	// 定义数据库的密码
	private String PASSWORD;// = "root";
	// 定义数据库的驱动信息
	private String DRIVER = "oracle.jdbc.driver.OracleDriver";// =
	// 定义访问数据库的地址
	private String ip = "";
	private String port = "";
	private String SID = "";
	private String ServiceName = "";
	private String tb_name = "";
	private String timeFied = "";
	private String date = "";// sjcq
	private String sjcz = "";
	private String where = "";
	private int rownum = 0;
	private String timeFiedType = "";
	// schema的值
	private String schema;
	// 定义数据库的链接
	private Connection con = null;
	// 定义sql语句的执行对象
	public PreparedStatement pstmt = null;
	// 定义查询返回的结果集合
	public ResultSet resultSet = null;
	public Statement stmt;
	private int pre = 0;
	private int sux = 0;
	private int count = 0;
	private int lastcount = 0;

	private int start = 0;
	private int end = 0;

	/**
	 * 获取存量的root子节点
	 * 
	 * @return
	 */
	public TreeMap<String, Object> getCLRootChild(String xtlb, String azdm) {
		TreeMap<String, Object> rootchild = new TreeMap<>();
		rootchild.put("ora_type", "old");
		rootchild.put("ora_azdm", azdm);
		rootchild.put("ora_xtlb", xtlb);
		rootchild.put("ora_user", this.USERNAME);
		// 获取数据抽取时间，即当前时间
		Date d = new Date();// 获取时间
		rootchild.put("ora_client", "jdbc");
		rootchild.put("ora_time", dd.format(d));
		rootchild.put("ora_schema", schema);
		rootchild.put("ora_table", tb_name);
		return rootchild;
	}

	public String getSql(int model) throws ParseException {
		String sql = "";
		if (model == 2) {
			if (timeFied == null||timeFied.equals("")) {
				if (where != null && !where.equals("")) {// where不为空也不等于空字符串
					if (date.equals("")) {
						sql = "select rowid  from " + schema + "." + tb_name
								+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
								+ "from (select rowid rid from " + schema + "." + tb_name + "  where  " + where
								+ " order by  rowid asc)) where rn= " + rownum + ")order by  t1.rowid asc";
					}else{
						sql = "select rowid  from " + schema + "." + tb_name
								+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
								+ "from (select rowid rid from " + schema + "." + tb_name + "  where  " + where+ " AND rowid "
								+ ">= '" + date 
								+ "' order by  rowid asc)) where rn= " + rownum + ")order by  t1.rowid asc";
					}
					return sql;
				} else {
					if (date.equals("")) {
						sql = "select rowid  from " + schema + "." + tb_name
								+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
								+ "from (select rowid rid from " + schema + "." + tb_name + " order by  rowid asc) )where rn= " + rownum + ")order by  t1.rowid asc";
					}else{
						sql = "select rowid  from " + schema + "." + tb_name
								+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
								+ "from (select rowid rid from " + schema + "." + tb_name + " where rowid>='"+date
								+"' order by  rowid asc) )where rn= " + rownum + ")order by  t1.rowid asc";
					}
					return sql;
				}
			} else {
				if (timeFied.equals("rowid")) {
					if (where != null && !where.equals("")) {// where不为空也不等于空字符串
						if (date.equals("")) {
							sql = "select rowid  from " + schema + "." + tb_name
									+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
									+ "from (select rowid rid from " + schema + "." + tb_name + "  where  " + where
									+ " order by  rowid asc)) where rn= " + rownum + ")order by  t1.rowid asc";
						}else{
							sql = "select rowid  from " + schema + "." + tb_name
									+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
									+ "from (select rowid rid from " + schema + "." + tb_name + "  where  " + where+ " AND rowid "
									+ ">= '" + date 
									+ "' order by  rowid asc)) where rn= " + rownum + ")order by  t1.rowid asc";
						}
						return sql;
					} else {
						if (date.equals("")) {
							sql = "select rowid  from " + schema + "." + tb_name
									+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
									+ "from (select rowid rid from " + schema + "." + tb_name + " order by  rowid asc) )where rn= " + rownum + ")order by  t1.rowid asc";
						}else{
							sql = "select rowid  from " + schema + "." + tb_name
									+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
									+ "from (select rowid rid from " + schema + "." + tb_name + " where rowid>='"+date
									+"' order by  rowid asc) )where rn= " + rownum + ")order by  t1.rowid asc";
						}
						System.out.println(sql);
						return sql;
					}
				} else {
					if (where != null && !where.equals("")) {// where不为空也不等于空字符串
						if (timeFiedType.equals("VARCHAR2")) {
							if (date.equals("")) {
								sql = "select " + timeFied + " from " + schema + "." + tb_name
										+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
										+ "from (select rowid rid from " + schema + "." + tb_name + " where  " + where
										+  "  order by  " + timeFied + " asc) ) where rn = "
										+ rownum + " ) order by  t1." + timeFied + " asc";
							}else{
								sql = "select " + timeFied + " from " + schema + "." + tb_name
										+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
										+ "from (select rowid rid from " + schema + "." + tb_name + " where  " + where
										+ " and to_date(" + timeFied + ",'yyyyMMddhh24miss') >=to_date('" + date
										+ "','yyyyMMddhh24miss')" + "  order by  " + timeFied + " asc) ) where rn = "
										+ rownum + " ) order by  t1." + timeFied + " asc";
							}
							return sql;
						} else {
							if (date.equals("")) {
								sql = "select " + timeFied + " from " + schema + "." + tb_name
										+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
										+ "from (select rowid rid from " + schema + "." + tb_name + " where  " + where
										+"  order by  " + timeFied + " asc)  ) where rn = " + rownum + ") order by  t1."
										+ timeFied + " asc";
							}else{
								sql = "select " + timeFied + " from " + schema + "." + tb_name
										+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
										+ "from (select rowid rid from " + schema + "." + tb_name + " where  " + where
										+ " and " + timeFied + ">=to_date('" + date + "','yyyyMMddhh24miss')"
										+ "  order by  " + timeFied + " asc)  ) where rn = " + rownum + ") order by  t1."
										+ timeFied + " asc";
							}
							System.out.println(sql);
							return sql;
						}
					} else {
						if (timeFiedType.equals("VARCHAR2")) {
							if (date.equals("")) {
								sql = "select " + timeFied + " from " + schema + "." + tb_name
										+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
										+ "from (select rowid rid from " + schema + "." + tb_name + 
										"  order by  " + timeFied + " asc) ) where rn = " + rownum + ")order by  t1."
										+ timeFied + " asc";
							}else{
								sql = "select " + timeFied + " from " + schema + "." + tb_name
										+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
										+ "from (select rowid rid from " + schema + "." + tb_name + " where to_date("
										+ timeFied + ",'yyyyMMddhh24miss') >=to_date('" + date + "','yyyyMMddhh24miss')"
										+ "  order by  " + timeFied + " asc) ) where rn = " + rownum + ")order by  t1."
										+ timeFied + " asc";
							}
							System.out.println(sql);
							return sql;
						} else {
							if (date.equals("")) {
								sql = "select " + timeFied + " from " + schema + "." + tb_name
										+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
										+ "from (select rowid rid from " + schema + "." + tb_name + 
										"  order by  " + timeFied
										+ " asc) ) where rn = " + rownum + ")order by  t1." + timeFied + " asc";
							}else{
								sql = "select " + timeFied + " from " + schema + "." + tb_name
										+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
										+ "from (select rowid rid from " + schema + "." + tb_name + " where " + timeFied
										+ " >=to_date('" + date + "','yyyyMMddhh24miss')" + "  order by  " + timeFied
										+ " asc) ) where rn = " + rownum + ")order by  t1." + timeFied + " asc";
							}
							return sql;
						}
					}
				}

			}
		}
		//   1    timeFied
					//2     where
						//3     date
		if (model == 1) {
			if (timeFied == null||timeFied.equals("")) {
				if (where != null && !where.equals("")) {// where不为空也不等于空字符串
					if (date.equals("")) {
						sql = "select t1.*,rowid from " + schema + "." + tb_name
								+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
								+ "from (select rowid rid from " + schema + "." + tb_name + " where  " + where
								+ "  order by  rowid asc) where rownum <= " + sux + " ) where rn > " + pre 
								+")order by rowid asc";
						System.out.println(sql);
						return sql;
					}else{
						sql = "select t1.*,rowid from " + schema + "." + tb_name
								+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
								+ "from (select rowid rid from " + schema + "." + tb_name + " where  " + where
								+ "  order by  rowid asc) where rownum <= " + sux + " ) where rn > " + pre + " AND rid "
								+ ">= '" + date +"')order by rowid asc";
						System.out.println(sql);
						return sql;
					}
				} else {
					if (date.equals("")) {
						sql = "select t1.*,rowid from " + schema + "." + tb_name
								+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
								+ "from (select rowid rid from " + schema + "." + tb_name
								+ "  order by  rowid asc) where rownum <= " + sux + " ) where rn > " + pre +")order by rowid asc";
						System.out.println(sql);
						return sql;
					}else{
						sql = "select t1.*,rowid from " + schema + "." + tb_name
								+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
								+ "from (select rowid rid from " + schema + "." + tb_name
								+ "  order by  rowid asc) where rownum <= " + sux + " ) where rn > " + pre + " AND rid "
								+ ">= '" + date +"')order by rowid asc";
						System.out.println(sql);
						return sql;
					}
				}
			} else {// 这里是date不为空的时候，也就是说date日期参数不为空
				if (timeFied.toLowerCase().equals("rowid")) {
					if (where != null && !where.equals("")) {// where不为空也不等于空字符串
						if (date.equals("")) {
							sql = "select t1.*,rowid from " + schema + "." + tb_name
									+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
									+ "from (select rowid rid from " + schema + "." + tb_name + " where  " + where
									+ "  order by  rowid asc) where rownum <= " + sux + " ) where rn > " + pre 
									+")order by rowid asc";
							System.out.println(sql);
							return sql;
						}else{
							sql = "select t1.*,rowid from " + schema + "." + tb_name
									+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
									+ "from (select rowid rid from " + schema + "." + tb_name + " where  " + where
									+ "  order by  rowid asc) where rownum <= " + sux + " ) where rn > " + pre + " AND rid "
									+ ">= '" + date +"')order by rowid asc";
							System.out.println(sql);
							return sql;
						}
					} else {
						if (date.equals("")) {
							sql = "select t1.*,rowid from " + schema + "." + tb_name
									+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
									+ "from (select rowid rid from " + schema + "." + tb_name
									+ "  order by  rowid asc) where rownum <= " + sux + " ) where rn > " + pre +")order by rowid asc";
//							System.out.println("date为空   where 为空    timeFied为rowid");
							return sql;
						}else{
							sql = "select t1.*,rowid from " + schema + "." + tb_name
									+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
									+ "from (select rowid rid from " + schema + "." + tb_name
									+ "  order by  rowid asc) where rownum <= " + sux + " ) where rn > " + pre + " AND rid "
									+ ">= '" + date +"')order by rowid asc";
							//"date为空   where 为空    timeFied为rowid"
							System.out.println(sql);
							return sql;
						}
					}
				}
				if (where != null && !where.equals("")) {// where不为空也不等于空字符串
					if (timeFiedType.equals("VARCHAR2")) {
						//0416
						if (date.equals("")) {
							sql = "select t1.*," + timeFied + " from " + schema + "." + tb_name
									+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
									+ "from (select rowid rid from " + schema + "." + tb_name + 
									"  order by  " + timeFied + " asc) where rownum <= " + sux
									+ " ) where rn > " + pre + ")order by  t1." + timeFied + " asc";
							System.out.println(sql);
							return sql;
						}else{
							sql = "select t1.*," + timeFied + " from " + schema + "." + tb_name
									+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
									+ "from (select rowid rid from " + schema + "." + tb_name + " where  " + where
									+ " and  to_date(" + timeFied + ",'yyyyMMddhh24miss')  >=to_date('" + date
									+ "','yyyyMMddhh24miss')" + "  order by  " + timeFied + " asc) where rownum <= " + sux
									+ " ) where rn > " + pre + ")order by  t1." + timeFied + " asc";
							System.out.println(sql);
							return sql;
						}
//						 System.out.println(sql);
					} else {
						//0416
						if (date.equals("")) {
							sql = "select t1.*," + timeFied + " from " + schema + "." + tb_name
									+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
									+ "from (select rowid rid from " + schema + "." + tb_name + " where  " + where 
									+ "  order by  " + timeFied
									+ " asc) where rownum <= " + sux + " ) where rn > " + pre + ")order by  t1." + timeFied
									+ " asc";
							System.out.println(sql);
							return sql;
						}else{
							sql = "select t1.*," + timeFied + " from " + schema + "." + tb_name
									+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
									+ "from (select rowid rid from " + schema + "." + tb_name + " where  " + where + " and "
									+ timeFied + ">=to_date('" + date + "','yyyyMMddhh24miss')" + "  order by  " + timeFied
									+ " asc) where rownum <= " + sux + " ) where rn > " + pre + ")order by  t1." + timeFied
									+ " asc";
							System.out.println(sql);
							return sql;
						}
					}
				} else {
					if (timeFiedType.equals("VARCHAR2")) {
						//0416
						if (date.equals("")) {
							sql = "select t1.*," + timeFied + " from " + schema + "." + tb_name
									+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
									+ "from (select rowid rid from " + schema + "." + tb_name + 
									"  order by  " + timeFied + " asc) where rownum <= " + sux + " ) where rn > " + pre
									+ ") order by  t1." + timeFied + " asc";
							System.out.println(sql);
							return sql;
						}else{
							sql = "select t1.*," + timeFied + " from " + schema + "." + tb_name
									+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
									+ "from (select rowid rid from " + schema + "." + tb_name + " where  " + " to_date("
									+ timeFied + ",'yyyyMMddhh24miss') >=to_date('" + date + "','yyyyMMddhh24miss')"
									+ "  order by  " + timeFied + " asc) where rownum <= " + sux + " ) where rn > " + pre
									+ ") order by  t1." + timeFied + " asc";
							System.out.println(sql);
							return sql;
						}
					} else {
						//0416
						if (date.equals("")) {
							sql = "select t1.*," + timeFied + " from " + schema + "." + tb_name
									+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
									+ "from (select rowid rid from " + schema + "." + tb_name +
									"  order by  " + timeFied
									+ " asc) where rownum <= " + sux + " ) where rn > " + pre + ")order by  t1." + timeFied
									+ " asc";
							System.out.println(sql);
							return sql;
						}else{
							sql = "select t1.*," + timeFied + " from " + schema + "." + tb_name
									+ " t1  where t1.rowid in(select rid from (select rownum rn, rid "
									+ "from (select rowid rid from " + schema + "." + tb_name + " where  " + timeFied
									+ ">=to_date('" + date + "','yyyyMMddhh24miss')" + "  order by  " + timeFied
									+ " asc) where rownum <= " + sux + " ) where rn > " + pre + ")order by  t1." + timeFied
									+ " asc";
							System.out.println(sql);
							return sql;
						}
//						 System.out.println(sql);
					}
				}
			}
		} 
		if (model == 0) {
			// 如果model是0，则获取的是countSql
			if (timeFied == null || timeFied.equals("")) {
				if (where != null && !where.equals("")) {// where不为空也不等于空字符串
					if (date.equals("")) {
						sql = "SELECT count(1) as c  FROM " + schema + "." + tb_name + " where " + where;
					}else{
						sql = "SELECT count(1) as c  FROM " + schema + "." + tb_name + " where rowid" 
					+">='"+date+"' and "+ where;
					}
					System.out.println(sql);
					return sql;
				} else {
					if (date.equals("")) {
						sql = "SELECT count(1) as c  FROM " + schema + "." + tb_name;
					}else{
						sql = "SELECT count(1) as c  FROM " + schema + "." + tb_name+
								" where rowid>='"+date+"'";
					}
					System.out.println(sql);
					return sql;
				}
			} else {
				if (timeFied.toLowerCase().equals("rowid")) {
					if (where != null && !where.equals("")) {// where不为空也不等于空字符串
						if (date.equals("")) {
							sql = "SELECT count(1) as c  FROM " + schema + "." + tb_name + " where " + where;
						}else{
							sql = "SELECT count(1) as c  FROM " + schema + "." + tb_name + " where rowid" 
						+">='"+date+"' and "+ where;
						}
						System.out.println(sql);
						return sql;
					} else {
						if (date.equals("")) {
							sql = "SELECT count(1) as c  FROM " + schema + "." + tb_name;
						}else{
							sql = "SELECT count(1) as c  FROM " + schema + "." + tb_name+
									" where rowid>='"+date+"'";
						}
						System.out.println(sql);
						return sql;
					}
				}
				if (where != null && !where.equals("")) {// where不为空也不等于空字符串
					if (timeFiedType.equals("VARCHAR2")) {
						if (date.equals("")) {
							sql = "SELECT count(*) as c  FROM " + schema + "." + tb_name + " where " + where;
						}else{
							sql = "SELECT count(*) as c  FROM " + schema + "." + tb_name + " where  to_date(" + timeFied
									+ ",'yyyyMMddhh24miss') >= to_date('" + date + "','yyyyMMddhh24miss') and " + where;
						}
						System.out.println(sql);
						return sql;
					} else {
						if (date.equals("")) {
							sql = "SELECT count(*) as c  FROM " + schema + "." + tb_name + " where " + where;
						}else{
							sql = "SELECT count(*) as c  FROM " + schema + "." + tb_name + " where " + timeFied
									+ ">= to_date('" + date + "','yyyyMMddhh24miss') and " + where;
						}
						System.out.println(sql);
						return sql;
					}
				} else {
					if (timeFiedType.equals("VARCHAR2")) {
						if (date.equals("")) {
							sql = "SELECT count(*) as c  FROM " + schema + "." + tb_name ;
						}else{
							sql = "SELECT count(*) as c  FROM " + schema + "." + tb_name + " where to_date(" + timeFied
									+ ",'yyyyMMddhh24miss') >= to_date('" + date + "','yyyyMMddhh24miss') ";
						}
						System.out.println(sql);
						return sql;
					} else {
						if (date.equals("")) {
							sql = "SELECT count(*) as c  FROM " + schema + "." + tb_name ;
						}else{
							sql = "SELECT count(*) as c  FROM " + schema + "." + tb_name + " where " + timeFied
									+ ">= to_date('" + date + "','yyyyMMddhh24miss') ";
						}
						System.out.println(sql);
						return sql;
					}
				}

			}
		}
		return sql;
	}

	/**
	 * 获取需要查询出多少条数据，如果条数超过100000
	 * 
	 * @return
	 */
	public int getCount() {
		String sql = "";
		try {
			sql = getSql(0);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		int size = 0;
		try {
			resultSet = getResultSet(sql);
			while (resultSet.next()) {
				size = resultSet.getInt("c");
			}
		} catch (SQLException e) {
			System.out.println("执行sql：" + sql + " 失败！");
		} finally {
			resultSet = null;
		}
		return size;
	}
	public int getCount(String sql) {
		int size = 0;
		try {
			resultSet = getResultSet(sql);
			while (resultSet.next()) {
				size = resultSet.getInt("c");
			}
		} catch (SQLException e) {
			System.out.println("执行sql：" + sql + " 失败！");
		} finally {
			resultSet = null;
		}
		return size;
	}

	public void setPreAndSux2() {
		int size = end - pre;
		if (size > 0 && count == 0) {
			if (size <= 50000) {
				count++;
				lastcount = size / 2;
				sux = pre + lastcount;
			} else if (size > 50000 && size <= 150000) {
				count++;
				lastcount = (size / 4);
				sux = pre + lastcount;
			} else if (size > 150000 && size <= 250000) {
				count++;
				lastcount = (size / 5);
				sux = pre + lastcount;
			} else if (size > 250000 && size <= 350000) {
				count++;
				lastcount = (size / 10);
				sux = pre + lastcount;
			} else if (size > 350000 && size <= 600000) {
				count++;
				lastcount = (size / 15);
				sux = pre + lastcount;
			} else if (size > 600000) {
				count++;
				lastcount = (size / 50);
				sux = pre + lastcount;
			}
		} else {
			count++;
			if (sux + lastcount <= end) {
				pre = sux;
				sux = sux + lastcount;
			} else {
				pre = sux;
				sux = end;
			}

		}
	}

	public void setPreAndSux1() {
		int size = end - pre;
		if (size > 1 && count == 0) {
			if (size <= 50000) {
				count++;
				lastcount = size / 2;
				sux = pre + lastcount;
			} else if (size > 50000 && size <= 100000) {
				count++;
				lastcount = (size / 3);
				sux = pre + lastcount;
			} else if (size > 100000 && size <= 200000) {
				count++;
				lastcount = (size / 5);
				sux = pre + lastcount;
			} else if (size > 200000 && size <= 1000000) {
				count++;
				lastcount = (size / 8);
				sux = pre + lastcount;
			} else if (size > 1000000 && size <= 10000000) {
				count++;
				lastcount = (size / 16);
				sux = pre + lastcount;
			} else if (size > 10000000 && size <= 100000000) {
				count++;
				lastcount = (size / 32);
				sux = pre + lastcount;
			}
		} else {
			count++;
			if (size>1) {
				if (sux + lastcount <= end) {
					pre = sux;
					sux = sux + lastcount;
				} else {
					pre = sux;
					sux = end;
				}
			}else{
				pre = sux;
				sux = end;
			}

		}
	}
	public void setPreAndSux(int size) {
		if (size > 0 && count == 0) {
			if (size <= 10000) {
				count++;
				lastcount = size / 1;
				sux = pre + lastcount;
			} else if (size > 10000 && size <= 100000) {
				count++;
				lastcount = (size / 3);
				sux = pre + lastcount;
			} else if (size > 100000 && size <= 1000000) {
				count++;
				lastcount = (size / 50);
				sux = pre + lastcount;
			} else if (size > 1000000 && size <= 10000000) {
				count++;
				lastcount = (size / 500);
				sux = pre + lastcount;
			} else if (size > 10000000 && size <= 100000000) {
				count++;
				lastcount = (size / 5000);
				sux = pre + lastcount;
			}
		} else {
			count++;
			System.out.println("count========" + count + "      lastcount=========" + lastcount);
			if (sux + lastcount <= end) {
				pre = sux;
				sux = sux + lastcount;
			} else {
				pre = sux;
				sux = end;
			}

		}
	}

	public void setPreAndSuxtest() {
		int size = end - pre;
		sux = pre + size;
		if (sux + lastcount <= end) {
			pre = sux;
			sux = sux + lastcount;
		} else {
			pre = sux;
			sux = end;
		}
	}

	/**
	 * 无参构造
	 */
	public JDBCUtil() {

	}

	public JDBCUtil(String USERNAME, String PASSWORD, String ip, String port, String SID) {
		this.USERNAME = USERNAME;
		this.PASSWORD = PASSWORD;
		this.ip = ip;
		this.port = port;
		this.SID = SID;
	}
	public JDBCUtil(String USERNAME, String PASSWORD, String ip, String port, String SID,boolean commit) {
		this.USERNAME = USERNAME;
		this.PASSWORD = PASSWORD;
		this.ip = ip;
		this.port = port;
		this.SID = SID;
	}

	/**
	 * 有参构造
	 * 
	 * @param USERNAME
	 * @param PASSWORD
	 * @param ip
	 * @param port
	 * @param SID
	 * @param schema
	 * @param ServiceName
	 * @param tb_name
	 * @param timeFied
	 * @param date
	 * @param where
	 */
	public JDBCUtil(String USERNAME, String PASSWORD, String ip, String port, String SID, String schema,
			String ServiceName, String tb_name, String timeFied, String date, String where) {
		this.USERNAME = USERNAME;
		this.PASSWORD = PASSWORD;
		this.ip = ip;
		this.port = port;
		this.SID = SID;
		this.schema = schema;
		this.ServiceName = ServiceName;
		this.tb_name = tb_name;
		this.timeFied = timeFied;
		this.date = date;
		this.where = where;
	}

	public JDBCUtil(String USERNAME, String PASSWORD, String ip, String port, String SID, String schema,
			String ServiceName, String tb_name, String where) {
		this.USERNAME = USERNAME;
		this.PASSWORD = PASSWORD;
		this.ip = ip;
		this.port = port;
		this.SID = SID;
		this.schema = schema;
		this.ServiceName = ServiceName;
		this.tb_name = tb_name;
		this.where = where;
	}

	public JDBCUtil(String USERNAME, String PASSWORD, String ip, String port, String SID, String schema,
			String ServiceName, String tb_name) {
		this.USERNAME = USERNAME;
		this.PASSWORD = PASSWORD;
		this.ip = ip;
		this.port = port;
		this.SID = SID;
		this.schema = schema;
		this.ServiceName = ServiceName;
		this.tb_name = tb_name;
	}

	/**
	 * 获取Map集合，String是列名，Object是值
	 * 
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public Map<String, Object> getresultMap(ResultSet rs) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (rs.next()) {
			ResultSetMetaData rsMeta = rs.getMetaData();
			int columnCount = rsMeta.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				dataMap.put(rsMeta.getColumnLabel(i), rs.getObject(i));
			}
		}
		return dataMap;
	}

	/**
	 * 
	 * @param USERNAME
	 * @param PASSWORD
	 * @param ip
	 * @param port
	 * @param SID
	 * @param schema
	 * @param ServiceName
	 * @param tb_name
	 * @param timeFied
	 * @param date
	 * @param where
	 * @return
	 */
	public static JDBCUtil getInstance(String USERNAME, String PASSWORD, String ip, String port, String SID,
			String schema, String ServiceName, String tb_name, String timeFied, String date, String where) {
		JDBCUtil jdbc = null;
		if (timeFied == null || timeFied.equals("") || where.equals("") || where == null) {
			jdbc = new JDBCUtil(USERNAME, PASSWORD, ip, port, SID, schema, ServiceName, tb_name);
		} else {
			jdbc = new JDBCUtil(USERNAME, PASSWORD, ip, port, SID, schema, ServiceName, tb_name, timeFied, date,
					where);
		}

			jdbc.getConnection();
		return jdbc;
	}

	/**
	 * 从数据库中查询数据
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public ResultSet getResultSet(String sql, List<Object> params) throws SQLException {
		int index = 1;
		pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		if (params != null && !params.isEmpty()) {
			for (int i = 0; i < params.size(); i++) {
				pstmt.setObject(index++, params.get(i));
			}
		}
		resultSet = pstmt.executeQuery();
		return resultSet;
	}

	public ResultSet getResultSet(String sql) throws SQLException {
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		resultSet = stmt.executeQuery(sql);
		return resultSet;

	}

	/**
	 * //注册驱动
	 */
	private void registeredDriver() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void test1(){
	}
	/**
	 * 驱动注册和连接
	 * 
	 * @throws SQLException
	 */
	public boolean getConnection(){
		// 注册驱动
		boolean flag =true;
		registeredDriver();
		String URL = "jdbc:oracle:thin:@" + ip + ":" + port + "/" + SID;
		try {
			DriverManager.setLoginTimeout(1);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag =getConnection1();
		}
		return flag;
	}
	/**
	 * 驱动注册和连接
	 * 
	 * @throws SQLException
	 */
	public boolean getConnection1(){
		// 注册驱动
		boolean flag =true;
		registeredDriver();
		String URL = "jdbc:oracle:thin:@" + ip + ":" + port + ":" + SID;
		try {
			
			DriverManager.setLoginTimeout(1);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag =false;
		}
		return flag;
	}
	/**
	 * 驱动注册和连接
	 * 
	 * @throws SQLException
	 */
	public boolean getConnection(boolean commit){
		// 注册驱动
		boolean flag =true;
		registeredDriver();
		String URL = "jdbc:oracle:thin:@" + ip + ":" + port + ":" + SID;
		try {
			
			DriverManager.setLoginTimeout(1);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag =false;
		}
		return flag;
	}
	public void commit() throws SQLException{
		con.commit();
	}
	/**
	 * 线程主体实现
	 * 
	 * @param taskID
	 * @param start
	 * @param end
	 * @return
	 */
	private static Runnable createTask(final int taskID, int start, int end) {
		return new Runnable() {
			public void run() {
				ResultSet resultSet = null;
				JDBCUtil db = new JDBCUtil("admin_test", "admin_test", "10.2.42.114", "1521", "orcl");
				db.getConnection();
				db.setSchema("admin_test");
				db.setTb_name("drv_log");
				db.setPre(start);
				db.setEnd(end);
				SAXCreate sax = new SAXCreate();
				sax.setTree(db.getCLRootChild("1000", "azdm"));
				try {
					db.getConnection();
					db.setTimeFied("ROWID");
//					db.setWhere("ywlx='C'");
					db.setRownum(start + 1);
					HashMap<String, String> startmap = db.executedd(db.getSql(2));
					System.out.println("断点记录 测试 ----startmap-"+ startmap.toString());
					String sql ="";
					while (db.getSux() < db.getEnd()) {
						// 如果关闭了
						db.setPreAndSux1();
						sql =db.getSql(1);
						System.out.println(sql);
						resultSet = db.getResultSet(sql);
						sax.createXMLDatalist1(resultSet, db.getTimeFied());
						resultSet = null;
						db.stmt.close();
						db.resultSet.close();
					}
					if (sax.isDocumentStatus()) {
						sax.createXMLEnd(true);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					// 关闭连接
					db.closeDB();
				}
				// 存量数据断点表
			}
		};
	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		// clResultSet();143367
		// 将剩余连接数获取；
		ThreadPool threadPool = new ThreadPool(7); //
		// 创建一个此表剩余可连接的线程数目工作线程的线程池。
		// 线程池分好了
		int start = 0;
		int end = 0;
		int count =400000/ 100000;
		for (int i = 0; i <=count; i++) {
			if (end<400000) {
				if (end + 100000 <400000) {
					start = i * 100000;
					end = start + 100000;
				} else {
					start = end;
					end = 400000;
				}
				threadPool.execute(createTask(i, start, end));
			}
		}
		threadPool.waitFinish(); // 等待所有任务执行完毕
		threadPool.closePool(); // 关闭线程池
		long endTime = System.currentTimeMillis();
		long time =(endTime - startTime);
		System.out.println("程序运行时间： " +time / 1000 + "s ;"+time);
	}

	/**
	 * 完成对数据库的表的添加删除和修改的操作
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public boolean executeUpdate(String sql, List<Object> params) throws SQLException {

		boolean flag = false;

		int result = -1; // 表示当用户执行添加删除和修改的时候所影响数据库的行数

		pstmt = con.prepareStatement(sql);

		if (params != null && !params.isEmpty()) {
			int index = 1;
			for (int i = 0; i < params.size(); i++) {
				pstmt.setObject(index++, i);
			}
		}

		result = pstmt.executeUpdate();
		flag = result > 0 ? true : false;

		return flag;
	}

	public boolean executeUpdate(String sql) throws SQLException {

		boolean flag = false;

		int result = -1; // 表示当用户执行添加删除和修改的时候所影响数据库的行数

		pstmt = con.prepareStatement(sql);
		result = pstmt.executeUpdate();
		flag = result > 0 ? true : false;

		return flag;
	}

	/**
	 * 从数据库中查询数据
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String, Object>> executeQuery(String sql, List<Object> params) throws SQLException {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		int index = 1;
		pstmt = con.prepareStatement(sql);
		if (params != null && !params.isEmpty()) {
			for (int i = 0; i < params.size(); i++) {
				pstmt.setObject(index++, params.get(i));
			}
		}
		resultSet = pstmt.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();
		int cols_len = metaData.getColumnCount();
		while (resultSet.next()) {
			Map<String, Object> map = new HashMap<String, Object>();
			for (int i = 0; i < cols_len; i++) {
				String cols_name = metaData.getColumnName(i + 1);
				Object cols_value = resultSet.getObject(cols_name);
				if (cols_value == null) {
					cols_value = "";
				}
				map.put(cols_name.toLowerCase(), cols_value);
			}
			list.add(map);
			break;// test
		}
		return list;

	}
	/**
	 * 从数据库中查询数据
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public List<String> executeQuery1(String sql) throws SQLException {
		List<String> list = new ArrayList<>();
		pstmt = con.prepareStatement(sql);
		resultSet = pstmt.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();
		int cols_len = metaData.getColumnCount();
		while (resultSet.next()) {
			String tbname = "";
			String colname = "";
			for (int i = 0; i < cols_len; i++) {
				String cols_name = metaData.getColumnName(i + 1);
				Object cols_value = resultSet.getObject(cols_name);
				if (cols_value == null) {
					cols_value = "";
				}
				if (i==0) {
					tbname= cols_value.toString();
				}
				if (i==1) {
					colname= cols_value.toString();
				}
			}
			String value = tbname+"."+colname;
			list.add(value.toLowerCase());
		}
		return list;
		
	}

	/**
	 * jdbc的封装可以用反射机制来封装,把从数据库中获取的数据封装到一个类的对象里
	 * 
	 * @param sql
	 * @param params
	 * @param cls
	 * @return
	 * @throws Exception
	 */
	public <T> List<T> executeQueryByRef(String sql, List<Object> params, Class<T> cls) throws Exception {
		List<T> list = new ArrayList<T>();
		int index = 1;
		pstmt = con.prepareStatement(sql);
		if (params != null && !params.isEmpty()) {
			for (int i = 0; i < params.size(); i++) {
				pstmt.setObject(index++, params.get(i));
			}
		}
		resultSet = pstmt.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();
		int cols_len = metaData.getColumnCount();
		while (resultSet.next()) {
			T resultObject = cls.newInstance(); // 通过反射机制创建实例
			for (int i = 0; i < cols_len; i++) {
				String cols_name = metaData.getColumnName(i + 1);
				Object cols_value = resultSet.getObject(cols_name);
				if (cols_value == null) {
					cols_value = "";
				}
				Field field = cls.getDeclaredField(cols_name);
				field.setAccessible(true); // 打开javabean的访问private权限
				field.set(resultObject, cols_value);
			}
			list.add(resultObject);
		}
		return list;

	}

	public void closeDB() {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 从数据库中查询数据
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public ConcurrentHashMap<String, Integer> executeQuery(String sql) throws SQLException {
		ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();
		pstmt = con.prepareStatement(sql);
		resultSet = pstmt.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();
		int cols_len = metaData.getColumnCount();
		while (resultSet.next()) {
			String ip = "";
			Integer index = 0;
			for (int i = 0; i < cols_len; i++) {
				String cols_name = metaData.getColumnName(i + 1);
				if (cols_name.equals("JGXTLB")) {
					Object cols_value = resultSet.getObject(cols_name);
					if (cols_value == null) {
						cols_value = "";
					}
					ip = cols_value.toString();
				}
				if (cols_name.equals("CLNUM")) {
					Object cols_value = resultSet.getObject(cols_name);
					if (cols_value == null) {
						cols_value = "0";
					}
					index = new Integer(cols_value.toString());
				}
				if (cols_name.equals("ZLNUM")) {
					Object cols_value = resultSet.getObject(cols_name);
					if (cols_value == null) {
						cols_value = "0";
					}
					index = new Integer(cols_value.toString());
				}
			}
			map.put(ip, index);
		}
		return map;

	}

	/**
	 * 从数据库中查询数据
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws ParseException 
	 */
	public HashMap<String, String> executedd(String sql) throws SQLException, ParseException {
		HashMap<String, String> map = new HashMap<String, String>();
		Statement stmt = con.prepareStatement(sql);
		ResultSet resultSet = getResultSet(sql);
		while (resultSet.next()) {
			ResultSetMetaData rsMeta = resultSet.getMetaData();
			int columnCount = rsMeta.getColumnCount();
			String value = "";
			String key = "";
			for (int i = 1; i <= columnCount; i++) {
				// 每列进行写入
				key = rsMeta.getColumnLabel(i).toLowerCase();
				value = "";
				if (resultSet.getObject(i) != null) {
					if (rsMeta.getColumnTypeName(i).equals("DATE")) {
						value = dd.format(resultSet.getTimestamp(i));
					} else if (rsMeta.getColumnTypeName(i).equals("TIMESTAMP")) {
						value = dd.format(resultSet.getTimestamp(i));
					} else {
						value = resultSet.getString(i);
					}
				}
			}
			if (timeFiedType.equals("VARCHAR2")&&!timeFied.equals("rowid")) {
				map.put(key, dd.format(getTime(forma.parse(value))));
			}else{
				map.put(key, value);
			}
		}
		resultSet.close();
		stmt.close();
		stmt = null;
		resultSet = null;
		return map;

	}
	public  Timestamp getTime(Date utilDate) {
		Timestamp sqlDate = new Timestamp(utilDate.getTime());// util.Date转sql.Date
		return sqlDate;
	}
	/**
	 * gettAndsett
	 * 
	 * @return
	 */

	public String getUSERNAME() {
		return USERNAME;
	}

	public int getLastcount() {
		return lastcount;
	}

	public void setLastcount(int lastcount) {
		this.lastcount = lastcount;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPre() {
		return pre;
	}

	public void setPre(int pre) {
		this.pre = pre;
	}

	public int getSux() {
		return sux;
	}
	/**
	 * 从数据库中查询存量文件数据
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public List<String> executeQueryClec(String jgxtlb,String sql,String model) throws SQLException {
		List<String> list = new ArrayList<>();
		pstmt = con.prepareStatement(sql);
		resultSet = pstmt.executeQuery();
		int loop=-1;
		int num=0;
		while (resultSet.next()) {
			num= Integer.valueOf(resultSet.getString("WJM").substring(resultSet.getString("WJM").length()-6, resultSet.getString("WJM").length()));
			if (-1==loop) {
				loop= Integer.valueOf(resultSet.getString("WJM").substring(resultSet.getString("WJM").length()-6, resultSet.getString("WJM").length()));
			}else{
				loop++;
			}
			for (int i = loop; i <num; i++) {
				 list.add(resultSet.getString("WJM").substring(0, 19)+String.format("%06d", loop));
				 loop++;
			}
		}
		if (model.equals("cl")) {
			XMLFileName.clcountMap.put(jgxtlb, num);
		}else if(model.equals("zl")){
			XMLFileName.zlcountMap.put(jgxtlb, num);
		}else {
			XMLFileName.hdcountMap.put(jgxtlb, num);
		}
		return list;
		
	}
	public void setSux(int sux) {
		this.sux = sux;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		this.PASSWORD = pASSWORD;
	}

	public String getDRIVER() {
		return DRIVER;
	}

	public void setDRIVER(String dRIVER) {
		this.DRIVER = dRIVER;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getSID() {
		return SID;
	}

	public void setSID(String sID) {
		this.SID = sID;
	}

	public String getServiceName() {
		return ServiceName;
	}

	public void setServiceName(String serviceName) {
		ServiceName = serviceName;
	}

	public String getTb_name() {
		return tb_name;
	}

	public void setTb_name(String tb_name) {
		this.tb_name = tb_name;
	}

	public String getTimeFied() {
		return timeFied;
	}

	public void setTimeFied(String timeFied) {
		this.timeFied = timeFied;
		if (timeFied.equals("*")||timeFied.equals("")||null==timeFied) {
			this.timeFied="rowid";
		}
		String sql = "select " + timeFied + " from " + schema + "." + tb_name+" where rownum=1";
		try {
			stmt = con.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData dataset = rs.getMetaData();
			for (int i = 1; i <= dataset.getColumnCount(); i++) {
				this.timeFiedType = dataset.getColumnTypeName(i).toUpperCase();
			}
			rs.close();
			stmt = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getTimeFiedType() {
		return timeFiedType;
	}

	public void setTimeFiedType(String timeFiedType) {
		this.timeFiedType = timeFiedType;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	public String getSjcz() {
		return sjcz;
	}

	public void setSjcz(String sjcz) {
		this.sjcz = sjcz;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}
}

//
//	public static void test() {
//		ResultSet resultSet = null;
//		JDBCUtil db = new JDBCUtil("rds_big", "rds_big", "10.2.42.114", "1521", "orcl");
//		db.setSchema("admin_test");
//		db.setTb_name("DRV_LOG");
//		// 设置起始节点结束节点
//		db.setPre(0);
//		db.setEnd(193514);
//		SAXCreate sax = new SAXCreate();
//		int filesize = 0;
//		try {
//			db.getConnection();
//			int count = 0;
//			while (db.getSux() < db.getEnd()) {
//				if (!sax.isDocumentStatus()) {
//					String filename = "D:\\TEST1" + count + ".xml";
//					sax.createXMLHead(filename, true);
//					sax.createXMLTitle(db.getCLRootChild("10", "azdm"), true);
//				}
//				System.out.println("pre===========" + db.getPre());
//				System.out.println("sux===========" + db.getSux());
//				count++;
//				resultSet = db.getResultSet(db.getSql(1));
////				Map<String, Object> param = sax.createXMLDatalist(resultSet, db.getPre(), db.getTimeFied());
////				int saxsize = new Integer(param.get("filesize").toString());
////				filesize = filesize + saxsize;
//				resultSet = null;
//				db.getStmt().close();
//				db.getResultSet().close();
//				if (filesize > 15728640) {
//					sax.createXMLEnd(true);
//					filesize = 0;
//				}
//			}
//			if (sax.isDocumentStatus()) {
//				sax.createXMLEnd(true);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//
//			// 关闭连接
//			db.closeDB();
//		}
//	}
//
//	public static void clResultSet() {
//		ResultSet resultSet = null;
//		JDBCUtil db = new JDBCUtil("lander", "admin123", "127.0.0.1", "1521", "orcl");
//		db.setSchema("lander");
//		db.setTb_name("tb_test");
//		int size = db.getCount();
//		System.out.println(db.getCLRootChild("10", "azdm").toString());
//		SAXCreate sax = new SAXCreate();
//		int filesize = 0;
//		try {
//			int count = 0;
//			while (db.getSux() < size) {
//				// 如果关闭了
//				if (!sax.isDocumentStatus()) {
//					String filename = "E:\\TEST" + count + ".xml";
//					// 打开
//					sax.createXMLHead(filename, true);
//					sax.createXMLTitle(db.getCLRootChild("10", "azdm"), true);
//				}
//				db.setPreAndSux(size);
//				count++;
//				System.out.println(db.getSql(1));
//				resultSet = db.getResultSet(db.getSql(1));
//				try {
////					sax.createXMLDatalist(resultSet, db.getPre(), db.getTimeFied());
//					resultSet = null;
//					db.resultSet.close();
//					db.stmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//				// 如果文件大于15M关闭
//				if (filesize> 15728640) {
//					sax.createXMLEnd(true);
//					filesize = 0;
//				}
//			}
//			if (sax.isDocumentStatus()) {
//				sax.createXMLEnd(true);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			db.closeDB();
//		}
//		// 不在此地关闭连接
//		/*
//		 * 
//		 */
//
//	}