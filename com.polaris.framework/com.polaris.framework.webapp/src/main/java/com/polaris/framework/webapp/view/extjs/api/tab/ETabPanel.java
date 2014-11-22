package com.polaris.framework.webapp.view.extjs.api.tab;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.extjs.annotation.Ext;
import com.polaris.framework.webapp.view.extjs.annotation.ExtField;
import com.polaris.framework.webapp.view.extjs.annotation.TagDocked;
import com.polaris.framework.webapp.view.extjs.annotation.VarType;
import com.polaris.framework.webapp.view.extjs.api.panel.EAbstractPanel;

@Ext(name = "Ext.tab.Panel", type = VarType.CREATE)
public class ETabPanel extends EAbstractPanel
{
	@ExtField
	protected Integer minTabWidth;
	@ExtField
	protected Integer maxTabWidth;
	@ExtField
	protected String activeTab;
	@ExtField
	protected Boolean plain;
	@ExtField
	protected Boolean removePanelHeader;
	@ExtField
	protected String tabPosition;

	@TagAttribute
	public void setMinTabWidth(Integer minTabWidth)
	{
		this.minTabWidth = minTabWidth;
	}

	@TagAttribute
	public void setMaxTabWidth(Integer maxTabWidth)
	{
		this.maxTabWidth = maxTabWidth;
	}

	@TagAttribute
	public void setActiveTab(String activeTab)
	{
		this.activeTab = activeTab;
	}

	@TagAttribute
	public void setPlain(Boolean plain)
	{
		this.plain = plain;
	}

	@TagAttribute
	public void setRemovePanelHeader(Boolean removePanelHeader)
	{
		this.removePanelHeader = removePanelHeader;
	}

	@TagAttribute
	public void setTabPosition(String tabPosition)
	{
		this.tabPosition = tabPosition;
	}

	@TagDocked
	public void addTab(ETab tab)
	{
		super.items.add(tab);
	}

}
