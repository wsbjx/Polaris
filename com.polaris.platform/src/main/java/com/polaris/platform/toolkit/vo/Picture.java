package com.polaris.platform.toolkit.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 图片表建模
 * 
 * @author wang.sheng
 * 
 */
@Entity
@Table
public class Picture
{
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	@Column(length = 32)
	private String id;
	/**
	 * 图片标题
	 */
	@Column(length = 50)
	private String title;
	/**
	 * 创建日期
	 */
	@Column(length = 8)
	private Date createDate;
	/**
	 * 修改日期
	 */
	@Column(length = 8)
	private Date modifyDate;
	/**
	 * 备注信息
	 */
	@Column(length = 200)
	private String remark;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public Date getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public Date getModifyDate()
	{
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate)
	{
		this.modifyDate = modifyDate;
	}

}
