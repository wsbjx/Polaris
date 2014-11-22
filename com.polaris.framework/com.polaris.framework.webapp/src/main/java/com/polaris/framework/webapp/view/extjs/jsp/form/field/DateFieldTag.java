package com.polaris.framework.webapp.view.extjs.jsp.form.field;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.extjs.api.form.field.EDateField;

@TagLib(name = "datefield", component = EDateField.class)
public class DateFieldTag extends TextFieldTag
{
	private static final long serialVersionUID = 1L;
	@TagAttribute
	protected String maxValue;
	@TagAttribute
	protected String minValue;
	@TagAttribute
	protected String format;
	@TagAttribute
	protected String altFormats;

	public void setMaxValue(String maxValue)
	{
		this.maxValue = maxValue;
	}

	public void setMinValue(String minValue)
	{
		this.minValue = minValue;
	}

	public void setFormat(String format)
	{
		this.format = format;
	}

	public void setAltFormats(String altFormats)
	{
		this.altFormats = altFormats;
	}

}
