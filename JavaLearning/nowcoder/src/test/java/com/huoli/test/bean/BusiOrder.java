package com.huoli.test.bean;

import com.alibaba.fastjson.JSONObject;


public class BusiOrder
{
	// 公共信息（必须包含以下字段）
	// productId + orderId唯一,日期时间类型的字段都必须转成long型   
	private String platId;//:56894568962,  //平台订单id,由统一订单平台生成,不可修改
	private String shortId;//:T55667788, // 短订单号,由统一订单平台生成,不可修改
	private String system;//:,  //业务系统
	private int version;//:1, //订单版本号
	private String productId;//:0, //产品id:0机票订单,7专车订单,字符型,不可修改
	private String orderId;//: 153421700460387,  //业务订单号,不可修改
	private String phoneId;//:411940, //用户id,不可修改
	private String uid;//:, //设备id ,不可修改
	private String p;//:, //设备参数,不可修改
	private String ip;//:127.0.0.1, // 预订时ip不可修改
	private String totalPrice;//:1024, // 订单总价,不可修改

	/**订单展示状态showType说明:
	0待付款订单 （未支付）,
	1已取消订单 （取消支付、临时未支付订单、关闭订单） 
	2未完成订单 （待出行、待发货、邮寄中、服务中、司机已确认、服务开始、部分退票、部分改期、退票待退款）,
	3已完成订单 （已出行、已全部退票退款、已收货、服务完成、已全部改期）,
	4已评价订单（目前不支持） 
	*/
	private int showType;//:1,
	private int status;//:5,  //订单状态:5已出票  
	private long createTime;//:10235648000, //创建时间,long型,不可修改
	private long updateTime;//:10235648900, //最后更新时间,long型
	private long expireTime;//:10235648300, //支付超时时间,long型,不可修改
	private int showFlag;//:0, // 是否显示, 0不显示,1显示
	private long startTime;//:10235648000, //订单开始时间,long型,不可修改
	private long endTime;//:10235648999, //订单结束时间,long型,不可修改
	private String name;//: , // 标题
	private String desc;//: // 描述
	private String payid;//: //支付id
	private String issuePrice;//:1024, // 发票可开具金额
	private int hideFlag;//: 0  // 是否首页隐藏, 0不隐藏,1隐藏

	//业务信息,大文本json（由各业务团队决定）
	private JSONObject info;//: {	}
	private String extdata;//: {	}

	public String getPlatId()
	{
		return this.platId;
	}

	public void setPlatId(String platId)
	{
		this.platId = platId;
	}

	public String getShortId()
	{
		return this.shortId;
	}

	public void setShortId(String shortId)
	{
		this.shortId = shortId;
	}

	public String getSystem()
	{
		return this.system;
	}

	public void setSystem(String system)
	{
		this.system = system;
	}

	public int getVersion()
	{
		return this.version;
	}

	public void setVersion(int version)
	{
		this.version = version;
	}

	public String getProductId()
	{
		return this.productId;
	}

	public void setProductId(String productId)
	{
		this.productId = productId;
	}

	public String getOrderId()
	{
		return this.orderId;
	}

	public void setOrderId(String orderId)
	{
		this.orderId = orderId;
	}

	public String getPhoneId()
	{
		return this.phoneId;
	}

	public void setPhoneId(String phoneId)
	{
		this.phoneId = phoneId;
	}

	public String getUid()
	{
		return this.uid;
	}

	public void setUid(String uid)
	{
		this.uid = uid;
	}

	public String getP()
	{
		return this.p;
	}

	public void setP(String p)
	{
		this.p = p;
	}

	public String getIp()
	{
		return this.ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	public String getTotalPrice()
	{
		return this.totalPrice;
	}

	public void setTotalPrice(String totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	public int getShowType()
	{
		return this.showType;
	}

	public void setShowType(int showType)
	{
		this.showType = showType;
	}

	public int getStatus()
	{
		return this.status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

	public long getCreateTime()
	{
		return this.createTime;
	}

	public void setCreateTime(long createTime)
	{
		this.createTime = createTime;
	}

	public long getUpdateTime()
	{
		return this.updateTime;
	}

	public void setUpdateTime(long updateTime)
	{
		this.updateTime = updateTime;
	}

	public long getExpireTime()
	{
		return this.expireTime;
	}

	public void setExpireTime(long expireTime)
	{
		this.expireTime = expireTime;
	}

	public int getShowFlag()
	{
		return this.showFlag;
	}

	public void setShowFlag(int showFlag)
	{
		this.showFlag = showFlag;
	}

	public long getStartTime()
	{
		return this.startTime;
	}

	public void setStartTime(long startTime)
	{
		this.startTime = startTime;
	}

	public long getEndTime()
	{
		return this.endTime;
	}

	public void setEndTime(long endTime)
	{
		this.endTime = endTime;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDesc()
	{
		return this.desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	public String getPayid()
	{
		return this.payid;
	}

	public void setPayid(String payid)
	{
		this.payid = payid;
	}

	public String getIssuePrice()
	{
		return this.issuePrice;
	}

	public void setIssuePrice(String issuePrice)
	{
		this.issuePrice = issuePrice;
	}

	public int getHideFlag()
	{
		return this.hideFlag;
	}

	public void setHideFlag(int hideFlag)
	{
		this.hideFlag = hideFlag;
	}

	public JSONObject getInfo()
	{
		return this.info;
	}

	public void setInfo(JSONObject info)
	{
		this.info = info;
	}

	public String getExtdata()
	{
		return this.extdata;
	}

	public void setExtdata(String extdata) throws ClassCastException
	{
		if (extdata != null && !extdata.equals(""))
		{
			JSONObject json = JSONObject.parseObject(extdata);
			this.extdata = json.toJSONString();
		}
		else
		{
			this.extdata = extdata;
		}
	}

}
