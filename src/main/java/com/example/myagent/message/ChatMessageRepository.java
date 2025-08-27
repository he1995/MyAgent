package com.example.myagent.message;

import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;

public interface ChatMessageRepository extends CrudRepository<ChatMessage, String> {
}
