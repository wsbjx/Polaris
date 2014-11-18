package com.polaris.platform.authorized.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.stereotype.Service;

/**
 * 登录授权信息的会话监听器
 * 
 * @author wang.sheng
 */
@Service
public class AuthorizedHttpSessionListener implements HttpSessionListener
{
	@Resource
	private AuthorizedService authorizedService;

	@Override
	public void sessionCreated(HttpSessionEvent event)
	{
		// TODO Auto-generated method stub
		authorizedService.sessionCreated(event.getSession());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event)
	{
		// TODO Auto-generated method stub
		authorizedService.sessionDestroyed(event.getSession());
	}

}
