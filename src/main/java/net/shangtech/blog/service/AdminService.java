package net.shangtech.blog.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.shangtech.blog.dao.AdminDao;
import net.shangtech.blog.entity.Admin;
import net.shangtech.framework.orm.service.BaseService;

@Service
@Transactional
public class AdminService extends BaseService<Admin> {
	
	@Autowired private AdminDao dao;
	
	public Admin findByUsername(String username){
		return dao.findByUsername(username);
	}
}
