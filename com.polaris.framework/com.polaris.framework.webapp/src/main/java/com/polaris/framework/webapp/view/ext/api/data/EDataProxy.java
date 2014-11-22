package com.polaris.framework.webapp.view.ext.api.data;

import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.ext.annotation.Ext;
import com.polaris.framework.webapp.view.ext.annotation.ExtChild;
import com.polaris.framework.webapp.view.ext.annotation.ExtField;
import com.polaris.framework.webapp.view.ext.annotation.TagDocked;
import com.polaris.framework.webapp.view.ext.annotation.VarType;

@Ext(type = VarType.CONFIG)
public class EDataProxy
{
	@ExtField
	protected String type;
	@ExtChild
	protected EDataReader reader;
	@ExtChild
	protected EDataProxyAPI api;
	@ExtChild
	protected EDataWriter writer;
	@ExtChild
	protected Object extraParams;
	@ExtField
	protected String head;

	@TagAttribute
	public void setHead(String head)
	{
		this.head = head;
	}

	@TagAttribute
	public void setType(String type)
	{
		this.type = type;
	}

	@TagDocked
	public void setReader(EDataReader reader)
	{
		this.reader = reader;
	}

	@TagDocked
	public void setApi(EDataProxyAPI api)
	{
		this.api = api;
	}

	@TagDocked
	public void setWriter(EDataWriter writer)
	{
		this.writer = writer;
	}

	@TagAttribute
	public void setExtraParams(String extraParams)
	{
		this.extraParams = extraParams;
	}

}
