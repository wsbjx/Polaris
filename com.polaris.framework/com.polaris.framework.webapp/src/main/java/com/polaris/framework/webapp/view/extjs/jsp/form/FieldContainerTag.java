package com.polaris.framework.webapp.view.extjs.jsp.form;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.extjs.api.form.EFieldContainer;
import com.polaris.framework.webapp.view.extjs.jsp.container.ContainerTag;

/**
 * fieldcontainer标签
 * 
 * @author wang.sheng
 */
@TagLib(name = "fieldcontainer", component = EFieldContainer.class)
public class FieldContainerTag extends ContainerTag
{
	private static final long serialVersionUID = 1L;
	@TagAttribute
	protected String fieldLabel;
	@TagAttribute
	protected Boolean combineErrors;
	@TagAttribute
	protected String defaults;
	@TagAttribute
	protected String labelConnector;
	@TagAttribute
	protected Boolean combineLabels;
	@TagAttribute
	protected String fieldDefaults;

	public void setFieldLabel(String fieldLabel)
	{
		this.fieldLabel = fieldLabel;
	}

	public void setCombineErrors(Boolean combineErrors)
	{
		this.combineErrors = combineErrors;
	}

	public void setDefaults(String defaults)
	{
		this.defaults = defaults;
	}

	public void setLabelConnector(String labelConnector)
	{
		this.labelConnector = labelConnector;
	}

	public void setCombineLabels(Boolean combineLabels)
	{
		this.combineLabels = combineLabels;
	}

	public void setFieldDefaults(String fieldDefaults)
	{
		this.fieldDefaults = fieldDefaults;
	}

}
