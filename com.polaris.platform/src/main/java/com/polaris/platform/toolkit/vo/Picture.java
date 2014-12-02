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
	 * 所在的目录ID
	 */
	@Column(length = 50)
	private String folderId;
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
	 * 图片宽度
	 */
	@Column(length = 4)
	private Integer width;
	/**
	 * 图片高度
	 */
	@Column(length = 4)
	private Integer height;
	/**
	 * 备注信息
	 */
	@Column(length = 200)
	private String remark;
	/**
	 * 二进制内容的ID
	 */
	@Column(length = 32, nullable = false)
	private String blobId;

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

	public String getBlobId()
	{
		return blobId;
	}

	public void setBlobId(String blobId)
	{
		this.blobId = blobId;
	}

	public String getFolderId()
	{
		return folderId;
	}

	public void setFolderId(String folderId)
	{
		this.folderId = folderId;
	}

	public Integer getWidth()
	{
		return width;
	}

	public void setWidth(Integer width)
	{
		this.width = width;
	}

	public Integer getHeight()
	{
		return height;
	}

	public void setHeight(Integer height)
	{
		this.height = height;
	}

}
