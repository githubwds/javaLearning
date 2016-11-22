package org.dsw.test.databases;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDataSourceJNDI {

    public void bindDataSource() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // 纯粹是为了确保能找到driver class
            MysqlConnectionPoolDataSource poolDataSource = new MysqlConnectionPoolDataSource();
            poolDataSource.setURL("jdbc:mysql://192.168.1.212:3307/ias");
            poolDataSource.setUser("artogrid");
            poolDataSource.setPassword("artogrid");

            InitialContext ctx = new InitialContext();
            ctx.bind("jdbc/mysql_212_3307", poolDataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TestDataSourceJNDI().bindDataSource();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            InitialContext context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("jdbc/mysql_212_3307");
            connection = dataSource.getConnection();

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
