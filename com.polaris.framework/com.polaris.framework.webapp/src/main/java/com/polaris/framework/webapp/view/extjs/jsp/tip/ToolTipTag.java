package com.polaris.framework.webapp.view.extjs.jsp.tip;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.extjs.annotation.ExtChild;
import com.polaris.framework.webapp.view.extjs.api.tip.EToolTip;

@TagLib(name = "tooltip", component = EToolTip.class)
public class ToolTipTag extends TipTag
{
	private static final long serialVersionUID = 1L;
	@TagAttribute
	protected Integer anchorOffset;
	@TagAttribute
	protected Boolean anchorToTarget;
	@TagAttribute
	protected Boolean autoHide;
	@TagAttribute
	protected String delegate;
	@TagAttribute
	protected Integer dismissDelay;
	@TagAttribute
	protected Integer hideDelay;
	@ExtChild
	protected String mouseOffset;
	@TagAttribute
	protected Integer showDelay;
	@TagAttribute
	protected String target;
	@TagAttribute
	protected Boolean trackMouse;

	public void setAnchorOffset(Integer anchorOffset)
	{
		this.anchorOffset = anchorOffset;
	}

	public void setAnchorToTarget(Boolean anchorToTarget)
	{
		this.anchorToTarget = anchorToTarget;
	}

	public void setAutoHide(Boolean autoHide)
	{
		this.autoHide = autoHide;
	}

	public void setDelegate(String delegate)
	{
		this.delegate = delegate;
	}

	public void setDismissDelay(Integer dismissDelay)
	{
		this.dismissDelay = dismissDelay;
	}

	public void setHideDelay(Integer hideDelay)
	{
		this.hideDelay = hideDelay;
	}

	public void setMouseOffset(String mouseOffset)
	{
		this.mouseOffset = mouseOffset;
	}

	public void setShowDelay(Integer showDelay)
	{
		this.showDelay = showDelay;
	}

	public void setTarget(String target)
	{
		this.target = target;
	}

	public void setTrackMouse(Boolean trackMouse)
	{
		this.trackMouse = trackMouse;
	}

}
