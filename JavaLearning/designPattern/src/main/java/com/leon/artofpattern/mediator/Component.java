package com.leon.artofpattern.mediator;

abstract class Component
{
	protected Mediator mediator;

	public Mediator getMediator()
	{
		return this.mediator;
	}

	public void setMediator(Mediator mediator)
	{
		this.mediator = mediator;
	}

	public void changed()
	{
		this.mediator.componentChanged(this);
	}

	public abstract void update();
}
