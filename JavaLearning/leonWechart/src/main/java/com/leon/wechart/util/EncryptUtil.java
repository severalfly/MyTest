package com.leon.wechart.util;

//public class EncryptUtil
//{
//	public static String encodeSHA(String str)
//	{
//		try
//		{
//			MessageDigest digest = MessageDigest.getInstance("SHA-1");
//			byte messageDigest[] = digest.digest();
//			StringBuffer hexString = new StringBuffer();
//			for (int i = 0; i < messageDigest.length; i++)
//			{
//				String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
//				if (shaHex.length() < 2)
//				{
//					hexString.append(0);
//				}
//				hexString.append(shaHex);
//			}
//			return hexString.toString();
//		}
//		catch (NoSuchAlgorithmException e)
//		{
//			e.printStackTrace();
//		}
//		return null;
//	}
//}

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 加密工具
 */
public class EncryptUtil
{
	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };

	private static byte[] iv = { 1, 2, 3, 4, 5, 6, 7, 8 };

	private static final String suffix = "33224";

	/**
	 * MD5加密
	 * @param origin 待加密字串
	 * @return 加密后的字串
	 */
	public static String md5(String origin)
	{
		return encodeToHex(origin, "UTF-8", "MD5");
	}

	public static String sha1(String origin)
	{
		return encodeToHex(origin, "UTF-8", "SHA1");
	}

	public static String encodeToHex(String origin, String charsetname, String type)
	{
		String resultString = null;
		try
		{
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance(type);
			if (charsetname == null || "".equals(charsetname))
			{
				resultString = byteArrayToHexString(md.digest(resultString.getBytes("UTF-8")));
			}
			else
			{
				resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
			}
		}
		catch (Exception exception)
		{
			return null;
		}
		return resultString;
	}

	public static String encodeBase64(String s)
	{
		if (s == null)
			return null;
		try
		{
			return (new BASE64Encoder()).encode(s.getBytes("UTF-8"));
		}
		catch (Exception e)
		{
			return null;
		}
	}

	public static String encodeBase64(byte[] bs)
	{
		if (bs == null)
			return null;
		return (new BASE64Encoder()).encode(bs);
	}

	public static String decodeBase64(String s)
	{
		if (s == null)
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try
		{
			byte[] b = decoder.decodeBuffer(s);
			return new String(b, "UTF-8");
		}
		catch (Exception e)
		{
			return null;
		}
	}

	public static byte[] decodeBase64Forb(String s)
	{
		if (s == null)
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try
		{
			return decoder.decodeBuffer(s);
		}
		catch (Exception e)
		{
			return null;
		}
	}

	public static byte[] encodeAESForb(String content, String password)
	{
		try
		{
			Cipher cipher = initCipher(Cipher.ENCRYPT_MODE, password);
			return cipher.doFinal(content.getBytes("UTF-8"));
		}
		catch (Exception e)
		{
			return null;
		}
	}

	public static String encodeAES(String content, String password)
	{
		try
		{
			byte[] result = encodeAESForb(content, password);
			return parseByte2HexStr(result);
		}
		catch (Exception e)
		{
			return null;
		}
	}

	public static String decodeAES(byte[] bs, String password)
	{
		try
		{
			Cipher cipher = initCipher(Cipher.DECRYPT_MODE, password);
			byte[] result = cipher.doFinal(bs);
			return new String(result, "UTF-8");
		}
		catch (Exception e)
		{
			return null;
		}
	}

	public static String encodeAESAndBase64(String content, String key)
	{
		byte[] bs1 = encodeAESForb(content, key);
		return encodeBase64(bs1);
	}

	/**
	 * 先解base64，再解AES
	 * @param content 密文
	 * @param key 密钥
	 * @return 明文
	 */
	public static String decodeBase64AndAES(String content, String key)
	{
		byte[] bs = decodeBase64Forb(content);
		return decodeAES(bs, key);
	}

	private static Cipher initCipher(int mode, String password) throws Exception
	{
		// 默认为128位加密
		SecretKeySpec key = new SecretKeySpec(password.getBytes(), "AES");
		// 创建密码器  
		Cipher cipher = Cipher.getInstance("AES");
		// 初始化  
		cipher.init(mode, key);
		return cipher;
	}

	public static String encryptDES(String cleartext, String seed) throws Exception
	{
		byte[] rawKey = seed.getBytes("UTF-8");
		byte[] result = encrypt(rawKey, cleartext.getBytes("UTF-8"));
		return parseByte2HexStr(result);
	}

	public static String decryptDES(String encrypted, String seed) throws Exception
	{
		byte[] rawKey = seed.getBytes("UTF-8");
		byte[] enc = parseHexStr2Byte(encrypted);
		byte[] result = decrypt(rawKey, enc);
		return new String(result, "UTF-8");
	}

	private static byte[] encrypt(byte[] raw, byte[] clear) throws Exception
	{
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "DES");
		IvParameterSpec zeroIv = new IvParameterSpec(iv);
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, zeroIv);
		byte[] encrypted = cipher.doFinal(clear);
		return encrypted;
	}

	private static byte[] decrypt(byte[] raw, byte[] encrypted) throws Exception
	{
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "DES");
		IvParameterSpec zeroIv = new IvParameterSpec(iv);
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec, zeroIv);
		byte[] decrypted = cipher.doFinal(encrypted);
		return decrypted;
	}

	private static String byteArrayToHexString(byte b[])
	{
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
		{
			int n = b[i];
			if (n < 0)
			{
				n += 256;
			}
			int d1 = n / 16;
			int d2 = n % 16;
			resultSb.append(hexDigits[d1] + hexDigits[d2]);
		}
		return resultSb.toString();
	}

	/**将二进制转换成16进制 
	 * @param buf 
	 * @return 
	 */
	public static String parseByte2HexStr(byte buf[])
	{
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++)
		{
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1)
			{
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**将16进制转换为二进制 
	 * @param hexStr 
	 * @return 
	 */
	public static byte[] parseHexStr2Byte(String hexStr)
	{
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++)
		{
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}

	public static String encodeURL(String url)
	{
		try
		{
			String str = URLEncoder.encode(url, "UTF-8");
			return str.replaceAll("\\+", "%20");
		}
		catch (UnsupportedEncodingException e)
		{
		}
		return null;
	}

}
