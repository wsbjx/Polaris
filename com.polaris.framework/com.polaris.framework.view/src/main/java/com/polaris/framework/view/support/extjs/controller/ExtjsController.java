package com.polaris.framework.view.support.extjs.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polaris.framework.view.support.extjs.service.ExtjsService;
import com.polaris.framework.view.support.extjs.vo.ModelProperty;

/**
 * ExtJS支撑的控制器
 * 
 * @author wang.sheng
 * 
 */
@RestController
@RequestMapping("/view/support/extjs")
public class ExtjsController
{
	@Resource
	private ExtjsService extjsService;

	@RequestMapping("")
	public ModelProperty getModel()
	{
		return null;
	}
}
