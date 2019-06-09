package com.leon.wechart.bean.send;

import java.util.List;

import org.jdom.Document;
import org.jdom.Element;

import com.leon.wechart.util.ObjectUtil;


/**
 * 回复图文消息
 * @author leon
 *
 */
public class WxSendNewsMsg extends WxMsg
{

	protected int articleCount;
	protected List<item> articles;

	public WxSendNewsMsg(String toUserName, String fromUsername, long createTime)
	{
		super(toUserName, fromUsername, createTime, "news");
	}

	public static class item
	{
		private String title;
		private String description;
		private String picUrl;
		private String url;

		public String getTitle()
		{
			return this.title;
		}

		public void setTitle(String title)
		{
			this.title = title;
		}

		public String getDescription()
		{
			return this.description;
		}

		public void setDescription(String description)
		{
			this.description = description;
		}

		public String getPicUrl()
		{
			return this.picUrl;
		}

		public void setPicUrl(String picUrl)
		{
			this.picUrl = picUrl;
		}

		public String getUrl()
		{
			return this.url;
		}

		public void setUrl(String url)
		{
			this.url = url;
		}

	}

	public int getArticleCount()
	{
		return this.articleCount;
	}

	public void setArticleCount(int articleCount)
	{
		this.articleCount = articleCount;
	}

	public List<item> getArticles()
	{
		return this.articles;
	}

	public void setArticles(List<item> articles)
	{
		this.articles = articles;
	}

	public Document toDocument()
	{
		if (this.articles == null || this.articles.size() <= 0 || this.articles.size() > 10)
		{
			return null;
		}
		Document document = toDocumentSuper();
		Element root = document.getRootElement();
		createElement(root, "ArticleCount", this.articles.size() + "");
		Element articles = createElement(root, "Articles", "");
		for (item item : this.articles)
		{
			Element i = createElement(articles, "item", "");
			createElement(i, "Title", ObjectUtil.getString(getPretty(item.getTitle())));
			createElement(i, "Description", ObjectUtil.getString(getPretty(item.getDescription())));
			createElement(i, "PicUrl", ObjectUtil.getString(getPretty(item.getPicUrl())));
			createElement(i, "Url", ObjectUtil.getString(getPretty(item.getUrl())));
		}
		return document;
	}
}
