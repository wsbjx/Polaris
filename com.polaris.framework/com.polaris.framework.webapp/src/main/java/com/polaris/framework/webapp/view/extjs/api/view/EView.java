package com.polaris.framework.webapp.view.extjs.api.view;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.extjs.annotation.Ext;
import com.polaris.framework.webapp.view.extjs.annotation.ExtChild;
import com.polaris.framework.webapp.view.extjs.annotation.ExtField;
import com.polaris.framework.webapp.view.extjs.annotation.TagDocked;
import com.polaris.framework.webapp.view.extjs.annotation.VarType;
import com.polaris.framework.webapp.view.extjs.api.EComponent;
import com.polaris.framework.webapp.view.extjs.api.data.EStore;

@Ext(name = "Ext.view.View", type = VarType.CREATE)
public class EView extends EComponent
{
	@ExtField
	protected String itemSelector;
	@ExtChild
	protected Object store;
	@ExtChild
	protected String tpl;
	@ExtField
	protected Boolean blockRefresh;
	@ExtField
	protected Boolean deferEmptyText;
	@ExtField
	protected Boolean deferInitialRefresh;
	@ExtField
	protected Boolean disableSelection;
	@ExtField
	protected String emptyText;
	@ExtField
	protected String itemCls;
	@ExtField
	protected String itemTpl;
	@ExtField
	protected Boolean loadMask;
	@ExtField
	protected String loadingCls;
	@ExtField
	protected Integer loadingHeight;
	@ExtField
	protected String loadingText;
	@ExtField
	protected Boolean multiSelect;
	@ExtField
	protected String overItemCls;
	@ExtField
	protected Boolean preserveScrollOnRefresh;
	@ExtField
	protected String selectedItemCls;
	@ExtField
	protected Boolean simpleSelect;
	@ExtField
	protected Boolean singleSelect;
	@ExtField
	protected Boolean trackOver;

	@TagAttribute
	public void setItemSelector(String itemSelector)
	{
		this.itemSelector = itemSelector;
	}

	@TagAttribute
	public void setStore(String store)
	{
		this.store = store;
	}

	@TagDocked
	public void setStore(EStore store)
	{
		this.store = store;
	}

	@TagAttribute
	public void setTpl(String tpl)
	{
		this.tpl = tpl;
	}

	@TagAttribute
	public void setBlockRefresh(Boolean blockRefresh)
	{
		this.blockRefresh = blockRefresh;
	}

	@TagAttribute
	public void setDeferEmptyText(Boolean deferEmptyText)
	{
		this.deferEmptyText = deferEmptyText;
	}

	@TagAttribute
	public void setDeferInitialRefresh(Boolean deferInitialRefresh)
	{
		this.deferInitialRefresh = deferInitialRefresh;
	}

	@TagAttribute
	public void setDisableSelection(Boolean disableSelection)
	{
		this.disableSelection = disableSelection;
	}

	@TagAttribute
	public void setEmptyText(String emptyText)
	{
		this.emptyText = emptyText;
	}

	@TagAttribute
	public void setItemCls(String itemCls)
	{
		this.itemCls = itemCls;
	}

	@TagAttribute
	public void setItemTpl(String itemTpl)
	{
		this.itemTpl = itemTpl;
	}

	@TagAttribute
	public void setLoadMask(Boolean loadMask)
	{
		this.loadMask = loadMask;
	}

	@TagAttribute
	public void setLoadingCls(String loadingCls)
	{
		this.loadingCls = loadingCls;
	}

	@TagAttribute
	public void setLoadingHeight(Integer loadingHeight)
	{
		this.loadingHeight = loadingHeight;
	}

	@TagAttribute
	public void setLoadingText(String loadingText)
	{
		this.loadingText = loadingText;
	}

	@TagAttribute
	public void setMultiSelect(Boolean multiSelect)
	{
		this.multiSelect = multiSelect;
	}

	@TagAttribute
	public void setOverItemCls(String overItemCls)
	{
		this.overItemCls = overItemCls;
	}

	@TagAttribute
	public void setPreserveScrollOnRefresh(Boolean preserveScrollOnRefresh)
	{
		this.preserveScrollOnRefresh = preserveScrollOnRefresh;
	}

	@TagAttribute
	public void setSelectedItemCls(String selectedItemCls)
	{
		this.selectedItemCls = selectedItemCls;
	}

	@TagAttribute
	public void setSimpleSelect(Boolean simpleSelect)
	{
		this.simpleSelect = simpleSelect;
	}

	@TagAttribute
	public void setSingleSelect(Boolean singleSelect)
	{
		this.singleSelect = singleSelect;
	}

	@TagAttribute
	public void setTrackOver(Boolean trackOver)
	{
		this.trackOver = trackOver;
	}

}
