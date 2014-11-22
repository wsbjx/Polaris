package com.polaris.framework.webapp.view.ext.api.data;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.ExtChild;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.TagDocked;
import com.polaris.framework.webapp.view.ext.annotation.VarType;

@Ext(name = "Ext.data.TreeStore", type = VarType.CREATE)
public class ETreeStore extends EAbstractStore
{
	@ExtField
	protected Boolean clearOnLoad;
	@ExtField
	protected String defaultRootId;
	@ExtField
	protected String defaultRootProperty;
	@ExtField
	protected Boolean folderSort;
	@ExtField
	protected String nodeParam;
	@ExtChild
	protected Object root;

	@TagAttribute
	public void setClearOnLoad(Boolean clearOnLoad)
	{
		this.clearOnLoad = clearOnLoad;
	}

	@TagAttribute
	public void setDefaultRootId(String defaultRootId)
	{
		this.defaultRootId = defaultRootId;
	}

	@TagAttribute
	public void setDefaultRootProperty(String defaultRootProperty)
	{
		this.defaultRootProperty = defaultRootProperty;
	}

	@TagAttribute
	public void setFolderSort(Boolean folderSort)
	{
		this.folderSort = folderSort;
	}

	@TagAttribute
	public void setNodeParam(String nodeParam)
	{
		this.nodeParam = nodeParam;
	}

	@TagDocked
	public void setRoot(ENodeInterface root)
	{
		this.root = root;
	}

	@TagAttribute
	public void setRoot(String root)
	{
		this.root = root;
	}

}
