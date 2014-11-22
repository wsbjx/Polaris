package com.polaris.framework.webapp.view.extjs.jsp.tab;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.extjs.api.tab.ETab;
import com.polaris.framework.webapp.view.extjs.jsp.container.ContainerTag;

@TagLib(name = "tab", component = ETab.class)
public class TabTag extends ContainerTag
{
	private static final long serialVersionUID = 1L;
	@TagAttribute
	protected String tooltip;
	@TagAttribute
	protected Boolean closable;
	@TagAttribute
	protected String iconCls;
	@TagAttribute
	protected String title;
	@TagAttribute
	protected Integer bodyPadding;
	@TagAttribute
	protected Integer tabIndex;

	public void setTooltip(String tooltip)
	{
		this.tooltip = tooltip;
	}

	public void setClosable(Boolean closable)
	{
		this.closable = closable;
	}

	public void setIconCls(String iconCls)
	{
		this.iconCls = iconCls;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setBodyPadding(Integer bodyPadding)
	{
		this.bodyPadding = bodyPadding;
	}

	public void setTabIndex(Integer tabIndex)
	{
		this.tabIndex = tabIndex;
	}

}
