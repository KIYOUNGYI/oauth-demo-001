package com.kiyoung.security.oauthdemo001.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

//@Data
@Entity
public class Member implements Serializable {
	@Id
	@GeneratedValue
	Long id;
	String name;
	String username;
	String remark;

	public Member() {

	}

	public Member(String name, String username, String remark) {
		this.name = name;
		this.username = username;
		this.remark = remark;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", username=" + username + ", remark=" + remark + "]";
	}

}
