package com.polaris.framework.webapp.view.extjs.api.tree;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.extjs.annotation.Ext;
import com.polaris.framework.webapp.view.extjs.annotation.ExtChild;
import com.polaris.framework.webapp.view.extjs.annotation.ExtField;
import com.polaris.framework.webapp.view.extjs.annotation.TagDocked;
import com.polaris.framework.webapp.view.extjs.annotation.VarType;
import com.polaris.framework.webapp.view.extjs.api.data.ENodeInterface;
import com.polaris.framework.webapp.view.extjs.api.data.ETreeStore;
import com.polaris.framework.webapp.view.extjs.api.panel.EAbstractPanel;

@Ext(name = "Ext.tree.Panel", type = VarType.CREATE)
public class ETreePanel extends EAbstractPanel
{
	@ExtField
	protected Boolean animate;
	@ExtField
	protected String displayField;
	@ExtField
	protected Boolean folderSort;
	@ExtField
	protected Boolean hideHeaders;
	@ExtField
	protected Boolean lines;
	@ExtChild
	protected Object root;
	@ExtField
	protected Boolean rootVisible;
	@ExtField
	protected Boolean singleExpand;
	@ExtField
	protected Boolean useArrows;
	@ExtChild
	protected Object store;

	@TagAttribute
	public void setAnimate(Boolean animate)
	{
		this.animate = animate;
	}

	@TagAttribute
	public void setDisplayField(String displayField)
	{
		this.displayField = displayField;
	}

	@TagAttribute
	public void setFolderSort(Boolean folderSort)
	{
		this.folderSort = folderSort;
	}

	@TagAttribute
	public void setHideHeaders(Boolean hideHeaders)
	{
		this.hideHeaders = hideHeaders;
	}

	@TagAttribute
	public void setLines(Boolean lines)
	{
		this.lines = lines;
	}

	@TagAttribute
	public void setRoot(String root)
	{
		this.root = root;
	}

	@TagDocked
	public void setRoot(ENodeInterface root)
	{
		this.root = root;
	}

	@TagAttribute
	public void setStore(String store)
	{
		this.store = store;
	}

	@TagDocked
	public void setStore(ETreeStore store)
	{
		this.store = store;
	}

	@TagAttribute
	public void setRootVisible(Boolean rootVisible)
	{
		this.rootVisible = rootVisible;
	}

	@TagAttribute
	public void setSingleExpand(Boolean singleExpand)
	{
		this.singleExpand = singleExpand;
	}

	@TagAttribute
	public void setUseArrows(Boolean useArrows)
	{
		this.useArrows = useArrows;
	}

}
