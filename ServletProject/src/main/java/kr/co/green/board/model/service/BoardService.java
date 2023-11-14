package kr.co.green.board.model.service;

import java.util.ArrayList;

import kr.co.green.board.model.dto.BoardDTO;
import kr.co.green.common.PageInfo;

public interface BoardService {
	// 게시글 목록 조회
	public ArrayList<BoardDTO> boardList(PageInfo pi, String searchText);
	
	// 전체 게시글 수
	public int boardListCount(String searchText);
	
	// 글 등록
	public int boardEnroll(String title, String content, String name, String fileName, String uploadDirectory);
	
	// 조회수 +1
	public int boardView(int idx);
	
	// 상세보기
	public void boardSelect(BoardDTO board);
	
	public int boardUpdate(String title, String content, int idx);
	
	public int boardDelete(int idx);
	
	
	
}
