package com.polaris.platform.system.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.polaris.platform.system.service.ModuleService;
import com.polaris.platform.system.vo.Module;

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

}
