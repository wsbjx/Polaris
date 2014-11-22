package com.polaris.framework.webapp.view.ext.jsp.form;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.ext.api.form.EFormPanel;
import com.polaris.framework.webapp.view.ext.jsp.panel.AbstractPanelTag;

/**
 * formpanel标签
 * 
 * @author wang.sheng
 */
@TagLib(name = "formpanel", component = EFormPanel.class)
public class FormPanelTag extends AbstractPanelTag
{
	private static final long serialVersionUID = 1L;
	@TagAttribute
	protected String fieldDefaults;
	@TagAttribute
	protected Boolean pollForChanges;
	@TagAttribute
	protected Integer pollInterval;
	@TagAttribute(description = "表单提交的目标地址")
	protected String url;
	@TagAttribute
	protected String method;
	@TagAttribute(description = "默认为false,采用AJAX方式提交.如果需要以普通方式提交则设置为true")
	protected Boolean standardSubmit;
	@TagAttribute
	protected Integer timeout;
	@TagAttribute
	protected String waitTitle;

	public void setFieldDefaults(String fieldDefaults)
	{
		this.fieldDefaults = fieldDefaults;
	}

	public void setPollForChanges(Boolean pollForChanges)
	{
		this.pollForChanges = pollForChanges;
	}

	public void setPollInterval(Integer pollInterval)
	{
		this.pollInterval = pollInterval;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public void setMethod(String method)
	{
		this.method = method;
	}

	public void setStandardSubmit(Boolean standardSubmit)
	{
		this.standardSubmit = standardSubmit;
	}

	public void setTimeout(Integer timeout)
	{
		this.timeout = timeout;
	}

	public void setWaitTitle(String waitTitle)
	{
		this.waitTitle = waitTitle;
	}

}
