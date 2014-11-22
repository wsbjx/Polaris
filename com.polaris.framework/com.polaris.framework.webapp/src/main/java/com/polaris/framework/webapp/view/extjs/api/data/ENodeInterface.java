package com.polaris.framework.webapp.view.extjs.api.data;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.extjs.annotation.Ext;
import com.polaris.framework.webapp.view.extjs.annotation.ExtChildren;
import com.polaris.framework.webapp.view.extjs.annotation.ExtField;
import com.polaris.framework.webapp.view.extjs.annotation.TagDocked;
import com.polaris.framework.webapp.view.extjs.annotation.VarType;

/**
 * 在使用SpringMVC通过@ResponseBody生成JSON过程中<br>
 * 引入@JsonSerialize(include = Inclusion.NON_NULL)用于确保生成的JSON字符串不含null字段<br>
 * 
 * @author wang.sheng
 */
@Ext(type = VarType.CONFIG)
@JsonSerialize(include = Inclusion.NON_NULL)
public class ENodeInterface
{
	@ExtField
	protected Boolean allowDrag;
	@ExtField
	protected Boolean allowDrop;
	@ExtField
	protected Boolean checked;
	@ExtChildren
	protected List<ENodeInterface> children;
	@ExtField
	protected Integer depth;
	@ExtField
	protected Boolean expandable;
	@ExtField
	protected Boolean expanded;
	@ExtField
	protected String href;
	@ExtField
	protected String hrefTarget;
	@ExtField
	protected String icon;
	@ExtField
	protected Integer index;
	@ExtField
	protected Boolean isFirst;
	@ExtField
	protected Boolean isLast;
	@ExtField
	protected Boolean leaf;
	@ExtField
	protected Boolean loaded;
	@ExtField
	protected Boolean loading;
	@ExtField
	protected String parentId;
	@ExtField
	protected String qtip;
	@ExtField
	protected String qtitle;
	@ExtField
	protected Boolean root;
	@ExtField
	protected String text;
	@ExtField
	protected String id;

	public Boolean getAllowDrag()
	{
		return allowDrag;
	}

	public Boolean getAllowDrop()
	{
		return allowDrop;
	}

	public Boolean getChecked()
	{
		return checked;
	}

	public List<ENodeInterface> getChildren()
	{
		return children;
	}

	public Integer getDepth()
	{
		return depth;
	}

	public Boolean getExpandable()
	{
		return expandable;
	}

	public Boolean getExpanded()
	{
		return expanded;
	}

	public String getHref()
	{
		return href;
	}

	public String getHrefTarget()
	{
		return hrefTarget;
	}

	public String getIcon()
	{
		return icon;
	}

	public Integer getIndex()
	{
		return index;
	}

	public Boolean getIsFirst()
	{
		return isFirst;
	}

	public Boolean getIsLast()
	{
		return isLast;
	}

	public Boolean getLeaf()
	{
		return leaf;
	}

	public Boolean getLoaded()
	{
		return loaded;
	}

	public Boolean getLoading()
	{
		return loading;
	}

	public String getParentId()
	{
		return parentId;
	}

	public String getQtip()
	{
		return qtip;
	}

	public String getQtitle()
	{
		return qtitle;
	}

	public Boolean getRoot()
	{
		return root;
	}

	public String getText()
	{
		return text;
	}

	public String getId()
	{
		return id;
	}

	@TagDocked
	public void addChild(ENodeInterface child)
	{
		if (this.children == null)
		{
			this.children = new ArrayList<ENodeInterface>();
		}
		this.children.add(child);
	}

	@TagAttribute
	public void setAllowDrag(Boolean allowDrag)
	{
		this.allowDrag = allowDrag;
	}

	@TagAttribute
	public void setAllowDrop(Boolean allowDrop)
	{
		this.allowDrop = allowDrop;
	}

	@TagAttribute
	public void setChecked(Boolean checked)
	{
		this.checked = checked;
	}

	@TagAttribute
	public void setDepth(Integer depth)
	{
		this.depth = depth;
	}

	@TagAttribute
	public void setExpandable(Boolean expandable)
	{
		this.expandable = expandable;
	}

	@TagAttribute
	public void setExpanded(Boolean expanded)
	{
		this.expanded = expanded;
	}

	@TagAttribute
	public void setHref(String href)
	{
		this.href = href;
	}

	@TagAttribute
	public void setHrefTarget(String hrefTarget)
	{
		this.hrefTarget = hrefTarget;
	}

	@TagAttribute
	public void setIcon(String icon)
	{
		this.icon = icon;
	}

	@TagAttribute
	public void setIndex(Integer index)
	{
		this.index = index;
	}

	@TagAttribute
	public void setIsFirst(Boolean isFirst)
	{
		this.isFirst = isFirst;
	}

	@TagAttribute
	public void setIsLast(Boolean isLast)
	{
		this.isLast = isLast;
	}

	@TagAttribute
	public void setLeaf(Boolean leaf)
	{
		this.leaf = leaf;
	}

	@TagAttribute
	public void setLoaded(Boolean loaded)
	{
		this.loaded = loaded;
	}

	@TagAttribute
	public void setLoading(Boolean loading)
	{
		this.loading = loading;
	}

	@TagAttribute
	public void setParentId(String parentId)
	{
		this.parentId = parentId;
	}

	@TagAttribute
	public void setQtip(String qtip)
	{
		this.qtip = qtip;
	}

	@TagAttribute
	public void setQtitle(String qtitle)
	{
		this.qtitle = qtitle;
	}

	@TagAttribute
	public void setRoot(Boolean root)
	{
		this.root = root;
	}

	@TagAttribute
	public void setText(String text)
	{
		this.text = text;
	}

	@TagAttribute
	public void setId(String id)
	{
		this.id = id;
	}

}
