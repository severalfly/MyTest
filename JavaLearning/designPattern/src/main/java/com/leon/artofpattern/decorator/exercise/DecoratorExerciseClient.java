package com.leon.artofpattern.decorator.exercise;

public class DecoratorExerciseClient
{
	public static void main(String[] args)
	{

		ToEncodeData toEncodeData = new ToEncodeString();
		ToEncodeDecorator toEncodeDataSimple = new ToEncodeHigherDecorator(toEncodeData);

		toEncodeDataSimple.encode();
	}
}
