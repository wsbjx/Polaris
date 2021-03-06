package com.polaris.platform.system.service;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.polaris.framework.common.security.SecurityService;
import com.polaris.platform.system.dao.UserDao;
import com.polaris.platform.system.dao.UserRoleRelDao;
import com.polaris.platform.system.vo.User;
import com.polaris.platform.system.vo.UserRoleRel;

/**
 * 用户管理
 * 
 * @author wang.sheng
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserService
{
	Log log = LogFactory.getLog(getClass());
	private User superUser;
	public static final String SUPER_USER = "admin";
	@Resource
	private UserDao userDao;
	@Resource
	private UserRoleRelDao userRoleRelDao;
	@Resource
	private SecurityService securityService;

	private boolean[] syncObject = new boolean[0];

	public User getSuperUser()
	{
		if (superUser != null)
		{
			return superUser;
		}
		synchronized (syncObject)
		{
			if (superUser == null)
			{
				superUser = userDao.getUserByUsername(SUPER_USER);
				if (superUser == null)
				{
					superUser = new User();
					superUser.setUsername(SUPER_USER);
					superUser.setPassword(securityService.encrypt("admin"));
					superUser.setRemark("超级用户");
					superUser.setName("超级用户");
					userDao.add(superUser);
				}
			}
			return superUser;
		}
	}

	public boolean isSuperUser(String userId)
	{
		User user = getSuperUser();
		return StringUtils.equals(userId, user.getId());
	}

	public Set<String> getRoleSetByUser(String userId)
	{
		Set<String> set = new HashSet<String>();
		UserRoleRel[] rels = userRoleRelDao.getUserRoleRelsByUser(userId);
		for (UserRoleRel rel : rels)
		{
			if (!set.contains(rel.getRoleId()))
			{
				set.add(rel.getRoleId());
			}
		}
		return set;
	}

	/**
	 * 登录操作.如果登录成功则返回用户信息,否则抛出异常
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public User login(String username, String password) throws Exception
	{
		User u = userDao.getUserByUsername(username);
		if (u != null)
		{
			String str = securityService.decrypt(u.getPassword());
			if (StringUtils.equals(str, password))
			{
				log.info("username=" + username + " login successful!");
				return u;
			}
		}
		throw new Exception("登录失败,用户不存在或者密码错误!");
	}

	public void addUsers(User[] users) throws Exception
	{
		for (User user : users)
		{
			addUser(user);
		}
	}

	public void addUser(User user)
	{
		User u = userDao.getUserByUsername(user.getUsername());
		if (u != null)
		{
			throw new RuntimeException("用户名已被占用:" + user.getUsername());
		}
		// 首次添加用户,以用户名作为密码
		user.setPassword(user.getUsername());
		// 对密码进行AES加密
		user.setPassword(securityService.encrypt(user.getPassword()));
		userDao.add(user);
	}

	public void modifyPassword(String userId, String oldPassword, String newPassword)
	{
		User u = userDao.getUser(userId);
		if (u != null)
		{
			String str = securityService.decrypt(u.getPassword());
			if (StringUtils.equals(str, oldPassword))
			{
				userDao.updatePassword(userId, securityService.encrypt(newPassword));
				log.info("username=" + u.getUsername() + " password modify successful!");
				return;
			}
		}
		else
		{
			throw new RuntimeException("用户不存在或者老密码验证失败!");
		}
	}

	public void updateUserRoles(String userId, String[] roleIds)
	{
		if (roleIds == null)
		{
			log.warn("roleIds is null!");
			return;
		}
		User u = userDao.getUser(userId);
		if (u == null)
		{
			throw new RuntimeException("用户不存在!");
		}
		userRoleRelDao.deleteByUser(userId);
		for (String roleId : roleIds)
		{
			UserRoleRel rel = new UserRoleRel();
			rel.setRoleId(roleId);
			rel.setUserId(userId);
			userRoleRelDao.add(rel);
		}
		log.info("username=" + u.getUsername() + " roles updated successful!");
	}

	public User getUser(String userId)
	{
		return userDao.getUser(userId);
	}

	public User[] getUsers()
	{
		return userDao.getUsers();
	}

	public void update(User[] users)
	{
		for (User user : users)
		{
			userDao.update(user);
		}
	}

	public void update(User user)
	{
		userDao.update(user);
	}

	public void delete(String id)
	{
		User u = userDao.getUser(id);
		if (u == null)
		{
			log.warn("User id=" + id + " is not exists!");
			return;
		}
		if (u.getUsername().equals(SUPER_USER))
		{
			log.warn("Super user cannot delete!");
			return;
		}
		userDao.delete(id);
		userRoleRelDao.deleteByUser(id);
	}
}
