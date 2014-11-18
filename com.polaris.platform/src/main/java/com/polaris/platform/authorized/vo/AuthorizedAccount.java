package com.polaris.platform.authorized.vo;

/**
 * 登录授权账号信息
 * 
 * @author wang.sheng
 */
public final class AuthorizedAccount implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	public static final String HTTP_SESSION_KEY = "_session_Authorized_Account";
	public static final String HTTP_REQUEST_KEY = "_request_Authorized_Account";

	/**
	 * 用户ID.游客的用户ID为null
	 */
	private String userId;
	private String userName;
	private String name;
	private long loginTime;
	private String ipAddress;

	public String getIpAddress()
	{
		return ipAddress;
	}

	public void setIpAddress(String ipAddress)
	{
		this.ipAddress = ipAddress;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public long getLoginTime()
	{
		return loginTime;
	}

	public void setLoginTime(long loginTime)
	{
		this.loginTime = loginTime;
	}

}
