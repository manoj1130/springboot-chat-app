package com.chat.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chat.app.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	List<Message> findBySenderUsernameAndReceiverUsernameOrSenderUsernameAndReceiverUsernameOrderByIdAsc(
	        String sender1,
	        String receiver1,
	        String sender2,
	        String receiver2);
}
