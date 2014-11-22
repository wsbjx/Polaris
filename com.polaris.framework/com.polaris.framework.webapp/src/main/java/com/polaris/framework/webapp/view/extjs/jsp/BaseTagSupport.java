package com.polaris.framework.webapp.view.extjs.jsp;

import java.lang.reflect.Method;

import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.polaris.framework.webapp.view.annotation.TagLib;
import com.polaris.framework.webapp.view.extjs.api.ERootBody;
import com.polaris.framework.webapp.view.extjs.utils.ExtAnnotationUtils;
import com.polaris.framework.webapp.view.turboext.jsp.ExtBodyTag;

/**
 * 基础的标签支持类
 * 
 * @author wang.sheng
 */
public abstract class BaseTagSupport extends BodyTagSupport implements ComponentSupport
{
	private static final long serialVersionUID = 1L;
	private Object component;
	Log log = LogFactory.getLog(getClass());

	@Override
	public final int doStartTag()
	{
		// 创建一个组件
		component = this.createComponent();
		if (component == null)
		{
			log.error("createComponent returns null!");
			return Tag.SKIP_BODY;
		}
		return BodyTag.EVAL_BODY_BUFFERED;
	}

	@Override
	public final int doEndTag()
	{
		if (component != null)
		{
			// 从标签中复制属性到组件中
			ExtAnnotationUtils.assembleyExtObject(component, this, super.pageContext.getRequest());
			Tag parentTag = super.getParent();
			if (parentTag != null && parentTag instanceof ComponentSupport)
			{
				Object parentComponent = ((ComponentSupport) parentTag).getComponent();
				if (parentComponent != null)
				{
					Method method = ExtAnnotationUtils.findDockedMethod(parentComponent, component);
					try
					{
						method.invoke(parentComponent, component);
					}
					catch (Exception e)
					{
						// TODO Auto-generated catch block
						log.error("docked method invoked failed!", e);
					}
				}
			}
		}
		return Tag.EVAL_PAGE;
	}

	@Override
	public final Object getComponent()
	{
		return component;
	}

	/**
	 * 获取根节点中的组件
	 * 
	 * @return
	 */
	protected ERootBody getRootBody()
	{
		Tag tag = this;
		while (true)
		{
			if (tag == null)
			{
				log.warn("ERootBody not found!");
				return null;
			}
			if (tag instanceof ExtBodyTag)
			{
				ExtBodyTag extBodyTag = (ExtBodyTag) tag;
				return (ERootBody) extBodyTag.getComponent();
			}
			else
			{
				tag = tag.getParent();
			}
		}
	}

	/**
	 * 创建一个组件对象<br>
	 * 该方法可以被子类重载<br>
	 * 
	 * @return
	 */
	protected Object createComponent()
	{
		if (this.getClass().isAnnotationPresent(TagLib.class))
		{
			TagLib extTag = this.getClass().getAnnotation(TagLib.class);
			Class<?> componentType = extTag.component();
			try
			{
				return componentType.newInstance();
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				throw new RuntimeException("componentType:" + componentType + " newInstnace failed!", e);
			}
		}
		else
		{
			throw new RuntimeException("extends ExtTagSupport must be annotation: @ExtTag");
		}
	}
}
