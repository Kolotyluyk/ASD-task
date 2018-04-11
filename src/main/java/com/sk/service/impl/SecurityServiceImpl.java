package com.sk.service.impl;

import com.sk.service.SecurityService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class SecurityServiceImpl implements SecurityService {
	@Override
	public Subject findOutRoleOfCurrentUser(String login, String password) {

		Factory<SecurityManager> factory = new IniSecurityManagerFactory("shiro.ini");

		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);

		Subject user = SecurityUtils.getSubject();

		return user;
	}

}
