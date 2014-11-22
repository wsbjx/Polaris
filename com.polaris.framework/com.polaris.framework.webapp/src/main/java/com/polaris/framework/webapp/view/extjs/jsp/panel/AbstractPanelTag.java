package com.polaris.framework.webapp.view.extjs.jsp.panel;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.extjs.jsp.container.ContainerTag;

/**
 * 抽象的面板标签
 * 
 * @author wang.sheng
 */
public abstract class AbstractPanelTag extends ContainerTag
{
	private static final long serialVersionUID = 1L;
	@TagAttribute
	protected String varName;
	@TagAttribute
	protected String region;
	@TagAttribute
	protected Boolean collapsible;
	@TagAttribute
	protected String title;
	@TagAttribute
	protected String anchor;
	@TagAttribute
	protected Boolean closable;
	@TagAttribute
	protected String closeAction;
	@TagAttribute
	protected Integer bodyPadding;
	@TagAttribute
	protected Boolean collapsed;
	@TagAttribute
	protected String buttonAlign;
	@TagAttribute
	protected Boolean frameHeader;
	@TagAttribute
	protected Boolean titleCollapse;
	@TagAttribute
	protected Boolean preventHeader;

	public void setPreventHeader(Boolean preventHeader)
	{
		this.preventHeader = preventHeader;
	}

	public void setVarName(String varName)
	{
		this.varName = varName;
	}

	public void setRegion(String region)
	{
		this.region = region;
	}

	public void setCollapsible(Boolean collapsible)
	{
		this.collapsible = collapsible;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setAnchor(String anchor)
	{
		this.anchor = anchor;
	}

	public void setClosable(Boolean closable)
	{
		this.closable = closable;
	}

	public void setCloseAction(String closeAction)
	{
		this.closeAction = closeAction;
	}

	public void setBodyPadding(Integer bodyPadding)
	{
		this.bodyPadding = bodyPadding;
	}

	public void setCollapsed(Boolean collapsed)
	{
		this.collapsed = collapsed;
	}

	public void setButtonAlign(String buttonAlign)
	{
		this.buttonAlign = buttonAlign;
	}

	public void setFrameHeader(Boolean frameHeader)
	{
		this.frameHeader = frameHeader;
	}

	public void setTitleCollapse(Boolean titleCollapse)
	{
		this.titleCollapse = titleCollapse;
	}

}
