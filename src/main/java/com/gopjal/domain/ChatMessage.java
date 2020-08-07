package com.gopjal.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@NoArgsConstructor
@Data
public class ChatMessage {

	
	public String type;
	public String content;
	public String sender;
	
	public ChatMessage(String type, String content, String sender) {
		super();
		this.type = type;
		this.content = content;
		this.sender = sender;
	}

	

}
