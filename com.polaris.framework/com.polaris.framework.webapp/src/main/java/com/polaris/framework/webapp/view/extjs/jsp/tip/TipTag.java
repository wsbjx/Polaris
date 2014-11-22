package com.polaris.framework.webapp.view.extjs.jsp.tip;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.extjs.api.tip.ETip;
import com.polaris.framework.webapp.view.extjs.jsp.panel.PanelTag;

@TagLib(name = "tip", component = ETip.class)
public class TipTag extends PanelTag
{
	private static final long serialVersionUID = 1L;
	@TagAttribute
	protected Boolean constrainPosition;
	@TagAttribute
	protected Boolean shadow;

	public void setConstrainPosition(Boolean constrainPosition)
	{
		this.constrainPosition = constrainPosition;
	}

	public void setShadow(Boolean shadow)
	{
		this.shadow = shadow;
	}

}
