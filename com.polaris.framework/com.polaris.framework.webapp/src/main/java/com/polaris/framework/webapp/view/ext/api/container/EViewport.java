package com.polaris.framework.webapp.view.ext.api.container;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.TagDocked;
import com.polaris.framework.webapp.view.ext.annotation.VarType;
import com.polaris.framework.webapp.view.ext.api.EModule;
import com.polaris.framework.webapp.view.ext.api.panel.EAbstractPanel;

@Ext(name = "Ext.Viewport", type = VarType.CREATE)
public class EViewport extends EContainer implements EModule
{
	protected String varName;

	@Override
	public String getVarName()
	{
		// TODO Auto-generated method stub
		return this.varName;
	}

	@TagAttribute
	public void setVarName(String varName)
	{
		this.varName = varName;
	}

	@TagDocked
	public void addPanel(EAbstractPanel panel)
	{
		super.items.add(panel);
	}
}
