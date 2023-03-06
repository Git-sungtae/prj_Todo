package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.Db;
import dto.TodoDto;

public class TodoDao {

	public int addTodo(TodoDto toDoDto) {
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
			Class.forName(Db.DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(Db.URL, Db.UID, Db.UPW);
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
		ArrayList<TodoDto> todoList = new ArrayList<>();
		String sql = "select id, title, name, sequence, type, TO_CHAR(regdate,'YY\"년\"MM\"월\"DD\"일\"HH24\"시\"mm\"분\"') from todo where type = 'TODO'";
		
		try {
			Class.forName(Db.DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(Db.URL, Db.UID, Db.UPW);
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

	public List<TodoDto> getDoings() {
		ArrayList<TodoDto> doingList = new ArrayList<>();
		String sql = "select id, title, name, sequence, type, TO_CHAR(regdate,'YY\"년\"MM\"월\"DD\"일\"HH24\"시\"mm\"분\"') from todo where type = 'DOING'";
		
		try {
			Class.forName(Db.DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(Db.URL, Db.UID, Db.UPW);
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
				 
				 doingList.add(todoDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return doingList;
	}	

	public List<TodoDto> getDones() {
		ArrayList<TodoDto> doneList = new ArrayList<>();
		String sql = "select id, title, name, sequence, type, TO_CHAR(regdate,'YY\"년\"MM\"월\"DD\"일\"HH24\"시\"mm\"분\"') from todo where type = 'DONE'";
		
		try {
			Class.forName(Db.DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(Db.URL, Db.UID, Db.UPW);
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
				 
				 doneList.add(todoDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return doneList;
	}	
	

	public int updateTodo(TodoDto toDoDto) {
		int result = 0;
		String sql = "";
		
		if (toDoDto.getType().equals("TODO")) {
			sql = "update todo set type = 'DOING' where id = ?";
		} else if(toDoDto.getType().equals("DOING")) {
			sql = "update todo set type = 'DONE' where id = ?";
		}
		
		try {
			Class.forName(Db.DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(Db.URL, Db.UID, Db.UPW);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			System.out.println("sql : " + sql);
			pstmt.setLong(1, toDoDto.getId());
			
			if ((result = pstmt.executeUpdate()) > 0) {
				System.out.println("업데이트 성공");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int reverseUpdateTodo(TodoDto toDoDto) {
		int result = 0;
		String sql = "";
		
		if (toDoDto.getType().equals("DONE")) {
			sql = "update todo set type = 'DOING' where id = ?";
		} else if(toDoDto.getType().equals("DOING")) {
			sql = "update todo set type = 'TODO' where id = ?";
		}
		
		try {
			Class.forName(Db.DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(Db.URL, Db.UID, Db.UPW);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			System.out.println("sql : " + sql);
			pstmt.setLong(1, toDoDto.getId());
			
			if ((result = pstmt.executeUpdate()) > 0) {
				System.out.println("업데이트 성공");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int deleteTodo(TodoDto todoDto) {
		int result = 0;
		String sql = "delete from todo where id = ?";
		
		try {
			Class.forName(Db.DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (Connection conn = DriverManager.getConnection(Db.URL, Db.UID, Db.UPW);
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			System.out.println("sql : " + sql);
			pstmt.setLong(1, todoDto.getId());
			if ((result = pstmt.executeUpdate()) > 0) {
				System.out.println("삭제 완료");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
}
