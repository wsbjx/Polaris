package com.polaris.platform.system.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

/**
 * 模块定义
 * 
 * @author wang.sheng
 */
@Entity
@Table
public class Module implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	@Column(unique = true, nullable = false, length = 32)
	private String id;
	@Column(nullable = false, length = 50)
	@Length(max = 50)
	private String title;
	@Column(nullable = false, length = 200)
	@Length(max = 200)
	private String url;
	@Column(nullable = false, length = 32)
	private String bigIconId;
	@Column(nullable = false, length = 32)
	private String smallIconId;
	@Column(length = 200)
	@Length(max = 200)
	private String remark;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getBigIconId()
	{
		return bigIconId;
	}

	public void setBigIconId(String bigIconId)
	{
		this.bigIconId = bigIconId;
	}

	public String getSmallIconId()
	{
		return smallIconId;
	}

	public void setSmallIconId(String smallIconId)
	{
		this.smallIconId = smallIconId;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

}
