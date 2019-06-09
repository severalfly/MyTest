package com.leon.generics;

public class TestGen
{
	public static void main(String[] args)
	{
		Gen<Integer> g = new Gen<Integer>(12);
		System.out.println(g.getObj());
	}
}
