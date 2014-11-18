package com.polaris.platform.system.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class ModuleRoleRel implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	@Column(unique = true, nullable = false, length = 32)
	private String id;
	@Column(nullable = false, length = 32)
	private String moduleId;
	@Column(nullable = false, length = 32)
	private String roleId;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getModuleId()
	{
		return moduleId;
	}

	public void setModuleId(String moduleId)
	{
		this.moduleId = moduleId;
	}

	public String getRoleId()
	{
		return roleId;
	}

	public void setRoleId(String roleId)
	{
		this.roleId = roleId;
	}

}
