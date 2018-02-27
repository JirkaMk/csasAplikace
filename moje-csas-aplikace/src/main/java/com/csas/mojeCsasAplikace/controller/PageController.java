package com.csas.mojeCsasAplikace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value = { "", "/home", "/index" }) //vsechno s timhle URL pujde pres tuhle metodu
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page"); // dispatcher-servlet preklada na page.jsp
        mv.addObject("greeting", "Welcome to Spring Web MVC");
		return mv;
	}
}