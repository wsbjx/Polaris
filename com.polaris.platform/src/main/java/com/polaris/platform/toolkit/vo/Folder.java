package com.polaris.platform.toolkit.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 表示一个文件夹
 * 
 * @author wang.sheng
 * 
 */
@Entity
@Table
public class Folder
{
	/**
	 * 表示图片目录
	 */
	public static final Integer PICTURE_FOLDER = 1;
	/**
	 * 表示文章目录
	 */
	public static final Integer ARTICLE_FOLDER = 2;

	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	@Column(length = 32)
	private String id;
	@Column(length = 4)
	private Integer type;
	@Column(length = 32)
	private String parentId;
	@Column(length = 50)
	private String name;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getParentId()
	{
		return parentId;
	}

	public void setParentId(String parentId)
	{
		this.parentId = parentId;
	}

	public String getName()
	{
		return name;
	}

	public Integer getType()
	{
		return type;
	}

	public void setType(Integer type)
	{
		this.type = type;
	}

	public void setName(String name)
	{
		this.name = name;
	}

}
