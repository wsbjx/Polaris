package com.polaris.platform.authorized.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.polaris.platform.authorized.vo.AuthorizedAccount;
import com.polaris.platform.system.dao.ModuleDao;
import com.polaris.platform.system.service.ModuleService;
import com.polaris.platform.system.service.RoleService;
import com.polaris.platform.system.service.UserService;
import com.polaris.platform.system.vo.Module;
import com.polaris.platform.system.vo.User;

/**
 * 系统授权服务
 * 
 * @author wang.sheng
 */
@Service
public class AuthorizedService
{
	Log log = LogFactory.getLog(getClass());
	private Map<String, HttpSession> sessionMap = new HashMap<String, HttpSession>();
	@Resource
	private UserService userService;
	@Resource
	private ModuleService moduleService;
	@Resource
	private ModuleDao moduleDao;
	private boolean[] syncObject = new boolean[0];

	/**
	 * 用户主动退出
	 * 
	 * @param session
	 */
	public void logout(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		AuthorizedAccount account = (AuthorizedAccount) session.getAttribute(AuthorizedAccount.HTTP_SESSION_KEY);
		session.removeAttribute(AuthorizedAccount.HTTP_SESSION_KEY);
		if (account == null || account.getUserId() == null)
		{
			// 无账户,或者为游客账户则无需做处理
			return;
		}
		log.info("logout username=" + account.getUserName());
		account.setIpAddress(request.getRemoteAddr());
		account.setLoginTime(System.currentTimeMillis());
		account.setName("游客");
		account.setUserName(RoleService.VISITOR_ROLE);
		account.setUserId(null);
		session.setAttribute(AuthorizedAccount.HTTP_SESSION_KEY, account);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Module findModuleByURL(String url)
	{
		if (url == null || url.length() < 1)
		{
			return null;
		}
		if (url.startsWith("http://"))
		{
			return null;
		}
		if (url.indexOf(".html") < 0)
		{
			url += ".html";
		}
		return moduleDao.findModuleByURL(url);
	}

	/**
	 * 检查模块的授权情况,禁止出现非授权的访问
	 * 
	 * @param account
	 * @param module
	 * @throws AuthorizedException
	 */
	public void checkModuleAuthority(AuthorizedAccount account, Module module) throws AuthorizedException
	{
		if (account == null)
		{
			// 授权账户没有建立,是一种非法的情况
			throw new AuthorizedException(null, "授权账户没有建立,禁止访问!");
		}
		if (module == null)
		{
			// 模块不在验证序列中,取消验证过程
			return;
		}
		if (!checkAuthority(module.getId(), account.getUserId()))
		{
			throw new AuthorizedException(module.getId(), "受到权限限制,禁止访问!");
		}
	}

	/**
	 * 检查权限,指定用户对于指定模块是否具备权限
	 * 
	 * @param moduleId
	 * @param userId
	 * @return
	 */
	private boolean checkAuthority(String moduleId, String userId)
	{
		if (userService.isSuperUser(userId))
		{
			// 如果是超级用户,则直接返回true
			return true;
		}
		Set<String> moduleRoleSet = moduleService.getRolesByModule(moduleId);
		Set<String> userRoleSet = userService.getRoleSetByUser(userId);
		// 如果两个集合无交集则无权限
		return !Collections.disjoint(moduleRoleSet, userRoleSet);
	}

	/**
	 * 用户登录<br>
	 * 
	 * @param session
	 * @param user
	 */
	public void login(HttpSession session, User user, String ipAddress)
	{
		AuthorizedAccount account = (AuthorizedAccount) session.getAttribute(AuthorizedAccount.HTTP_SESSION_KEY);
		if (account == null)
		{
			// 这种情况不大可能发生
			account = new AuthorizedAccount();
			session.setAttribute(AuthorizedAccount.HTTP_SESSION_KEY, account);
		}
		account.setIpAddress(ipAddress);
		account.setLoginTime(System.currentTimeMillis());
		account.setName(user.getName());
		account.setUserId(user.getId());
		account.setUserName(user.getUsername());
	}

	/**
	 * 获取当前在线的所有账户
	 * 
	 * @return
	 */
	public AuthorizedAccount[] getAllOnlineAccount()
	{
		List<AuthorizedAccount> list = new ArrayList<AuthorizedAccount>();
		synchronized (syncObject)
		{
			for (Map.Entry<String, HttpSession> entry : sessionMap.entrySet())
			{
				HttpSession session = entry.getValue();
				AuthorizedAccount account = (AuthorizedAccount) session.getAttribute(AuthorizedAccount.HTTP_SESSION_KEY);
				if (account != null)
				{
					list.add(account);
				}
			}
		}
		return list.toArray(new AuthorizedAccount[0]);
	}

	/**
	 * 会话被创建
	 * 
	 * @param session
	 */
	public void sessionCreated(HttpSession session)
	{
		String sessionId = session.getId();
		log.info("sessionCreated sessionId=" + sessionId);
		synchronized (syncObject)
		{
			sessionMap.put(sessionId, session);
		}
	}

	/**
	 * 会话被注销
	 * 
	 * @param session
	 */
	public void sessionDestroyed(HttpSession session)
	{
		String sessionId = session.getId();
		log.info("sessionDestroyed sessionId=" + sessionId);
		synchronized (syncObject)
		{
			sessionMap.remove(sessionId);
		}
	}
}
