package com.polaris.framework.webapp.view.ext.jsp.grid.column;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.ext.api.grid.column.ERowNumberer;
import com.polaris.framework.webapp.view.ext.jsp.ExtTagSupport;

@TagLib(name = "rownumberer", component = ERowNumberer.class, bodyContent = "empty")
public class RowNumbererTag extends ExtTagSupport
{
	private static final long serialVersionUID = 1L;
	@TagAttribute
	protected Integer width;
	@TagAttribute
	protected Boolean sortable;

	public void setWidth(Integer width)
	{
		this.width = width;
	}

	public void setSortable(Boolean sortable)
	{
		this.sortable = sortable;
	}

}
