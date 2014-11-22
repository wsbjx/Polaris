package com.polaris.framework.webapp.view.ext.jsp.data;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.ext.api.data.ETreeStore;

@TagLib(name = "treestore", component = ETreeStore.class)
public class TreeStoreTag extends AbstractStoreTag
{
	private static final long serialVersionUID = 1L;
	@TagAttribute
	protected Boolean clearOnLoad;
	@TagAttribute
	protected String defaultRootId;
	@TagAttribute
	protected String defaultRootProperty;
	@TagAttribute
	protected Boolean folderSort;
	@TagAttribute
	protected String nodeParam;
	@TagAttribute
	protected Object root;

	public void setClearOnLoad(Boolean clearOnLoad)
	{
		this.clearOnLoad = clearOnLoad;
	}

	public void setDefaultRootId(String defaultRootId)
	{
		this.defaultRootId = defaultRootId;
	}

	public void setDefaultRootProperty(String defaultRootProperty)
	{
		this.defaultRootProperty = defaultRootProperty;
	}

	public void setFolderSort(Boolean folderSort)
	{
		this.folderSort = folderSort;
	}

	public void setNodeParam(String nodeParam)
	{
		this.nodeParam = nodeParam;
	}

	public void setRoot(String root)
	{
		this.root = root;
	}

}
