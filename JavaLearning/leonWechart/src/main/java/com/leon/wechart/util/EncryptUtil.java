package com.leon.wechart.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil
{
	public static String encodeSHA(String str)
	{
		try
		{
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			byte messageDigest[] = digest.digest();
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < messageDigest.length; i++)
			{
				String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
				if (shaHex.length() < 2)
				{
					hexString.append(0);
				}
				hexString.append(shaHex);
			}
			return hexString.toString();
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
