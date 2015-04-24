package net.shangtech.blog.dao.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

/**
 * 保存文章标题时间等字段，不包含内容
 * @author xiangheng.song
 *
 */
public class PostTitleDto implements Serializable {

	private static final long serialVersionUID = -7708401856794975429L;
	
	/** 编码,url */
	@Column(name = "code")
	private String code;
	
	/** 标题 */
	@Column(name = "title")
	private String title;
	
	/** 创建时间 */
	@Column(name = "create_time")
	private Date createTime;

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
	
}
