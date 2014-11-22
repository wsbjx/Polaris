package com.polaris.framework.webapp.view.extjs.jsp.util;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.extjs.api.util.EListener;
import com.polaris.framework.webapp.view.extjs.jsp.ExtTagSupport;

@TagLib(name = "listener", component = EListener.class)
public class ListenerTag extends ExtTagSupport
{
	private static final long serialVersionUID = 1L;
	@TagAttribute
	protected String event;
	@TagAttribute
	protected String function;

	public void setEvent(String event)
	{
		this.event = event;
	}

	public void setFunction(String function)
	{
		this.function = function;
	}

}
