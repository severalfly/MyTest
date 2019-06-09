package com.leon.artofpattern.abstractfactory;

public interface SkinFactory
{
	public Button createButton();

	public TextField createTextField();

	public ComboBox createComboBox();
}
