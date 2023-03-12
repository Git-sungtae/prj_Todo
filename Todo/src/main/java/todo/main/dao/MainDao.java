package todo.main.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import todo.db.JdbcUtil;
import todo.main.dto.MainDto;

public class MainDao {

	public int addTodo(MainDto toDoDto) {
		int added = 0;

		String name = toDoDto.getName();
		String title = toDoDto.getTitle();
		int sequence = toDoDto.getSequence();
		String sql = "insert into todo(title, name, sequence) " + "values('" + title + "', '" + name + "', " + sequence
				+ ")";
//		String sql2= "insert into todo(title, name, sequence) values(?, ?, ?)";

		System.out.println(sql);
		try {
			Class.forName(JdbcUtil.DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(JdbcUtil.URL, JdbcUtil.UID, JdbcUtil.UPW);
				Statement stmt = conn.createStatement()) {
//			PreparedStatement pstmt = conn.prepareStatement(sql2);
			added = stmt.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(added);
		return added;
	}

	public JSONObject getTodosByType(String type) {
//		ArrayList<MainDto> todoList = new ArrayList<>();
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArr = new JSONArray();

		String sql = "select id, title, name, sequence, type, TO_CHAR(regdate,'YY\"년\"MM\"월\"DD\"일\"HH24\"시\"mm\"분\"') from todo where type = ?";

		try {
			Class.forName(JdbcUtil.DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(JdbcUtil.URL, JdbcUtil.UID, JdbcUtil.UPW);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, type);
			
			try (ResultSet rs = pstmt.executeQuery()){
				//rs의 metadata를 사용해 컬럼개수를 가져옴
				//컬럼 개수만큼 for문을 돌려서 jsonObject에 컬럼이름, 데이터 순서로 넣는다.
				// ㄴ 1개의 row를 jasonObject에 넣는 것
				//1개의 row가 완료되면 jsonObjcet를 jasonArray에 넣는다.
				//loop → jasonObject 리턴
				ResultSetMetaData rsmd = rs.getMetaData();
				while (rs.next()) {
					int colCount = rsmd.getColumnCount();
					JSONObject row = new JSONObject();
					for (int i = 1; i <= colCount; i++) {
						String colName = rsmd.getColumnName(i);
						Object data = rs.getObject(i);
						row.put(colName, data);
					}
					jsonArr.add(row);
				}
				jsonObj.put("data", jsonArr);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("jsonObj : " + jsonObj);
		return jsonObj;
	}

	public JSONObject getTodosById(String id) {
//		ArrayList<MainDto> todoList = new ArrayList<>();
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArr = new JSONArray();

		String sql = "select id, title, name, sequence, type, TO_CHAR(regdate,'YY\"년\"MM\"월\"DD\"일\"HH24\"시\"mm\"분\"') from todo where id = ?";

		try {
			Class.forName(JdbcUtil.DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(JdbcUtil.URL, JdbcUtil.UID, JdbcUtil.UPW);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setLong(1, Long.parseLong(id));
			
			try (ResultSet rs = pstmt.executeQuery()){
				//rs의 metadata를 사용해 컬럼개수를 가져옴
				//컬럼 개수만큼 for문을 돌려서 jsonObject에 컬럼이름, 데이터 순서로 넣는다.
				// ㄴ 1개의 row를 jasonObject에 넣는 것
				//1개의 row가 완료되면 jsonObjcet를 jasonArray에 넣는다.
				//loop → jasonObject 리턴
				ResultSetMetaData rsmd = rs.getMetaData();
				while (rs.next()) {
					int colCount = rsmd.getColumnCount();
					JSONObject row = new JSONObject();
					for (int i = 1; i <= colCount; i++) {
						String colName = rsmd.getColumnName(i);
						Object data = rs.getObject(i);
						row.put(colName, data);
					}
					jsonArr.add(row);
				}
				jsonObj.put("data", jsonArr);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("jsonObj : " + jsonObj);
		return jsonObj;
	}	
	
	
	public int changeTypeRight(String id, String type) {
		int result = 0;
		String sql = "update todo set type = ? where id = ?";

		try {
			Class.forName(JdbcUtil.DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(JdbcUtil.URL, JdbcUtil.UID, JdbcUtil.UPW);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			if (type.equals("TODO")) {
				pstmt.setString(1, "DOING");
			} else if(type.equals("DOING")) {
				pstmt.setString(1, "DONE");
			}
			pstmt.setLong(2, Long.parseLong(id));
			
			if ((result = pstmt.executeUpdate()) > 0) {
				System.out.println("업데이트 성공");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public int changeTypeLeft(String id, String type) {
		int result = 0;
		String sql = "update todo set type = ? where id = ?";

		try {
			Class.forName(JdbcUtil.DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(JdbcUtil.URL, JdbcUtil.UID, JdbcUtil.UPW);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			System.out.println("dao type : " + type);
			System.out.println("dao id : " + id);
			if (type.equals("DOING")) {
				pstmt.setString(1, "TODO");
			} else if(type.equals("DONE")) {
				pstmt.setString(1, "DOING");
			}
			pstmt.setLong(2, Long.parseLong(id));
			
			if ((result = pstmt.executeUpdate()) > 0) {
				System.out.println("업데이트 성공");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

//end class
}	
	
//	///////////////////////예전코드//////////////////////////////
//	public List<MainDto> getDoings() {
//		ArrayList<MainDto> doingList = new ArrayList<>();
//		String sql = "select id, title, name, sequence, type, TO_CHAR(regdate,'YY\"년\"MM\"월\"DD\"일\"HH24\"시\"mm\"분\"') from todo where type = 'DOING'";
//
//		try {
//			Class.forName(JdbcUtil.DRIVER);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		try (Connection conn = DriverManager.getConnection(JdbcUtil.URL, JdbcUtil.UID, JdbcUtil.UPW);
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//				ResultSet rs = pstmt.executeQuery()) {
//
//			while (rs.next()) {
//				MainDto todoDto = new MainDto();
//
//				todoDto.setId(rs.getInt(1));
//				todoDto.setTitle(rs.getString(2));
//				todoDto.setName(rs.getString(3));
//				todoDto.setSequence(rs.getInt(4));
//				todoDto.setType(rs.getString(5));
//				todoDto.setRegDate(rs.getString(6));
//
//				System.out.println(todoDto);
//
//				doingList.add(todoDto);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return doingList;
//	}
//
//	public List<MainDto> getDones() {
//		ArrayList<MainDto> doneList = new ArrayList<>();
//		String sql = "select id, title, name, sequence, type, TO_CHAR(regdate,'YY\"년\"MM\"월\"DD\"일\"HH24\"시\"mm\"분\"') from todo where type = 'DONE'";
//
//		try {
//			Class.forName(JdbcUtil.DRIVER);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		try (Connection conn = DriverManager.getConnection(JdbcUtil.URL, JdbcUtil.UID, JdbcUtil.UPW);
//				PreparedStatement pstmt = conn.prepareStatement(sql);
//				ResultSet rs = pstmt.executeQuery()) {
//
//			while (rs.next()) {
//				MainDto todoDto = new MainDto();
//
//				todoDto.setId(rs.getInt(1));
//				todoDto.setTitle(rs.getString(2));
//				todoDto.setName(rs.getString(3));
//				todoDto.setSequence(rs.getInt(4));
//				todoDto.setType(rs.getString(5));
//				todoDto.setRegDate(rs.getString(6));
//
//				System.out.println(todoDto);
//
//				doneList.add(todoDto);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return doneList;
//	}
//
//	public int updateTodo(MainDto toDoDto, int lrBtn) {
//		int result = 0;
//		String sql = "update todo set type = ? where id = ?";
//		String type = null;
//
//		if (toDoDto.getType().equals("TODO")) {
//			type = "DOING";
//		} else if (toDoDto.getType().equals("DOING")) {
//			type = lrBtn > 0 ? "DONE" : "TODO";
//		} else if (toDoDto.getType().equals("DONE")) {
//			type = "DOING";
//		}
//
//		try {
//			Class.forName(JdbcUtil.DRIVER);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		try (Connection conn = DriverManager.getConnection(JdbcUtil.URL, JdbcUtil.UID, JdbcUtil.UPW);
//				PreparedStatement pstmt = conn.prepareStatement(sql)) {
//			pstmt.setString(1, type);
//			pstmt.setLong(2, toDoDto.getId());
//			if ((result = pstmt.executeUpdate()) > 0) {
//				System.out.println("업데이트 성공");
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return result;
//	}
//
//	public int reverseUpdateTodo(MainDto toDoDto) {
//		int result = 0;
//		String sql = "";
//
//		if (toDoDto.getType().equals("DONE")) {
//			sql = "update todo set type = 'DOING' where id = ?";
//		} else if (toDoDto.getType().equals("DOING")) {
//			sql = "update todo set type = 'TODO' where id = ?";
//		}
//
//		try {
//			Class.forName(JdbcUtil.DRIVER);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		try (Connection conn = DriverManager.getConnection(JdbcUtil.URL, JdbcUtil.UID, JdbcUtil.UPW);
//				PreparedStatement pstmt = conn.prepareStatement(sql)) {
//			System.out.println("sql : " + sql);
//			pstmt.setLong(1, toDoDto.getId());
//
//			if ((result = pstmt.executeUpdate()) > 0) {
//				System.out.println("업데이트 성공");
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return result;
//	}
//
//	public int deleteTodo(MainDto todoDto) {
//		int result = 0;
//		String sql = "delete from todo where id = ?";
//
//		try {
//			Class.forName(JdbcUtil.DRIVER);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		try (Connection conn = DriverManager.getConnection(JdbcUtil.URL, JdbcUtil.UID, JdbcUtil.UPW);
//				PreparedStatement pstmt = conn.prepareStatement(sql)) {
//			System.out.println("sql : " + sql);
//			pstmt.setLong(1, todoDto.getId());
//			if ((result = pstmt.executeUpdate()) > 0) {
//				System.out.println("삭제 완료");
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}