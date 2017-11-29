package com.leon.wechat.util;

import com.leon.wechart.util.TrainUtil;

public class TestTrainUtil
{
	//	@Test
	public void testIsTrainCode()
	{
		//		System.out.println(TrainUtil.isTrainCode("T122"));
		//		System.out.println(TrainUtil.isTrainCode("TT122"));
		//		System.out.println(TrainUtil.isTrainCode("122"));
		//		System.out.println(TrainUtil.isTrainCode("1"));
		//		System.out.println(TrainUtil.isTrainCode(""));
	}

	//	@Test
	public void testContainsTraincode()
	{
		System.out.println(TrainUtil.containsTrain("测TT1试"));
		System.out.println(TrainUtil.containsTrain("测TTS11试"));
		System.out.println(TrainUtil.containsTrain("测TTS试"));
		System.out.println(TrainUtil.containsTrain("测1试"));
		System.out.println(TrainUtil.containsTrain("测试"));
		System.out.println("done");
	}


}
