package com.polaris.framework.webapp.view.extjs.jsp.data;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.extjs.api.data.EStore;

@TagLib(name = "datastore", component = EStore.class)
public class StoreTag extends AbstractStoreTag
{
	private static final long serialVersionUID = 1L;
	@TagAttribute
	protected Boolean autoDestroy;
	@TagAttribute
	protected Integer pageSize;
	@TagAttribute
	protected Boolean buffered;
	@TagAttribute
	protected Boolean remoteFilter;
	@TagAttribute
	protected Object data;

	public void setAutoDestroy(Boolean autoDestroy)
	{
		this.autoDestroy = autoDestroy;
	}

	public void setPageSize(Integer pageSize)
	{
		this.pageSize = pageSize;
	}

	public void setBuffered(Boolean buffered)
	{
		this.buffered = buffered;
	}

	public void setRemoteFilter(Boolean remoteFilter)
	{
		this.remoteFilter = remoteFilter;
	}

	public void setData(Object data)
	{
		this.data = data;
	}

}
