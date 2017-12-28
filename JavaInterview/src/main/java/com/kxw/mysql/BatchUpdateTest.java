package com.kxw.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Create by kangxiongwei on 2017/12/28 15:06.
 */
public class BatchUpdateTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/kxw_test?useSSL=true";
        Connection connection = DriverManager.getConnection(url, "root", "Kxw@672015");
        connection.setAutoCommit(false);
        String sql = "UPDATE t_user SET username = 'zhangsan' WHERE id = ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        for (int i = 0; i < 3; i++) {
            ps.setInt(1, i);
            ps.addBatch();
        }
        int[] res = ps.executeBatch();
        connection.commit();
        connection.setAutoCommit(true);
        for (int i : res) {
            System.out.println(i);
        }
        connection.close();
    }


}
