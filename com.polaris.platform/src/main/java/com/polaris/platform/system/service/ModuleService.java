package com.polaris.platform.system.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.polaris.platform.annotation.Module;
import com.polaris.platform.system.vo.ModuleProperty;

/**
 * 模块服务
 * 
 * @author wang.sheng
 * 
 */
@Service
public class ModuleService
{
	Log log = LogFactory.getLog(getClass());

	@Resource
	private ApplicationContext applicationContext;
	private static final Map<String, ModuleProperty> moduleMap = new HashMap<String, ModuleProperty>();

	/**
	 * 获取所有的模块属性
	 * 
	 * @return
	 */
	public ModuleProperty[] getModuleProperties()
	{
		return moduleMap.values().toArray(new ModuleProperty[0]);
	}

	/**
	 * 获取指定的模块属性
	 * 
	 * @param id
	 * @return
	 */
	public ModuleProperty getModuleProperty(String id)
	{
		return moduleMap.get(id);
	}

	/**
	 * 启动服务
	 */
	@PostConstruct
	protected void startService()
	{
		log.info("start load Module Properties");
		moduleMap.clear();
		Map<String, Object> beanMap = applicationContext.getBeansWithAnnotation(RestController.class);
		for (Map.Entry<String, Object> entry : beanMap.entrySet())
		{
			Class<?> beanClass = entry.getValue().getClass();
			if (beanClass.isAnnotationPresent(Module.class))
			{
				Module module = beanClass.getAnnotation(Module.class);
				ModuleProperty mp = this.toModuleProperty(module, beanClass);
				log.info("load Module, id:" + mp.getId() + ", name:" + mp.getName() + ", jsFile:" + mp.getJsFile());
				moduleMap.put(mp.getId(), mp);
			}
		}
		log.info("Module Properties loaded successful!");
	}

	/**
	 * 将注释转换为属性对象
	 * 
	 * @param module
	 * @param beanClass
	 * @return
	 */
	private ModuleProperty toModuleProperty(Module module, Class<?> beanClass)
	{
		ModuleProperty mp = new ModuleProperty();
		String id = module.id();
		if (StringUtils.isEmpty(id))
		{
			id = beanClass.getName();
		}
		mp.setId(id);
		String name = module.name();
		if (StringUtils.isEmpty(name))
		{
			name = beanClass.getSimpleName();
		}
		mp.setName(name);
		mp.setJsFile(module.jsFile());
		mp.setRoles(module.roles());
		return mp;
	}

	/**
	 * 停止服务
	 */
	@PreDestroy
	protected void stopService()
	{
		moduleMap.clear();
	}
}
