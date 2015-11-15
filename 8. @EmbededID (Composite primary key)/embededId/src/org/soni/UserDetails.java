package org.soni;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class UserDetails {
	@EmbeddedId
	private PrimaryKey userKey;
	private String userName;
	
	public PrimaryKey getUserKey() {
		return userKey;
	}
	public void setUserKey(PrimaryKey userKey) {
		this.userKey = userKey;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
