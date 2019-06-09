package com.leon.artofpattern.mediator;

public class ConcreteMediator extends Mediator
{
	public Button addButton;
	public List list;
	public TextBox userNameTextBox;
	public ComboBox cb;

	@Override
	public void componentChanged(Component c)
	{
		if (c == addButton)
		{
			System.out.println("--单击增加按钮--");
			this.list.update();
			this.cb.update();
			userNameTextBox.update();
		}
		else if (c == this.list)
		{
			System.out.println("--从列表选择用户--");
			this.cb.select();
			this.userNameTextBox.setText();
		}
		else if (c == this.cb)
		{
			System.out.println("--从组合框选择客户--");
			this.cb.select();
			this.userNameTextBox.setText();
		}
	}

	public Button getAddButton()
	{
		return this.addButton;
	}

	public void setAddButton(Button addButton)
	{
		this.addButton = addButton;
	}

	public List getList()
	{
		return this.list;
	}

	public void setList(List list)
	{
		this.list = list;
	}

	public TextBox getUserNameTextBox()
	{
		return this.userNameTextBox;
	}

	public void setUserNameTextBox(TextBox userNameTextBox)
	{
		this.userNameTextBox = userNameTextBox;
	}

	public ComboBox getCb()
	{
		return this.cb;
	}

	public void setCb(ComboBox cb)
	{
		this.cb = cb;
	}

}
