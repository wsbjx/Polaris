package com.polaris.platform.authorized.service;

/**
 * 授权过程中出现异常
 * 
 * @author wang.sheng
 */
public class AuthorizedException extends Exception
{
	private static final long serialVersionUID = 1L;
	/**
	 * 对应的模块ID
	 */
	private String moduleId;

	public AuthorizedException(String moduleId, String message)
	{
		super(message);
		this.moduleId = moduleId;
	}

	public String getModuleId()
	{
		return moduleId;
	}

}
