package com.polaris.framework.view.io;

import java.io.InputStream;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

/**
 * 资源加载器
 * 
 * @author wang.sheng
 * 
 */
@Service
public class ResourceLoader
{
	Log log = LogFactory.getLog(getClass());

	private static final String RESOURCE_PATH = "META-INF/view/%s";

	/**
	 * 根据路径名称获取资源输入流
	 * 
	 * @param uri
	 * @return
	 * @throws Exception
	 */
	public InputStream getInputStream(String uri)
	{
		if (StringUtils.isEmpty(uri))
		{
			throw new IllegalArgumentException("URI is invalid uri=" + uri + "!");
		}
		String resourcePath = String.format(RESOURCE_PATH, uri);
		return Thread.currentThread().getContextClassLoader().getResourceAsStream(resourcePath);
	}
}
