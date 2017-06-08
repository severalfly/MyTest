package com.leon.artofpattern.decorator;

public class ComponentDecorator extends Component
{
	private Component component;

	public ComponentDecorator(Component component)
	{
		super();
		this.component = component;
	}

	@Override
	public void display()
	{
		this.component.display();
	}

}
