package net.shangtech.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

import net.shangtech.framework.orm.dao.support.BaseEntity;

@Entity
@Table(name = "t_admin")
public class Admin extends BaseEntity<Long> {

	private static final long serialVersionUID = 2559214163210068728L;

	@Column(name = "username")
	@Index(name = "idx_admin_username")
	private String username;
	
	@Column(name = "password")
	private String passwrod;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswrod() {
		return passwrod;
	}

	public void setPasswrod(String passwrod) {
		this.passwrod = passwrod;
	}
	
}
