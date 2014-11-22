package com.polaris.framework.webapp.view.extjs.api.form.field;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.extjs.annotation.Ext;
import com.polaris.framework.webapp.view.extjs.annotation.ExtField;
import com.polaris.framework.webapp.view.extjs.annotation.VarType;

@Ext(name = "textfield", type = VarType.CONFIG)
public class ETextField extends EAbstractField
{
	@ExtField
	protected String emptyText;
	@ExtField
	protected String maskRe;
	@ExtField
	protected String regex;
	@ExtField
	protected String regexText;
	@ExtField
	protected Integer maxLength;
	@ExtField
	protected Boolean enforceMaxLength;
	@ExtField
	protected String inputType;
	@ExtField
	protected Boolean grow;

	@TagAttribute
	public void setEmptyText(String emptyText)
	{
		this.emptyText = emptyText;
	}

	@TagAttribute
	public void setMaskRe(String maskRe)
	{
		this.maskRe = maskRe;
	}

	@TagAttribute
	public void setRegex(String regex)
	{
		this.regex = regex;
	}

	@TagAttribute
	public void setRegexText(String regexText)
	{
		this.regexText = regexText;
	}

	@TagAttribute
	public void setMaxLength(Integer maxLength)
	{
		this.maxLength = maxLength;
	}

	@TagAttribute
	public void setEnforceMaxLength(Boolean enforceMaxLength)
	{
		this.enforceMaxLength = enforceMaxLength;
	}

	@TagAttribute
	public void setInputType(String inputType)
	{
		this.inputType = inputType;
	}

	@TagAttribute
	public void setGrow(Boolean grow)
	{
		this.grow = grow;
	}

}
