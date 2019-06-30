package com.leon.artofpatternv2.ch8Build;

import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
public class Ch8Actor
{
	private String type;
	private String sex;
	private String face;

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(type);
		sb.append(": ");
		sb.append(sex);
		sb.append(", ");
		sb.append(face);
		return sb.toString();
	}
}
