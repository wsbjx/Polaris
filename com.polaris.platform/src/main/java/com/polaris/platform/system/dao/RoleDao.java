package com.polaris.platform.system.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.polaris.framework.common.dao.HibernateTemplate;
import com.polaris.platform.system.vo.Role;

/**
 * 角色DAO
 * 
 * @author wang.sheng
 * 
 */
@Repository
public class RoleDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;

	public void add(Role role)
	{
		hibernateTemplate.save(role);
	}

	public void update(Role role)
	{
		hibernateTemplate.update(role);
	}

	public void delete(String id)
	{
		hibernateTemplate.executeUpdate("delete from Role t where t.id=?", new Object[] { id });
	}

	public Role getRole(String id)
	{
		return hibernateTemplate.queryForObject("from Role t where t.id=?", new Object[] { id }, Role.class);
	}

	public Role getRoleByName(String name)
	{
		return hibernateTemplate.queryForObject("from Role t where t.name=?", new Object[] { name }, Role.class);
	}

	public Role[] getRoles()
	{
		return hibernateTemplate.queryForArray("from Role t order by t.name", null, Role.class);
	}

	public Role[] getUserRoles(String userId)
	{
		String hql = "from Role t where t.id in(select r.roleId from UserRoleRel r where r.userId=?)";
		return hibernateTemplate.queryForArray(hql, new Object[] { userId }, Role.class);
	}

	public Role[] getModuleRoles(String moduleId)
	{
		String hql = "from Role t where t.id in(select m.roleId from ModuleRoleRel m where m.moduleId=?)";
		return hibernateTemplate.queryForArray(hql, new Object[] { moduleId }, Role.class);
	}

	public Role[] getOtherUserRoles(String userId)
	{
		String hql = "from Role t where t.id not in(select r.roleId from UserRoleRel r where r.userId=?)";
		return hibernateTemplate.queryForArray(hql, new Object[] { userId }, Role.class);
	}

	public Role[] getOtherModuleRoles(String moduleId)
	{
		String hql = "from Role t where t.id not in(select m.roleId from ModuleRoleRel m where m.moduleId=?)";
		return hibernateTemplate.queryForArray(hql, new Object[] { moduleId }, Role.class);
	}

	public Role[] getRoles(String[] roleIds)
	{
		Session session = this.hibernateTemplate.getCurrentSession();
		List<?> list = session.createQuery("from Role t where t.id in(:roleIds)").setParameterList("roleIds", roleIds).list();
		return list.toArray(new Role[0]);
	}

	public Role[] getOtherRoles(String[] roleIds)
	{
		Session session = this.hibernateTemplate.getCurrentSession();
		List<?> list = session.createQuery("from Role t where t.id not in(:roleIds)").setParameterList("roleIds", roleIds).list();
		return list.toArray(new Role[0]);
	}
}
