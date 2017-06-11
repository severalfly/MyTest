package com.leon.artofpattern.mediator.exercise;

public abstract class MdEPane
{
	protected MdEMediator mediator;

	public MdEMediator getMediator()
	{
		return this.mediator;
	}

	public void setMediator(MdEMediator mediator)
	{
		this.mediator = mediator;
	}

	public void changed()
	{
		this.mediator.planeChanged(this);
	}

	public abstract void update();
}
