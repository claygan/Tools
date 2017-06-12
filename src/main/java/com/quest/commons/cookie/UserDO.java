package com.quest.commons.cookie;

/**
 * @Title: UserDO.java
 * @Package com.gexin.platform.web.module.manager.config.cookie
 * @Description: cookie实体
 * @author Administrator
 * @date 2011-11-24 下午1:19:46
 * @version V1.0
 */
public class UserDO {

	public UserDO() {

	}

	public UserDO(long userId, String username, String password) {
		//
		this.userId = userId;
		this.username = username;
		this.password = password;
	}

	private long userId;

	private String username;

	private String password;

	private long groupId;

	private String groupName;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
