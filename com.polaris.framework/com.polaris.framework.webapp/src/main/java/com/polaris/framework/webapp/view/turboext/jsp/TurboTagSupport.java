package com.polaris.framework.webapp.view.turboext.jsp;

import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.polaris.framework.webapp.view.ext.api.ERootBody;

/**
 * 抽象的加强型标签
 * 
 * @author wang.sheng
 */
public abstract class TurboTagSupport extends BodyTagSupport
{
	private static final long serialVersionUID = 1L;
	Log log = LogFactory.getLog(getClass());

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
}
