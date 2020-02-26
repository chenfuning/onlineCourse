package com.ning.pojo.BO;

import javax.persistence.*;

public class UserBO {
  
	private String userId;
	private String faceDate;
	private String nickname;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFaceDate() {
		return faceDate;
	}
	public void setFaceDate(String faceDate) {
		this.faceDate = faceDate;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}