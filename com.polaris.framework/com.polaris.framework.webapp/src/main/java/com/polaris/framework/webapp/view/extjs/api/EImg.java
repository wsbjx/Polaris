package com.polaris.framework.webapp.view.extjs.api;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.extjs.annotation.Ext;
import com.polaris.framework.webapp.view.extjs.annotation.ExtField;
import com.polaris.framework.webapp.view.extjs.annotation.VarType;

@Ext(name = "image", type = VarType.CONFIG)
public class EImg extends EComponent
{
	@ExtField
	protected String src;
	@ExtField
	protected String alt;

	@TagAttribute
	public void setSrc(String src)
	{
		this.src = src;
	}

	@TagAttribute
	public void setAlt(String alt)
	{
		this.alt = alt;
	}

}
