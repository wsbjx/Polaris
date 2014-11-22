package com.polaris.framework.webapp.view.ext.jsp.data;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.ext.api.data.EDataProxyAPI;
import com.polaris.framework.webapp.view.ext.jsp.ExtTagSupport;

@TagLib(name = "dataproxyapi", component = EDataProxyAPI.class, bodyContent = "empty")
public class DataProxyAPITag extends ExtTagSupport
{
	private static final long serialVersionUID = 1L;
	@TagAttribute
	protected String read;
	@TagAttribute
	protected String update;
	@TagAttribute
	protected String destroy;
	@TagAttribute
	protected String create;

	public void setRead(String read)
	{
		this.read = read;
	}

	public void setUpdate(String update)
	{
		this.update = update;
	}

	public void setDestroy(String destroy)
	{
		this.destroy = destroy;
	}

	public void setCreate(String create)
	{
		this.create = create;
	}

}
