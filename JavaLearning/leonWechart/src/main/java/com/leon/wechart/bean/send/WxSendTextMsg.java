package com.leon.wechart.bean.send;

import org.jdom.Document;
import org.jdom.Element;

/**
 * 回复文本消息
 * @author leon
 *
 */
public class WxSendTextMsg extends WxMsg
{
	protected String content;

	public WxSendTextMsg(String toUserName, String fromUsername, long createTime)
	{
		super(toUserName, fromUsername, createTime, "text");
	}

	public String getContent()
	{
		return this.content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public Document toDocument()
	{

		Document document = toDocumentSuper();
		Element root = document.getRootElement();
		createElement(root, "Content", com.leon.wechart.util.ObjectUtil.getString(getPretty(this.content)));
		return document;
	}

}
