package com.leon.wechart.bean;

public class TextMsgFromWC extends MsgFromWC
{
	protected String content;
	protected long MsgId;

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public long getMsgId()
	{
		return MsgId;
	}

	public void setMsgId(long msgId)
	{
		MsgId = msgId;
	}

}
