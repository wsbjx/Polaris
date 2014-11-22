package com.polaris.framework.webapp.view.extjs.jsp;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.extjs.api.EUxObject;

@TagLib(name = "object", component = EUxObject.class)
public class ObjectTag extends BaseTagSupport
{
	private static final long serialVersionUID = 1L;
	@TagAttribute(required = true)
	protected String name;

	public void setName(String name)
	{
		this.name = name;
	}

}
