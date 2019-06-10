package com.leon.util;

import java.io.File;

import javax.annotation.Resource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLUtil
{
	private static final String configPath = "config.xml";
	public static String getCharttype()
	{
		try
		{
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			ClassPathResource resource = new ClassPathResource(configPath);
			Document doc = builder.parse(resource.getInputStream());

			NodeList nl = doc.getElementsByTagName("chartType");
			Node classNode = nl.item(0).getFirstChild();
			String chartType = classNode.getNodeValue().trim();
			return chartType;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取指定对象的bean
	 * @param className
	 * @return
	 */
	public static Object getBean(String className)
	{
		try
		{
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			ClassPathResource resource = new ClassPathResource(configPath);
			Document doc = builder.parse(resource.getInputStream());

			NodeList nl = doc.getElementsByTagName(className);
			Node classNode = nl.item(0).getFirstChild();
			String chartType = classNode.getNodeValue().trim();

			Class c = Class.forName(chartType);
			return c.newInstance();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
