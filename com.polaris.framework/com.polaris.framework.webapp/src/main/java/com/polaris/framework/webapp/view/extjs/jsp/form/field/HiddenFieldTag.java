package com.polaris.framework.webapp.view.extjs.jsp.form.field;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.extjs.api.form.field.EHiddenField;
import com.polaris.framework.webapp.view.extjs.jsp.ExtTagSupport;

@TagLib(name = "hiddenfield", component = EHiddenField.class)
public class HiddenFieldTag extends ExtTagSupport
{
	private static final long serialVersionUID = 1L;
	@TagAttribute
	protected String id;
	@TagAttribute
	protected String name;
	@TagAttribute
	protected Object value;

	public void setId(String id)
	{
		this.id = id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setValue(Object value)
	{
		this.value = value;
	}

}
