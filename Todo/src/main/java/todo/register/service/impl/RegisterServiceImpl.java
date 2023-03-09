package todo.register.service.impl;

import java.sql.Connection;

import todo.db.JdbcUtil;
import todo.register.dao.RegisterDao;
import todo.register.dto.RegisterDto;
import todo.register.service.RegisterService;

public class RegisterServiceImpl implements RegisterService {
	
	@Override
	public int registerTodo(RegisterDto dto) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = JdbcUtil.getConnection();
			RegisterDao dao = new RegisterDao();
			result = dao.addTodo(dto, conn);
			if (result > 0) {
				conn.commit();
			}
			System.out.println("커밋 완료, result : " + result);
			
		} catch (Exception e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
		} finally {
			JdbcUtil.close(conn);
		}
		
		return result;
		
	}
	
}
