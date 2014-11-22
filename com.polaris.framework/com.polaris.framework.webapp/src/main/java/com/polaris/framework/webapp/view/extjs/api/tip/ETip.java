package com.polaris.framework.webapp.view.extjs.api.tip;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.extjs.annotation.Ext;
import com.polaris.framework.webapp.view.extjs.annotation.ExtField;
import com.polaris.framework.webapp.view.extjs.annotation.VarType;
import com.polaris.framework.webapp.view.extjs.api.panel.EPanel;

@Ext(name = "Ext.tip.Tip", type = VarType.CREATE)
public class ETip extends EPanel
{
	@ExtField
	protected Boolean constrainPosition;
	@ExtField
	protected Boolean shadow;

	@TagAttribute
	public void setConstrainPosition(Boolean constrainPosition)
	{
		this.constrainPosition = constrainPosition;
	}

	@TagAttribute
	public void setShadow(Boolean shadow)
	{
		this.shadow = shadow;
	}

}
