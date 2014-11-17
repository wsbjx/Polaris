package com.polaris.framework.view.io;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 资源控制器<br>
 * 
 * @author wang.sheng
 * 
 */
@Controller
@RequestMapping(value = "/view")
public class ViewController
{
	Log log = LogFactory.getLog(getClass());

	private final static String DEFAULT_CONTENT_TYPE = "text/html";

	@Resource
	private ResourceLoader resourceLoader;

	/**
	 * 加载指定资源
	 * 
	 * @param uri
	 * @param response
	 */
	@RequestMapping(value = "**/*", method = RequestMethod.GET)
	public void load(HttpServletRequest request, HttpServletResponse response)
	{
		String prefixPath = request.getContextPath() + request.getServletPath() + "/view/";
		String requestURI = request.getRequestURI();
		String uri = requestURI.substring(prefixPath.length());
		log.debug("load resource, uri: " + uri);
		String contentType = getContentType(request.getServletContext(), uri);
		response.setContentType(contentType);
		response.setCharacterEncoding("UTF-8");
		InputStream is = null;
		try
		{
			is = resourceLoader.getInputStream(uri);
			IOUtils.copy(is, response.getOutputStream());
		}
		catch (Exception e)
		{
			log.warn("load resource failed! uri: " + uri, e);
		}
		finally
		{
			if (is != null)
			{
				try
				{
					is.close();
				}
				catch (IOException e)
				{
					log.warn("InputStream closed faled!", e);
				}
			}
		}
	}

	/**
	 * 根据URI字符串判断Reponse返回内容类型
	 * 
	 * @param context
	 * @param uri
	 * @return
	 */
	private static String getContentType(ServletContext context, String uri)
	{
		if (StringUtils.isEmpty(uri))
		{
			return DEFAULT_CONTENT_TYPE;
		}
		uri = uri.toLowerCase();
		int index = uri.lastIndexOf(".");
		if (index < 0)
		{
			return DEFAULT_CONTENT_TYPE;
		}
		String suffix = uri.substring(index);
		String mimeType = context.getMimeType(suffix);
		if (mimeType != null && !mimeType.isEmpty())
		{
			return mimeType;
		}
		return DEFAULT_CONTENT_TYPE;
	}
}
