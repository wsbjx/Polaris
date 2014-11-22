package com.polaris.framework.webapp.view.extjs.jsp.form.field;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.extjs.api.form.field.ECheckboxGroup;
import com.polaris.framework.webapp.view.extjs.jsp.form.FieldContainerTag;

@TagLib(name = "checkboxgroup", component = ECheckboxGroup.class)
public class CheckboxGroupTag extends FieldContainerTag
{
	private static final long serialVersionUID = 1L;
	@TagAttribute
	protected Boolean vertical;
	@TagAttribute
	protected String blankText;
	@TagAttribute
	protected Boolean allowBlank;
	@TagAttribute
	protected String columns;

	public void setVertical(Boolean vertical)
	{
		this.vertical = vertical;
	}

	public void setBlankText(String blankText)
	{
		this.blankText = blankText;
	}

	public void setAllowBlank(Boolean allowBlank)
	{
		this.allowBlank = allowBlank;
	}

	public void setColumns(String columns)
	{
		this.columns = columns;
	}

}
