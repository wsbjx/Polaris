package com.polaris.framework.webapp.view.extjs.api.form.field;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.extjs.annotation.Ext;
import com.polaris.framework.webapp.view.extjs.annotation.ExtField;
import com.polaris.framework.webapp.view.extjs.annotation.VarType;

@Ext(name = "numberfield", type = VarType.CONFIG)
public class ENumberField extends EAbstractField
{
	@ExtField
	protected Number minValue;
	@ExtField
	protected Number maxValue;
	@ExtField
	protected Integer decimalPrecision;
	@ExtField
	protected Integer step;

	@TagAttribute
	public void setMinValue(Number minValue)
	{
		this.minValue = minValue;
	}

	@TagAttribute
	public void setMaxValue(Number maxValue)
	{
		this.maxValue = maxValue;
	}

	@TagAttribute
	public void setStep(Integer step)
	{
		this.step = step;
	}

	@TagAttribute
	public void setDecimalPrecision(Integer decimalPrecision)
	{
		this.decimalPrecision = decimalPrecision;
	}

}
