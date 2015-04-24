package net.shangtech.blog.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.shangtech.blog.entity.PostSeries;
import net.shangtech.framework.orm.dao.hibernate.BaseDao;

@Repository
public class PostSeriesDao extends BaseDao<PostSeries> {
	/**
	 * 查询所有的系列并以sort排序
	 * @return
	 */
	public List<PostSeries> findAllSeries(){
		return super.findAll("sort");
	}
}
