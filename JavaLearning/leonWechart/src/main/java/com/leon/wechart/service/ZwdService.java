package com.leon.wechart.service;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leon.wechart.util.LeonHttpClient;
import com.leon.wechart.util.ObjectUtil;

public class ZwdService
{
	private static final Logger logger = LoggerFactory.getLogger(ZwdService.class);

	/**
	 * 
	 * @param cz 查询车站，如 汉口
	 * @param cc 查询车次，如 T180
	 * @param departDate 查询日期，如 2017-05-25
	 * @return
	 */
	public static String query(String cz, String cc, String departDate)
	{
		try
		{
			Map<String, String> headers = new HashMap<>();
			headers.put("Accept", "*/*");
			headers.put("Accept-Encoding", "gzip, deflate, sdch");
			headers.put("Accept-Language", "zh-CN,zh;q=0.8");
			headers.put("Connection", "keep-alive");
			headers.put("Cookie",
					"RAIL_EXPIRATION=1495368058704; RAIL_OkLJUJ=FDhbTKqbe0ujpSxvFbFetdVVv9rT6P7q; RAIL_DEVICEID=TWnvGmcepsYmCyFWKnNUD7Lx6Hv--0Mnk7Tk_Im2FYtPwhrQs_WBKG4YrrZaNCBgwQMboIWkYH07VYc_ohTz60MFANNj51LhGA8s5jNY3aJhwVndOsBwZ3qWdOjyRtJ_8ZDkRBnIr9PPskyN-BVJUnmnGDTBAKcL; route=c5c62a339e7744272a54643b3be5bf64; BIGipServerotn=670040586.38945.0000; JSESSIONID=ZmMV5TZGhyy2LxyqpqjJxMKdM9bFMQWpzbGShVT1v3b81R0qDv2n!533242656; BIGipServerzwdcx=4010803466.28695.0000");
			headers.put("Host", "dynamic.12306.cn");
			headers.put("Referer", "http://dynamic.12306.cn/mapping/kfxt/zwdcx/LCZWD/CCCX.jsp");
			headers.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
			String czEn = URLEncoder.encode(cz, "utf-8").replaceAll("%", "-");
			cz = URLEncoder.encode(cz, "gbk");
			String url = String.format("http://dynamic.12306.cn/mapping/kfxt/zwdcx/LCZWD/from2.jsp?cz=%s&cc=%s&cxlx=0&rq=%s&czEn=%s&tp=%s", cz, cc, departDate, czEn, System.currentTimeMillis());
			String res = LeonHttpClient.sendRequestUrl(url, headers);
			System.out.println(res);
			logger.info(res);
			if (res.contains("ERROR_ADDRESS_DATE"))
			{
				return "暂无正晚点信息，请稍候查询";
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			logger.error("", e);
		}
		return "";
	}

	@Test
	public void testQuery()
	{
		System.out.println(queryZWDV2("g9", "上海虹桥"));
	}

	public static String queryZWDV2(String trainCode, String station)
	{
		String deRes = "暂无正晚点信息";
		if (ObjectUtil.isNull(station) || ObjectUtil.isNull(station.trim()))
		{
			return deRes;
		}
		try
		{
			String utf8Code = URLEncoder.encode(station, "utf-8").replaceAll("%", "-");
			String gbCode = URLEncoder.encode(station, "gb2312");
			String departdate = ObjectUtil.getDay();
			String url = "http://dynamic.12306.cn/mapping/kfxt/zwdcx/LCZWD/cx.jsp?cz=%s&cc=%s&cxlx=0&rq=%s&czEn=%s&tp=%s";
			url = String.format(url, gbCode, trainCode, departdate, utf8Code, System.currentTimeMillis() - 10);
			HttpGet httpGet = new HttpGet(url);
			//HttpClient  
			CloseableHttpClient httpClient = HttpClients.createDefault();
			try
			{
				//执行get请求  
				HttpResponse httpResponse = httpClient.execute(httpGet);
				//获取响应消息实体  
				HttpEntity entity = httpResponse.getEntity();
				//响应状态  
				//判断响应实体是否为空  
				if (entity != null)
				{
					//					System.out.println("response content:" + EntityUtils.toString(entity));
					deRes = EntityUtils.toString(entity);
				}
			}
			catch (IOException e)
			{
				logger.error("", e);
			}
			finally
			{
				try
				{
					//关闭流并释放资源  
					httpClient.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}

		}
		catch (Exception e)
		{
			logger.error("", e);
		}
		return deRes;

	}
}
