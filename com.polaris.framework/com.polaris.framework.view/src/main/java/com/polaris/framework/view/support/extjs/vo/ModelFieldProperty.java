package com.polaris.framework.view.support.extjs.vo;

/**
 * 字段属性模型
 * 
 * @author wang.sheng
 * 
 */
public class ModelFieldProperty
{
	private String name;
	private Object defaultValue;
	private String type;
	private String convert;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Object getDefaultValue()
	{
		return defaultValue;
	}

	public void setDefaultValue(Object defaultValue)
	{
		this.defaultValue = defaultValue;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getConvert()
	{
		return convert;
	}

	public void setConvert(String convert)
	{
		this.convert = convert;
	}

}
