package com.leon.loco.dao;

import java.util.List;
import com.leon.loco.bean.Reply;

public interface ReplyDAO
{
	public List<Reply> findReplyByMessageID(int messageID);
	public int addReply(Reply reply);
}