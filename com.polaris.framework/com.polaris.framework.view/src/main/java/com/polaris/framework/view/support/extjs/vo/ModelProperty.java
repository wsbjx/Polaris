package com.polaris.framework.view.support.extjs.vo;

/**
 * 模型属性
 * 
 * @author wang.sheng
 * 
 */
public class ModelProperty
{
	private String name;
	private String idProperty;
	private ModelFieldProperty[] modelFields;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public ModelFieldProperty[] getModelFields()
	{
		return modelFields;
	}

	public void setModelFields(ModelFieldProperty[] modelFields)
	{
		this.modelFields = modelFields;
	}

	public String getIdProperty()
	{
		return idProperty;
	}

	public void setIdProperty(String idProperty)
	{
		this.idProperty = idProperty;
	}

}
