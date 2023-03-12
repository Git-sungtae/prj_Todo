package todo.main.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.main.dao.MainDao;
import todo.main.dto.MainDto;
import todo.main.service.JsonStringService;
import todo.main.service.impl.JsonStringServiceImple;

/**
 * Servlet implementation class Main
 */
@WebServlet("/main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request, response 한글 깨짐 방지
		System.out.println("Main-servlet doGet() 실행");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");
		
		String type = request.getParameter("type");
		JsonStringService json = new JsonStringServiceImple();
			//jsonString을 리턴할 서비스 호출
		String jsString = json.getJsonByType(type);

		//아작스로 전달
		PrintWriter out = response.getWriter();
		out.print(jsString);
		out.flush();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Main-servlet doPost() 실행");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");
		
		MainDto dto = new MainDto();
		MainDao dao = new MainDao();
		
		dto.setId(Long.parseLong(request.getParameter("id")));
		dto.setType(request.getParameter("type"));
		System.out.println("doPost() 파라미터 확인 → id : " + dto.getId() + " type : " + dto.getType() );
		
		
		int result = 0;
//		result = dao.updateTodo(dto,  request.getParameter("lrBtn"));
		
		if (result > 0) {
			System.out.println("해당하는 dao 호출 및 데이터 업데이트 완료");
		}
		System.out.println("각각 해당하는 dao 호출 완료");
	}

}
