package com.leon.artofpattern.template.execrise;

import com.leon.util.XMLUtil;

public class TemplateExecriseClient
{
	public static void main(String[] args)
	{
		SQLOperator operator = (SQLOperator) XMLUtil.getBean("templateExecrise");
		operator.handle(false);
	}
}
