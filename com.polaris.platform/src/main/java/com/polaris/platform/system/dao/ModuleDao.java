package com.polaris.platform.system.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.polaris.framework.common.hibernate.HibernateTemplate;
import com.polaris.platform.system.vo.Module;

/**
 * 模块表的DAO
 * 
 * @author wang.sheng
 * 
 */
@Repository
public class ModuleDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;

	public Module[] getModules()
	{
		return hibernateTemplate.queryForArray("from Module t order by t.name", null, Module.class);
	}

	public Module getModule(String id)
	{
		return hibernateTemplate.queryForObject("from Module t where t.id=?", new Object[] { id }, Module.class);
	}

	public void delete(String id)
	{
		hibernateTemplate.executeUpdate("delete from Module t where t.id=?", new Object[] { id });
	}

	public void save(Module module)
	{
		hibernateTemplate.save(module);
	}

	public void update(Module module)
	{
		hibernateTemplate.update(module);
	}
}
