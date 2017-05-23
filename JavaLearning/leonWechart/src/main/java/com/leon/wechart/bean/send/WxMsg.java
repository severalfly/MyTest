package com.leon.wechart.bean.send;

import org.jdom.Document;
import org.jdom.Element;

import com.leon.wechart.util.ObjectUtil;

public class WxMsg
{
	protected String toUserName;
	protected String fromUserName;
	protected long createTime;
	protected String msgType;
	protected int funcLlag = 0;

	public WxMsg(String toUserName, String fromUsername, long createTime, String msgType)
	{
		this.toUserName = toUserName;
		this.fromUserName = fromUsername;
		this.createTime = createTime;
		this.msgType = msgType;
	}

	public String getToUserName()
	{
		return this.toUserName;
	}

	public void setToUserName(String toUserName)
	{
		this.toUserName = toUserName;
	}

	public String getFromUserName()
	{
		return this.fromUserName;
	}

	public void setFromUserName(String fromUserName)
	{
		this.fromUserName = fromUserName;
	}

	public long getCreateTime()
	{
		return this.createTime;
	}

	public void setCreateTime(long createTime)
	{
		this.createTime = createTime;
	}

	public String getMsgType()
	{
		return this.msgType;
	}

	public void setMsgType(String msgType)
	{
		this.msgType = msgType;
	}

	public int getFuncLlag()
	{
		return this.funcLlag;
	}

	public void setFuncLlag(int funcLlag)
	{
		this.funcLlag = funcLlag;
	}

	@SuppressWarnings("unchecked")
	protected Element createElement(Element parent, String name, String value)
	{
		Element elem = new Element(name);
		elem.setText(value);
		parent.getChildren().add(elem);
		return elem;
	}

	protected <T> Object getPretty(T obj)
	{
		if (obj instanceof String)
		{
			// <![CDATA[微信帐号与手机号绑定]]>
			return "<![CDATA[" + obj + "]]>";
		}
		else
		{
			return obj;
		}
	}

	protected Document toDocumentSuper()
	{

		Document document = new Document();
		Element root = new Element("xml");
		document.setRootElement(root);
		createElement(root, "FromUserName", ObjectUtil.getString(getPretty(this.fromUserName)));
		createElement(root, "ToUserName", ObjectUtil.getString(getPretty(this.toUserName)));
		createElement(root, "CreateTime", this.createTime + "");
		createElement(root, "MsgType", ObjectUtil.getString(getPretty(this.msgType)));
		createElement(root, "FuncFlag", this.funcLlag + "");
		return document;
	}

	public Document toDocument()
	{
		return null;
	}

}
