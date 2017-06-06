package com.leon.artofpattern.adapter;

public class OperationAdapter implements ScoreOperation
{
	private QuickSort quickSort;
	private BinarySearch binarySearch;

	public OperationAdapter()
	{
		this.quickSort = new QuickSort();
		this.binarySearch = new BinarySearch();
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
