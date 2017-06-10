package com.leon.artofpattern.proxy;

public class ProxySearcher implements Seacher
{
	private RealSearcher searcher = new RealSearcher();
	private AccessValidator validator = new AccessValidator();
	private Logger logger = new Logger();

	@Override
	public String doSearch(String userid, String keyword)
	{
		if (this.validator.validate(userid))
		{
			String result = this.searcher.doSearch(userid, keyword);
			this.logger.log(userid);
			return result;
		}
		return null;
	}

}
