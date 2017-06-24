package com.leon.artofpattern.mediator;

public class MediatorClient
{
	public static void main(String[] args)
	{
		ConcreteMediator mediator = new ConcreteMediator();

		Button addBt = new Button();
		List list = new List();
		ComboBox cb = new ComboBox();
		TextBox tb = new TextBox();

		addBt.setMediator(mediator);
		list.setMediator(mediator);
		cb.setMediator(mediator);
		tb.setMediator(mediator);

		mediator.setAddButton(addBt);
		mediator.setList(list);
		mediator.setCb(cb);
		mediator.setUserNameTextBox(tb);

		addBt.changed();
		System.out.println("--------------------------");
		System.out.println("--------------------------");
		list.changed();
	}
}
