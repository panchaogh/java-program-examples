package top.pcstar.basics.jdbc;

import java.sql.*;

/**
 * @Author: PanChao
 * @Description: JDBC连接数据库步骤
 * @Date: Created in 17:31 2018/5/9
 */
public class JDBCOperations {
    private static final String USER_NAME = "test";
    private static final String PASS_WORD = "888888";
    //2.提供数据库连接URL
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";

    //1.加载JDBC驱动程序
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("加载JDBC驱动包失败!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //3.创建数据库连接（获取Connection）
        Connection connection = getConnection();
        Statement stat = null;
        ResultSet rs = null;
        try {
            //4.创建一个会话(Statement,PreparedStatement,CallableStatement)
            /*
            执行静态SQL语句:Statement
            执行动态SQL语句:PreparedStatement
            执行数据库存储过程:CallableStatement
             */
            stat = connection.createStatement();
            //5.执行SQL语句
            /*
            execute()返回是否成功
            executeQuery()返回一个结果集ResultSet
            executeUpdate()返回处理数据条数
             */
            rs = stat.executeQuery("select * from test");
            //6.处理结果
            while (rs.next()) {
                System.out.println(rs.getString(1) + "---" + rs.getString(2) + "---" + rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7.关闭JDBC对象(释放资源)
            close(connection, stat, rs);
        }
    }

    /**
     * 关闭JDBC对象(释放资源)
     *
     * @param connection
     * @param stat
     * @param rs
     */
    private static void close(Connection connection, Statement stat, ResultSet rs) {
        //关闭顺序：ResultSet>Statement,PreparedStatement,CallableStatement>Connection
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取Connection
     *
     * @return
     */
    private static Connection getConnection() {
        Connection connection = null;
        try {
            //创建数据库连接（获取Connection）
            connection = DriverManager.getConnection(URL, USER_NAME, PASS_WORD);
        } catch (SQLException e) {
            System.out.println("创建数据库连接失败!");
            e.printStackTrace();
        }
        return connection;
    }
}
