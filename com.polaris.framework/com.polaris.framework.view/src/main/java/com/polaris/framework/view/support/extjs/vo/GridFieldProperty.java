package com.polaris.framework.view.support.extjs.vo;

/**
 * Grid字段属性
 * 
 * @author wang.sheng
 * 
 */
public class GridFieldProperty
{
	private String header;
	private Integer width;
	private String dataIndex;
	private String input;
	private Boolean sortable;
	private Integer flex;

	public String getHeader()
	{
		return header;
	}

	public void setHeader(String header)
	{
		this.header = header;
	}

	public Integer getWidth()
	{
		return width;
	}

	public void setWidth(Integer width)
	{
		this.width = width;
	}

	public String getDataIndex()
	{
		return dataIndex;
	}

	public void setDataIndex(String dataIndex)
	{
		this.dataIndex = dataIndex;
	}

	public String getInput()
	{
		return input;
	}

	public void setInput(String input)
	{
		this.input = input;
	}

	public Boolean getSortable()
	{
		return sortable;
	}

	public void setSortable(Boolean sortable)
	{
		this.sortable = sortable;
	}

	public Integer getFlex()
	{
		return flex;
	}

	public void setFlex(Integer flex)
	{
		this.flex = flex;
	}

}
