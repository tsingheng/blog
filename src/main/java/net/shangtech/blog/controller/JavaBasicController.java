package net.shangtech.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/java-basic")
public class JavaBasicController {
	
	@RequestMapping("/")
	public String list(Model model){
		return page("list", model);
	}
	
	@RequestMapping("/{page}")
	public String page(@PathVariable String page, Model model){
		model.addAttribute("menu", "java-basic");
		return "blog.java.basic." + page;
	}
	
}
