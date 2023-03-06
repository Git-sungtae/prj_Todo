package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
public class DbConn {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "scott";
		String upw = "1111";
		
		try (Connection conn = DriverManager.getConnection(url, uid, upw);
				){
			if (conn != null) {
				System.out.println("DB연결 성공");
			} else {
				System.out.println("DB연결 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}