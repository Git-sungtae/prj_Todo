package todo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
	public static String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static String UID = "scott";
	public static String UPW = "1111";	
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, UID, UPW);
			if (conn != null) {
				System.out.println("DB연결 성공");
			} else {
				System.out.println("DB연결 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
    public static void rollback(Connection conn) {
		if (conn != null) {
	        try {
	            conn.rollback(); // 변경 내용을 취소하고 롤백
	        } catch (SQLException e1) {
	            e1.printStackTrace();
	        }
	    }
    }
    
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
    public static void main(String[] args) {
		getConnection();
	}
    
}