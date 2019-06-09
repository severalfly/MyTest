package com.leon.effectiveJava.entry06;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackMain
{
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INTITAL_CAPACITY = 16;

	public StackMain()
	{
		elements = new Object[DEFAULT_INTITAL_CAPACITY];
	}

	public void push(Object e)
	{
		ensureCapacity();
		elements[size++] = e;
	}

	public Object pop()
	{
		if (size == 0)
		{
			throw new EmptyStackException();
		}
		return elements[--size];
	}

	private void ensureCapacity()
	{
		if (elements.length == size)
		{
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}

	public static void main(String[] args)
	{
		StackMain s = new StackMain();
		for (int i = 0; i < 100000; i++)
		{
			s.push(new Object());
			s.pop();
		}
	}
}
