package com.gopjal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopjal.dao.ChatMessageDao;
import com.gopjal.domain.ChatMessage;

@Controller
public class ChatController {

	@Autowired
	private ChatMessageDao chatMessageDao;

	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/gopjal")
	public ChatMessage sendMessage(@Payload ChatMessage ChatMessage) {

		// database connection and save into the database
		chatMessageDao.save(ChatMessage);
		System.out.println(ChatMessage);

		return ChatMessage;
	}

	@MessageMapping("/chat.newUser")
	@SendTo("/topic/gopjal")
	public ChatMessage newUser(@Payload ChatMessage ChatMessage, SimpMessageHeaderAccessor headerAccessor) {

		headerAccessor.getSessionAttributes().put("username", ChatMessage.getSender());

		// saving into the database
		chatMessageDao.save(ChatMessage);
		System.out.println(ChatMessage);
		return ChatMessage;
	}

	

}
