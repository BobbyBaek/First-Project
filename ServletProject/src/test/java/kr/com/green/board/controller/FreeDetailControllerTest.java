package kr.com.green.board.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;

import kr.co.green.board.controller.FreeDetailController;

public class FreeDetailControllerTest {

	private FreeDetailController fdc;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private RequestDispatcher dispatcher;
	
	@Before
	public void setUp() throws Exception {
		fdc = new FreeDetailController();
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		session = mock(HttpSession.class);
		dispatcher = mock(RequestDispatcher.class);
		
		when(request.getRequestDispatcher("/views/board/free/freeDetail.jsp")).thenReturn(dispatcher);
	}	
	
	@Test
	public void testDoGet() throws Exception{
		when(request.getParameter("idx")).thenReturn("1");
		fdc.doGet(request, response);
		verify(dispatcher).forward(request, response);
	}
	
}