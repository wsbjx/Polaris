package com.polaris.framework.webapp.view.extjs.api.form;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.extjs.annotation.Ext;
import com.polaris.framework.webapp.view.extjs.annotation.ExtField;
import com.polaris.framework.webapp.view.extjs.annotation.VarType;
import com.polaris.framework.webapp.view.extjs.api.container.EContainer;

@Ext(name = "fieldset", type = VarType.CONFIG)
public class EFieldSet extends EContainer
{
	@ExtField
	protected String title;

	@TagAttribute
	public void setTitle(String title)
	{
		this.title = title;
	}

}
