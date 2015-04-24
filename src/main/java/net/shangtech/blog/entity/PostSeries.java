package net.shangtech.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.shangtech.framework.orm.dao.support.BaseEntity;

/**
 * 文章系列
 * @author xiangheng.song
 *
 */
@Entity
@Table(name = "t_post_series")
public class PostSeries extends BaseEntity<Long> {

	private static final long serialVersionUID = -7010442362605608472L;

	/** 分类名称 */
	@Column(name = "name")
	private String name;
	
	/** 排序 */
	@Column(name = "sort")
	private Integer sort;
	
	/** 编码 */
	@Column(name = "code")
	private String code;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
