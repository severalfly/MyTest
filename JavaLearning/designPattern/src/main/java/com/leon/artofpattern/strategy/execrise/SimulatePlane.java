package com.leon.artofpattern.strategy.execrise;

/**
 * 飞机模拟系统
 * @author leon
 *
 */
public class SimulatePlane
{
	private Plane plane;

	public Plane getPlane()
	{
		return this.plane;
	}

	public void setPlane(Plane plane)
	{
		this.plane = plane;
	}

	public void start()
	{
		this.plane.takeOffCha();
		this.plane.flyCha();
	}
}
