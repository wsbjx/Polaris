package com.polaris.framework.webapp.view.ext.api.form.field;

import org.apache.commons.lang.math.NumberUtils;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.VarType;
import com.polaris.framework.webapp.view.ext.api.form.EFieldContainer;

@Ext(name = "checkboxgroup", type = VarType.CONFIG)
public class ECheckboxGroup extends EFieldContainer
{
	@ExtField
	protected Boolean vertical;
	@ExtField
	protected String blankText;
	@ExtField
	protected Boolean allowBlank;
	@ExtField(isJson = true)
	protected Object columns;

	@TagAttribute
	public void setVertical(Boolean vertical)
	{
		this.vertical = vertical;
	}

	@TagAttribute
	public void setBlankText(String blankText)
	{
		this.blankText = blankText;
	}

	@TagAttribute
	public void setAllowBlank(Boolean allowBlank)
	{
		this.allowBlank = allowBlank;
	}

	@TagAttribute
	public void setColumns(String columns)
	{
		if (NumberUtils.isNumber(columns))
		{
			this.columns = NumberUtils.createInteger(columns);
		}
		else
		{
			this.columns = columns;
		}
	}

}
