package db;


import java.sql.Connection;
import java.sql.DriverManager;
public class Db {
	public static String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	public static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static String UID = "scott";
	public static String UPW = "1111";	
	
	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection(URL, UID, UPW);
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