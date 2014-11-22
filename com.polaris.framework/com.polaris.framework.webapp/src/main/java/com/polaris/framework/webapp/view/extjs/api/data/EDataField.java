package com.polaris.framework.webapp.view.extjs.api.data;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.extjs.annotation.Ext;
import com.polaris.framework.webapp.view.extjs.annotation.ExtChild;
import com.polaris.framework.webapp.view.extjs.annotation.ExtField;
import com.polaris.framework.webapp.view.extjs.annotation.VarType;

@Ext(type = VarType.CONFIG)
public class EDataField
{
	@ExtField
	protected String name;
	@ExtField
	protected String type;
	@ExtField
	protected String dateFormat;
	@ExtField
	protected Object defaultValue;
	@ExtField
	protected Boolean useNull;
	@ExtChild
	protected String convert;

	@TagAttribute
	public void setName(String name)
	{
		this.name = name;
	}

	@TagAttribute
	public void setType(String type)
	{
		this.type = type;
	}

	@TagAttribute
	public void setDateFormat(String dateFormat)
	{
		this.dateFormat = dateFormat;
	}

	@TagAttribute
	public void setDefaultValue(Object defaultValue)
	{
		this.defaultValue = defaultValue;
	}

	@TagAttribute
	public void setUseNull(Boolean useNull)
	{
		this.useNull = useNull;
	}

	@TagAttribute
	public void setConvert(String convert)
	{
		this.convert = convert;
	}

}
