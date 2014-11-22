package com.polaris.framework.webapp.view.ext.api.data;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.VarType;

@Ext(name = "Ext.data.Store", type = VarType.CREATE)
public class EStore extends EAbstractStore
{
	@ExtField
	protected Boolean autoDestroy;
	@ExtField
	protected Boolean remoteFilter;
	@ExtField
	protected Integer pageSize;
	@ExtField
	protected Boolean buffered;
	@ExtField(isJson = true)
	protected Object data;

	@TagAttribute
	public void setRemoteFilter(Boolean remoteFilter)
	{
		this.remoteFilter = remoteFilter;
	}

	@TagAttribute
	public void setBuffered(Boolean buffered)
	{
		this.buffered = buffered;
	}

	@TagAttribute
	public void setAutoDestroy(Boolean autoDestroy)
	{
		this.autoDestroy = autoDestroy;
	}

	@TagAttribute
	public void setPageSize(Integer pageSize)
	{
		this.pageSize = pageSize;
	}

	@TagAttribute
	public void setData(Object data)
	{
		this.data = data;
	}

}
