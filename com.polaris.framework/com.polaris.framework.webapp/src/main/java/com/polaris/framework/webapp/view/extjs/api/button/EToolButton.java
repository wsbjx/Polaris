package com.polaris.framework.webapp.view.extjs.api.button;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.extjs.annotation.Ext;
import com.polaris.framework.webapp.view.extjs.annotation.ExtChild;
import com.polaris.framework.webapp.view.extjs.annotation.ExtField;
import com.polaris.framework.webapp.view.extjs.annotation.TagContent;
import com.polaris.framework.webapp.view.extjs.annotation.VarType;
import com.polaris.framework.webapp.view.extjs.api.EComponent;

/**
 * 用于表单的工具栏中
 * 
 * @author wang.sheng
 */
@Ext(name = "button", type = VarType.CONFIG)
public class EToolButton extends EComponent
{
	@ExtField
	protected String text;
	@ExtField
	protected String tooltip;
	@ExtChild
	protected String handler;
	@ExtField
	protected String iconCls;

	@TagAttribute
	public void setIconCls(String iconCls)
	{
		this.iconCls = iconCls;
	}

	@TagAttribute
	public void setText(String text)
	{
		this.text = text;
	}

	@TagAttribute
	public void setTooltip(String tooltip)
	{
		this.tooltip = tooltip;
	}

	@TagAttribute
	@TagContent
	public void setHandler(String handler)
	{
		this.handler = handler;
	}
}