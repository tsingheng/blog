package net.shangtech.blog.service;

import java.util.List;

import net.shangtech.blog.dao.PostDao;
import net.shangtech.blog.dao.dto.PostTitleDto;
import net.shangtech.blog.entity.Post;
import net.shangtech.framework.orm.service.BaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PostService extends BaseService<Post> {

	@Autowired private PostDao dao;
	
	public List<PostTitleDto> findBySeriesId(Long seriesId){
		return dao.findBySeries(seriesId);
	}
	
	public Post findByCode(String code){
		return dao.findByCode(code);
	}
}
