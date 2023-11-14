package kr.co.green.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.board.model.service.BoardServiceImpl;

@WebServlet("/boardUpdate.do")
public class FreeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FreeUpdateController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 1. 값 받기 (idx, 제목, 내용)
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		// 2. 서비스 호출(DTO or 매개변수)
		BoardServiceImpl boardService = new BoardServiceImpl();
		int result = boardService.boardUpdate(title, content, idx);
//		System.out.println("result:" + result);
		
		// 3. 성공 유무에 따라 처리
		// 성공시 /freeList.do 로 이동(sendRediret)
		// 실패시 /views/common/error.jsp
		if(result > 0) {
			response.sendRedirect("/freeList.do?cpage=1");
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/views/common/error.jsp");
			view.forward(request, response);
		}
		
//		1) RequestDispatcher;
//		   호출할 페이지가 jsp
//		2) response.sendRedirect();
//		   호출할 페이지가 Controller;

		
	}

}
