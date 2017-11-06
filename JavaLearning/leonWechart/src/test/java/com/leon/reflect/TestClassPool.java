package com.leon.reflect;

import java.io.IOException;

import com.leon.nio.ReadAndWrite;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.NotFoundException;

public class TestClassPool
{
	public static void main(String[] args) throws NotFoundException, InstantiationException, IllegalAccessException, CannotCompileException, IOException
	{
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("com.leon.nio.ReadAndWrite");
		CtField i = cc.getField("in");
		System.out.println(i.getName());
		Class clazz = cc.toClass();
		ReadAndWrite r = (ReadAndWrite) clazz.newInstance();
		r.main(null);
	}
}
