package com.polaris.framework.webapp.view.extjs.api.toolbar;

import com.polaris.framework.webapp.view.extjs.annotation.Ext;
import com.polaris.framework.webapp.view.extjs.annotation.TagDocked;
import com.polaris.framework.webapp.view.extjs.annotation.VarType;
import com.polaris.framework.webapp.view.extjs.api.button.ESeparator;
import com.polaris.framework.webapp.view.extjs.api.container.EContainer;

@Ext(name = "toolbar", type = VarType.CONFIG)
public class EToolbar extends EContainer
{

	@TagDocked
	public void addSeparator(ESeparator separator)
	{
		items.add("-");
	}
}
