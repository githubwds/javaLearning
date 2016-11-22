package org.dsw.test.databases;

import java.sql.*;
import java.util.Properties;

public class TestJDBC {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); // 纯粹是为了确保能找到driver class
            Properties connProps = new Properties();
            connection = DriverManager.getConnection("jdbc:mysql://192.168.1.212:3307/ias", "artogrid", "artogrid");
            statement = connection.createStatement();
            String sql = "select count(*) from asset_nstd";
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != resultSet) {
                    resultSet.close();
                }
                if (null != statement) {
                    statement.close();
                }
                if (null != connection) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
