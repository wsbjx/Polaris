package com.polaris.framework.webapp.view.extjs.jsp.grid.column;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.extjs.api.grid.column.EColumn;
import com.polaris.framework.webapp.view.extjs.jsp.ExtTagSupport;

@TagLib(name = "column", component = EColumn.class)
public class ColumnTag extends ExtTagSupport
{
	private static final long serialVersionUID = 1L;
	@TagAttribute(required = true)
	protected String header;
	@TagAttribute(required = true)
	protected String dataIndex;
	@TagAttribute
	protected Integer flex;
	@TagAttribute
	protected Integer width;
	@TagAttribute
	protected String field;
	@TagAttribute
	protected Boolean sortable;
	@TagAttribute
	protected String align;
	@TagAttribute
	protected String renderer;
	@TagAttribute
	protected Boolean hideable;
	@TagAttribute
	protected Boolean menuDisabled;
	@TagAttribute
	protected String menuText;
	@TagAttribute
	protected Boolean resizable;
	@TagAttribute
	protected Boolean draggable;

	public void setHideable(Boolean hideable)
	{
		this.hideable = hideable;
	}

	public void setSortable(Boolean sortable)
	{
		this.sortable = sortable;
	}

	public void setHeader(String header)
	{
		this.header = header;
	}

	public void setDataIndex(String dataIndex)
	{
		this.dataIndex = dataIndex;
	}

	public void setFlex(Integer flex)
	{
		this.flex = flex;
	}

	public void setWidth(Integer width)
	{
		this.width = width;
	}

	public void setField(String field)
	{
		this.field = field;
	}

	public void setAlign(String align)
	{
		this.align = align;
	}

	public void setRenderer(String renderer)
	{
		this.renderer = renderer;
	}

	public void setMenuDisabled(Boolean menuDisabled)
	{
		this.menuDisabled = menuDisabled;
	}

	public void setMenuText(String menuText)
	{
		this.menuText = menuText;
	}

	public void setResizable(Boolean resizable)
	{
		this.resizable = resizable;
	}

	public void setDraggable(Boolean draggable)
	{
		this.draggable = draggable;
	}

}
