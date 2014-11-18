package com.polaris.platform.system.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.polaris.framework.common.restful.SimpleResponse;
import com.polaris.platform.authorized.service.AuthorizedService;
import com.polaris.platform.authorized.vo.AuthorizedAccount;
import com.polaris.platform.system.service.UserService;
import com.polaris.platform.system.vo.Module;
import com.polaris.platform.system.vo.User;

/**
 * 用户管理控制器<br>
 * 
 * @author wang.sheng
 */
@Controller
@SessionAttributes(AuthorizedAccount.HTTP_SESSION_KEY)
public class UserController
{
	private final static String USER_MODULE_URL = "/system/user/list.html";
	Log log = LogFactory.getLog(getClass());
	@Resource
	private UserService userService;
	@Resource
	private AuthorizedService authorizedService;
	/**
	 * 用户管理的模块
	 */
	private Module userModule;

	@PostConstruct
	public void initUserService()
	{
		// 生成超级用户
		userService.getSuperUser();
		userModule = authorizedService.findModuleByURL(USER_MODULE_URL);
		if (userModule == null)
		{
			log.warn("URL:" + USER_MODULE_URL + " Module is not found!");
		}
	}

	/**
	 * 在表单中加载数据
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/system/user/load")
	@ResponseBody
	public Map<String, Object> load(String userId)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		User user = userService.getUser(userId);
		if (user == null)
		{
			map.put("success", false);
			map.put("errorMessage", "没有找到用户信息,userId=" + userId);
		}
		else
		{
			map.put("success", true);
			map.put("data", user);
		}
		return map;
	}

	/**
	 * 添加/修改时候进行保存
	 * 
	 * @param user
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value = "/system/user/save")
	@ResponseBody
	public SimpleResponse save(@Valid User user, BindingResult userBindingResult)
	{
		SimpleResponse response = new SimpleResponse();
		if (userBindingResult.hasErrors())
		{
			response.setSuccess(false);
			Map<String, String> errorMap = new HashMap<String, String>();
			for (FieldError fieldError : userBindingResult.getFieldErrors())
			{
				errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			response.setMessage("用户信息保存失败!");
			response.setData(errorMap);
			return response;
		}
		if (user.getId() == null || user.getId().length() < 1)
		{
			log.info("add user:" + user.getUsername());
			try
			{
				userService.addUser(user);
			}
			catch (Exception e)
			{
				log.warn("addUser failed!", e);
				response.setSuccess(false);
				response.setMessage(e.getMessage());
				return response;
			}
			response.setMessage("用户添加成功!");
		}
		else
		{
			log.info("update user:" + user.getUsername());
			userService.updateUser(user);
			response.setMessage("用户修改成功!");
		}
		response.setSuccess(true);
		response.setData(user);
		return response;
	}

	/**
	 * 批量添加用户
	 * 
	 * @param users
	 * @return
	 */
	@RequestMapping(value = "/system/user/create")
	@ResponseBody
	public Object create(@RequestBody User[] users)
	{
		try
		{
			userService.addUsers(users);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("success", true);
			map.put("message", "用户批量添加成功!");
			return map;
		}
		catch (Exception e)
		{
			log.warn("create User failed!", e);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("success", false);
			map.put("message", "用户批量添加失败!");
			return map;
		}
	}

	/**
	 * 批量保存用户信息
	 * 
	 * @param users
	 * @return
	 */
	@RequestMapping(value = "/system/user/update")
	@ResponseBody
	public Object update(@RequestBody User[] users)
	{
		for (User user : users)
		{
			userService.updateUser(user);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		map.put("message", "用户批量修改成功!");
		return map;
	}

	@RequestMapping(value = "/system/user/destroy")
	@ResponseBody
	public Object destroy(@RequestBody User[] users)
	{
		for (User user : users)
		{
			userService.deleteUser(user.getId());
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		map.put("message", "用户批量删除成功!");
		return map;
	}

	@RequestMapping(value = "/system/user/updateUserRole")
	@ResponseBody
	public Object updateUserRole(String userId, String roleIds)
	{
		String[] roles = roleIds.split(",");
		try
		{
			userService.updateUserRoles(userId, roles);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("success", true);
			map.put("message", "用户角色修改成功!");
			return map;
		}
		catch (Exception e)
		{
			log.warn("updateUserRole failed!", e);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("success", false);
			map.put("message", "用户角色修改失败!");
			return map;
		}
	}
}
