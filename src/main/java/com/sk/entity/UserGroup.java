package com.sk.entity;

public class UserGroup {
	private Integer id;
	private String groupName;

	public UserGroup() {
	}

	public UserGroup(Integer id, String groupName) {

		this.id = id;
		this.groupName = groupName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
