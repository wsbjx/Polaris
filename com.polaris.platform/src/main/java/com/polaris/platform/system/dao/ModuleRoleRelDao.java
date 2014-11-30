package com.polaris.platform.system.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.polaris.framework.common.hibernate.HibernateTemplate;
import com.polaris.platform.system.vo.ModuleRoleRel;

/**
 * 模块与角色的关系表DAO
 * 
 * @author wang.sheng
 * 
 */
@Repository
public class ModuleRoleRelDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;

	public void insert(ModuleRoleRel rel)
	{
		hibernateTemplate.save(rel);
	}

	public void delete(String id)
	{
		hibernateTemplate.executeUpdate("delete from ModuleRoleRel t where t.id=?", new Object[] { id });
	}

	public void deleteByRole(String roleId)
	{
		hibernateTemplate.executeUpdate("delete from ModuleRoleRel t where t.roleId=?", new Object[] { roleId });
	}

	public void deleteByModule(String moduleId)
	{
		hibernateTemplate.executeUpdate("delete from ModuleRoleRel t where t.moduleId=?", new Object[] { moduleId });
	}

}
