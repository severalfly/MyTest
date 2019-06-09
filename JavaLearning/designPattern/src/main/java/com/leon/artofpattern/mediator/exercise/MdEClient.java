package com.leon.artofpattern.mediator.exercise;

public class MdEClient
{
	public static void main(String[] args)
	{
		MdEConstrectMediator mediator = new MdEConstrectMediator();

		TextPane textPane = new TextPane();
		ListPane listPane = new ListPane();
		GraphicPane graphicPane = new GraphicPane();

		textPane.setMediator(mediator);
		listPane.setMediator(mediator);
		graphicPane.setMediator(mediator);

		mediator.setTextPane(textPane);
		mediator.setListPane(listPane);
		mediator.setGraphicPane(graphicPane);

		textPane.changed();

		System.out.println("----------------------");

		listPane.changed();
	}
}
