package com.polaris.framework.webapp.view.extjs.jsp.button;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.extjs.api.button.EButton;
import com.polaris.framework.webapp.view.extjs.jsp.ComponentTag;

@TagLib(name = "button", component = EButton.class)
public class ButtonTag extends ComponentTag
{
	private static final long serialVersionUID = 1L;
	@TagAttribute
	protected String text;
	@TagAttribute
	protected String tooltip;
	@TagAttribute
	protected String handler;
	@TagAttribute
	protected String iconCls;
	@TagAttribute
	protected String type;
	@TagAttribute
	protected String href;
	@TagAttribute
	protected String hrefTarget;
	@TagAttribute
	protected String params;
	@TagAttribute
	protected String textAlign;

	public void setType(String type)
	{
		this.type = type;
	}

	public void setHref(String href)
	{
		this.href = href;
	}

	public void setHrefTarget(String hrefTarget)
	{
		this.hrefTarget = hrefTarget;
	}

	public void setParams(String params)
	{
		this.params = params;
	}

	public void setTextAlign(String textAlign)
	{
		this.textAlign = textAlign;
	}

	public void setIconCls(String iconCls)
	{
		this.iconCls = iconCls;
	}

	public void setText(String text)
	{
		this.text = text;
	}

	public void setTooltip(String tooltip)
	{
		this.tooltip = tooltip;
	}

	public void setHandler(String handler)
	{
		this.handler = handler;
	}

}
