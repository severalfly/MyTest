package com.leon.loco.dao;

import com.leon.loco.bean.Message;
import com.leon.loco.util.Page;
import java.util.List;


public interface MessageDAO
{
	public int addMessage(Message message);
	public int updateMessage(Message message);
	public int deleteMessage(int messageID);
	public List<Message> findAllMessage(Page page);
	public Message findMessageById(int messageID);
	public int findAllCount();
}