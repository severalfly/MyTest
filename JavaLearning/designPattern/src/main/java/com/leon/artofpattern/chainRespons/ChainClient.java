package com.leon.artofpattern.chainRespons;

public class ChainClient
{
	public static void main(String[] args)
	{
		Approver direct = new Director("张无忌");
		Approver vicePresident = new VicePresident("杨过");
		Approver president = new President("郭靖");
		Approver congress = new Congress("董事会");

		//		direct.setSuccessor(vicePresident);
		//		vicePresident.setSuccessor(president);
		direct.setSuccessor(president);
		president.setSuccessor(congress);

		PurchaseRequest request1 = new PurchaseRequest(45000, 10001, "购买倚天剑");
		direct.processRequest(request1);
		PurchaseRequest request2 = new PurchaseRequest(60000, 10001, "购买屠龙刀");
		direct.processRequest(request2);
		PurchaseRequest request3 = new PurchaseRequest(150000, 10001, "购买《九阴真经》");
		direct.processRequest(request3);
		PurchaseRequest request4 = new PurchaseRequest(800000, 10001, "购买桃花岛");

		direct.processRequest(request4);
	}
}
