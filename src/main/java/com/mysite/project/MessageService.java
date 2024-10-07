package com.mysite.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	@Autowired
	private MessageMapper messageMapper;
	
	// 데이터베이스에서 값을 가져오는 것
	public Message getMessage(Integer id) {
		return messageMapper.getMessageById(id);
		//return "Hello World";
	}
	
	public void createMessage(Message message) {
		messageMapper.insertMessage(message);
	}
	
	public List<Message> getMessagesLimit10() {
		return messageMapper.getMessagesLimit10();
	}
	
	public PageDTO getPagedData(int page, int size) {
		int offset = (page - 1) * size;
        List<Message> content = messageMapper.getMessagesWithPaging(offset, size);
        int totalElements = messageMapper.countTotal();
        int totalPages = (int) Math.ceil((double) totalElements / size);

        return new PageDTO(page, size, totalPages, totalElements, content);
	}
}