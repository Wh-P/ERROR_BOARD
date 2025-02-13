package com.web.mes021.a03_ChatHandler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class A09_ChattingController {
	
	@Value("${socketServer}")
	private String socketServer;
	
	// http://localhost:3030/chatting
	@GetMapping("chatting")
	public String chatting(Model d) {
		d.addAttribute("socketServer", socketServer);
		
		return "WEB-INF\\a02_mvc\\a03_chatting.jsp";
	}

}
