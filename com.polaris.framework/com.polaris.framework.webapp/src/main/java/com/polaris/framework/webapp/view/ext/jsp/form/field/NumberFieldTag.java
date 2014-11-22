package com.polaris.framework.webapp.view.ext.jsp.form.field;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.ext.api.form.field.ENumberField;

@TagLib(name = "numberfield", component = ENumberField.class)
public class NumberFieldTag extends AbstractFieldTag
{
	private static final long serialVersionUID = 1L;
	@TagAttribute
	protected Double minValue;
	@TagAttribute
	protected Double maxValue;
	@TagAttribute
	protected Integer decimalPrecision;
	@TagAttribute
	protected Integer step;

	public void setStep(Integer step)
	{
		this.step = step;
	}

	public void setMinValue(Double minValue)
	{
		this.minValue = minValue;
	}

	public void setMaxValue(Double maxValue)
	{
		this.maxValue = maxValue;
	}

	public void setDecimalPrecision(Integer decimalPrecision)
	{
		this.decimalPrecision = decimalPrecision;
	}

}
