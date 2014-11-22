package com.polaris.framework.webapp.view.extjs.api.selection;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.extjs.annotation.Ext;
import com.polaris.framework.webapp.view.extjs.annotation.VarType;
import com.polaris.framework.webapp.view.extjs.api.EModule;

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
