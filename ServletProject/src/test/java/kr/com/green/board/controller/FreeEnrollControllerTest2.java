package kr.com.green.board.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import kr.co.green.board.controller.FreeEnrollController;

public class FreeEnrollControllerTest2 {
	
	private FreeEnrollController fec;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private HttpSession session;
	private RequestDispatcher dispatcher;

	// @Before : @Test 어노테이션의 메소드가 실행되기 전, 먼저 실행(1회)
	// @BeforeEach : @Test 어노테이션의 메소드가 실행되기 전, 먼저 실행(1회)
	
	@BeforeEach
	public void setUp() throws Exception {
		fec = new FreeEnrollController();
		
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		session = mock(HttpSession.class);
		dispatcher = mock(RequestDispatcher.class);
		
		when(request.getSession()).thenReturn(session);
		when(request.getRequestDispatcher("/test")).thenReturn(dispatcher);
		
	}

	// @ParameterizedTest : 배열에 지정된 값들을 매개변수로 주입
	@ParameterizedTest
	// @CsvSource : 매개변수 넣을 값들의 리스트
	@CsvSource({
		"title, content, name, /freeList.do?cpage=1",
		"title, '', name, /freeList.do?cpage=1",
		"'', content, name, /freeList.do?cpage=1",
		"title, content, '', /freeList.do?cpage=1",
	})
	public void testDoPost(String title,
						   String content,
						   String name,
						   String result) throws Exception {
		when(request.getParameter("title")).thenReturn(title);
		when(request.getParameter("content")).thenReturn(content);
		when(session.getAttribute("name")).thenReturn(name);
		
		fec.doPost(request, response);
		
//		verify(response).sendRedirect(result);
		verify(dispatcher).forward(request, response);
	}
}


















