package todo.addTodo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.addTodo.dto.AddTodoDto;
import todo.addTodo.service.AddTodoService;
import todo.addTodo.service.impl.AddtodoServiceImpl;

/**
 * Servlet implementation class TodoAddServlet
 */
@WebServlet("/addTodoController")
public class AddTodoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTodoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request, response 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");
		
		//post요청이 들어오면 파라미터 값 dto에 세팅
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String sequence = request.getParameter("sequence");
		AddTodoDto dto = new AddTodoDto();
		dto.setTitle(title);
		dto.setName(name);
		dto.setSequence(Integer.parseInt(sequence));
		
		//AddTodoService 호출
		AddTodoService service = new AddtodoServiceImpl();
		
		//AddTodoServiceimple에 dto파라미터 넘겨줘서 dao의 add() 메서드실행하여 Insert쿼리 실행 후 변경한 row 개수 리턴(result)
		//result > 0 이면 입력 성공
		int result = service.insertTodo(dto);
		
		//입력이 성공(result>0)했을 때 alert띄워주고 main.jsp 호출
		if (result > 0) {
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("<script>alert('입력이 완료되었습니다.'); location.href='main.jsp';</script>");
	        out.flush();
	    //입력이 실패했을 때. 에러페이지로 포워딩
		} else {
			request.getRequestDispatcher("errorPage.jsp").forward(request, response);
		}
		
		
		//workList.jsp에서 넘어온 parameter들을 변수에 저장
//		MainPageDto dto = new MainPageDto();
//		dto.setTitle(work_title);
//		dto.setName(work_name);
//		dto.setSequence(Integer.parseInt(work_sequence));
//		
//		MainPageDao dao = new MainPageDao();
//		if (dao.addTodo(dto) != 0) {
//			response.sendRedirect("main");
//		}
		
	}

}
