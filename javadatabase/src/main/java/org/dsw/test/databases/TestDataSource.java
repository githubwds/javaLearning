package org.dsw.test.databases;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDataSource {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); // 纯粹是为了确保能找到driver class

//            MysqlDataSource dataSource = new MysqlDataSource();
            MysqlConnectionPoolDataSource poolDataSource = new MysqlConnectionPoolDataSource();
            poolDataSource.setURL("jdbc:mysql://192.168.1.212:3307/ias");
            poolDataSource.setUser("artogrid");
            poolDataSource.setPassword("artogrid");
            connection = poolDataSource.getConnection();
            System.out.println("connection transaction isolation level: " + connection.getTransactionIsolation());
            System.out.println("connection transaction isolation level support: "
                    + connection.getMetaData().supportsTransactionIsolationLevel(Connection.TRANSACTION_SERIALIZABLE));
            String sql = "select count(*) from asset_nstd";
            statement = connection.prepareStatement(sql);
            System.out.println("connection autoCommit status: " + connection.getAutoCommit());
            connection.setAutoCommit(false);
            System.out.println("connection autoCommit status: " + connection.getAutoCommit());
            resultSet = statement.executeQuery(sql);
            connection.commit();
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
                    connection.setAutoCommit(true);
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
