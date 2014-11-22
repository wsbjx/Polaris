package com.polaris.framework.webapp.view.ext.jsp.grid.plugin;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.ext.api.grid.plugin.ECellEditing;
import com.polaris.framework.webapp.view.ext.jsp.ExtTagSupport;

@TagLib(name = "cellediting", component = ECellEditing.class, bodyContent = "empty")
public class CellEditingTag extends ExtTagSupport
{
	private static final long serialVersionUID = 1L;
	@TagAttribute
	protected Integer clicksToEdit;
	@TagAttribute
	protected String varName;

	public void setClicksToEdit(Integer clicksToEdit)
	{
		this.clicksToEdit = clicksToEdit;
	}

	public void setVarName(String varName)
	{
		this.varName = varName;
	}

}
