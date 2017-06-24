package com.leon.artofpattern.chainRespons.exercise;

public class ChainExerciseClient
{
	public static void main(String[] args)
	{
		LeaveApprove director = new Director("huo");
		LeaveApprove manager = new Manager("li");
		LeaveApprove president = new President("tian");

		director.setSuccessor(manager);
		manager.setSuccessor(president);

		Leave leave1 = new Leave("张", "烦燥", 1);
		Leave leave2 = new Leave("王", "生病", 5);
		Leave leave3 = new Leave("陈", "蜜月", 15);
		Leave leave4 = new Leave("孙", "不想干了", 35);
		director.process(leave1);
		director.process(leave2);
		director.process(leave3);
		director.process(leave4);
	}
}
