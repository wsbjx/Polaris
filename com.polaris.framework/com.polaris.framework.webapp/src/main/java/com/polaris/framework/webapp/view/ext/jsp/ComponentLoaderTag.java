package com.polaris.framework.webapp.view.ext.jsp;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.ext.api.EComponentLoader;

@TagLib(name = "componentloader", component = EComponentLoader.class)
public class ComponentLoaderTag extends BaseTagSupport
{
	private static final long serialVersionUID = 1L;
	@TagAttribute
	protected String ajaxOptions;
	@TagAttribute
	protected Boolean autoLoad;
	@TagAttribute
	protected String baseParams;
	@TagAttribute
	protected String callback;
	@TagAttribute
	protected String failure;
	@TagAttribute
	protected Boolean loadMask;
	@TagAttribute
	protected String params;
	@TagAttribute
	protected String renderer;
	@TagAttribute
	protected String success;
	@TagAttribute(isURL = true)
	protected String url;

	public void setAjaxOptions(String ajaxOptions)
	{
		this.ajaxOptions = ajaxOptions;
	}

	public void setAutoLoad(Boolean autoLoad)
	{
		this.autoLoad = autoLoad;
	}

	public void setBaseParams(String baseParams)
	{
		this.baseParams = baseParams;
	}

	public void setCallback(String callback)
	{
		this.callback = callback;
	}

	public void setFailure(String failure)
	{
		this.failure = failure;
	}

	public void setLoadMask(Boolean loadMask)
	{
		this.loadMask = loadMask;
	}

	public void setParams(String params)
	{
		this.params = params;
	}

	public void setRenderer(String renderer)
	{
		this.renderer = renderer;
	}

	public void setSuccess(String success)
	{
		this.success = success;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

}
