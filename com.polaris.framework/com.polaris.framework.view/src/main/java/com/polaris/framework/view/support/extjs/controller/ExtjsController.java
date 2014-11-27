package com.polaris.framework.view.support.extjs.controller;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.polaris.framework.common.restful.SimpleResponse;
import com.polaris.framework.view.support.extjs.service.ExtjsService;
import com.polaris.framework.view.support.extjs.vo.GridFieldProperty;
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
	Log log = LogFactory.getLog(getClass());

	@Resource
	private ExtjsService extjsService;

	/**
	 * 获取数据对象的类型信息
	 * 
	 * @param className
	 * @return
	 */
	@RequestMapping(value = "/model/{className}", method = RequestMethod.GET)
	public SimpleResponse getModelInfo(@PathVariable String className)
	{
		SimpleResponse response = new SimpleResponse();
		try
		{
			Class<?> clazz = Thread.currentThread().getContextClassLoader().loadClass(className);
			ModelProperty modelProperty = extjsService.buildModelProperty(clazz);
			response.setSuccess(true);
			response.setData(modelProperty);
		}
		catch (Exception e)
		{
			response.setSuccess(false);
			response.setMessage(e.getMessage());
			log.error("getModelInfo failed!", e);
		}
		return response;
	}

	/**
	 * 获取表格的字段集合
	 * 
	 * @param className
	 * @return
	 */
	@RequestMapping(value = "/grid/{className}", method = RequestMethod.GET)
	public SimpleResponse getGridInfo(@PathVariable String className)
	{
		SimpleResponse response = new SimpleResponse();
		try
		{
			Class<?> clazz = Thread.currentThread().getContextClassLoader().loadClass(className);
			GridFieldProperty[] gridFieldProperties = extjsService.buildGridFieldPropertys(clazz);
			response.setSuccess(true);
			response.setData(gridFieldProperties);
		}
		catch (Exception e)
		{
			response.setSuccess(false);
			response.setMessage(e.getMessage());
			log.error("getGridInfo failed!", e);
		}
		return response;
	}
}
