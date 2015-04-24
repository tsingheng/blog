package net.shangtech.blog.dao;

import java.util.List;

import net.shangtech.blog.dao.dto.PostTitleDto;
import net.shangtech.blog.entity.Post;
import net.shangtech.framework.orm.dao.hibernate.BaseDao;
import net.shangtech.framework.orm.dao.support.MapHolder;

import org.springframework.stereotype.Repository;

@Repository
public class PostDao extends BaseDao<Post> {
	public List<PostTitleDto> findBySeries(Long seriesId){
		MapHolder<String> holder = new MapHolder<String>();
		holder.put("seriesId", seriesId);
		return findBySql("PostTitleDto.findBySeries", holder, PostTitleDto.class);
	}
	
	public Post findByCode(String code){
		return findOneByProperty("code", code);
	}
}
