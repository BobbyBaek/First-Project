package kr.com.green.member.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import kr.co.green.member.controller.loginController;

public class loginControllerTest {
	private loginController lc;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private RequestDispatcher dispatcher;
	
	@BeforeEach
	public void setUp() throws Exception {
		lc = new loginController();
		
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		dispatcher = mock(RequestDispatcher.class);
		dispatcher = mock(RequestDispatcher.class);
		
		when(request.getRequestDispatcher("/test")).thenReturn(dispatcher);
		
	}
	
	@ParameterizedTest
	@CsvSource({
		"id, pwd, /freeList.do?cpage=1",
		"id, '', /freeList.do?cpage=1",
		"'', pwd, /freeList.do?cpage=1",
	})
	public void testDoPost(String id,
						   String pwd) throws Exception{
		when(request.getParameter("id")).thenReturn(id);
		when(request.getParameter("pwd")).thenReturn(pwd);
		
		lc.doPost(request, response);
		verify(dispatcher).forward(request, response);
	}
	
	
}
