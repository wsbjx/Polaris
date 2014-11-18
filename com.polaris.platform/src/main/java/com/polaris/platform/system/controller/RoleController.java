package com.polaris.platform.system.controller;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.polaris.framework.common.restful.PagingResult;
import com.polaris.framework.common.restful.SimpleResponse;
import com.polaris.platform.authorized.service.AuthorizedService;
import com.polaris.platform.authorized.vo.AuthorizedAccount;
import com.polaris.platform.system.service.RoleService;
import com.polaris.platform.system.vo.Role;

/**
 * 角色管理的控制器
 * 
 * @author wang.sheng
 * 
 */
@Controller
@SessionAttributes(AuthorizedAccount.HTTP_SESSION_KEY)
public class RoleController
{
	Log log = LogFactory.getLog(getClass());
	@Resource
	private RoleService roleService;
	@Resource
	private AuthorizedService authorizedService;

	/**
	 * 批量添加角色
	 * 
	 * @param users
	 * @return
	 */
	@RequestMapping(value = "/system/role/create")
	@ResponseBody
	public Object create(@RequestBody Role[] roles)
	{
		for (Role role : roles)
		{
			roleService.addRole(role);
		}
		SimpleResponse response = new SimpleResponse();
		response.setMessage("角色批量添加成功!");
		return response;
	}

	/**
	 * 批量保存角色信息
	 * 
	 * @param users
	 * @return
	 */
	@RequestMapping(value = "/system/role/update")
	@ResponseBody
	public Object update(@RequestBody Role[] roles)
	{
		for (Role role : roles)
		{
			roleService.updateRole(role);
		}
		SimpleResponse response = new SimpleResponse();
		response.setMessage("角色批量修改成功!");
		return response;
	}

	/**
	 * 批量删除角色信息
	 * 
	 * @param roles
	 * @return
	 */
	@RequestMapping(value = "/system/role/destroy")
	@ResponseBody
	public Object destroy(@RequestBody Role[] roles)
	{
		for (Role role : roles)
		{
			roleService.deleteRole(role.getId());
		}
		SimpleResponse response = new SimpleResponse();
		response.setMessage("角色批量删除成功!");
		return response;
	}

	@RequestMapping(value = "/system/role/readUserRole")
	@ResponseBody
	public PagingResult<Role> readUserRole(String userId)
	{
		Role[] roles = roleService.getUserRoles(userId);
		return new PagingResult<Role>(roles.length, roles);
	}

	@RequestMapping(value = "/system/role/readOtherUserRole")
	@ResponseBody
	public PagingResult<Role> readOtherUserRole(String userId)
	{
		Role[] roles = roleService.getOtherUserRoles(userId);
		return new PagingResult<Role>(roles.length, roles);
	}

	@RequestMapping(value = "/system/role/readModuleRole")
	@ResponseBody
	public PagingResult<Role> readModuleRole(String moduleId)
	{
		Role[] roles = roleService.getModuleRoles(moduleId);
		return new PagingResult<Role>(roles.length, roles);
	}

	@RequestMapping(value = "/system/role/readOtherModuleRole")
	@ResponseBody
	public PagingResult<Role> readOtherModuleRole(String moduleId)
	{
		Role[] roles = roleService.getOtherModuleRoles(moduleId);
		return new PagingResult<Role>(roles.length, roles);
	}
}
