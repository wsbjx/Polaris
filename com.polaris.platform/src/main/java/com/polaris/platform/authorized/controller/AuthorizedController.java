package com.polaris.platform.authorized.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.polaris.framework.common.restful.SimpleResponse;
import com.polaris.framework.common.security.SecurityService;
import com.polaris.platform.authorized.service.AuthorizedException;
import com.polaris.platform.authorized.service.AuthorizedService;
import com.polaris.platform.authorized.vo.AuthorizedAccount;
import com.polaris.platform.system.service.ModuleService;
import com.polaris.platform.system.service.UserService;
import com.polaris.platform.system.vo.Module;
import com.polaris.platform.system.vo.User;

/**
 * 授权控制器
 * 
 * @author wang.sheng
 */
@Controller
@SessionAttributes(AuthorizedAccount.HTTP_SESSION_KEY)
public class AuthorizedController
{
	Log log = LogFactory.getLog(getClass());

	private static final String COOKIE_PATH = "com.polaris.platform.cookie";

	@Resource
	private AuthorizedService authorizedService;
	@Resource
	private ModuleService moduleService;
	@Resource
	private UserService userService;
	@Resource
	private SecurityService securityService;

	/**
	 * 模块调度器
	 * 
	 * @param moduleId
	 * @param account
	 * @return
	 * @throws AuthorizedException
	 */
	@RequestMapping(value = "/authorized/moduleDispatch")
	public ModelAndView moduleDispatch(String moduleId, @ModelAttribute(AuthorizedAccount.HTTP_SESSION_KEY) AuthorizedAccount account)
			throws AuthorizedException
	{
		log.info("requestModule moduleId=" + moduleId);
		ModelAndView mv = new ModelAndView();
		Module module = moduleService.getModule(moduleId);
		// 检查不通过的时候将报出异常
		authorizedService.checkModuleAuthority(account, module);
		// 具备访问资格
		String url = module.getUrl();
		log.info("moduleDispatch module url:" + url + ",username:" + account.getUserName());
		if (url != null && url.startsWith("http://"))
		{
			// 重定向到其他的网站
			mv.setViewName("redirect:" + url);
		}
		else
		{
			// 采用跟进的方式进入指定的url
			mv.setViewName("forward:" + url);
		}
		return mv;
	}

	@RequestMapping(value = "/authorized/logout")
	@ResponseBody
	public Object logout(HttpServletRequest request, HttpServletResponse response)
	{
		SimpleResponse simpleResponse = new SimpleResponse();
		authorizedService.logout(request);
		simpleResponse.setMessage("注销成功!");
		// 清除cookie
		removeCookie(response);
		return simpleResponse;
	}

	@RequestMapping(value = "/authorized/modifyPassword")
	@ResponseBody
	public Object modifyPassword(String oldPassword, String password, String password2,
			@ModelAttribute(AuthorizedAccount.HTTP_SESSION_KEY) AuthorizedAccount account)
	{
		SimpleResponse response = new SimpleResponse();
		if (account == null || account.getUserId() == null)
		{
			response.setSuccess(false);
			response.setMessage("您尚未登录,请重新登录!");
			return response;
		}
		if (!StringUtils.equals(password, password2))
		{
			response.setSuccess(false);
			response.setMessage("两次输入的新密码不一致!");
			return response;
		}
		try
		{
			User user = userService.login(account.getUserName(), oldPassword);
			userService.modifyPassword(user.getId(), oldPassword, password);
			response.setSuccess(true);
			response.setMessage("密码修改成功!");
			return response;
		}
		catch (Exception e)
		{
			response.setSuccess(false);
			response.setMessage(e.getMessage());
			return response;
		}
	}

	@RequestMapping(value = "/authorized/login")
	@ResponseBody
	public Object login(String username, String password, Boolean autoLogin, HttpServletRequest request, HttpServletResponse response)
	{
		log.info("login username=" + username);
		SimpleResponse simpleResponse = new SimpleResponse();
		User user = null;
		try
		{
			user = userService.login(username, password);
		}
		catch (Exception e)
		{
			simpleResponse.setMessage(e.getMessage());
			simpleResponse.setSuccess(false);
			return simpleResponse;
		}
		HttpSession session = request.getSession();
		String ipAddress = request.getRemoteAddr();
		authorizedService.login(session, user, ipAddress);
		simpleResponse.setSuccess(true);
		simpleResponse.setMessage("登录成功!");
		if (autoLogin)
		{
			// 如果需要自动登录,则添加Cookie
			addCookie(response, user.getId());
		}
		else
		{
			removeCookie(response);
		}
		return simpleResponse;
	}

	/**
	 * 清除客户端里面的Cookie
	 * 
	 * @param response
	 */
	private void removeCookie(HttpServletResponse response)
	{
		// 清除cookie
		Cookie cookie = new Cookie(COOKIE_PATH, "");
		cookie.setPath("/");
		cookie.setMaxAge(-1);
		log.info("remove Cookie");
		response.addCookie(cookie);
	}

	/**
	 * 给响应添加cookie的静态方法
	 * 
	 * @param response
	 */
	private void addCookie(HttpServletResponse response, String userId)
	{
		String des = securityService.encrypt(userId);
		Cookie cookie = new Cookie(COOKIE_PATH, des);
		cookie.setPath("/");
		cookie.setMaxAge(3600 * 24 * 30);
		log.info("addCookie value=" + des);
		response.addCookie(cookie);
	}
}
