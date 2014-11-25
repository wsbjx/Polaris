package com.polaris.framework.view.support.extjs.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.polaris.framework.common.utils.ReflectUtils;
import com.polaris.framework.view.support.extjs.annotation.GridField;
import com.polaris.framework.view.support.extjs.annotation.Model;
import com.polaris.framework.view.support.extjs.annotation.ModelField;
import com.polaris.framework.view.support.extjs.vo.GridFieldProperty;
import com.polaris.framework.view.support.extjs.vo.ModelFieldProperty;
import com.polaris.framework.view.support.extjs.vo.ModelProperty;

/**
 * ExtJS支撑的服务
 * 
 * @author wang.sheng
 * 
 */
@Service
public class ExtjsService
{
	Log log = LogFactory.getLog(getClass());

	/**
	 * 根据类型构建GridField属性集合
	 * 
	 * @param clazz
	 * @return
	 */
	public GridFieldProperty[] buildGridFieldPropertys(Class<?> clazz)
	{
		List<GridFieldProperty> list = new ArrayList<GridFieldProperty>();
		Field[] fields = ReflectUtils.getAllFields(clazz);
		for (Field field : fields)
		{
			GridField gridField = field.getAnnotation(GridField.class);
			if (gridField == null)
			{
				// 忽略该属性
				continue;
			}
			GridFieldProperty gridFieldProperty = new GridFieldProperty();
			// 列标题
			String header = gridField.header();
			if (StringUtils.isEmpty(header))
			{
				header = field.getName();
			}
			gridFieldProperty.setHeader(header);
			// 列宽
			int width = gridField.width();
			if (width > 0)
			{
				gridFieldProperty.setWidth(width);
			}
			// 数据索引
			String dataIndex = gridField.dataIndex();
			if (StringUtils.isEmpty(dataIndex))
			{
				dataIndex = field.getName();
			}
			gridFieldProperty.setDataIndex(dataIndex);
			// 编辑框类型
			String input = gridField.input();
			if (!StringUtils.isEmpty(input))
			{
				gridFieldProperty.setInput(input);
			}
			// 排序
			gridFieldProperty.setSortable(gridField.sortable());
			// 列比例宽度
			int flex = gridField.flex();
			if (flex > 0)
			{
				gridFieldProperty.setFlex(flex);
			}
			list.add(gridFieldProperty);
		}
		return list.toArray(new GridFieldProperty[0]);
	}

	/**
	 * 构建ModelProperty
	 * 
	 * @param clazz
	 * @return
	 */
	public ModelProperty buildModelProperty(Class<?> clazz)
	{
		Model model = clazz.getAnnotation(Model.class);
		if (model == null)
		{
			throw new IllegalArgumentException("Model Annotation not found! class:" + clazz);
		}
		ModelProperty modelProperty = new ModelProperty();
		String name = model.value();
		if (StringUtils.isEmpty(name))
		{
			// 取类型名称作为默认名
			name = clazz.getSimpleName();
		}
		modelProperty.setName(name);
		Field[] fields = ReflectUtils.getAllFields(clazz);
		List<ModelFieldProperty> list = new ArrayList<ModelFieldProperty>();
		for (Field field : fields)
		{
			ModelField modelField = field.getAnnotation(ModelField.class);
			if (modelField == null)
			{
				// 忽略该属性
				continue;
			}
			ModelFieldProperty modelFieldProperty = new ModelFieldProperty();
			// 设置属性名称
			String fieldName = modelField.value();
			if (StringUtils.isEmpty(fieldName))
			{
				fieldName = field.getName();
			}
			modelFieldProperty.setName(fieldName);
			if (modelField.key())
			{
				// 设置关键字
				modelProperty.setIdProperty(fieldName);
			}
			String defaultValue = modelField.defaultValue();
			if (!StringUtils.isEmpty(defaultValue))
			{
				// 设置默认值
				Object object = ConvertUtils.convert(defaultValue, field.getType());
				modelFieldProperty.setDefaultValue(object);
			}
			// 设置类型
			String type = modelField.type();
			if (StringUtils.isEmpty(type))
			{
				type = getShortType(field.getType());
			}
			modelFieldProperty.setType(type);
			// 设置转换器
			String convert = modelField.convert();
			if (!StringUtils.isEmpty(convert))
			{
				modelFieldProperty.setConvert(convert);
			}
			list.add(modelFieldProperty);
		}
		modelProperty.setModelFields(list.toArray(new ModelFieldProperty[0]));
		return modelProperty;
	}

	/**
	 * 根据简单属性类型获取短类型名称
	 * 
	 * @param typeClass
	 * @return
	 */
	private static String getShortType(Class<?> typeClass)
	{
		String type = null;
		if (typeClass == String.class)
		{
			type = "string";
		}
		else if (typeClass == Integer.class || typeClass == int.class)
		{
			type = "int";
		}
		else if (typeClass == Boolean.class || typeClass == boolean.class)
		{
			type = "boolean";
		}
		else if (typeClass == Double.class || typeClass == double.class)
		{
			type = "double";
		}
		else if (typeClass == Float.class || typeClass == float.class)
		{
			type = "float";
		}
		else if (typeClass == Long.class || typeClass == long.class)
		{
			type = "long";
		}
		else if (typeClass == Date.class)
		{
			type = "date";
		}
		else
		{
			type = "string";
		}
		return type;
	}
}
