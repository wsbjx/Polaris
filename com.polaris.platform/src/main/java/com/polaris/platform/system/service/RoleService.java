package com.polaris.platform.system.service;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.polaris.platform.system.dao.ModuleRoleRelDao;
import com.polaris.platform.system.dao.RoleDao;
import com.polaris.platform.system.dao.UserRoleRelDao;
import com.polaris.platform.system.vo.Role;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class RoleService
{
	Log log = LogFactory.getLog(getClass());

	public static final String VISITOR_ROLE = "Visitor";

	@Resource
	private RoleDao roleDao;
	@Resource
	private UserRoleRelDao userRoleRelDao;
	@Resource
	private ModuleRoleRelDao moduleRoleRelDao;
	private boolean[] syncObject = new boolean[0];

	public Role getVisitorRole()
	{
		synchronized (syncObject)
		{
			Role visitorRole = roleDao.getRoleByName(VISITOR_ROLE);
			if (visitorRole == null)
			{
				visitorRole = new Role();
				visitorRole.setName(VISITOR_ROLE);
				visitorRole.setRemark("访客");
				roleDao.add(visitorRole);
			}
			log.info("Visitor Role,id=" + visitorRole.getId() + ",name=" + visitorRole.getName());
			return visitorRole;
		}
	}

	public Role[] getRoles(String[] roleIds)
	{
		if (roleIds == null)
		{
			log.warn("roleIds is null");
			return new Role[0];
		}
		return roleDao.getRoles(roleIds);
	}

	public Role[] getUserRoles(String userId)
	{
		return roleDao.getUserRoles(userId);
	}

	public Role[] getModuleRoles(String moduleId)
	{
		return roleDao.getModuleRoles(moduleId);
	}

	public Role[] getOtherUserRoles(String userId)
	{
		return roleDao.getOtherUserRoles(userId);
	}

	public Role[] getOtherModuleRoles(String moduleId)
	{
		return roleDao.getOtherModuleRoles(moduleId);
	}

	public Role[] getOtherRoles(String[] roleIds)
	{
		if (roleIds == null)
		{
			log.warn("roleIds is null");
			return new Role[0];
		}
		return roleDao.getOtherRoles(roleIds);
	}

	public void addRole(Role role)
	{
		if (VISITOR_ROLE.equals(role.getName()))
		{
			log.warn("addRole role name is Visitor!");
			return;
		}
		roleDao.add(role);
	}

	public void updateRole(Role role)
	{
		if (VISITOR_ROLE.equals(role.getName()))
		{
			log.warn("updateRole role name is Visitor!");
			return;
		}
		roleDao.update(role);
	}

	public void deleteRole(String id)
	{
		if (id == null || id.length() < 1)
		{
			log.warn("deleteRole id is null!");
			return;
		}
		if (id.equals(getVisitorRole().getId()))
		{
			log.warn("Visitor Role cannot delete!");
			return;
		}
		roleDao.delete(id);
		userRoleRelDao.deleteByRole(id);
		moduleRoleRelDao.deleteByRole(id);
		log.info("Role id=" + id + " deleted successful!");
	}
}
