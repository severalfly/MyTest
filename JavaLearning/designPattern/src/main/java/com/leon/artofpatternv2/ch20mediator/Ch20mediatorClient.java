package com.leon.artofpatternv2.ch20mediator;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Ch20mediatorClient
{
	public static void main(String[] args)
	{
		ConcreteMediator mediator = new ConcreteMediator();

		Ch20Button addBt = new Ch20Button();
		Ch20List list = new Ch20List();
		Ch20ComboBox cb = new Ch20ComboBox();
		Ch20TextBox tb = new Ch20TextBox();

		addBt.setMediator(mediator);
		list.setMediator(mediator);
		cb.setMediator(mediator);
		tb.setMediator(mediator);

		mediator.setAddButton(addBt);
		mediator.setList(list);
		mediator.setCb(cb);
		mediator.setUserNameText(tb);

		addBt.change();
		System.out.println("--------------------------");
		System.out.println("--------------------------");
		list.change();
	}
}

abstract class Mediator
{
	public abstract void componentChanged(Component c);
}

/**
 * 具体抽象类
 */

@Setter
@Getter
class ConcreteMediator extends Mediator
{
	public Ch20Button addButton;
	public Ch20List list;
	public Ch20TextBox userNameText;
	public Ch20ComboBox cb;

	@Override
	public void componentChanged(Component c)
	{
		if (c == addButton)
		{
			// 单击按钮
			System.out.println("--单击增加按钮--");
			list.update();
			cb.update();
			userNameText.update();

		}
		else if (c == list)
		{
			System.out.println("--从列表中选择--");
			cb.select();
			userNameText.setText();
		}
		else if (c == cb)
		{
			System.out.println("--从组合框选择客户--");
			cb.select();
			userNameText.setText();
		}
	}
}

abstract class Component
{
	protected Mediator mediator;

	public void setMediator(Mediator mediator)
	{
		this.mediator = mediator;
	}

	public void change()
	{
		this.mediator.componentChanged(this);
	}

	public abstract void update();

}

class Ch20Button extends Component
{

	@Override
	public void update()
	{
		// 不需要操作
	}
}

class Ch20List extends Component
{

	@Override
	public void update()
	{
		System.out.println(this.getClass().getSimpleName() + " 增加一项：" + "张无忌");
	}

	public void select()
	{
		System.out.println(this.getClass().getSimpleName() + " 选择一项：" + "小龙女");
	}
}

class Ch20ComboBox extends Component
{

	@Override
	public void update()
	{
		System.out.println(this.getClass().getSimpleName() + " 增加一项：" + "张无忌");
	}

	public void select()
	{
		System.out.println(this.getClass().getSimpleName() + " 选择一项：" + "小龙女");
	}
}

class Ch20TextBox extends Component
{

	@Override
	public void update()
	{
		System.out.println(this.getClass().getSimpleName() + " 清空内容");
	}

	public void setText()
	{
		System.out.println(this.getClass().getSimpleName() + " 选择一项：" + "小龙女");
	}
}
