package com.polaris.platform.system.service;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.polaris.platform.system.dao.ModuleDao;
import com.polaris.platform.system.dao.ModuleRoleRelDao;
import com.polaris.platform.system.vo.Module;
import com.polaris.platform.system.vo.ModuleRoleRel;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ModuleService
{
	Log log = LogFactory.getLog(getClass());
	@Resource
	private ModuleDao moduleDao;
	@Resource
	private ModuleRoleRelDao moduleRoleRelDao;

	public void addModule(Module module)
	{
		moduleDao.add(module);
	}

	public Module getModule(String id)
	{
		return moduleDao.getModule(id);
	}

	public void updateModule(Module module)
	{
		moduleDao.update(module);
	}

	public Module[] getModules()
	{
		return moduleDao.getModules();
	}

	public Module[] getModulesByRoles(String[] roleIds)
	{
		return moduleDao.getModulesByRoles(roleIds);
	}

	public void deleteModule(String id)
	{
		moduleDao.delete(id);
		moduleRoleRelDao.deleteByModule(id);
	}

	public void updateModuleRoles(String moduleId, String[] roleIds)
	{
		if (roleIds == null)
		{
			log.warn("roleIds is null!");
			return;
		}
		Module module = moduleDao.getModule(moduleId);
		if (module == null)
		{
			log.warn("Module id=" + moduleId + " not found!");
			return;
		}
		moduleRoleRelDao.deleteByModule(moduleId);
		for (String roleId : roleIds)
		{
			ModuleRoleRel rel = new ModuleRoleRel();
			rel.setModuleId(moduleId);
			rel.setRoleId(roleId);
			moduleRoleRelDao.add(rel);
		}
		log.info("Module name=" + module.getTitle() + " roles updated successful!");
	}

	public Set<String> getRolesByModule(String moduleId)
	{
		Set<String> set = new HashSet<String>();
		ModuleRoleRel[] rels = moduleRoleRelDao.getModuleRoleRelsByModule(moduleId);
		for (ModuleRoleRel rel : rels)
		{
			if (!set.contains(rel.getRoleId()))
			{
				set.add(rel.getRoleId());
			}
		}
		return set;
	}

}
