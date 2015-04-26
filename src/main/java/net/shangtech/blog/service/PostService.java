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
	
	public void updatePost(Post post){
		Post old = dao.find(post.getId());
		old.setCode(post.getCode());
		old.setContent(post.getContent());
		old.setSort(post.getSort());
		old.setTitle(post.getTitle());
		old.setSeoDescription(post.getSeoDescription());
		old.setSeoKeywords(post.getSeoKeywords());
		old.setSeoTitle(post.getSeoTitle());
		dao.update(old);
	}
}
