package com.polaris.framework.webapp.view.ext.jsp.form;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.ext.api.form.EFieldSet;
import com.polaris.framework.webapp.view.ext.jsp.container.ContainerTag;

/**
 * fieldset标签
 * 
 * @author wang.sheng
 */
@TagLib(name = "fieldset", component = EFieldSet.class)
public class FieldSetTag extends ContainerTag
{
	private static final long serialVersionUID = 1L;
	@TagAttribute
	protected String title;

	public void setTitle(String title)
	{
		this.title = title;
	}

}
