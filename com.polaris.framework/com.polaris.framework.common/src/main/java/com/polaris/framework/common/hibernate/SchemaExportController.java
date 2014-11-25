package com.polaris.framework.common.hibernate;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.polaris.framework.common.restful.SimpleResponse;

/**
 * 自动生成表结构
 * 
 * @author wang.sheng
 * 
 */
@RestController
@RequestMapping(value = "/schemaexport")
public class SchemaExportController
{
	Log log = LogFactory.getLog(getClass());

	@Resource(name = "&sessionFactory")
	private LocalSessionFactoryBean localSessionFactoryBean;

	/**
	 * 自动生成表结构
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public SimpleResponse schemaExport()
	{
		SimpleResponse response = new SimpleResponse();
		try
		{
			SchemaExport schemaExport = new SchemaExport(localSessionFactoryBean.getConfiguration());
			schemaExport.create(true, true);
			response.setSuccess(true);
			response.setMessage("schemaExport successful!");
		}
		catch (Exception e)
		{
			response.setSuccess(false);
			response.setMessage(e.getMessage());
			log.error("schemaExport failed!", e);
		}
		return response;
	}
}
