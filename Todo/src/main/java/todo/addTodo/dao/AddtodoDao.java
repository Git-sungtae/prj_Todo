package todo.addTodo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import todo.addTodo.dto.AddTodoDto;

public class AddtodoDao {
	
	public int addTodo(AddTodoDto addTodoDto, Connection conn) {
		int result = 0;
		String title = addTodoDto.getTitle();
		String name = addTodoDto.getName();
		int sequence = addTodoDto.getSequence();
		String sql = "insert into todo(title, name, sequence) values(?, ?, ?)";
		
		System.out.println(sql);
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, name);
			pstmt.setInt(3, sequence);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
		return result;
	}
}
