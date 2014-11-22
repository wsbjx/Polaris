package com.polaris.framework.webapp.view.extjs.jsp.window;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.extjs.api.window.EWindow;
import com.polaris.framework.webapp.view.extjs.jsp.panel.AbstractPanelTag;

@TagLib(name = "window", component = EWindow.class)
public class WindowTag extends AbstractPanelTag
{
	private static final long serialVersionUID = 1L;
	@TagAttribute
	protected String animateTarget;
	@TagAttribute
	protected Boolean constrain;
	@TagAttribute
	protected Boolean constrainHeader;
	@TagAttribute
	protected String defaultFocus;
	@TagAttribute
	protected Boolean draggable;
	@TagAttribute
	protected Boolean expandOnShow;
	@TagAttribute
	protected Boolean maximizable;
	@TagAttribute
	protected Boolean maximized;
	@TagAttribute
	protected Boolean minimizable;
	@TagAttribute
	protected Boolean modal;
	@TagAttribute
	protected String onEsc;
	@TagAttribute
	protected Boolean plain;
	@TagAttribute
	protected Boolean resizable;
	@TagAttribute
	protected Integer x;
	@TagAttribute
	protected Integer y;

	public void setConstrainHeader(Boolean constrainHeader)
	{
		this.constrainHeader = constrainHeader;
	}

	public void setAnimateTarget(String animateTarget)
	{
		this.animateTarget = animateTarget;
	}

	public void setConstrain(Boolean constrain)
	{
		this.constrain = constrain;
	}

	public void setDefaultFocus(String defaultFocus)
	{
		this.defaultFocus = defaultFocus;
	}

	public void setDraggable(Boolean draggable)
	{
		this.draggable = draggable;
	}

	public void setExpandOnShow(Boolean expandOnShow)
	{
		this.expandOnShow = expandOnShow;
	}

	public void setMaximizable(Boolean maximizable)
	{
		this.maximizable = maximizable;
	}

	public void setMaximized(Boolean maximized)
	{
		this.maximized = maximized;
	}

	public void setMinimizable(Boolean minimizable)
	{
		this.minimizable = minimizable;
	}

	public void setModal(Boolean modal)
	{
		this.modal = modal;
	}

	public void setOnEsc(String onEsc)
	{
		this.onEsc = onEsc;
	}

	public void setPlain(Boolean plain)
	{
		this.plain = plain;
	}

	public void setResizable(Boolean resizable)
	{
		this.resizable = resizable;
	}

	public void setX(Integer x)
	{
		this.x = x;
	}

	public void setY(Integer y)
	{
		this.y = y;
	}

}
