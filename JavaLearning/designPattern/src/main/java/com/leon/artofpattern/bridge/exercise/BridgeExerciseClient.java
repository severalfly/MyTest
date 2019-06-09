package com.leon.artofpattern.bridge.exercise;

public class BridgeExerciseClient
{
	public static void main(String[] args)
	{
		Format format = new SaveXmlFormat();
		FormatImp imp = new OracleImpl();
		format.setImp(imp);
		format.save();
	}
}
