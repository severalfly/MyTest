package com.leon.wechart.service;


import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.leon.wechart.bean.TextMsgFromWC;
import com.leon.wechart.bean.send.WxMsg;
import com.leon.wechart.util.LeonHttpClient;
import com.leon.wechart.util.ObjectUtil;
import com.leon.wechart.util.Pair;

public class WeChartService
{
	private static final Logger logger = LoggerFactory.getLogger(WeChartService.class);
	public static final String appId = "wx8aa538a3f854dc2b";
	public static final String appsecret = "219b4e3fecdc3962c5d1c2c2dbfe115f";
	//	public static final String appId = GtConfig.getProperty("wechart_appid");
	//	public static final String appsecret = EncryptUtil.decodeBase64AndAES(GtConfig.getProperty("wechart_appsecret"), GtConstant.BANK_INFO_KEY);
	// 缓存中微信token 的id
	public static final String weChartMemTokenId = "wechart_open_access_token";
	// 缓存中微信ips 的id
	public static final String weChartMemIpsId = "wechart_open_ips";
	public static final String WC_MENU_KEY_BIND_PHONE = "bind_phone";
	public static final String WC_MENU_EVENT_CLICK = "CLICK";
	private static Map<String, Object> innerMap = new HashMap<String, Object>();

	/**
	 * 更新微信公众号平台token 
	 * @return 有效期  秒
	 */
	public static Pair<String, Integer> updateWeChartAccessToken()
	{
		try
		{
			String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
			//			url = String.format(url, GtConfig.getProperty("wechart_appid"), EncryptUtil.decodeBase64AndAES(GtConfig.getProperty("wechart_appsecret"), GtConstant.BANK_INFO_KEY));
			url = String.format(url, appId, appsecret);
			String res = LeonHttpClient.sendRequestUrl(url, null);
			logger.info("更新微信公众号平台token结果：" + res);
			JSONObject json = JSONObject.parseObject(res);
			if (json.containsKey("errcode"))
			{
				throw new Exception(json.getString("errmsg"));
			}
			// token
			String access_token = json.getString("access_token");
			// 有效期
			int expires_in = json.getIntValue("expires_in");
			storeObject(weChartMemTokenId, access_token, (expires_in - 200) * 1000l);// 提前设置刷新
			return new Pair<String, Integer>(access_token, expires_in);
		}

		catch (Exception e)
		{
			logger.error("", e);
		}
		return new Pair<String, Integer>("", 0);
	}

	//	@Test
	public void testUpdate()
	{
		System.out.println(updateWeChartAccessToken());
	}

	public static String getWechartAccessToken()
	{
		String token = (String) getObject(weChartMemTokenId);
		if (ObjectUtil.isNotNull(token))
		{
			return token;
		}
		return updateWeChartAccessToken().left;
	}

	/**
	 * 更新微信ips，无明确时间，目前（2017-04-01）按每天刷新一次
	 * @param avaLong 缓存有效期，
	 * @return 当前微信ip 127.0.0.1,127.0.0.2
	 */
	public static String updateWechartIps(long avaLong)
	{
		try
		{
			String url = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=%s";
			String token = (String) getObject(weChartMemTokenId);
			if (ObjectUtil.isNull(token))
			{
				token = updateWeChartAccessToken().left;
			}
			url = String.format(url, token);
			String res = LeonHttpClient.sendRequestUrl(url, null);
			JSONObject json = JSONObject.parseObject(res);
			List<String> ipList = JSONArray.parseArray(json.getString("ip_list"), String.class);
			StringBuffer sb = new StringBuffer();
			for (String ip : ipList)
			{
				// 这里面有个神奇的 121.51.130.64/27 需要处理下
				if (ip.contains("/"))
				{
					sb.append(ip.replaceAll("([0-9]{1,3}\\.)([0-9]{1,3}\\.)([0-9]{1,3}\\.)([0-9]{1,3})/([0-9]{1,3})", "$1$2$3$4,$1$2$3$5,"));
				}
				else
				{
					sb.append(ip + ",");
				}
			}
			sb.append("192.168.3.126,27.17.10.210,");
			sb.append("58.247.206.144,58.247.206.155,58.247.206.153,58.247.206.150,58.247.206.145,58.247.206.140,58.247.206.144,58.247.206.139,58.247.206.152,58.247.206.154,58.247.206.158,58.247.206.157,58.247.206.146,101.226.233.139,101.226.233.154,101.226.233.149,101.226.233.144");
			storeObject(weChartMemIpsId, sb.toString(), avaLong);
			return sb.toString();
		}
		catch (Exception e)
		{
			logger.error("", e);
		}
		return "";
	}

	//	@Test
	public void testSlash()
	{
		String ip = "121.51.130.64/27";
		// 121.51.130.64,121.51.130.27
		System.out.println(ip.replaceAll("([0-9]{1,3}\\.)([0-9]{1,3}\\.)([0-9]{1,3}\\.)([0-9]{1,3})/([0-9]{1,3})", "$1$2$3$4,$1$2$3$5,"));
	}

	/**
	 * 获取微信公众平台可用ips
	 * @return
	 */
	public static String getWechartIps()
	{
		String ips = (String) getObject(weChartMemIpsId);
		if (com.leon.wechart.util.ObjectUtil.isNotNull(ips))
		{
			return ips;
		}
		return updateWechartIps(24 * 60 * 60 * 1000l);
	}

	//	@Test
	public void testWechartips()
	{
		System.out.println(getWechartIps());
	}

	/**
	 * 模拟memcache，测试不可用
	 * @return
	 */
	public static boolean storeObject(String key, Object obj, long avalong)
	{

		// 测试服
		innerMap.put(key, obj);
		return true;

	}

	/**
	 * 测试服模拟memcache
	 * @param key
	 * @return
	 */
	public static Object getObject(String key)
	{

		return innerMap.get(key);

	}

	/**
	 * 解微信公众平台发来的消息
	 * @param params 微信发来的消息，
	 * 			<xml>
				<ToUserName><![CDATA[toUser]]></ToUserName>
				<FromUserName><![CDATA[fromUser]]></FromUserName> 
				<CreateTime>1348831860</CreateTime>
				<MsgType><![CDATA[text]]></MsgType>
				<Content><![CDATA[this is a test]]></Content>
				<MsgId>1234567890123456</MsgId>
				</xml>
	 * @return
	 */
	public static Map<String, Object> parseXmlToList2(String params)
	{
		if (ObjectUtil.isNull(params))
		{
			return new HashMap<String, Object>(0);
		}
		Map<String, Object> retMap = new HashMap<String, Object>();
		try
		{
			StringReader read = new StringReader(params);
			// 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
			InputSource source = new InputSource(read);
			// 创建一个新的SAXBuilder
			SAXBuilder sb = new SAXBuilder();
			// 通过输入源构造一个Document
			Document doc = (Document) sb.build(source);
			Element root = doc.getRootElement();// 指向根节点
			List<Element> es = root.getChildren();
			if (es != null && es.size() != 0)
			{
				for (Element element : es)
				{
					retMap.put(element.getName(), element.getText());
				}
			}
		}
		catch (Exception e)
		{
			logger.error("", e);
		}
		return retMap;
	}

	public static TextMsgFromWC parseTextMsg(Map<String, Object> s)
	{
		TextMsgFromWC tmf = new TextMsgFromWC();
		tmf.setFromUserName(ObjectUtil.getString(s.get("FromUserName")));
		tmf.setToUserName(ObjectUtil.getString(s.get("ToUserName")));
		tmf.setCreateTime(ObjectUtil.getLong(s.get("CreateTime")));
		tmf.setMsgType("text");
		tmf.setContent(ObjectUtil.getString(s.get("Content")));
		tmf.setMsgId(ObjectUtil.getLong(s.get("MsgId")));
		return tmf;
	}

	public static String getResult(WxMsg wxMsg)
	{
		Document doc = wxMsg.toDocument();
		String result = "";
		try
		{
			if (null != doc)
			{
				StringWriter writer = new StringWriter();
				new XMLOutputter().output(doc, writer);
				result = writer.toString().replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "").replaceAll("&lt;", "<").replaceAll("&gt;", ">");
				writer.close();
			}
			else
			{
				logger.error("发送消息时,解析出dom为空 msg :");
			}
		}
		catch (Exception e)
		{
			logger.error("转换为微信返回消息时出错：" + JSONObject.toJSONString(wxMsg), e);
		}
		return result;
	}
}
