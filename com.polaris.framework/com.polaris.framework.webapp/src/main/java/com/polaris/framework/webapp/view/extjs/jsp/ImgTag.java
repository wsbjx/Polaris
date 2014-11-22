package com.polaris.framework.webapp.view.extjs.jsp;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.extjs.api.EImg;

@TagLib(name = "img", component = EImg.class)
public class ImgTag extends ComponentTag
{
	private static final long serialVersionUID = 1L;
	@TagAttribute
	protected String src;
	@TagAttribute
	protected String alt;

	public void setSrc(String src)
	{
		this.src = src;
	}

	public void setAlt(String alt)
	{
		this.alt = alt;
	}

}
