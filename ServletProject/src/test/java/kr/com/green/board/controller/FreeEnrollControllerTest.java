package kr.com.green.board.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;

import kr.co.green.board.controller.FreeEnrollController;

public class FreeEnrollControllerTest {
	
	private FreeEnrollController fec;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;

//	<Before 어노테이션>
//	@test 어노테이션이 실행되기 전에 먼저 @Before 어노테이션의 메소드가 실행됨
	
	@Before
	public void setUp() throws Exception {
		fec = new FreeEnrollController();
		
		// .class : HttpServletRequest 클래스의 class 객체를 가져옴
		// mock() : 가짜 객체 생성
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		session = mock(HttpSession.class);
		
		when(request.getParameter("title")).thenReturn("");
		when(request.getParameter("content")).thenReturn("");
		when(request.getSession()).thenReturn(session);
		
	}

	@Test
	public void testDoPost() throws Exception {
		// 모킹(가짜 객체)된 session에서 name을 가지고 올 때
		// 값을 "홍길동" 리턴
		when(session.getAttribute("name")).thenReturn("홍길동");
		
		fec.doPost(request, response);
		
		// verify(response) : response 객체 검증
		verify(response).sendRedirect("/freeList.do?cpage=1");
	}
}


















