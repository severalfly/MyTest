package hello.order12306;

public class LeonConstant
{
	// 12306 getjessionid url
	public static final String ONT_URL = "https://kyfw.12306.cn/otn/";
	// 12306 登录初始化地址
	public static final String INIT_12306_URL = "https://kyfw.12306.cn/otn/login/init";
	// 12306 获取验证码
	public static final String LOGIN_PASSCODE_12306_URL = "https://kyfw.12306.cn/otn/passcodeNew/getPassCodeNew?module=login&rand=sjrand&" + Math.random();
	// 12306 提交验证码
	public static final String CHECK_RANDOM_CODE_URL = "https://kyfw.12306.cn/otn/passcodeNew/checkRandCodeAnsyn";
	// 12306 登录验证
	public static final String LOGIN_12306_URL = "https://kyfw.12306.cn/otn/login/loginAysnSuggest";
}
