package com.polaris.framework.webapp.view.ext.jsp.grid;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.ext.api.grid.EGridPanel;
import com.polaris.framework.webapp.view.ext.jsp.panel.AbstractPanelTag;

@TagLib(name = "gridpanel", component = EGridPanel.class)
public class GridPanelTag extends AbstractPanelTag
{
	private static final long serialVersionUID = 1L;
	@TagAttribute(required = true)
	protected String store;
	@TagAttribute
	protected Boolean loadMask;
	@TagAttribute
	protected String selModel;
	@TagAttribute
	protected String selType;
	@TagAttribute
	protected Boolean invalidateScrollerOnRefresh;
	@TagAttribute
	protected Boolean disableSelection;
	@TagAttribute
	protected String verticalScrollerType;
	@TagAttribute
	protected String viewConfig;

	public void setViewConfig(String viewConfig)
	{
		this.viewConfig = viewConfig;
	}

	public void setInvalidateScrollerOnRefresh(Boolean invalidateScrollerOnRefresh)
	{
		this.invalidateScrollerOnRefresh = invalidateScrollerOnRefresh;
	}

	public void setDisableSelection(Boolean disableSelection)
	{
		this.disableSelection = disableSelection;
	}

	public void setVerticalScrollerType(String verticalScrollerType)
	{
		this.verticalScrollerType = verticalScrollerType;
	}

	public void setStore(String store)
	{
		this.store = store;
	}

	public void setLoadMask(Boolean loadMask)
	{
		this.loadMask = loadMask;
	}

	public void setSelModel(String selModel)
	{
		this.selModel = selModel;
	}

	public void setSelType(String selType)
	{
		this.selType = selType;
	}

}
