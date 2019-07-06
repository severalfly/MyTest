package com.leon.artofpatternv2.ch9adapter;

public class Ch9OperationAdapter implements Ch9ScoreOperation
{
	private Ch9QuickSort quickSort;
	private Ch9BinarySearch binarySearch;

	public Ch9OperationAdapter()
	{
		this.quickSort = new Ch9QuickSort();
		this.binarySearch = new Ch9BinarySearch();
	}

	@Override
	public int[] sort(int[] array)
	{
		return this.quickSort.quickSort(array);
	}

	@Override
	public int search(int[] array, int key)
	{
		return this.binarySearch.binarySearch(array, key);
	}
}
