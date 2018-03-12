package com.csas.mojeCsasAplikace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csas.moje_csas_aplikace_backend.dao.ProductDao;
import com.csas.moje_csas_aplikace_backend.dto.Product;

@Controller
@RequestMapping("/json/data") //vsechny mapovani ktera zacinaji takto 
public class JsonDataController {

	@Autowired
	private ProductDao productDao;
	
	
	@RequestMapping("/all/products")
	@ResponseBody // vrat telo, Spring a Jakson - converter uz se postara ze dojde k vraceni ve forme JSON
	public List<Product> getAllProducts() {
		
		return productDao.listActiveProducts();
				
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable int id) {
		
		return productDao.listActiveProductsByCategory(id);
				
	}
	
	
	
}
