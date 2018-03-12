package com.csas.mojeCsasAplikace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.csas.moje_csas_aplikace_backend.dao.CategoryDao;
import com.csas.moje_csas_aplikace_backend.dto.Category;

@Controller
public class PageController {

    // Spring se postara uz o instanci tehle kategorie sam, nic nevytvarim	
	@Autowired
	private CategoryDao categoryDao;
	
	@RequestMapping(value = { "", "/home", "/index" }) // vsechno s timhle URL pujde pres tuhle metodu
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("page"); // dispatcher-servlet preklada na page.jsp
		//mv.addObject("greeting", "Welcome to Spring Web MVC");
		mv.addObject("title", "Home"); // incializuje (preda) promennou title hodnotou Home
		
		mv.addObject("categories", categoryDao.list()); // predavam list kategorii z tridy(rozhrani) categoryDao MVC Springu
		
		mv.addObject("userClickHome", true); // incializuje prommennou (preda) userClickHome hodnotou true
		
		return mv;
	}

	@RequestMapping(value = "/about") // vsechno s timhle URL pujde pres tuhle metodu
	public ModelAndView about() {
		
		ModelAndView mv = new ModelAndView("page"); // dispatcher-servlet preklada na page.jsp
		//mv.addObject("greeting", "Welcome to Spring Web MVC");
		mv.addObject("title", "About Us"); // incializuje promennou title hodnotou Home
		mv.addObject("userClickAbout", true); // incializuje prommennou userClickHome hodnotou true
		return mv;
	}
	
	@RequestMapping(value = "/contact") // vsechno s timhle URL pujde pres tuhle metodu
	public ModelAndView contact() {
		
		ModelAndView mv = new ModelAndView("page"); // dispatcher-servlet preklada na page.jsp
		//mv.addObject("greeting", "Welcome to Spring Web MVC");
		mv.addObject("title", "Contact Us"); // incializuje promennou title hodnotou Home
		mv.addObject("userClickContact", true); // incializuje prommennou userClickHome hodnotou true
		return mv;
	}
	
    // nacte vsechny produkty	
	@RequestMapping(value = { "/show/all/products" }) // vsechno s timhle URL pujde pres tuhle metodu
	public ModelAndView showAllProducts() {
		
		ModelAndView mv = new ModelAndView("page"); // dispatcher-servlet preklada na page.jsp
		//mv.addObject("greeting", "Welcome to Spring Web MVC");
		mv.addObject("title", "All Products"); // incializuje (preda) promennou title hodnotou Home
		
		mv.addObject("categories", categoryDao.list()); // predavam list kategorii z tridy(rozhrani) categoryDao MVC Springu
		
		mv.addObject("userClickAllProducts", true); // incializuje prommennou (preda) userClickHome hodnotou true
		
		return mv;
	}
	
	@RequestMapping(value = { "/show/category/{id}/products" }) // vsechno s timhle URL pujde pres tuhle metodu
	public ModelAndView showCategoryProducts(@PathVariable("id")int id) { //je potreba mit pristup k ID kategorie proto anotace @PathVariable
		ModelAndView mv = new ModelAndView("page"); // dispatcher-servlet preklada na page.jsp

		// abych nacetl pouze konkretni kategorii, pouziju BE implementaci categoryDao
		Category category = null;
		
		category = categoryDao.get(id);
		
		//mv.addObject("greeting", "Welcome to Spring Web MVC");
		mv.addObject("title", category.getName()); // incializuje (preda) promennou title hodnotou Home
		
		mv.addObject("categories", categoryDao.list()); // predavam list kategorii z tridy(rozhrani) categoryDao MVC Springu

		mv.addObject("category", category); //predavam jeden objekt kategorii rovnajici se ID z requestu 
		
		mv.addObject("userClickCategoryProducts", true); // incializuje prommennou (preda) userClickHome hodnotou true
		
		return mv;
	}		
	
	@RequestMapping(value = "/atm") // vsechno s timhle URL pujde pres tuhle metodu
	public ModelAndView atm() {
		
		ModelAndView mv = new ModelAndView("page"); // dispatcher-servlet preklada na page.jsp
		//mv.addObject("greeting", "Welcome to Spring Web MVC");
		mv.addObject("title", "CSAS ATM"); // incializuje promennou title hodnotou Home
		mv.addObject("userClickCsasATMs", true); // incializuje prommennou userClickHome hodnotou true
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

