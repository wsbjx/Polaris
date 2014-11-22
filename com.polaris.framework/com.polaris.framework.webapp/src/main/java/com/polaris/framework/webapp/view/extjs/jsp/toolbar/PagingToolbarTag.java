package com.polaris.framework.webapp.view.extjs.jsp.toolbar;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.extjs.api.toolbar.EPagingToolbar;

@TagLib(name = "pagingtoolbar", component = EPagingToolbar.class)
public class PagingToolbarTag extends ToolbarTag
{
	private static final long serialVersionUID = 1L;
	@TagAttribute
	protected String store;
	@TagAttribute
	protected Boolean displayInfo;

	public void setStore(String store)
	{
		this.store = store;
	}

	public void setDisplayInfo(Boolean displayInfo)
	{
		this.displayInfo = displayInfo;
	}

}
