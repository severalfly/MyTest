package com.leon.artofpattern.adapter;

public class QuickSort
{
	public static void main(String[] args)
	{
		int[] array = new int[] { 1, 5, 3, 5 };
		array = new QuickSort().quickSort(array);
		for (int i : array)
		{
			System.out.println(i);
		}
	}

	public int[] quickSort(int array[])
	{
		sort(array, 0, array.length - 1);
		return array;
	}

	public void sort(int array[], int p, int r)
	{
		int q = 0;
		if (p < r)
		{
			q = partition(array, p, r);
			sort(array, p, q - 1);
			sort(array, q + 1, r);
		}
	}

	private int partition(int[] a, int p, int r)
	{
		int x = a[r];
		int j = p - 1;
		for (int i = p; i < r; i++)
		{
			if (a[i] < x)
			{
				j++;
				swap(a, j, i);
			}
		}
		swap(a, j + 1, r);
		return j + 1;
	}

	private void swap(int[] a, int j, int i)
	{
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
}
