package com.polaris.framework.webapp.view.ext.api;

import java.util.HashMap;
import java.util.Map;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.ExtChild;
import com.polaris.framework.webapp.view.ext.annotation.ExtChildren;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.TagDocked;
import com.polaris.framework.webapp.view.ext.annotation.VarType;
import com.polaris.framework.webapp.view.ext.api.util.EListener;

@Ext(name = "Ext.ComponentLoader", type = VarType.CREATE)
public class EComponentLoader
{
	@ExtChild
	protected Object ajaxOptions;
	@ExtField
	protected Boolean autoLoad;
	@ExtChild
	protected Object baseParams;
	@ExtChild
	protected Object callback;
	@ExtChild
	protected Object failure;
	@ExtChildren
	protected Map<String, Object> listeners = new HashMap<String, Object>();
	@ExtField
	protected Boolean loadMask;
	@ExtChild
	protected Object params;
	@ExtChild
	protected Object renderer;
	@ExtChild
	protected Object success;
	@ExtField
	protected String url;

	@TagDocked
	public void addListener(EListener listener)
	{
		listeners.put(listener.getEvent(), listener.getFunction());
	}

	@TagAttribute
	public void setAjaxOptions(String ajaxOptions)
	{
		this.ajaxOptions = ajaxOptions;
	}

	@TagAttribute
	public void setAutoLoad(Boolean autoLoad)
	{
		this.autoLoad = autoLoad;
	}

	@TagAttribute
	public void setBaseParams(String baseParams)
	{
		this.baseParams = baseParams;
	}

	@TagAttribute
	public void setCallback(String callback)
	{
		this.callback = callback;
	}

	public void setFailure(Object failure)
	{
		this.failure = failure;
	}

	@TagAttribute
	public void setLoadMask(Boolean loadMask)
	{
		this.loadMask = loadMask;
	}

	@TagAttribute
	public void setParams(String params)
	{
		this.params = params;
	}

	@TagAttribute
	public void setRenderer(String renderer)
	{
		this.renderer = renderer;
	}

	@TagAttribute
	public void setSuccess(String success)
	{
		this.success = success;
	}

	@TagAttribute
	public void setUrl(String url)
	{
		this.url = url;
	}

}
