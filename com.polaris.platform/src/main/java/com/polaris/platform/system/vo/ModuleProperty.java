package com.polaris.platform.system.vo;

public class ModuleProperty
{
	private String id;
	private String name;
	private String jsFile;
	private String[] roles;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getJsFile()
	{
		return jsFile;
	}

	public void setJsFile(String jsFile)
	{
		this.jsFile = jsFile;
	}

	public String[] getRoles()
	{
		return roles;
	}

	public void setRoles(String[] roles)
	{
		this.roles = roles;
	}

}
