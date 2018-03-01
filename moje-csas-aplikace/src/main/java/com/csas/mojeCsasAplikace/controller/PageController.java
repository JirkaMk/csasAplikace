package com.csas.mojeCsasAplikace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value = { "", "/home", "/index" }) // vsechno s timhle URL pujde pres tuhle metodu
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("page"); // dispatcher-servlet preklada na page.jsp
		mv.addObject("greeting", "Welcome to Spring Web MVC");
		return mv;
	}

/*	@RequestMapping(value = "/test2")
	// RequesParam prisuzuje URL parameter, ktery je diky required false promenne nepovinny
	public ModelAndView test2(@RequestParam(value = "greeting", required = false) String greeting) {
		
		if (greeting == null) {
			greeting = "Hello there.";
		}

		ModelAndView mv = new ModelAndView("page"); // dispatcher-servlet preklada na page.jsp
		mv.addObject("greeting", greeting); // predavam modelview promennou greeting
		return mv;
	}
}*/
	
	@RequestMapping(value = "/test/{greeting}")
	// PathVariable prisuzuje cast URL hodnotu promenne 
	public ModelAndView test(@PathVariable("greeting") String pathVariableExample) {
		
		if (pathVariableExample == null) {
			pathVariableExample = "Hello there.";
		}

		ModelAndView mv = new ModelAndView("page"); // dispatcher-servlet preklada na page.jsp
		mv.addObject("greeting", pathVariableExample); // predavam modelview promennou greeting
		return mv;
	}
}

