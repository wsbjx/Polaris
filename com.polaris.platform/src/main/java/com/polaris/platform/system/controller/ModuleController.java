package com.polaris.platform.system.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.polaris.framework.common.restful.SimpleResponse;
import com.polaris.platform.authorized.service.AuthorizedService;
import com.polaris.platform.authorized.vo.AuthorizedAccount;
import com.polaris.platform.system.service.ModuleService;
import com.polaris.platform.system.vo.Module;

/**
 * 模块管理控制器
 * 
 * @author wang.sheng
 */
@Controller
@SessionAttributes(AuthorizedAccount.HTTP_SESSION_KEY)
public class ModuleController
{
	Log log = LogFactory.getLog(getClass());
	@Resource
	private ModuleService moduleService;
	@Resource
	private AuthorizedService authorizedService;

	@RequestMapping(value = "/system/module/load")
	@ResponseBody
	public Map<String, Object> load(String id)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Module module = moduleService.getModule(id);
		if (module == null)
		{
			map.put("success", false);
			map.put("errorMessage", "没有找到模块信息,moduleId=" + id);
		}
		else
		{
			map.put("success", true);
			map.put("data", module);
		}
		return map;
	}

	/**
	 * 批量删除模块信息
	 * 
	 * @param roles
	 * @return
	 */
	@RequestMapping(value = "/system/module/destroy")
	@ResponseBody
	public Object destroy(@RequestBody Module[] modules)
	{
		for (Module module : modules)
		{
			moduleService.deleteModule(module.getId());
		}
		SimpleResponse response = new SimpleResponse();
		response.setMessage("模块批量删除成功!");
		return response;
	}

	@RequestMapping(value = "/system/module/save")
	@ResponseBody
	public SimpleResponse save(Module module)
	{
		SimpleResponse response = new SimpleResponse();
		if (module.getId() == null || module.getId().length() < 1)
		{
			// 新建记录
			moduleService.addModule(module);
			response.setMessage(module.getTitle() + "模块添加成功!");
		}
		else
		{
			// 修改记录
			moduleService.updateModule(module);
			response.setMessage(module.getTitle() + "模块修改成功!");
		}
		response.setData(module);
		response.setSuccess(true);
		return response;
	}

	@RequestMapping(value = "/system/module/updateModuleRole")
	@ResponseBody
	public Object updateModuleRole(String moduleId, String roleIds)
	{
		String[] roles = roleIds.split(",");
		moduleService.updateModuleRoles(moduleId, roles);
		SimpleResponse response = new SimpleResponse();
		response.setMessage("模块角色修改成功!");
		return response;
	}
}
