package com.web.mes021.a02_board;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.mes021.z01_vo.Board;
import com.web.mes021.z01_vo.BoardFile;
import com.web.mes021.z01_vo.BoardSch;

@Service
public class A02_BoardService {
	@Autowired(required = false)
	private A03_BoardDao dao;

	public List<Board> getBoardList(BoardSch sch) {
		// 0. 검색 조건 처리..
		if (sch.getSubject() == null)
			sch.setSubject("");
		if (sch.getWriter() == null)
			sch.setWriter("");
		sch.setSubject("%" + sch.getSubject() + "%");
		sch.setWriter("%" + sch.getWriter() + "%");
		
		
		// 1. 총데이터 건수 설정.
		sch.setCount(dao.getBoardCount(sch));
		// 2. 한번에 보일 페이지의 데이터 건수
		if(sch.getPageSize()==0) {
			sch.setPageSize(5);
		}
		// 3. 총페이지 수..(총데이터건수/한번에 보일 데이터 건수)
		sch.setPageCount((int)Math.ceil(sch.getCount()/(double)sch.getPageSize()));
		
		if(sch.getCurPage()==0)
			sch.setCurPage(1);
		if(sch.getCurPage()>sch.getPageCount())
			sch.setCurPage(sch.getPageCount());
		
/*
-- 시작번호(start), 마지막번호(end)          시작  마지막
-- 경우1 : 한번에 보일건수:5, 페이지번호 1 ==> 1,  5
-- 경우2 : 한번에 보일건수:5, 페이지번호 2 ==> 6,  10
-- 경우3 : 한번에 보일건수:10, 페이지번호 3 ==> 21,  30
-- 경우4 : 한번에 보일건수:20, 페이지번호 4 ==> 61,  80
 * */		
		
		sch.setStart((sch.getCurPage()-1)*sch.getPageSize()+1);
		
		
		
		/// 마지막페이지 : 현재클릭한페이지번호 * 선택한페이지의크기
		//  DB에서 자동 처리해주나, 정확한 로직 처리를 위해
		int endNo = sch.getCurPage()*sch.getPageSize();
		sch.setEnd(endNo>sch.getCount()?sch.getCount():
								sch.getCurPage()*sch.getPageSize()); 
		// 페이지 블럭 처리
		// 1. 블럭 크기 설정.
		sch.setBlockSize(5);
		// 2. 블럭 번호 = 올림(현재페이지번호/블럭의크기)
		int blockNum = (int)Math.ceil(sch.getCurPage()/(double)sch.getBlockSize());
		// 3. 시작 블럭
		sch.setStartBlock((blockNum-1)*sch.getBlockSize()+1);
		// 4. 마지막블럭(예외처리-기본적으로 블럭번호는 블럭번호*블럭의크기로 하는데 정확하게 
		//    페이지크기 보다 클수 있다.)
		int endBlock = blockNum * sch.getBlockSize();
		sch.setEndBlock(endBlock>sch.getPageCount()?sch.getPageCount():endBlock);
		
		
		
		
		
		return dao.getBoardList(sch);
	}

	@Value("${user.upload}")
	private String path;
  
	public List<BoardFile> getFiles(){
		return dao.getFiles();
	}
	
	public String insertBoard(Board ins) {
		String msg = dao.insertBoard(ins)>0?"게시물 등록 성공\\n":"게시물 등록 실패\\n";
		// 물리적 파일업로드
		//if (ins.getReports() != null && ins.getReports().length > 0) {
			try {
				int cnt=0;
				for (MultipartFile mpf : ins.getReports()) {
					if(	!mpf.getOriginalFilename().equals("") ) {
						String fname = mpf.getOriginalFilename();
						File file = new File(path, fname);
						mpf.transferTo(file);
						cnt += dao.insertBoardFile(new BoardFile(ins.getNo(),fname,
								"게시판파일업로드:"+ins.getSubject()));
					}
				}
				msg += cnt+"건 파일 등록 성공";
			} catch (IllegalStateException e) {
				msg += "[파일 상태예외]"+e.getMessage();	
			} catch (IOException e) {
				msg += "[파일 DB연동예외]"+e.getMessage();
			} catch (Exception e) {
				msg += "[파일 기타예외]"+e.getMessage();
			}

		//}
		// DB 등록

		return msg;
	}
	
	
	
	
	
	// 수정후, 다시 로딩시..
	public 	Board getBoard(int no) {
		Board b = dao.getBoard(no); // 기본 정보..
		b.setFlist(dao.getBoardFile(no)); // 파일 리스트 정보 할당..
		return b;
	}
	// list에서 상세 조회시..
	public 	Board getBoardDetail(int no) {
		// 상세 조회시 조회 카운트 업..
		dao.readCntUpdate(no);
		return getBoard(no);
	}	
	public String updateBoard(Board upt) {
		return dao.updateBoard(upt)>0?"수정성공":"수정실패";
	}	
	public String deleteBoard(int no) {
		return dao.deleteBoard(no)>0?"삭제성공":"삭제실패";
	}   	
	
	
}
