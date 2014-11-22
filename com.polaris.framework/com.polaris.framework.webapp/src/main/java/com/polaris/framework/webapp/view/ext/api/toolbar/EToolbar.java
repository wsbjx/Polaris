package com.polaris.framework.webapp.view.ext.api.toolbar;

import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.TagDocked;
import com.polaris.framework.webapp.view.ext.annotation.VarType;
import com.polaris.framework.webapp.view.ext.api.button.ESeparator;
import com.polaris.framework.webapp.view.ext.api.container.EContainer;

@Ext(name = "toolbar", type = VarType.CONFIG)
public class EToolbar extends EContainer
{

	@TagDocked
	public void addSeparator(ESeparator separator)
	{
		items.add("-");
	}
}
