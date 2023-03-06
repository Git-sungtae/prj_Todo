package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TodoDao;
import dto.TodoDto;

/**
 * Servlet implementation class TodoReverseServlet
 */
@WebServlet("/todoReverseServlet")
public class TodoReverseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoReverseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");
		
		//id 파라미터 DTO에 셋팅
		TodoDto dto = new TodoDto();
		dto.setId(Long.parseLong(request.getParameter("id")));
		dto.setType(request.getParameter("type"));
		
		//DAO의 update메서드 실행
		TodoDao dao = new TodoDao();
		if (dao.reverseUpdateTodo(dto) > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("main");
			rd.forward(request, response);
		}
	}

}
