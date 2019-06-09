package com.huoli.test.bean;


import org.junit.Test;

import com.alibaba.fastjson.JSONObject;

public class TestJson
{
	@Test
	public void testJsonObj()
	{
		try
		{
			String boStr = "{\"createTime\":1494486322000,\"desc\":\"\",\"endTime\":1496381100000,\"expireTime\":1494488122000,\"extdata\":\"\",\"hideFlag\":1,\"info\":\"{\\\"usoList\\\":[{\\\"arriveName\\\":\\\"平凉南\\\",\\\"arrivetime\\\":\\\"13:25\\\",\\\"cardNo\\\":\\\"341222199005215975\\\",\\\"cardType\\\":\\\"二代身份证\\\",\\\"changeInsurance\\\":0,\\\"changeTask\\\":0,\\\"coach\\\":\\\"02\\\",\\\"createTime\\\":\\\"2017-05-11 15:05:22.0\\\",\\\"departDate\\\":\\\"2017-06-02\\\",\\\"departName\\\":\\\"平凉\\\",\\\"departtime\\\":\\\"13:10\\\",\\\"detailUrl\\\":\\\"gtgj://start?type=orderdetail&url=aHR0cHM6Ly9qdC5yc3NjYy5jb20vZ3RnandhcC9hcHAvaGVscGJ1eS9kZXRhaWwuaHRtbD90PTEmb2lkPUQyMDUxMTE1MDUyMjU0MTA2Nw==\\\",\\\"dstCityName\\\":\\\"平凉\\\",\\\"dstCode\\\":\\\"POJ\\\",\\\"endTime\\\":\\\"2017-06-02 13:25:00.0\\\",\\\"expiredTime\\\":1494488122000,\\\"ip\\\":\\\"27.17.10.210\\\",\\\"istatus\\\":6,\\\"km\\\":0,\\\"mustHasUser\\\":true,\\\"name\\\":\\\"张云飞\\\",\\\"orderId\\\":\\\"D20511150522541067\\\",\\\"orderSource\\\":\\\"6\\\",\\\"orgCityName\\\":\\\"平凉\\\",\\\"orgCode\\\":\\\"PIJ\\\",\\\"p\\\":\\\"BCxiaomiApp,android,5.1.1,gtgj,5.5,2014812,0\\\",\\\"payClass\\\":0,\\\"payExpireTime\\\":\\\"2017-05-11 15:35:22.0\\\",\\\"price\\\":1.0,\\\"refundInsurance\\\":0,\\\"refundTask\\\":0,\\\"scheduleResult\\\":\\\"c49ff4aPIJ3539959ed3b406\\\",\\\"seatName\\\":\\\"硬座\\\",\\\"seatNo\\\":\\\"019号\\\",\\\"startTime\\\":\\\"2017-06-02 13:10:00\\\",\\\"status\\\":\\\"已改签\\\",\\\"subOrderId\\\":\\\"D205111505225410670\\\",\\\"ticketArrive\\\":1496381100000,\\\"ticketType\\\":\\\"成人票\\\",\\\"trainCode\\\":\\\"6074\\\",\\\"travelTime\\\":0,\\\"uid\\\":\\\"27ada767960800fb2\\\",\\\"userid\\\":936343033953088}],\\\"GtgjOrderType\\\":\\\"orderid\\\",\\\"userorder\\\":{\\\"amount\\\":1.0,\\\"arriveName\\\":\\\"平凉南\\\",\\\"count\\\":0,\\\"createTime\\\":\\\"2017-05-11 15:05:22.0\\\",\\\"createUserid\\\":0,\\\"departDate\\\":\\\"2017-06-02\\\",\\\"departName\\\":\\\"平凉\\\",\\\"departTimestamp\\\":1496380200000,\\\"exchange\\\":\\\"2\\\",\\\"istatus\\\":3,\\\"orderId\\\":\\\"D20511150522541067\\\",\\\"orderSource\\\":\\\"6\\\",\\\"orderTime\\\":\\\"2017-05-11 15:05:22.0\\\",\\\"p\\\":\\\"BCxiaomiApp,android,5.1.1,gtgj,5.5,2014812,0\\\",\\\"payUserid\\\":936343033953088,\\\"rcCoupon\\\":\\\"653daae05906463ba9bd755a25a3d6cc\\\",\\\"show\\\":0,\\\"status\\\":\\\"支付成功\\\",\\\"ticketCount\\\":1,\\\"trainCode\\\":\\\"6074\\\",\\\"uid\\\":\\\"27ada767960800fb2\\\",\\\"userid\\\":\\\"936343033953088\\\",\\\"volume\\\":0.0}}\",\"ip\":\"27.17.10.210\",\"issuePrice\":\"0\",\"name\":\"\",\"orderId\":\"D20511150522541067\",\"p\":\"BCxiaomiApp,android,5.1.1,gtgj,5.5,2014812,0\",\"payid\":\"\",\"phoneId\":\"8142609\",\"platId\":\"2599332594861057\",\"productId\":\"29\",\"shortId\":\"A1536919555\",\"showFlag\":1,\"showType\":3,\"startTime\":1496380200000,\"status\":3,\"system\":\"train\",\"totalPrice\":\"1.0\",\"uid\":\"27ada767960800fb2\",\"updateTime\":1494489424115,\"version\":7}";
			System.out.println(boStr);
			Jsonob
			JSONObject.parseObject(boStr, BusiOrder.class);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
