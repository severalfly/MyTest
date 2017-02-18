package org.leon;

/** 
 * 修改Class 文件，暂时只能提供修改常量池的功能
 */
public class ClassModifier
{
	// Class 文件中常量池的起始偏移
	private static final int CONSTANT_POOL_COUNT_INDEX = 8;

	// CONSTANT_Utf8_info 常量的tag 标志
	private static final int CONSTANT_Utf8_info = 1;

	// 常量池中11 种常量所占的长度，CONSTANT_Utf8_info 型除外，因为它不是定长的
	private static final int[] CONSTANT_ITEM_LENGTH = {-1, -1, -1, 5, 5, 9, 9, 3, 3, 5, 5, 5, 5};

	private static final int u1 = 1;
	private static final int u2 = 2;

	private byte[] classByte;

	public ClassModifier(byte[] classByte)
	{
		this.classByte = classByte;
	}

	/**
	 * 修改常量池中 CONSTANT_Utf8_info常量的内容
	 * @param  oldStr 修改前的字符串
	 * @param  newStr 修改后的字符串
	 * @return        修改结果
	 */	
	public byte[] modifyUTF8Constant(String oldStr, String newStr)
	{

	}
}