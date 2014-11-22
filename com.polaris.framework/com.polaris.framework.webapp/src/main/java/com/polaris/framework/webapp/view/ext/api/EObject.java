package com.polaris.framework.webapp.view.ext.api;

import java.util.HashMap;
import java.util.Map;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.ExtChildren;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.TagDocked;
import com.polaris.framework.webapp.view.ext.api.util.EListener;

/**
 * 最为底层的Ext对象
 * 
 * @author wang.sheng
 */
public abstract class EObject
{
	@ExtChildren
	protected Map<String, Object> listeners = new HashMap<String, Object>();
	@ExtField
	protected String id;
	@ExtField
	protected String itemId;
	@ExtField
	protected String contentEl;

	@TagDocked
	public void addListener(EListener listener)
	{
		listeners.put(listener.getEvent(), listener.getFunction());
	}

	@TagAttribute
	public void setId(String id)
	{
		this.id = id;
	}

	@TagAttribute
	public void setItemId(String itemId)
	{
		this.itemId = itemId;
	}

	@TagAttribute
	public void setContentEl(String contentEl)
	{
		this.contentEl = contentEl;
	}

}
