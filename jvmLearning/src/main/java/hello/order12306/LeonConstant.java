package hello.order12306;

public class LeonConstant
{
	// 12306 登录初始化地址
	public static final String INIT_12306_URL = "https://kyfw.12306.cn/otn/login/init";
	// 12306 获取验证码
	public static final String LOGIN_12306_URL = "https://kyfw.12306.cn/otn/passcodeNew/getPassCodeNew?module=login&rand=sjrand&" + Math.random();
}
