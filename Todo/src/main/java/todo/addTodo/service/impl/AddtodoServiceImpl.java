package todo.addTodo.service.impl;

import java.sql.Connection;

import todo.addTodo.dao.AddtodoDao;
import todo.addTodo.dto.AddTodoDto;
import todo.addTodo.service.AddTodoService;
import todo.db.JdbcUtil;

public class AddtodoServiceImpl implements AddTodoService {
	
	@Override
	public int insertTodo(AddTodoDto dto) {
		Connection conn = null;
		int result = 0;
		
		try {
			System.out.println("여기까진왔니?");
			conn = JdbcUtil.getConnection();
			AddtodoDao dao = new AddtodoDao();
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
