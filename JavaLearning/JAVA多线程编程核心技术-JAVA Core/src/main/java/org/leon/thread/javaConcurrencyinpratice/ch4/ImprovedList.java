package org.leon.thread.javaConcurrencyinpratice.ch4;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 通过组合方式实现“若没有则添加”
 * 
 * @author leon
 *
 */
public class ImprovedList<T> implements List<T>
{
	private final List<T> list;

	public ImprovedList(List<T> list)
	{
		this.list = list;
	}

	/**
	 * 若没有则添加的方法实现
	 * @param x
	 * @return
	 */
	public synchronized boolean putIfAbsent(T x)
	{
		boolean contains = this.list.contains(x);
		if (contains)
		{
			this.list.add(x);
		}
		return !contains;
	}

	/**
	 * 以下所有方法都实现list 中的方法即可，
	 */
	public int size()
	{
		return this.list.size();
	}

	public boolean isEmpty()
	{
		return this.list.isEmpty();
	}

	public boolean contains(Object o)
	{
		return this.list.contains(o);
	}

	public Iterator<T> iterator()
	{
		return this.list.iterator();
	}

	public Object[] toArray()
	{
		return this.toArray();
	}

	public <T> T[] toArray(T[] a)
	{
		return this.list.toArray(a);
	}

	public boolean add(T e)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean remove(Object o)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsAll(Collection<?> c)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(Collection<? extends T> c)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(int index, Collection<? extends T> c)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeAll(Collection<?> c)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public boolean retainAll(Collection<?> c)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public void clear()
	{
		// TODO Auto-generated method stub

	}

	public T get(int index)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public T set(int index, T element)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void add(int index, T element)
	{
		// TODO Auto-generated method stub

	}

	public T remove(int index)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public int indexOf(Object o)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	public int lastIndexOf(Object o)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	public ListIterator<T> listIterator()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public ListIterator<T> listIterator(int index)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> subList(int fromIndex, int toIndex)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
