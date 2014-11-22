package com.polaris.framework.webapp.view.extjs.api.grid;

import java.util.ArrayList;
import java.util.List;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.extjs.annotation.Ext;
import com.polaris.framework.webapp.view.extjs.annotation.ExtChild;
import com.polaris.framework.webapp.view.extjs.annotation.ExtChildren;
import com.polaris.framework.webapp.view.extjs.annotation.ExtField;
import com.polaris.framework.webapp.view.extjs.annotation.TagDocked;
import com.polaris.framework.webapp.view.extjs.annotation.VarType;
import com.polaris.framework.webapp.view.extjs.api.EReference;
import com.polaris.framework.webapp.view.extjs.api.data.EAbstractStore;
import com.polaris.framework.webapp.view.extjs.api.grid.column.EColumn;
import com.polaris.framework.webapp.view.extjs.api.grid.column.ERowNumberer;
import com.polaris.framework.webapp.view.extjs.api.grid.plugin.ECellEditing;
import com.polaris.framework.webapp.view.extjs.api.panel.EAbstractPanel;
import com.polaris.framework.webapp.view.extjs.api.selection.ECheckboxModel;
import com.polaris.framework.webapp.view.extjs.api.toolbar.EPagingToolbar;
import com.polaris.framework.webapp.view.extjs.api.toolbar.EToolbar;

@Ext(name = "Ext.grid.Panel", type = VarType.CREATE)
public class EGridPanel extends EAbstractPanel
{
	@ExtChild
	protected Object store;
	@ExtField
	protected Boolean loadMask;
	@ExtChildren
	protected List<Object> columns = new ArrayList<Object>();
	@ExtChildren
	protected List<Object> dockedItems = new ArrayList<Object>();
	@ExtChild
	protected Object selModel;
	@ExtField
	protected String selType;
	@ExtChild
	protected String viewConfig;
	@ExtField
	protected Boolean invalidateScrollerOnRefresh;
	@ExtField
	protected Boolean disableSelection;
	@ExtField
	protected String verticalScrollerType;

	@TagAttribute
	public void setInvalidateScrollerOnRefresh(Boolean invalidateScrollerOnRefresh)
	{
		this.invalidateScrollerOnRefresh = invalidateScrollerOnRefresh;
	}

	@TagAttribute
	public void setDisableSelection(Boolean disableSelection)
	{
		this.disableSelection = disableSelection;
	}

	@TagAttribute
	public void setVerticalScrollerType(String verticalScrollerType)
	{
		this.verticalScrollerType = verticalScrollerType;
	}

	@TagAttribute
	public void setViewConfig(String viewConfig)
	{
		this.viewConfig = viewConfig;
	}

	@TagAttribute
	public void setStore(String store)
	{
		this.store = store;
	}

	@TagAttribute
	public void setLoadMask(Boolean loadMask)
	{
		this.loadMask = loadMask;
	}

	@TagAttribute
	public void setSelModel(String selModel)
	{
		this.selModel = selModel;
	}

	@TagDocked
	public void addRowNumberer(ERowNumberer rn)
	{
		columns.add(rn);
	}

	@TagDocked
	public void addColumn(EColumn column)
	{
		columns.add(column);
	}

	@TagDocked
	public void addToolbar(EPagingToolbar toolbar)
	{
		dockedItems.add(toolbar);
	}

	@TagDocked
	public void addToolbar(EToolbar toolbar)
	{
		dockedItems.add(toolbar);
	}

	@TagDocked(dockType = ECellEditing.class)
	public void addPlugin(EReference reference)
	{
		plugins.add(reference);
	}

	@TagDocked
	public void addPlugin(ECellEditing ce)
	{
		plugins.add(ce);
	}

	@TagDocked
	public void setSelModel(ECheckboxModel selModel)
	{
		this.selModel = selModel;
	}

	@TagDocked
	public void setStore(EAbstractStore store)
	{
		this.store = store;
	}

	@TagAttribute
	public void setSelType(String selType)
	{
		this.selType = selType;
	}
}
