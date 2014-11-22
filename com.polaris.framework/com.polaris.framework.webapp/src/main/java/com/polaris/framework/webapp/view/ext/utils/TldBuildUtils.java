package com.polaris.framework.webapp.view.ext.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.util.Set;

import com.polaris.framework.webapp.common.utils.ClassScanUtil;
import com.polaris.framework.webapp.view.annotation.TagAttribute;
import com.polaris.framework.webapp.view.annotation.TagLib;

/**
 * TLD文件构建器工具
 * 
 * @author wang.sheng
 */
public final class TldBuildUtils
{
	private TldBuildUtils()
	{
	}

	public static void main(String[] args) throws Exception
	{
		// 直接修改源代码
		File file = new File("E:/web-dev/framework3/framework3/WEB-INF/tlds/framework3-ext.tld");
		buildExt(file);
		file = new File("E:/web-dev/framework3/framework3/WEB-INF/tlds/framework3-turbo.tld");
		buildTurbo(file);
	}

	public static void buildExt(File file) throws Exception
	{
		OutputStream os = new FileOutputStream(file, false);
		OutputStreamWriter writer = new OutputStreamWriter(os, "UTF-8");
		writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		writer.write("<!DOCTYPE taglib PUBLIC \"-//Sun Microsystems, Inc.//DTD JSP Tag Library 1.2//EN\" \"http://java.sun.com/dtd/web-jsptaglibrary_1_2.dtd\">\n");
		writer.write("<taglib>\n");
		writer.write("  <tlib-version>2.2.3</tlib-version>\n");
		writer.write("  <jsp-version>1.2</jsp-version>\n");
		writer.write("  <short-name>ext</short-name>\n");
		writer.write("  <uri>/framework3-ext</uri>\n");
		writer.write("  <display-name>framework3 Ext Tags</display-name>\n");
		Set<Class<?>> classes = ClassScanUtil.scanClasses("net.sirius.framework3.view");
		for (Class<?> cl : classes)
		{
			if (cl.isAnnotationPresent(TagLib.class))
			{
				TagLib tagLib = cl.getAnnotation(TagLib.class);
				if (tagLib.component() == Object.class)
				{
					continue;
				}
				String name = tagLib.name();
				if (name == null || name.length() < 1)
				{
					name = cl.getSimpleName();
				}

				writer.write("\n    <tag>\n");
				writer.write("      <name>" + name + "</name>\n");
				String description = tagLib.description();
				if (description != null && description.length() > 0)
				{
					writer.write("      <description>" + description + "</description>\n");
				}
				writer.write("      <tag-class>");
				writer.write(cl.getName());
				writer.write("</tag-class>\n");
				writer.write("      <body-content>" + tagLib.bodyContent() + "</body-content>\n");
				Field[] fields = ReflectUtils.getAllFields(cl);
				for (Field field : fields)
				{
					if (field.isAnnotationPresent(TagAttribute.class))
					{
						TagAttribute tagAttribute = field.getAnnotation(TagAttribute.class);
						writer.write("      <attribute>\n");
						name = tagAttribute.name();
						if (name == null || name.length() < 1)
						{
							name = field.getName();
						}
						boolean required = tagAttribute.required();
						boolean rtexprvalue = tagAttribute.rtexprvalue();
						description = tagAttribute.description();
						writer.write("          <name>" + name + "</name>\n");
						writer.write("          <required>" + required + "</required>\n");
						writer.write("          <rtexprvalue>" + rtexprvalue + "</rtexprvalue>\n");
						if (description != null && description.length() > 0)
						{
							writer.write("          <description>" + description + "</description>");
						}
						writer.write("      </attribute>\n");
					}
				}
				writer.write("  </tag>\n");
			}
		}
		writer.write("</taglib>\n");
		writer.close();
		os.close();
	}

	public static void buildTurbo(File file) throws Exception
	{
		OutputStream os = new FileOutputStream(file, false);
		OutputStreamWriter writer = new OutputStreamWriter(os, "UTF-8");
		writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		writer.write("<!DOCTYPE taglib PUBLIC \"-//Sun Microsystems, Inc.//DTD JSP Tag Library 1.2//EN\" \"http://java.sun.com/dtd/web-jsptaglibrary_1_2.dtd\">\n");
		writer.write("<taglib>\n");
		writer.write("  <tlib-version>2.2.3</tlib-version>\n");
		writer.write("  <jsp-version>1.2</jsp-version>\n");
		writer.write("  <short-name>ext</short-name>\n");
		writer.write("  <uri>/framework3-turbo</uri>\n");
		writer.write("  <display-name>framework3 Turbo Tags</display-name>\n");
		Set<Class<?>> classes = ClassScanUtil.scanClasses("net.sirius.framework3.view");
		for (Class<?> cl : classes)
		{
			if (cl.isAnnotationPresent(TagLib.class))
			{
				TagLib tagLib = cl.getAnnotation(TagLib.class);
				if (tagLib.component() != Object.class)
				{
					continue;
				}
				String name = tagLib.name();
				if (name == null || name.length() < 1)
				{
					name = cl.getSimpleName();
				}

				writer.write("\n    <tag>\n");
				writer.write("      <name>" + name + "</name>\n");
				String description = tagLib.description();
				if (description != null && description.length() > 0)
				{
					writer.write("      <description>" + description + "</description>\n");
				}
				writer.write("      <tag-class>");
				writer.write(cl.getName());
				writer.write("</tag-class>\n");
				writer.write("      <body-content>" + tagLib.bodyContent() + "</body-content>\n");
				Field[] fields = ReflectUtils.getAllFields(cl);
				for (Field field : fields)
				{
					if (field.isAnnotationPresent(TagAttribute.class))
					{
						TagAttribute tagAttribute = field.getAnnotation(TagAttribute.class);
						writer.write("      <attribute>\n");
						name = tagAttribute.name();
						if (name == null || name.length() < 1)
						{
							name = field.getName();
						}
						boolean required = tagAttribute.required();
						boolean rtexprvalue = tagAttribute.rtexprvalue();
						description = tagAttribute.description();
						writer.write("          <name>" + name + "</name>\n");
						writer.write("          <required>" + required + "</required>\n");
						writer.write("          <rtexprvalue>" + rtexprvalue + "</rtexprvalue>\n");
						if (description != null && description.length() > 0)
						{
							writer.write("          <description>" + description + "</description>");
						}
						writer.write("      </attribute>\n");
					}
				}
				writer.write("  </tag>\n");
			}
		}
		writer.write("</taglib>\n");
		writer.close();
		os.close();
	}
}
