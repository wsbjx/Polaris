package com.polaris.framework.webapp.view.extjs.api.form.field;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.extjs.annotation.Ext;
import com.polaris.framework.webapp.view.extjs.annotation.ExtChild;
import com.polaris.framework.webapp.view.extjs.annotation.ExtField;
import com.polaris.framework.webapp.view.extjs.annotation.VarType;

@Ext(name = "datefield", type = VarType.CONFIG)
public class EDateField extends ETextField
{
	@ExtChild
	protected String maxValue;
	@ExtChild
	protected String minValue;
	@ExtField
	protected String format;
	@ExtField
	protected String altFormats;

	@TagAttribute
	public void setMaxValue(String maxValue)
	{
		this.maxValue = maxValue;
	}

	@TagAttribute
	public void setMinValue(String minValue)
	{
		this.minValue = minValue;
	}

	@TagAttribute
	public void setFormat(String format)
	{
		this.format = format;
	}

	@TagAttribute
	public void setAltFormats(String altFormats)
	{
		this.altFormats = altFormats;
	}

}
