package com.polaris.framework.webapp.view.ext.api.tip;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.ExtChild;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.VarType;

@Ext(name = "Ext.tip.ToolTip", type = VarType.CREATE)
public class EToolTip extends ETip
{
	@ExtField
	protected Integer anchorOffset;
	@ExtField
	protected Boolean anchorToTarget;
	@ExtField
	protected Boolean autoHide;
	@ExtField
	protected String delegate;
	@ExtField
	protected Integer dismissDelay;
	@ExtField
	protected Integer hideDelay;
	@ExtChild
	protected String mouseOffset;
	@ExtField
	protected Integer showDelay;
	@ExtField
	protected String target;
	@ExtField
	protected Boolean trackMouse;

	@TagAttribute
	public void setAnchorOffset(Integer anchorOffset)
	{
		this.anchorOffset = anchorOffset;
	}

	@TagAttribute
	public void setAnchorToTarget(Boolean anchorToTarget)
	{
		this.anchorToTarget = anchorToTarget;
	}

	@TagAttribute
	public void setAutoHide(Boolean autoHide)
	{
		this.autoHide = autoHide;
	}

	@TagAttribute
	public void setDelegate(String delegate)
	{
		this.delegate = delegate;
	}

	@TagAttribute
	public void setDismissDelay(Integer dismissDelay)
	{
		this.dismissDelay = dismissDelay;
	}

	@TagAttribute
	public void setHideDelay(Integer hideDelay)
	{
		this.hideDelay = hideDelay;
	}

	@TagAttribute
	public void setMouseOffset(String mouseOffset)
	{
		this.mouseOffset = mouseOffset;
	}

	@TagAttribute
	public void setShowDelay(Integer showDelay)
	{
		this.showDelay = showDelay;
	}

	@TagAttribute
	public void setTarget(String target)
	{
		this.target = target;
	}

	@TagAttribute
	public void setTrackMouse(Boolean trackMouse)
	{
		this.trackMouse = trackMouse;
	}

}
