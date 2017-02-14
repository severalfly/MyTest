package org.fenixsoft.classloading;

class SupperClass  {
	static 
	{
		System.out.println("SupperClass init");
	}
	public static int value= 123;
}

 class SubClass extends SupperClass
{
	static
	{
		System.out.println("SubClass init");
	}
}

public class NotInitialization
{
	// public static void main(String[] args) {
	// 	System.out.println(SubClass.value);
	// }
	public static void main(String[] args) {
		SubClass[] sca = new SubClass[10];
	}
}