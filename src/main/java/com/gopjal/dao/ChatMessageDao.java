package com.gopjal.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gopjal.domain.ChatMessage;

@Repository
public interface ChatMessageDao extends MongoRepository<ChatMessage, String> {

}
