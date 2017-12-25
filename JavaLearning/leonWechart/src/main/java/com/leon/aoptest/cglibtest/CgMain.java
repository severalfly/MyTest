package com.leon.aoptest.cglibtest;

import net.sf.cglib.proxy.Enhancer;

public class CgMain
{
	public static void main(String[] args)
	{
		Enhancer enhancer = new Enhancer();

		enhancer.setSuperclass(MyClass.class);
		enhancer.setCallback(new MethodInterceptorImpl());

		MyClass my = (MyClass) enhancer.create();
		my.method();
	}

}
