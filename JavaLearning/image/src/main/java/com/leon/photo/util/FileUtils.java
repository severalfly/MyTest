package com.leon.photo.util;


import java.io.InputStream;

import com.google.gson.Gson;
import com.leon.photo.LConfig;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

public class FileUtils
{
	private static final String ACCESS_KEY = LConfig.instance.getProperty("access_key");//这里填上面我们讲到的，密钥管理里面的密钥
	private static final String SECRET_KEY = LConfig.instance.getProperty("secret_key");
	private static final String BUCKET_NAME = "severalfly-image";//填我们在七牛云创建的 Bucket 名字
	private static final Zone zone = Zone.zone2();
	/**
	 * 华东	Zone.zone0()
	华北	Zone.zone1()
	华南	Zone.zone2()
	北美	Zone.zoneNa0()
	 */
	/**
	 * 上传图片到七牛云存储
	 * @param reader
	 * @param fileName
	 */
	public static void upload(InputStream reader, String fileName)
	{
		//构造一个带指定Zone对象的配置类
		Configuration cfg = new Configuration(zone);
		//...其他参数参考类注释

		UploadManager uploadManager = new UploadManager(cfg);
		//...生成上传凭证，然后准备上传
		String accessKey = ACCESS_KEY;
		String secretKey = SECRET_KEY;
		String bucket = BUCKET_NAME;

		//默认不指定key的情况下，以文件内容的hash值作为文件名
		String key = fileName;

		try
		{
			Auth auth = Auth.create(accessKey, secretKey);
			String upToken = auth.uploadToken(bucket);

			try
			{
				Response response = uploadManager.put(reader, key, upToken, null, null);
				//解析上传成功的结果
				DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
				System.out.println(putRet.key);
				System.out.println(putRet.hash);
			}
			catch (QiniuException ex)
			{
				Response r = ex.response;
				System.err.println(r.toString());
				try
				{
					System.err.println(r.bodyString());
				}
				catch (QiniuException ex2)
				{
					//ignore
				}
			}
		}
		catch (Exception ex)
		{
			//ignore
		}


	}

	/**
	 * 删除七牛云存储上的图片
	 * @param key
	 */
	public static void delete(String key)
	{
		Configuration cfg = new Configuration(zone);
		Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
		BucketManager bucketManager = new BucketManager(auth, cfg);
		try {
			bucketManager.delete(BUCKET_NAME, key);
		} catch (QiniuException ex) {
		    //如果遇到异常，说明删除失败
		    System.err.println(ex.code());
		    System.err.println(ex.response.toString());
		}

	}
}