package com.polaris.platform.toolkit.vo;

import java.sql.Clob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 大文本内容
 * 
 * @author wang.sheng
 * 
 */
@Entity
@Table
public class ClobContent
{
	@Id
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(generator = "system-uuid")
	@Column(length = 32)
	private String id;
	@Column
	private Clob content;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public Clob getContent()
	{
		return content;
	}

	public void setContent(Clob content)
	{
		this.content = content;
	}

}
