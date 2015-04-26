package net.shangtech.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.shangtech.blog.dao.PostSeriesDao;
import net.shangtech.blog.entity.PostSeries;
import net.shangtech.framework.orm.service.BaseService;

@Service
@Transactional
public class PostSeriesService extends BaseService<PostSeries> {

	@Autowired private PostSeriesDao dao;
	
	public List<PostSeries> findAllSeries(){
		return dao.findAllSeries();
	}
	
	public void updateSeries(PostSeries series){
		PostSeries old = dao.find(series.getId());
		old.setCode(series.getCode());
		old.setName(series.getName());
		old.setSort(series.getSort());
		dao.update(old);
	}
}
