package com.polaris.framework.webapp.view.ext.api;

import java.util.ArrayList;
import java.util.List;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.ExtChild;
import com.polaris.framework.webapp.view.ext.annotation.ExtChildren;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.TagDocked;

/**
 * UI中的组件
 * 
 * @author Administrator
 */
public abstract class EComponent extends EObject
{
	@ExtField
	protected Boolean autoScroll;
	@ExtField
	protected String margin;
	@ExtField
	protected Boolean disabled;
	@ExtField
	protected Boolean hidden;
	@ExtField
	protected String padding;
	@ExtField
	protected Integer width;
	@ExtField
	protected Integer height;
	@ExtChild
	protected String renderTo;
	@ExtField(isJson = true)
	protected Object data;
	@ExtField
	protected Object value;
	@ExtField
	protected Integer flex;
	@ExtChild
	protected String html;
	@ExtField
	protected Integer minHeight;
	@ExtField
	protected Integer minWidth;
	@ExtField
	protected Integer maxHeight;
	@ExtField
	protected Integer maxWidth;
	@ExtField
	protected Boolean frame;
	@ExtField
	protected String dock;
	@ExtChildren
	protected List<Object> plugins = new ArrayList<Object>();
	@ExtChild
	protected Object loader;

	@TagDocked
	public void setLoader(EComponentLoader loader)
	{
		this.loader = loader;
	}

	@TagDocked
	public void addPlugin(EUxObject ux)
	{
		this.plugins.add(ux);
	}

	@TagAttribute
	public void setAutoScroll(Boolean autoScroll)
	{
		this.autoScroll = autoScroll;
	}

	@TagAttribute
	public void setDock(String dock)
	{
		this.dock = dock;
	}

	@TagAttribute
	public void setFrame(Boolean frame)
	{
		this.frame = frame;
	}

	@TagAttribute
	public void setMinHeight(Integer minHeight)
	{
		this.minHeight = minHeight;
	}

	@TagAttribute
	public void setMinWidth(Integer minWidth)
	{
		this.minWidth = minWidth;
	}

	@TagAttribute
	public void setMaxHeight(Integer maxHeight)
	{
		this.maxHeight = maxHeight;
	}

	@TagAttribute
	public void setMaxWidth(Integer maxWidth)
	{
		this.maxWidth = maxWidth;
	}

	@TagAttribute
	public void setValue(Object value)
	{
		// TODO Auto-generated method stub
		this.value = value;
	}

	@TagAttribute
	public void setData(Object data)
	{
		this.data = data;
	}

	@TagAttribute
	public void setMargin(String margin)
	{
		this.margin = margin;
	}

	@TagAttribute
	public void setDisabled(Boolean disabled)
	{
		this.disabled = disabled;
	}

	@TagAttribute
	public void setHidden(Boolean hidden)
	{
		this.hidden = hidden;
	}

	@TagAttribute
	public void setPadding(String padding)
	{
		this.padding = padding;
	}

	@TagAttribute
	public void setWidth(Integer width)
	{
		this.width = width;
	}

	@TagAttribute
	public void setHeight(Integer height)
	{
		this.height = height;
	}

	@TagAttribute
	public void setRenderTo(String renderTo)
	{
		this.renderTo = renderTo;
	}

	@TagAttribute
	public void setFlex(Integer flex)
	{
		this.flex = flex;
	}

	@TagAttribute
	public void setHtml(String html)
	{
		this.html = html;
	}

}
