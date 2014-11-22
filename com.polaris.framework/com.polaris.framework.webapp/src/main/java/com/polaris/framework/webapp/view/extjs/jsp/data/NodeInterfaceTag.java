package com.polaris.framework.webapp.view.extjs.jsp.data;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.extjs.api.data.ENodeInterface;
import com.polaris.framework.webapp.view.extjs.jsp.ExtTagSupport;

@TagLib(name = "nodeinterface", component = ENodeInterface.class)
public class NodeInterfaceTag extends ExtTagSupport
{
	private static final long serialVersionUID = 1L;
	@TagAttribute
	protected Boolean allowDrag;
	@TagAttribute
	protected Boolean allowDrop;
	@TagAttribute
	protected Boolean checked;
	@TagAttribute
	protected Integer depth;
	@TagAttribute
	protected Boolean expandable;
	@TagAttribute
	protected Boolean expanded;
	@TagAttribute
	protected String href;
	@TagAttribute
	protected String hrefTarget;
	@TagAttribute
	protected String icon;
	@TagAttribute
	protected Integer index;
	@TagAttribute
	protected Boolean isFirst;
	@TagAttribute
	protected Boolean isLast;
	@TagAttribute
	protected Boolean leaf;
	@TagAttribute
	protected Boolean loaded;
	@TagAttribute
	protected Boolean loading;
	@TagAttribute
	protected String parentId;
	@TagAttribute
	protected String qtip;
	@TagAttribute
	protected String qtitle;
	@TagAttribute
	protected Boolean root;
	@TagAttribute
	protected String text;

	public void setAllowDrag(Boolean allowDrag)
	{
		this.allowDrag = allowDrag;
	}

	public void setAllowDrop(Boolean allowDrop)
	{
		this.allowDrop = allowDrop;
	}

	public void setChecked(Boolean checked)
	{
		this.checked = checked;
	}

	public void setDepth(Integer depth)
	{
		this.depth = depth;
	}

	public void setExpandable(Boolean expandable)
	{
		this.expandable = expandable;
	}

	public void setExpanded(Boolean expanded)
	{
		this.expanded = expanded;
	}

	public void setHref(String href)
	{
		this.href = href;
	}

	public void setHrefTarget(String hrefTarget)
	{
		this.hrefTarget = hrefTarget;
	}

	public void setIcon(String icon)
	{
		this.icon = icon;
	}

	public void setIndex(Integer index)
	{
		this.index = index;
	}

	public void setIsFirst(Boolean isFirst)
	{
		this.isFirst = isFirst;
	}

	public void setIsLast(Boolean isLast)
	{
		this.isLast = isLast;
	}

	public void setLeaf(Boolean leaf)
	{
		this.leaf = leaf;
	}

	public void setLoaded(Boolean loaded)
	{
		this.loaded = loaded;
	}

	public void setLoading(Boolean loading)
	{
		this.loading = loading;
	}

	public void setParentId(String parentId)
	{
		this.parentId = parentId;
	}

	public void setQtip(String qtip)
	{
		this.qtip = qtip;
	}

	public void setQtitle(String qtitle)
	{
		this.qtitle = qtitle;
	}

	public void setRoot(Boolean root)
	{
		this.root = root;
	}

	public void setText(String text)
	{
		this.text = text;
	}

}
