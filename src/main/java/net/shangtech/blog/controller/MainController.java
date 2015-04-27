package net.shangtech.blog.controller;

import net.shangtech.blog.entity.Post;
import net.shangtech.blog.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@Autowired private PostService postService;
	
	/**
	 * 博客首页
	 * @return
	 */
	@RequestMapping("/")
	public String index(){
		return "blog.index";
	}
	
	/**
	 * java-basic系列
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping("/java-basic/{page}")
	public String javaBasic(@PathVariable String page, Model model){
		model.addAttribute("menu", "java-basic");
		
		Post post = postService.findByCode("java-basic/" + page);
		model.addAttribute("post", post);
		return "blog.java.basic";
	}
}
