package com.polaris.framework.webapp.view.ext.api.form.field;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.VarType;

@Ext(name = "checkboxfield", type = VarType.CONFIG)
public class ECheckboxField extends EAbstractField
{
	@ExtField
	protected String boxLabel;
	@ExtField
	protected Boolean checked;
	@ExtField
	protected String inputValue;
	@ExtField
	protected String uncheckedValue;

	@TagAttribute
	public void setBoxLabel(String boxLabel)
	{
		this.boxLabel = boxLabel;
	}

	@TagAttribute
	public void setChecked(Boolean checked)
	{
		this.checked = checked;
	}

	@TagAttribute
	public void setInputValue(String inputValue)
	{
		this.inputValue = inputValue;
	}

	@TagAttribute
	public void setUncheckedValue(String uncheckedValue)
	{
		this.uncheckedValue = uncheckedValue;
	}

}
