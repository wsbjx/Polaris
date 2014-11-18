package com.polaris.platform.system.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.polaris.framework.common.dao.HibernateTemplate;
import com.polaris.platform.system.vo.UserRoleRel;

/**
 * 用户角色关联
 * 
 * @author wang.sheng
 * 
 */
@Repository
public class UserRoleRelDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;

	public void add(UserRoleRel rel)
	{
		hibernateTemplate.save(rel);
	}

	public void delete(String id)
	{
		hibernateTemplate.executeUpdate("delete from UserRoleRel t where t.id=?", new Object[] { id });
	}

	public void deleteByUser(String userId)
	{
		hibernateTemplate.executeUpdate("delete from UserRoleRel t where t.userId=?", new Object[] { userId });
	}

	public void deleteByRole(String roleId)
	{
		hibernateTemplate.executeUpdate("delete from UserRoleRel t where t.roleId=?", new Object[] { roleId });
	}

	public UserRoleRel[] getUserRoleRelsByUser(String userId)
	{
		return hibernateTemplate.queryForArray("from UserRoleRel t where t.userId=?", new Object[] { userId }, UserRoleRel.class);
	}

	public UserRoleRel[] getUserRoleRelsByRole(String roleId)
	{
		return hibernateTemplate.queryForArray("from UserRoleRel t where t.roleId=?", new Object[] { roleId }, UserRoleRel.class);
	}
}
