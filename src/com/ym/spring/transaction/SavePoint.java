package com.ym.spring.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

/**
 * �����ύ��������Ӧ�ã�����
 * eg:����������У������쳣����ô���������ع������ﱣ���Savepoint��Ȼ���ύ�������
 * @author Administrator
 *
 */
public class SavePoint {

	/** 
     * ���������ࡢ�������� 
     *  
     * A:�Ȱ�connection���óɲ������Զ��ύ 
     *  
     * B:�м��趨����� 
     *  
     * C:�ع��ĵط�Ҫʹ�ñ���� 
     *  
     * D�����Ҫ���ǽ���commit()�ύ���� 
     *  
     * @param args 
     */  
    public static void main(String[] args) throws SQLException {  
        test();  
    }  
  
    /** 
     * ������������ı���� 
     *  
     * ���޸�������Ǯ�������ñ���㣬���޸������Ǯ�����ж����ĵ�Ǯ���Ƿ����300���ǣ������쳣�����лع��������Ĳ��� 
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
            // ��ʼ�����Զ��ύ  
            conn.setAutoCommit(false);  
            st = conn.createStatement();  
            // ������ȥ10Ԫ  
            String sql = "update  account.t_user_account_00 set balance = 102  where uid = 201609010292735000";  
            st.executeUpdate(sql);  
            // ��������ı����  
            sp = conn.setSavepoint();  
            // �����10Ԫ  
            sql = "update  account.t_user_account_00 set balance = 301  where uid = 201609010153615100";  
            st.executeUpdate(sql);  
            // ��ѯ�������ĵ�Ǯ��  
            sql = "select * from account.t_user_account_00 where uid = 201609010292735000";  
            rs = st.executeQuery(sql);  
  
            float money = 0.0f;  
            if (rs.next()) {  
                money = rs.getLong("balance");  
            }  
            // �ж����ĵ�Ǯ���Ƿ����300  
            if (money > 100) {  
                throw new RuntimeException("�Ѿ�����300");  
            }  
            sql = "update  account.t_user_account_00 set balance = 401  where uid = 201609010153615100";  
            st.executeUpdate(sql);  
            conn.commit();  
        } catch (ClassNotFoundException e) {  
            throw new ExceptionInInitializerError(e);  
        } catch (RuntimeException e) {  
            // ������ĵ�Ǯ������300�����׳�RuntimeException�쳣  
            if (conn != null && sp != null) {  
                // ���лع�����  
                conn.rollback(sp);  
                System.out.println("�ع���������ȥ10Ԫ��״̬��");  
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
