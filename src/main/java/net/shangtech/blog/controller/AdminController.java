package net.shangtech.blog.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.shangtech.blog.dao.dto.PostTitleDto;
import net.shangtech.blog.entity.Admin;
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
import org.springframework.web.bind.annotation.RequestParam;
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
	public AjaxResponse login(@RequestParam String username, @RequestParam String password, HttpServletRequest request){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		Admin admin = adminService.findByUsername(username);
		if(admin == null || !password.equals(admin.getPasswrod())){
			ajaxResponse.addError("password", "账号或密码错误");
			return ajaxResponse;
		}
		request.getSession().setAttribute("LOGIN_ADMIN", admin);
		ajaxResponse.setSuccess(true);
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
		List<PostSeries> seriesList = seriesService.findAllSeries();
		model.addAttribute("seriesList", seriesList);
		
		if(seriesId != null){
			List<PostTitleDto> postList = postService.findBySeriesId(seriesId);
			model.addAttribute("postList", postList);
			PostSeries series = seriesService.find(seriesId);
			model.addAttribute("series", series);
			model.addAttribute("seriesId", seriesId);
		}
		return "blog.admin.series";
	}
	
	/**
	 * 分类编辑表单
	 * @param id
	 * @return
	 */
	@RequestMapping("/series/form")
	public String seriesForm(Long id, Model model){
		if(id != null){
			PostSeries series = seriesService.find(id);
			model.addAttribute("series", series);
		}
		return "blog.admin.series.form";
	}
	
	/**
	 * 保存分类
	 * @param series
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/series/save", method = RequestMethod.POST)
	public AjaxResponse saveSeries(PostSeries series){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		if(series.getId() == null){
			seriesService.save(series);
		}else{
			seriesService.updateSeries(series);
		}
		ajaxResponse.setSuccess(true);
		return ajaxResponse;
	}
	
	/**
	 * 文章编辑页面
	 * @param model
	 * @param code
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/post")
	public Post post(Long id){
		Post post = postService.find(id);
		return post;
	}
	
	@ResponseBody
	@RequestMapping(value = "/post/save", method = RequestMethod.POST)
	public AjaxResponse savePost(Post post){
		AjaxResponse ajaxResponse = AjaxResponse.instance();
		if(post.getId() == null){
			post.setCreateTime(new Date());
			postService.save(post);
		}else{
			postService.updatePost(post);
		}
		ajaxResponse.setSuccess(true);
		return ajaxResponse;
	}
}
