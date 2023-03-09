package todo.register.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import todo.register.dto.RegisterDto;

public class RegisterDao {
	
	public int addTodo(RegisterDto registerDto, Connection conn) {
		int result = 0;
		String title = registerDto.getTitle();
		String name = registerDto.getName();
		int sequence = registerDto.getSequence();
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
