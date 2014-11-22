package com.polaris.framework.webapp.view.extjs.api.data;

import java.util.ArrayList;
import java.util.List;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.extjs.annotation.Ext;
import com.polaris.framework.webapp.view.extjs.annotation.ExtChild;
import com.polaris.framework.webapp.view.extjs.annotation.ExtChildren;
import com.polaris.framework.webapp.view.extjs.annotation.ExtField;
import com.polaris.framework.webapp.view.extjs.annotation.TagDocked;
import com.polaris.framework.webapp.view.extjs.annotation.VarType;
import com.polaris.framework.webapp.view.extjs.api.EDefine;

@Ext(name = "Ext.data.Model", type = VarType.DEFINE)
public class EDataModel implements EDefine
{
	protected String define;
	@ExtField
	protected String idProperty;
	@ExtChild
	protected EDataProxy proxy;
	@ExtChildren
	protected List<EDataField> fields = new ArrayList<EDataField>();

	@Override
	public String getDefine()
	{
		// TODO Auto-generated method stub
		return define;
	}

	@TagAttribute
	public void setIdProperty(String idProperty)
	{
		this.idProperty = idProperty;
	}

	@TagAttribute
	public void setDefine(String define)
	{
		this.define = define;
	}

	@TagDocked
	public void addField(EDataField field)
	{
		fields.add(field);
	}

	@TagDocked
	public void setProxy(EDataProxy proxy)
	{
		this.proxy = proxy;
	}

	@Override
	public String getVarName()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
