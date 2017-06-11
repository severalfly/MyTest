package com.leon.artofpattern.mediator.exercise;

public class MdEConstrectMediator extends MdEMediator
{
	private TextPane textPane;
	private ListPane listPane;
	private GraphicPane graphicPane;

	@Override
	public void planeChanged(MdEPane pane)
	{
		if(pane == this.textPane)
		{
			this.listPane.update();
			this.graphicPane.update();
		}
		else if(pane== this.listPane)
		{
			this.listPane.update();
			this.graphicPane.update();
			
		}
		else if(pane == this.graphicPane)
		{
			this.listPane.update();
			this.graphicPane.update();

		}
	}

	public TextPane getTextPane()
	{
		return this.textPane;
	}

	public void setTextPane(TextPane textPane)
	{
		this.textPane = textPane;
	}

	public ListPane getListPane()
	{
		return this.listPane;
	}

	public void setListPane(ListPane listPane)
	{
		this.listPane = listPane;
	}

	public GraphicPane getGraphicPane()
	{
		return this.graphicPane;
	}

	public void setGraphicPane(GraphicPane graphicPane)
	{
		this.graphicPane = graphicPane;
	}

}
