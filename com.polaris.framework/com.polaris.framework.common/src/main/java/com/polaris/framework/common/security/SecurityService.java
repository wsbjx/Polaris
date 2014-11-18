package com.polaris.framework.common.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

/**
 * 安全服务
 * 
 * @author wang.sheng
 * 
 */
@Service
public class SecurityService
{
	Log log = LogFactory.getLog(getClass());

	/**
	 * 将明文加密为密文
	 * 
	 * @param value
	 * @return
	 */
	public String encrypt(String value)
	{
		try
		{
			byte[] bytes = AESUtils.encrypt(value.getBytes(), null);
			return new String(bytes);
		}
		catch (Exception e)
		{
			log.warn("encrypt failed!", e);
			return null;
		}
	}

	/**
	 * 将密文转换为明文
	 * 
	 * @param value
	 * @return
	 */
	public String decrypt(String value)
	{
		try
		{
			byte[] bytes = AESUtils.decrypt(value.getBytes(), null);
			return new String(bytes);
		}
		catch (Exception e)
		{
			log.warn("decrypt failed!", e);
			return null;
		}
	}
}
