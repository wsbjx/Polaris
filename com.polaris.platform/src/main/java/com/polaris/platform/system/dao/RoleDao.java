package com.polaris.platform.system.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.polaris.framework.common.hibernate.HibernateTemplate;
import com.polaris.platform.system.vo.Role;

/**
 * Role表对应的DAO
 * 
 * @author wang.sheng
 * 
 */
@Repository
public class RoleDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;

	public Role[] getRoles()
	{
		return hibernateTemplate.queryForArray("from Role t order by t.name", null, Role.class);
	}

	public Role getRole(String id)
	{
		return hibernateTemplate.queryForObject("from Role t where t.id=?", new Object[] { id }, Role.class);
	}

	public void update(Role role)
	{
		hibernateTemplate.update(role);
	}

	public void insert(Role role)
	{
		hibernateTemplate.save(role);
	}

	public void delete(String id)
	{
		hibernateTemplate.executeUpdate("delete from Role t where t.id=?", new Object[] { id });
	}
}
