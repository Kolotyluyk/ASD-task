package com.sk.service;

import org.apache.shiro.subject.Subject;

public interface SecurityService {
	Subject findOutRoleOfCurrentUser(String login, String password);

}
