package com.polaris.framework.webapp.view.ext.api.selection;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.VarType;
import com.polaris.framework.webapp.view.ext.api.EModule;

@Ext(name = "Ext.selection.CheckboxModel", type = VarType.CREATE)
public class ECheckboxModel implements EModule
{
	private String varName;

	@Override
	public String getVarName()
	{
		// TODO Auto-generated method stub
		return varName;
	}

	@TagAttribute
	public void setVarName(String varName)
	{
		this.varName = varName;
	}

}
