package com.polaris.framework.webapp.view.extjs.jsp.view;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.extjs.api.view.EView;
import com.polaris.framework.webapp.view.extjs.jsp.ComponentTag;

@TagLib(name = "view", component = EView.class)
public class ViewTag extends ComponentTag
{
	private static final long serialVersionUID = 1L;
	@TagAttribute(required = true)
	protected String itemSelector;
	@TagAttribute
	protected String store;
	@TagAttribute
	protected String tpl;
	@TagAttribute
	protected Boolean blockRefresh;
	@TagAttribute
	protected Boolean deferEmptyText;
	@TagAttribute
	protected Boolean deferInitialRefresh;
	@TagAttribute
	protected Boolean disableSelection;
	@TagAttribute
	protected String emptyText;
	@TagAttribute
	protected String itemCls;
	@TagAttribute
	protected String itemTpl;
	@TagAttribute
	protected Boolean loadMask;
	@TagAttribute
	protected String loadingCls;
	@TagAttribute
	protected Integer loadingHeight;
	@TagAttribute
	protected String loadingText;
	@TagAttribute
	protected Boolean multiSelect;
	@TagAttribute
	protected String overItemCls;
	@TagAttribute
	protected Boolean preserveScrollOnRefresh;
	@TagAttribute
	protected String selectedItemCls;
	@TagAttribute
	protected Boolean simpleSelect;
	@TagAttribute
	protected Boolean singleSelect;
	@TagAttribute
	protected Boolean trackOver;

	public void setItemSelector(String itemSelector)
	{
		this.itemSelector = itemSelector;
	}

	public void setStore(String store)
	{
		this.store = store;
	}

	public void setTpl(String tpl)
	{
		this.tpl = tpl;
	}

	public void setBlockRefresh(Boolean blockRefresh)
	{
		this.blockRefresh = blockRefresh;
	}

	public void setDeferEmptyText(Boolean deferEmptyText)
	{
		this.deferEmptyText = deferEmptyText;
	}

	public void setDeferInitialRefresh(Boolean deferInitialRefresh)
	{
		this.deferInitialRefresh = deferInitialRefresh;
	}

	public void setDisableSelection(Boolean disableSelection)
	{
		this.disableSelection = disableSelection;
	}

	public void setEmptyText(String emptyText)
	{
		this.emptyText = emptyText;
	}

	public void setItemCls(String itemCls)
	{
		this.itemCls = itemCls;
	}

	public void setItemTpl(String itemTpl)
	{
		this.itemTpl = itemTpl;
	}

	public void setLoadMask(Boolean loadMask)
	{
		this.loadMask = loadMask;
	}

	public void setLoadingCls(String loadingCls)
	{
		this.loadingCls = loadingCls;
	}

	public void setLoadingHeight(Integer loadingHeight)
	{
		this.loadingHeight = loadingHeight;
	}

	public void setLoadingText(String loadingText)
	{
		this.loadingText = loadingText;
	}

	public void setMultiSelect(Boolean multiSelect)
	{
		this.multiSelect = multiSelect;
	}

	public void setOverItemCls(String overItemCls)
	{
		this.overItemCls = overItemCls;
	}

	public void setPreserveScrollOnRefresh(Boolean preserveScrollOnRefresh)
	{
		this.preserveScrollOnRefresh = preserveScrollOnRefresh;
	}

	public void setSelectedItemCls(String selectedItemCls)
	{
		this.selectedItemCls = selectedItemCls;
	}

	public void setSimpleSelect(Boolean simpleSelect)
	{
		this.simpleSelect = simpleSelect;
	}

	public void setSingleSelect(Boolean singleSelect)
	{
		this.singleSelect = singleSelect;
	}

	public void setTrackOver(Boolean trackOver)
	{
		this.trackOver = trackOver;
	}

}
