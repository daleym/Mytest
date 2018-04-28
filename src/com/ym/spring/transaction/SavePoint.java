package com.ym.spring.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

/**
 * 事物提交：保存点的应用！！！
 * eg:如果再事物中，发生异常，那么可以做到回滚到事物保存点Savepoint，然后提交事物！！！
 * @author Administrator
 *
 */
public class SavePoint {

	/** 
     * 加载驱动类、建立连接 
     *  
     * A:先把connection设置成不进行自动提交 
     *  
     * B:中间设定保存点 
     *  
     * C:回滚的地方要使用保存点 
     *  
     * D：最后不要忘记进行commit()提交事务 
     *  
     * @param args 
     */  
    public static void main(String[] args) throws SQLException {  
        test();  
    }  
  
    /** 
     * 本例测试事务的保存点 
     *  
     * 先修改张三的钱数，设置保存点，再修改王五的钱数，判断李四的钱数是否大于300，是：则抛异常，进行回滚到保存点的操作 
     *  
     *  
     * @throws SQLException 
     */  
    static void test() throws SQLException {  
        Connection conn = null;  
        Statement st = null;  
        ResultSet rs = null;  
        Savepoint sp = null;  
        try {  
//            Class.forName("com.mysql.jdbc.Driver");  
            Class.forName("org.mariadb.jdbc.Driver");  
            conn = DriverManager.getConnection("jdbc:mysql://192.168.9.93:3306/account", "mysqluser", "mysqluser@zyxr.com");  
            // 初始化不自动提交  
            conn.setAutoCommit(false);  
            st = conn.createStatement();  
            // 张三减去10元  
            String sql = "update  account.t_user_account_00 set balance = 102  where uid = 201609010292735000";  
            st.executeUpdate(sql);  
            // 设置事务的保存点  
            sp = conn.setSavepoint();  
            // 王五减10元  
            sql = "update  account.t_user_account_00 set balance = 301  where uid = 201609010153615100";  
            st.executeUpdate(sql);  
            // 查询的是李四的钱数  
            sql = "select * from account.t_user_account_00 where uid = 201609010292735000";  
            rs = st.executeQuery(sql);  
  
            float money = 0.0f;  
            if (rs.next()) {  
                money = rs.getLong("balance");  
            }  
            // 判断李四的钱数是否大于300  
            if (money > 100) {  
                throw new RuntimeException("已经超过300");  
            }  
            sql = "update  account.t_user_account_00 set balance = 401  where uid = 201609010153615100";  
            st.executeUpdate(sql);  
            conn.commit();  
        } catch (ClassNotFoundException e) {  
            throw new ExceptionInInitializerError(e);  
        } catch (RuntimeException e) {  
            // 如果李四的钱数大于300，则抛出RuntimeException异常  
            if (conn != null && sp != null) {  
                // 进行回滚操作  
                conn.rollback(sp);  
                System.out.println("回滚到张三减去10元的状态！");  
                conn.commit();  
            }  
            throw e;  
        } catch (SQLException e) {  
            if (conn != null) {  
                conn.rollback();  
            }  
            throw e;  
        } finally {  
            try {  
                if (rs != null) {  
                    rs.close();  
                }  
            } catch (SQLException e) {  
                e.printStackTrace();  
            } finally {  
                try {  
                    if (st != null) {  
                        st.close();  
                    }  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                } finally {  
                    try {  
                        if (conn != null) {  
                            conn.close();  
                        }  
                    } catch (SQLException e) {  
                        e.printStackTrace();  
                    }  
                }  
            }  
        }  
    }
	
}
