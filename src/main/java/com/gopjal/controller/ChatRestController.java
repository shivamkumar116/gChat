package com.gopjal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.gopjal.dao.ChatMessageDao;
import com.gopjal.domain.ChatMessage;

@RestController
public class ChatRestController {
	
	@Autowired
	private ChatMessageDao chatMessageDao;

	

	@GetMapping("/history")
	public List<ChatMessage> getChat() {
		List<ChatMessage> myMessage=  chatMessageDao.findAll();
		for(ChatMessage message:myMessage) {
			System.out.println(message);
			
		}
		return myMessage;
		
		
	}
}
