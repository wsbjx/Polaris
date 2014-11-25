package com.polaris.platform.system.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.polaris.framework.common.hibernate.HibernateTemplate;
import com.polaris.platform.system.vo.Module;

/**
 * 模块DAO
 * 
 * @author wang.sheng
 * 
 */
@Repository
public class ModuleDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;

	public void add(Module vo)
	{
		hibernateTemplate.save(vo);
	}

	public void update(Module vo)
	{
		hibernateTemplate.update(vo);
	}

	public void delete(String id)
	{
		hibernateTemplate.executeUpdate("delete from Module t where t.id=?", new Object[] { id });
	}

	public Module findModuleByURL(String url)
	{
		return this.hibernateTemplate.queryForObject("from Module t where t.url like ?", new Object[] { url + "%" }, Module.class);
	}

	public Module[] getModules()
	{
		return hibernateTemplate.queryForArray("from Module t order by t.title", null, Module.class);
	}

	public Module[] getModulesByRoles(String[] roleIds)
	{
		String hql = "from Module t where t.id in" + "(select r.moduleId from ModuleRoleRel r where r.roleId in (:roleIds))";
		Session session = hibernateTemplate.getCurrentSession();
		List<?> list = session.createQuery(hql).setParameterList("roleIds", roleIds).list();
		return list.toArray(new Module[0]);
	}

	public Module getModule(String id)
	{
		return hibernateTemplate.queryForObject("from Module t where t.id=?", new Object[] { id }, Module.class);
	}
}
