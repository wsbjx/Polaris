package com.polaris.framework.webapp.view.extjs.api;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.extjs.annotation.Ext;
import com.polaris.framework.webapp.view.extjs.annotation.TagContent;
import com.polaris.framework.webapp.view.extjs.annotation.VarType;

/**
 * Ext扩展对象
 * 
 * @author wang.sheng
 */
@Ext(type = VarType.UX)
public class EUxObject
{
	private String name;
	private String config;

	@TagAttribute
	public void setName(String name)
	{
		this.name = name;
	}

	@TagContent
	public void setConfig(String config)
	{
		this.config = config;
	}

	public String getName()
	{
		return name;
	}

	public String getConfig()
	{
		return config;
	}

}
