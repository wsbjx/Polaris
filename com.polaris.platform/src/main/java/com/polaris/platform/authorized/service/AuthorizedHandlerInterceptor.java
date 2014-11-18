package com.polaris.platform.authorized.service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.polaris.framework.common.security.SecurityService;
import com.polaris.platform.authorized.vo.AuthorizedAccount;
import com.polaris.platform.system.service.RoleService;
import com.polaris.platform.system.service.UserService;
import com.polaris.platform.system.vo.User;

/**
 * 用于授权的拦截器
 * 
 * @author wang.sheng
 */
@Service
public class AuthorizedHandlerInterceptor implements HandlerInterceptor
{
	Log log = LogFactory.getLog(getClass());
	@Resource
	private UserService userService;
	@Resource
	private SecurityService securityService;

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
	{
		if (ex != null)
		{
			log.error("exception handler=" + handler, ex);
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception
	{
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		log.info("preHandle request uri=" + request.getRequestURI());
		HttpSession session = request.getSession();
		AuthorizedAccount account = (AuthorizedAccount) session.getAttribute(AuthorizedAccount.HTTP_SESSION_KEY);
		if (account == null)
		{
			// 会话中尚未建立账户信息
			// 从cookie中获取用户id信息
			account = new AuthorizedAccount();
			String userId = getUserIdFromCookie(request);
			User user = null;
			if (userId != null)
			{
				user = userService.getUser(userId);
			}
			if (user == null)
			{
				// 创建游客账户信息
				account.setName("游客");
				account.setUserId(null);
				account.setUserName(RoleService.VISITOR_ROLE);
			}
			else
			{
				account.setName(user.getName());
				account.setUserId(userId);
				account.setUserName(user.getUsername());
			}
			account.setLoginTime(System.currentTimeMillis());
			account.setIpAddress(request.getRemoteAddr());
			session.setAttribute(AuthorizedAccount.HTTP_SESSION_KEY, account);
		}
		request.setAttribute(AuthorizedAccount.HTTP_REQUEST_KEY, account);
		return true;
	}

	/**
	 * 查找Cookie实例
	 * 
	 * @param request
	 * @return
	 */
	private String getUserIdFromCookie(HttpServletRequest request)
	{
		Cookie[] cookies = request.getCookies();
		if (cookies == null || cookies.length < 1)
		{
			return null;
		}
		for (Cookie cookie : cookies)
		{
			if (cookie.getName() != null && cookie.getName().equals("SIRIUS_COOKIE"))
			{
				String des = cookie.getValue();
				log.info("read cookie value:" + des);
				if (des != null && des.length() > 0)
				{
					return securityService.decrypt(des);
				}
			}
		}
		return null;
	}

}
