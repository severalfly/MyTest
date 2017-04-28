package com.leon.factory;

public class FactoryMain
{
	public static void main(String[] args)
	{
		IFactory factory = new VolunteerFactory();
		LeiFeng student = factory.createLeiFeng();

		student.wash();
		student.sweep();
	}
}
