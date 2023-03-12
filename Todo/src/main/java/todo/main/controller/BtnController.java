package todo.main.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.main.service.JsonStringService;
import todo.main.service.BtnService;
import todo.main.service.impl.JsonStringServiceImple;
import todo.main.service.impl.BtnServiceImpl;

/**
 * Servlet implementation class RightBtnController
 */
@WebServlet("/btnController")
public class BtnController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BtnController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request, response 한글 깨짐 방지
		System.out.println("BtnController doGet() 실행");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");
		
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String btnType = request.getParameter("btnType");
		
		System.out.println("Controller btnType : " + btnType);
		System.out.println("Controller type : " + type);
		System.out.println("Controller id : " + id);
		
		String jsonString = "";
		
		BtnServiceImpl btn = new BtnServiceImpl();
		if (btnType.toLowerCase().equals("right")) {
			//jsonString을 리턴할 서비스 호출
			jsonString = btn.changeTypeRight(id, type);
		} else if (btnType.toLowerCase().equals("left")) {
			jsonString = btn.changeTypeLeft(id, type);
		}
		
		
		//아작스로 전달
		PrintWriter out = response.getWriter();
		out.print(jsonString);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
