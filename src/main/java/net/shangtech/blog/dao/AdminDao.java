package net.shangtech.blog.dao;

import org.springframework.stereotype.Repository;

import net.shangtech.blog.entity.Admin;
import net.shangtech.framework.orm.dao.hibernate.BaseDao;

@Repository
public class AdminDao extends BaseDao<Admin> {
	/**
	 * 根据用户名查询用户
	 * @param username
	 * @return
	 */
	public Admin findByUsername(String username){
		return findOneByProperty("username", username);
	}
}
