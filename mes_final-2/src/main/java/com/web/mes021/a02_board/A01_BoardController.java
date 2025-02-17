package com.web.mes021.a02_board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.web.mes021.z01_vo.Board;
import com.web.mes021.z01_vo.BoardSch;


@Controller
public class A01_BoardController {

	@Autowired(required=false)
	private A02_BoardService service;
	
	@GetMapping("/")
	public String redirectToBoardList() {
		return "redirect:/boardList";
	}
	 // 도메인만 입력시, 자동으로 /boardList 에 리 다이렉트 할수 있게 구현 하였습니다.
	
	// http://localhost:3030/boardList
	@RequestMapping("/boardList")
	public String boardList(@ModelAttribute("sch") BoardSch sch, Model d) {
		d.addAttribute("boardList", service.getBoardList(sch));
		return "WEB-INF\\a01_board\\a01_boardList.jsp";
	}
	
	
	// http://localhost:3030/boardReply
	@PostMapping("boardReply")
	public String replyForm(@ModelAttribute("re") Board ins, Model d) {
		ins.setRefno(ins.getNo()); // 이전글 번호
		ins.setSubject("RE:"+ins.getSubject());
		ins.setContent("\n\n\n\n\n==== 이전글 ===\n"+ins.getContent());
		// ${board.refno}  ${board.subject}  ${board.content}
		
		
		return "WEB-INF\\a01_board\\a02_boardInsert.jsp";
	}	
	
	// http://localhost:3030/boardInsert
		@RequestMapping("boardInsert")
		public String boardInsert(Board ins, Model d) {
			if(ins.getSubject()!=null ) {
				d.addAttribute("msg", service.insertBoard(ins));
			}
			return "WEB-INF\\a01_board\\a02_boardInsert.jsp";
		}
		// dao ==> service ==> controller  view 처리 (상세 처리)
		// http://localhost:3030/boardDetail
		//   
		// http://localhost:3030/boardDetail?no=1
		@GetMapping("boardDetail")
		public String boardDetail(@RequestParam("no") int no, Model d) {
			d.addAttribute("board", service.getBoardDetail(no));
			return "WEB-INF\\a01_board\\a03_boardDetail.jsp";
		}
		// http://localhost:3030/boardUpdate
		@PostMapping("boardUpdate")
		public String boardUpdate(Board upt, Model d) {
			d.addAttribute("msg", service.updateBoard(upt));
			// 수정이후에 데이터를 상세회면에서 데이터를 확인해야되기 때문에 필요..
			d.addAttribute("board", service.getBoard(upt.getNo()));
			return "WEB-INF\\a01_board\\a03_boardDetail.jsp";
		}	
		// http://localhost:3030/boardDelete
		@PostMapping("boardDelete")
		public String boardDelete(@RequestParam("no") int no, Model d) {
			d.addAttribute("msg", service.deleteBoard(no));
			return "WEB-INF\\a01_board\\a03_boardDetail.jsp";
		}		
		
	
}
