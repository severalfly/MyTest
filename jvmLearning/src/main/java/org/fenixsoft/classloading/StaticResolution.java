package org.fenixsoft.classloading;

public class StaticResolution
{
	public static void sayHello()
	{
		System.out.println("hello World!");
	}

	public static void main(String[] args) {
		StaticResolution.sayHello();
	}
}