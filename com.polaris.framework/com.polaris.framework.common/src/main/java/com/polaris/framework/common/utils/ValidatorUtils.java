package com.polaris.framework.common.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * 校验工具类
 * 
 * @author wang.sheng
 * 
 */
public class ValidatorUtils
{
	/**
	 * 获取错误数据Map对象
	 * 
	 * @param bindingResult
	 * @return
	 */
	public static Map<String, String> getErrorMsgMap(BindingResult bindingResult)
	{
		if (!bindingResult.hasFieldErrors())
		{
			// 无错误时返回null
			return null;
		}
		Map<String, String> errorMap = new HashMap<String, String>();
		for (FieldError fieldError : bindingResult.getFieldErrors())
		{
			errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return errorMap;
	}
}
