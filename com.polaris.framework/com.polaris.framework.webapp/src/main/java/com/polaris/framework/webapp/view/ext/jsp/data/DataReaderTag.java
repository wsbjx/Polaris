package com.polaris.framework.webapp.view.ext.jsp.data;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.ext.api.data.EDataReader;
import com.polaris.framework.webapp.view.ext.jsp.ExtTagSupport;

@TagLib(name = "datareader", component = EDataReader.class, bodyContent = "empty")
public class DataReaderTag extends ExtTagSupport
{
	private static final long serialVersionUID = 1L;
	@TagAttribute
	protected String root;
	@TagAttribute
	protected String totalProperty;
	@TagAttribute
	protected String successProperty;
	@TagAttribute
	protected String messageProperty;

	public void setRoot(String root)
	{
		this.root = root;
	}

	public void setTotalProperty(String totalProperty)
	{
		this.totalProperty = totalProperty;
	}

	public void setSuccessProperty(String successProperty)
	{
		this.successProperty = successProperty;
	}

	public void setMessageProperty(String messageProperty)
	{
		this.messageProperty = messageProperty;
	}

}
