package com.polaris.framework.webapp.view.extjs.jsp.data;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.extjs.api.data.EDataProxy;
import com.polaris.framework.webapp.view.extjs.jsp.ExtTagSupport;

@TagLib(name = "dataproxy", component = EDataProxy.class)
public class DataProxyTag extends ExtTagSupport
{
	private static final long serialVersionUID = 1L;
	@TagAttribute
	protected String type;
	@TagAttribute
	protected String extraParams;
	@TagAttribute
	protected String head;

	public void setHead(String head)
	{
		this.head = head;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public void setExtraParams(String extraParams)
	{
		this.extraParams = extraParams;
	}

}
