package net.shangtech.blog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

import net.shangtech.framework.orm.dao.support.BaseEntity;

/**
 * 文章
 * @author xiangheng.song
 *
 */
@Entity
@Table(name = "t_post")
public class Post extends BaseEntity<Long> {

	private static final long serialVersionUID = -6532017630071858011L;

	/** 编码,url */
	@Column(name = "code")
	@Index(name = "idx_post_code")
	private String code;
	
	/** 标题 */
	@Column(name = "title")
	private String title;
	
	/** 创建时间 */
	@Column(name = "create_time")
	private Date createTime;
	
	/** 排序 */
	@Column(name = "sort")
	private Integer sort;
	
	/** 正文 */
	@Lob
	@Column(name = "content")
	private String content;
	
	/** 所属系列  */
	@Column(name = "series_id")
	@Index(name = "idx_post_series_id")
	private Long seriesId;
	
	@Column(name = "seo_title")
	private String seoTitle;
	
	@Column(name = "seo_keywords")
	private String seoKeywords;
	
	@Column(name = "seo_description")
	private String seoDescription;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getSeriesId() {
		return seriesId;
	}

	public void setSeriesId(Long seriesId) {
		this.seriesId = seriesId;
	}

	public String getSeoTitle() {
		return seoTitle;
	}

	public void setSeoTitle(String seoTitle) {
		this.seoTitle = seoTitle;
	}

	public String getSeoKeywords() {
		return seoKeywords;
	}

	public void setSeoKeywords(String seoKeywords) {
		this.seoKeywords = seoKeywords;
	}

	public String getSeoDescription() {
		return seoDescription;
	}

	public void setSeoDescription(String seoDescription) {
		this.seoDescription = seoDescription;
	}
	
}
