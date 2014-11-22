package com.polaris.framework.webapp.view.extjs.api.form;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.extjs.annotation.Ext;
import com.polaris.framework.webapp.view.extjs.annotation.ExtChild;
import com.polaris.framework.webapp.view.extjs.annotation.ExtField;
import com.polaris.framework.webapp.view.extjs.annotation.VarType;
import com.polaris.framework.webapp.view.extjs.api.panel.EAbstractPanel;

@Ext(name = "Ext.form.Panel", type = VarType.CREATE)
public class EFormPanel extends EAbstractPanel
{
	@ExtChild
	protected String fieldDefaults;
	@ExtField
	protected Boolean pollForChanges;
	@ExtField
	protected Integer pollInterval;
	@ExtField
	protected String url;
	@ExtField
	protected String method;
	@ExtField
	protected Boolean standardSubmit;
	@ExtField
	protected Integer timeout;
	@ExtField
	protected String waitTitle;

	@TagAttribute
	public void setFieldDefaults(String fieldDefaults)
	{
		this.fieldDefaults = fieldDefaults;
	}

	@TagAttribute
	public void setPollForChanges(Boolean pollForChanges)
	{
		this.pollForChanges = pollForChanges;
	}

	@TagAttribute
	public void setPollInterval(Integer pollInterval)
	{
		this.pollInterval = pollInterval;
	}

	@TagAttribute(isURL = true)
	public void setUrl(String url)
	{
		this.url = url;
	}

	@TagAttribute
	public void setMethod(String method)
	{
		this.method = method;
	}

	@TagAttribute
	public void setStandardSubmit(Boolean standardSubmit)
	{
		this.standardSubmit = standardSubmit;
	}

	@TagAttribute
	public void setTimeout(Integer timeout)
	{
		this.timeout = timeout;
	}

	@TagAttribute
	public void setWaitTitle(String waitTitle)
	{
		this.waitTitle = waitTitle;
	}

}
