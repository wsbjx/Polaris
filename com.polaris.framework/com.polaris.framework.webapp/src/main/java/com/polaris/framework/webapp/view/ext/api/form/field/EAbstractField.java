package com.polaris.framework.webapp.view.ext.api.form.field;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.api.EComponent;

/**
 * 抽象的Field对象
 * 
 * @author wang.sheng
 */
abstract class EAbstractField extends EComponent implements EField
{
	@ExtField
	protected Integer labelWidth;
	@ExtField
	protected Boolean allowBlank;
	@ExtField
	protected String blankText;
	@ExtField
	protected String name;
	@ExtField
	protected String fieldLabel;
	@ExtField
	protected String anchor;
	@ExtField
	protected Boolean readOnly;
	@ExtField
	protected String labelSeparator;
	@ExtField
	protected Boolean hideEmptyLabel;

	@TagAttribute
	public void setBlankText(String blankText)
	{
		this.blankText = blankText;
	}

	@TagAttribute
	public void setLabelWidth(Integer labelWidth)
	{
		this.labelWidth = labelWidth;
	}

	@TagAttribute
	public void setAllowBlank(Boolean allowBlank)
	{
		this.allowBlank = allowBlank;
	}

	@TagAttribute
	public void setName(String name)
	{
		this.name = name;
	}

	@TagAttribute
	public void setFieldLabel(String fieldLabel)
	{
		this.fieldLabel = fieldLabel;
	}

	@TagAttribute
	public void setAnchor(String anchor)
	{
		this.anchor = anchor;
	}

	@TagAttribute
	public void setReadOnly(Boolean readOnly)
	{
		this.readOnly = readOnly;
	}

	@TagAttribute
	public void setLabelSeparator(String labelSeparator)
	{
		this.labelSeparator = labelSeparator;
	}

	@TagAttribute
	public void setHideEmptyLabel(Boolean hideEmptyLabel)
	{
		this.hideEmptyLabel = hideEmptyLabel;
	}

}
