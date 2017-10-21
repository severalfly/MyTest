package com.leon.wechat.util;

import org.junit.Test;

import com.leon.wechart.util.TrainUtil;

public class TestTrainUtil
{
	@Test
	public void testIsTrainCode()
	{
		System.out.println(TrainUtil.isTrainCode("T122"));
		System.out.println(TrainUtil.isTrainCode("TT122"));
		System.out.println(TrainUtil.isTrainCode("122"));
		System.out.println(TrainUtil.isTrainCode("1"));
		System.out.println(TrainUtil.isTrainCode(""));
	}

	@Test
	public void testContainsTraincode()
	{
		System.out.println(TrainUtil.containsTrain("测TT1试"));
		System.out.println(TrainUtil.containsTrain("测TT试"));
	}
}
