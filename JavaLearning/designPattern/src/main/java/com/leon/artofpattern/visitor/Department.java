package com.leon.artofpattern.visitor;

public abstract class Department
{
	public abstract void visit(FullTimeEmployee employee);

	public abstract void visit(ParttimeEmployee employee);

}
