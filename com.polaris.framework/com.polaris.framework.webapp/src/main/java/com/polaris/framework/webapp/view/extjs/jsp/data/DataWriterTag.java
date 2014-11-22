package com.polaris.framework.webapp.view.extjs.jsp.data;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.extjs.api.data.EDataWriter;
import com.polaris.framework.webapp.view.extjs.jsp.ExtTagSupport;

@TagLib(name = "datawriter", component = EDataWriter.class, bodyContent = "empty")
public class DataWriterTag extends ExtTagSupport
{
	private static final long serialVersionUID = 1L;
	@TagAttribute
	protected String type;
	@TagAttribute
	protected Boolean writeAllFields;
	@TagAttribute
	protected Boolean allowSingle;

	public void setType(String type)
	{
		this.type = type;
	}

	public void setWriteAllFields(Boolean writeAllFields)
	{
		this.writeAllFields = writeAllFields;
	}

	public void setAllowSingle(Boolean allowSingle)
	{
		this.allowSingle = allowSingle;
	}

}
