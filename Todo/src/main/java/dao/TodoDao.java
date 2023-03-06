package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dto.TodoDto;

public class TodoDao {

	public int addTodo(TodoDto toDoDto) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "scott";
		String upw = "1111";
		int added = 0;
		
		String name = toDoDto.getName();
		String title = toDoDto.getTitle();
		int sequence = toDoDto.getSequence();
		String sql = "insert into todo(title, name, sequence) "
						+ "values('" + title + "', '" + name + "', "
						+ sequence + ")";
//		String sql2= "insert into todo(title, name, sequence) values(?, ?, ?)";
		
		System.out.println(sql);
		
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(url, uid, upw);
				Statement stmt = conn.createStatement()){
//			PreparedStatement pstmt = conn.prepareStatement(sql2);
			added = stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(added);
		return added;
		
	}



	public List<TodoDto> getTodos() {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uid = "scott";
		String upw = "1111";
		ArrayList<TodoDto> todoList = new ArrayList<>();
		String sql = "select id, title, name, sequence, type, TO_CHAR(regdate,'YY\"년\"MM\"월\"DD\"일\"HH24\"시\"mm\"분\"') from todo";
		
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(url, uid, upw);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
				
				while(rs.next()) {
				 TodoDto todoDto = new TodoDto();
				 
				 todoDto.setId(rs.getInt(1));
				 todoDto.setTitle(rs.getString(2));
				 todoDto.setName(rs.getString(3));
				 todoDto.setSequence(rs.getInt(4));
				 todoDto.setType(rs.getString(5));
				 todoDto.setRegDate(rs.getString(6));
				 
				 System.out.println(todoDto);
				 
				 todoList.add(todoDto);
				 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return todoList;
	}
	 

//	private int updateTodo(TodoDto toDoDto) {
//		int updatedTodos = 0;
//		return Math.abs(this.todos - updatedTodos);
//	}

}
