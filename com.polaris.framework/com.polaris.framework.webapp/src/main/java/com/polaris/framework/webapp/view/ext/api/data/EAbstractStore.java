package com.polaris.framework.webapp.view.ext.api.data;

import java.util.ArrayList;
import java.util.List;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.ExtChild;
import com.polaris.framework.webapp.view.ext.annotation.ExtChildren;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.TagDocked;
import com.polaris.framework.webapp.view.ext.api.EModule;
import com.polaris.framework.webapp.view.ext.api.EObject;

/**
 * 抽象的数据容器对象
 * 
 * @author wang.sheng
 */
public abstract class EAbstractStore extends EObject implements EModule
{
	protected String varName;
	@ExtField
	protected Boolean autoLoad;
	@ExtField
	protected Boolean autoSync;
	@ExtChildren
	protected List<EDataField> fields = new ArrayList<EDataField>();
	@ExtField
	protected String model;
	@ExtChild
	protected EDataProxy proxy;
	@ExtField
	protected String storeId;

	@Override
	public String getVarName()
	{
		// TODO Auto-generated method stub
		return varName;
	}

	@TagAttribute
	public void setAutoLoad(Boolean autoLoad)
	{
		this.autoLoad = autoLoad;
	}

	@TagAttribute
	public void setAutoSync(Boolean autoSync)
	{
		this.autoSync = autoSync;
	}

	@TagAttribute
	public void setModel(String model)
	{
		this.model = model;
	}

	@TagAttribute
	public void setStoreId(String storeId)
	{
		this.storeId = storeId;
	}

	@TagDocked
	public void setProxy(EDataProxy proxy)
	{
		this.proxy = proxy;
	}

	@TagAttribute
	public void setVarName(String varName)
	{
		this.varName = varName;
	}

	@TagDocked
	public void addDataField(EDataField fieldType)
	{
		this.fields.add(fieldType);
	}

}
