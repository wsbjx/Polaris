package com.polaris.framework.webapp.view.ext.api.tab;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.TagContent;
import com.polaris.framework.webapp.view.ext.annotation.TagDocked;
import com.polaris.framework.webapp.view.ext.annotation.VarType;
import com.polaris.framework.webapp.view.ext.api.container.EContainer;
import com.polaris.framework.webapp.view.ext.api.panel.EAbstractPanel;

@Ext(type = VarType.CONFIG)
public class ETab extends EContainer
{
	@ExtField
	protected String tooltip;
	@ExtField
	protected Boolean closable;
	@ExtField
	protected String iconCls;
	@ExtField
	protected String title;
	@ExtField
	protected Integer bodyPadding;
	@ExtField
	protected Integer tabIndex;

	@TagAttribute
	public void setTooltip(String tooltip)
	{
		this.tooltip = tooltip;
	}

	@TagAttribute
	public void setClosable(Boolean closable)
	{
		this.closable = closable;
	}

	@TagAttribute
	public void setIconCls(String iconCls)
	{
		this.iconCls = iconCls;
	}

	@TagAttribute
	public void setTitle(String title)
	{
		this.title = title;
	}

	@TagAttribute
	public void setBodyPadding(Integer bodyPadding)
	{
		this.bodyPadding = bodyPadding;
	}

	@TagContent
	public void setHtml(String html)
	{
		super.setHtml(html);
	}

	@TagAttribute
	public void setTabIndex(Integer tabIndex)
	{
		this.tabIndex = tabIndex;
	}

	@TagDocked
	public void addPanel(EAbstractPanel panel)
	{
		super.items.add(panel);
	}

}
