package com.polaris.platform.system.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.polaris.platform.system.service.ModuleService;
import com.polaris.platform.system.vo.ModuleProperty;

/**
 * 模块控制器
 * 
 * @author wang.sheng
 * 
 */
@RestController
@RequestMapping("/platform/system/module")
public class ModuleController
{
	@Resource
	private ModuleService moduleService;

	@RequestMapping(method = RequestMethod.GET)
	public ModuleProperty[] getModuleProperties()
	{
		return moduleService.getModuleProperties();
	}

	@RequestMapping(value = "/{moduleId}", method = RequestMethod.GET)
	public ModuleProperty getModuleProperty(@PathVariable String moduleId)
	{
		return moduleService.getModuleProperty(moduleId);
	}
}
