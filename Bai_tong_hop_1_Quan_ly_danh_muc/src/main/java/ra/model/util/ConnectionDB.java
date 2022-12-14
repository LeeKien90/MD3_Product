package ra.model.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/quan_ly_san_pham";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static Connection openConnection(){
        Connection conn = null;
        try {
//            1. Set Driver làm việc với CSDL MySQL
            Class.forName(DRIVER);
//            2. Khởi tạo đối tượng connection làm việc với Database
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn, CallableStatement callSt) {
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (callSt!=null){
            try {
                callSt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
