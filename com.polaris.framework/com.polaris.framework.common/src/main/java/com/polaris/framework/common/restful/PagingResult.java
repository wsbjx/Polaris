package com.polaris.framework.common.restful;

/**
 * 分页页面数据结果
 * 
 * @author wang.sheng
 */
public final class PagingResult<T>
{
	private int totalCount;
	private T[] results;

	public PagingResult(int totalCount, T[] results)
	{
		this.totalCount = totalCount;
		this.results = results;
	}

	public int getTotalCount()
	{
		return totalCount;
	}

	public T[] getResults()
	{
		return results;
	}

}
