package com.mysite.project;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MessageMapper {

	Message getMessageById(Integer id);
	void insertMessage(Message message);
	List<Message> getMessagesLimit10();
	List<Message> getMessagesWithPaging(@Param("size") Integer size, @Param("offset") Integer offset);
	int countTotal();
	
}