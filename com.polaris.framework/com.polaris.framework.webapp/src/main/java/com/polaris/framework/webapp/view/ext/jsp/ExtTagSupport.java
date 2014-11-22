package com.polaris.framework.webapp.view.ext.jsp;

import com.polaris.framework.webapp.view.annotation.TagAttribute;

/**
 * 抽象的标签支持类
 * 
 * @author wang.sheng
 */
public abstract class ExtTagSupport extends BaseTagSupport
{
	private static final long serialVersionUID = 1L;
	@TagAttribute
	protected String id;
	@TagAttribute
	protected String itemId;
	@TagAttribute
	protected String contentEl;

	public void setId(String id)
	{
		this.id = id;
	}

	public void setItemId(String itemId)
	{
		this.itemId = itemId;
	}

	public void setContentEl(String contentEl)
	{
		this.contentEl = contentEl;
	}
}
