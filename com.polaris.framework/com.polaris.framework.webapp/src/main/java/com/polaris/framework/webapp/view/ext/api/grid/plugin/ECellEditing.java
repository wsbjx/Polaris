package com.polaris.framework.webapp.view.ext.api.grid.plugin;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.VarType;
import com.polaris.framework.webapp.view.ext.api.EModule;

@Ext(name = "Ext.grid.plugin.CellEditing", type = VarType.CREATE)
public class ECellEditing implements EModule
{
	@ExtField
	protected Integer clicksToEdit;
	protected String varName;

	@TagAttribute
	public void setVarName(String varName)
	{
		this.varName = varName;
	}

	@TagAttribute
	public void setClicksToEdit(Integer clicksToEdit)
	{
		this.clicksToEdit = clicksToEdit;
	}

	@Override
	public String getVarName()
	{
		// TODO Auto-generated method stub
		return varName;
	}

}
