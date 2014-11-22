package com.polaris.framework.webapp.view.turboext.jsp;

import java.lang.reflect.Field;
import java.util.Date;

import javax.servlet.jsp.tagext.Tag;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.polaris.framework.webapp.common.utils.ReflectUtils;
import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.ext.api.data.EDataField;
import com.polaris.framework.webapp.view.ext.api.data.EDataModel;
import com.polaris.framework.webapp.view.ext.api.data.EDataProxy;
import com.polaris.framework.webapp.view.ext.api.data.EDataProxyAPI;
import com.polaris.framework.webapp.view.ext.api.data.EDataReader;
import com.polaris.framework.webapp.view.ext.api.data.EDataWriter;
import com.polaris.framework.webapp.view.turboext.annotation.DataField;
import com.polaris.framework.webapp.view.turboext.annotation.DataModel;
import com.polaris.framework.webapp.view.turboext.annotation.DataReader;
import com.polaris.framework.webapp.view.turboext.annotation.DataWriter;

@TagLib(name = "datamodel")
public class DataModelTag extends TurboTagSupport
{
	private static final long serialVersionUID = 1L;
	Log log = LogFactory.getLog(getClass());
	@TagAttribute(required = true)
	private String modelClass;
	@TagAttribute(required = true)
	private String define;
	@TagAttribute
	private String extraParams;
	@TagAttribute(required = true)
	private String read;
	@TagAttribute
	private String update;
	@TagAttribute
	private String destroy;
	@TagAttribute
	private String create;

	public void setModelClass(String modelClass)
	{
		this.modelClass = modelClass;
	}

	public void setDefine(String define)
	{
		this.define = define;
	}

	public void setExtraParams(String extraParams)
	{
		this.extraParams = extraParams;
	}

	public void setRead(String read)
	{
		this.read = read;
	}

	public void setUpdate(String update)
	{
		this.update = update;
	}

	public void setDestroy(String destroy)
	{
		this.destroy = destroy;
	}

	public void setCreate(String create)
	{
		this.create = create;
	}

	@Override
	public int doEndTag()
	{
		EDataModel dataModel = this.createEDataModel();
		super.getRootBody().docked(dataModel);
		return Tag.EVAL_PAGE;
	}

	protected EDataModel createEDataModel()
	{
		Class<?> cl = null;
		try
		{
			cl = Class.forName(modelClass);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			log.error("load modelClass:" + modelClass + " failed!", e);
			return null;
		}
		if (!cl.isAnnotationPresent(DataModel.class))
		{
			log.error("load modelClass:" + modelClass + " must be Annotation of @DataModel");
			return null;
		}
		DataModel model = cl.getAnnotation(DataModel.class);
		DataReader reader = null;
		if (cl.isAnnotationPresent(DataReader.class))
		{
			reader = cl.getAnnotation(DataReader.class);
		}
		DataWriter writer = null;
		if (cl.isAnnotationPresent(DataWriter.class))
		{
			writer = cl.getAnnotation(DataWriter.class);
		}
		EDataModel dataModel = new EDataModel();
		EDataProxyAPI dataProxyAPI = new EDataProxyAPI();
		EDataProxy dataProxy = new EDataProxy();
		EDataReader dataReader = new EDataReader();
		EDataWriter dataWriter = new EDataWriter();

		dataModel.setDefine(define);
		dataModel.setIdProperty("id");
		dataModel.setProxy(dataProxy);

		dataProxy.setApi(dataProxyAPI);
		dataProxy.setExtraParams(extraParams);
		dataProxy.setReader(dataReader);
		dataProxy.setType(model.type());
		dataProxy.setWriter(dataWriter);

		if (create != null && create.length() > 0)
		{
			dataProxyAPI.setCreate(create);
		}
		if (update != null && update.length() > 0)
		{
			dataProxyAPI.setUpdate(update);
		}
		if (destroy != null && destroy.length() > 0)
		{
			dataProxyAPI.setDestroy(destroy);
		}
		dataProxyAPI.setRead(read);

		if (reader != null)
		{
			dataReader.setRoot(reader.root());
			dataReader.setSuccessProperty(reader.successProperty());
			dataReader.setTotalProperty(reader.totalProperty());
		}
		else
		{
			dataReader.setRoot("results");
			dataReader.setSuccessProperty("success");
			dataReader.setTotalProperty("totalCount");
		}

		if (writer != null)
		{
			dataWriter.setAllowSingle(writer.allowSingle());
			dataWriter.setType(writer.type());
			dataWriter.setWriteAllFields(writer.writeAllFields());
		}
		else
		{
			dataWriter.setAllowSingle(false);
			dataWriter.setType("json");
			dataWriter.setWriteAllFields(true);
		}

		Field[] fields = ReflectUtils.getAllFields(cl);
		for (Field field : fields)
		{
			if (!field.isAnnotationPresent(DataField.class))
			{
				continue;
			}
			DataField dataField = field.getAnnotation(DataField.class);
			String name = dataField.name();
			String type = dataField.type();
			String dateFormat = dataField.dateFormat();
			if (name == null || name.length() < 1)
			{
				name = field.getName();
			}
			if (dataField.isIdProperty())
			{
				dataModel.setIdProperty(name);
			}
			Class<?> typeClass = field.getType();
			if (type == null || type.length() < 1)
			{
				if (typeClass == int.class || typeClass == Integer.class)
				{
					type = "int";
				}
				else if (typeClass == double.class || typeClass == Double.class)
				{
					type = "double";
				}
				else if (typeClass == float.class || typeClass == Float.class)
				{
					type = "float";
				}
				else if (typeClass == Date.class)
				{
					type = "date";
				}
			}
			if (typeClass == Date.class && (dateFormat == null || dateFormat.length() < 1))
			{
				dateFormat = "Y-m-d";
			}
			EDataField edf = new EDataField();
			if (dateFormat.length() > 0)
			{
				edf.setDateFormat(dateFormat);
			}
			edf.setName(name);
			if (type.length() > 0)
			{
				edf.setType(type);
			}
			dataModel.addField(edf);
		}
		return dataModel;
	}
}
