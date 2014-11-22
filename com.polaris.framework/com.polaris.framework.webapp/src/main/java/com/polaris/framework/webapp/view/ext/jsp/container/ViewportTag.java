package com.polaris.framework.webapp.view.ext.jsp.container;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.ext.api.container.EViewport;

/**
 * viewport标记
 * 
 * @author wang.sheng
 */
@TagLib(name = "viewport", component = EViewport.class)
public class ViewportTag extends ContainerTag
{
	private static final long serialVersionUID = 1L;
	@TagAttribute
	protected String varName;

	public void setVarName(String varName)
	{
		this.varName = varName;
	}

}
