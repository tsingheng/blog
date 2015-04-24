package net.shangtech.blog.controller;

import net.shangtech.blog.entity.Post;
import net.shangtech.blog.entity.PostSeries;
import net.shangtech.blog.service.AdminService;
import net.shangtech.blog.service.PostSeriesService;
import net.shangtech.blog.service.PostService;
import net.shangtech.framework.web.controller.AjaxResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired private PostService postService;
	@Autowired private PostSeriesService seriesService;
	@Autowired private AdminService adminService;
	
	/**
	 * 登录页面
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(){
		return "blog.admin.login";
	}
	
	/**
	 * ajax登录
	 * @param username
	 * @param password
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public AjaxResponse login(String username, String password){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		
		return ajaxResponse;
	}
	
	/**
	 * 管理主界面
	 * @param model
	 * @return
	 */
	@RequestMapping("/main")
	public String main(Model model){
		
		return "blog.admin.main";
	}
	
	/**
	 * 文章分类列表页
	 * @param model
	 * @return
	 */
	@RequestMapping("/series")
	public String series(Model model, Long seriesId){
		return "blog.admin.series";
	}
	
	/**
	 * 分类编辑表单
	 * @param id
	 * @return
	 */
	@RequestMapping("/series/form")
	public String seriesForm(Long id){
		return "blog.admin.series.form";
	}
	
	/**
	 * 保存分类
	 * @param series
	 * @return
	 */
	@RequestMapping(value = "/series/save", method = RequestMethod.GET)
	public AjaxResponse saveSeries(PostSeries series){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		
		return ajaxResponse;
	}
	
	/**
	 * 文章编辑页面
	 * @param model
	 * @param code
	 * @return
	 */
	@RequestMapping("/post")
	public String post(Model model, Long id){
		
		return "blog.admin.post";
	}
	
	@RequestMapping(value = "/post/save", method = RequestMethod.POST)
	public AjaxResponse savePost(Post post){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		
		return ajaxResponse;
	}
}
