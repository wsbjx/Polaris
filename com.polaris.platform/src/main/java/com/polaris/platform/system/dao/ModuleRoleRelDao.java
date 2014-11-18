package com.polaris.platform.system.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.polaris.framework.common.dao.HibernateTemplate;
import com.polaris.platform.system.vo.ModuleRoleRel;

/**
 * 模块角色关系DAO
 * 
 * @author wang.sheng
 * 
 */
@Repository
public class ModuleRoleRelDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;

	public void add(ModuleRoleRel rel)
	{
		hibernateTemplate.save(rel);
	}

	public void delete(String id)
	{
		hibernateTemplate.executeUpdate("delete from ModuleRoleRel t where t.id=?", new Object[] { id });
	}

	public void deleteByModule(String moduleId)
	{
		hibernateTemplate.executeUpdate("delete from ModuleRoleRel t where t.moduleId=?", new Object[] { moduleId });
	}

	public void deleteByRole(String roleId)
	{
		hibernateTemplate.executeUpdate("delete from ModuleRoleRel t where t.roleId=?", new Object[] { roleId });
	}

	public ModuleRoleRel[] getModuleRoleRelsByModule(String moduleId)
	{
		return hibernateTemplate.queryForArray("from ModuleRoleRel t where t.moduleId=?", new Object[] { moduleId }, ModuleRoleRel.class);
	}

	public ModuleRoleRel[] getModuleRoleRelsByRole(String roleId)
	{
		return hibernateTemplate.queryForArray("from ModuleRoleRel t where t.roleId=?", new Object[] { roleId }, ModuleRoleRel.class);
	}
}
