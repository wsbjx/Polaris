package com.polaris.platform.system.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.polaris.framework.common.hibernate.HibernateTemplate;
import com.polaris.platform.system.vo.User;

/**
 * 用户DAO
 * 
 * @author wang.sheng
 */
@Repository
public class UserDao
{
	@Resource
	private HibernateTemplate hibernateTemplate;

	public User getUser(String id)
	{
		return hibernateTemplate.queryForObject("from User t where t.id=?", new Object[] { id }, User.class);
	}

	public User[] getUsers()
	{
		return hibernateTemplate.queryForArray("from User t order by t.username", null, User.class);
	}

	public User getUserByUsername(String username)
	{

		return hibernateTemplate.queryForObject("from User t where t.username=?", new Object[] { username }, User.class);
	}

	public void add(User user)
	{
		hibernateTemplate.save(user);
	}

	public void update(User user)
	{
		hibernateTemplate.executeUpdate("update User set name=?,remark=? where id=?",
				new Object[] { user.getName(), user.getRemark(), user.getId() });
	}

	public void delete(String id)
	{
		hibernateTemplate.executeUpdate("delete from User t where t.id=?", new Object[] { id });
	}

	public void updatePassword(String id, String password)
	{

		hibernateTemplate.executeUpdate("update User set password=? where id=?", new Object[] { password, id });
	}

}
