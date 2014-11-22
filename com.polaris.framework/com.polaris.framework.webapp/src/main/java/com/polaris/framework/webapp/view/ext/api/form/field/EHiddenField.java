package com.polaris.framework.webapp.view.ext.api.form.field;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.VarType;

@Ext(name = "hidden", type = VarType.CONFIG)
public class EHiddenField implements EField
{
	@ExtField
	protected String id;
	@ExtField
	protected String name;
	@ExtField
	protected Object value;

	@TagAttribute
	public void setId(String id)
	{
		this.id = id;
	}

	@TagAttribute
	public void setName(String name)
	{
		this.name = name;
	}

	@TagAttribute
	public void setValue(Object value)
	{
		// TODO Auto-generated method stub
		this.value = value;
	}

	public Object getValue()
	{
		// TODO Auto-generated method stub
		return value;
	}

}
