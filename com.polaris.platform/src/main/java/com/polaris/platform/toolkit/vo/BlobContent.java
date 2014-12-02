package com.polaris.platform.toolkit.vo;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 二进制的内容
 * 
 * @author wang.sheng
 * 
 */
@Entity
@Table
public class BlobContent
{
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	@Column(length = 32)
	private String id;
	@Column
	private Blob content;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public Blob getContent()
	{
		return content;
	}

	public void setContent(Blob content)
	{
		this.content = content;
	}

}
