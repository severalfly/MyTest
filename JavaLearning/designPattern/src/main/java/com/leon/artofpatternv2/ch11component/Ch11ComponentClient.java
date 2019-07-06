package com.leon.artofpatternv2.ch11component;

import java.util.ArrayList;
import java.util.List;

public class Ch11ComponentClient
{
	public static void main(String[] args)
	{
		Component component = new FoldFeild("main");

		Component textFeild = new TextField("统计1.csv");
		Component imageFeild = new ImageTextField("小龙女.jpg");
		Component foldFeild = new FoldFeild("私密");

		Component inTextFeild = new TextField("你猜是个啥名字.txt");
		Component inTextFeild2 = new TextField("我不知道呀.py");
		foldFeild.add(inTextFeild);
		foldFeild.add(inTextFeild2);

		component.add(textFeild);
		component.add(imageFeild);
		component.add(foldFeild);

		component.killVirus();
	}
}

interface Component
{
	public void add(Component component);

	public void remove(int key);

	public Component getFile(int key);

	public void killVirus();

}

class TextField implements Component
{
	private String name;

	public TextField(String name)
	{
		this.name = name;
	}

	@Override
	public void add(Component component)
	{
		System.out.println(this.getClass().getSimpleName() + "  " + this.name + " do not support add");
	}

	@Override
	public void remove(int key)
	{
		System.out.println(this.getClass().getSimpleName() + "  " + this.name + " do not support remove");
	}

	@Override
	public Component getFile(int key)
	{
		System.out.println(this.getClass().getSimpleName() + "  " + this.name + " do not support getFile");
		return null;
	}

	@Override
	public void killVirus()
	{
		System.out.println(this.getClass().getSimpleName() + "  " + this.name + "  kill virus");
	}
}

class ImageTextField implements Component
{
	private String name;

	public ImageTextField(String name)
	{
		this.name = name;
	}

	@Override
	public void add(Component component)
	{
		System.out.println(this.getClass().getSimpleName() + "  " + this.name + " do not support add");
	}

	@Override
	public void remove(int key)
	{
		System.out.println(this.getClass().getSimpleName() + "  " + this.name + " do not support remove");
	}

	@Override
	public Component getFile(int key)
	{
		System.out.println(this.getClass().getSimpleName() + "  " + this.name + " do not support getFile");
		return null;
	}

	@Override
	public void killVirus()
	{
		System.out.println(this.getClass().getSimpleName() + "  " + this.name + "  kill virus");
	}
}

class FoldFeild implements Component
{
	private String name;
	private List<Component> list;

	public FoldFeild(String name)
	{
		this.list = new ArrayList<>();
		this.name = name;
	}

	@Override
	public void add(Component component)
	{
		this.list.add(component);
	}

	@Override
	public void remove(int key)
	{
		this.list.remove(key);
	}

	@Override
	public Component getFile(int key)
	{
		return this.list.get(key);
	}

	@Override
	public void killVirus()
	{
		System.out.println(this.getClass().getSimpleName() + "  " + this.name + " killing virus");
		for (Component component : list)
		{
			component.killVirus();
		}
	}
}
