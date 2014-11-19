package com.polaris.platform.system.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.polaris.framework.common.restful.SimpleResponse;
import com.polaris.platform.authorized.service.AuthorizedService;
import com.polaris.platform.system.service.UserService;
import com.polaris.platform.system.vo.User;

/**
 * 用户管理控制器<br>
 * 
 * @author wang.sheng
 */
@RestController
@RequestMapping("/platform/system/user")
public class UserController
{
	Log log = LogFactory.getLog(getClass());
	@Resource
	private UserService userService;
	@Resource
	private AuthorizedService authorizedService;

	@PostConstruct
	protected void initUserService()
	{
		// 生成超级用户
		userService.getSuperUser();
	}

	/**
	 * 获取所有的用户信息
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public User[] getUsers()
	{
		return userService.getUsers();
	}

	/**
	 * 在表单中加载数据
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public SimpleResponse getUser(@PathVariable String userId)
	{
		SimpleResponse response = new SimpleResponse();
		User user = userService.getUser(userId);
		if (user == null)
		{
			response.setSuccess(false);
			response.setMessage("没有找到用户信息,userId=" + userId);
		}
		else
		{
			response.setSuccess(true);
			response.setData(user);
		}
		return response;
	}

	/**
	 * 添加/修改时候进行保存
	 * 
	 * @param user
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public SimpleResponse save(@Valid @RequestBody User user, BindingResult userBindingResult)
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
	 * 删除一个指定用户
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public SimpleResponse delete(@PathVariable String userId)
	{
		userService.deleteUser(userId);
		SimpleResponse response = new SimpleResponse();
		response.setMessage("用户删除成功!");
		return response;
	}

	/**
	 * 更新用户的角色列表
	 * 
	 * @param userId
	 * @param roleIds
	 * @return
	 */
	@RequestMapping(value = "/{userId}/role", method = RequestMethod.POST)
	public SimpleResponse updateUserRole(@PathVariable String userId, @RequestBody String[] roleIds)
	{
		SimpleResponse response = new SimpleResponse();
		try
		{
			userService.updateUserRoles(userId, roleIds);
			response.setSuccess(true);
			response.setMessage("用户角色修改成功!");
		}
		catch (Exception e)
		{
			log.warn("updateUserRole failed!", e);
			response.setSuccess(false);
			response.setMessage("用户角色修改失败!");
		}
		return response;
	}
}