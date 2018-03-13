package com.csas.mojeCsasAplikace.controller;

import java.util.Arrays;
import java.util.List;

import org.dom4j.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.csas.moje_csas_aplikace_backend.dao.ProductDao;
import com.csas.moje_csas_aplikace_backend.dto.ATM;
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
	
	
	/* -------------- CSAS cast -------------- */
	
	@RequestMapping("/all/atms")
	@ResponseBody
    public ATM saysHi() {
		
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON}));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("WEB-API-key", "883ee272-de8e-4beb-b15a-9146e313f51d");


        RestTemplate restTemplate  = new RestTemplate();

        HttpEntity entity = new HttpEntity(headers);

        /*ResponseEntity<String> response = restTemplate.exchange(
                "https://api.csas.cz/sandbox/webapi/api/v2/places?size=1&page=0", HttpMethod.GET, entity, String.class);*/
        /*ResponseEntity<Item> response = restTemplate.exchange(
                "https://api.csas.cz/sandbox/webapi/api/v2/places?size=1&page=0", HttpMethod.GET, entity, Item.class);*/
        ResponseEntity<ATM> responseEntity = restTemplate.exchange("https://api.csas.cz/sandbox/webapi/api/v2/places?size=2&page=0",HttpMethod.GET, entity, ATM.class);
        //ATM aTM = new ATM();
        
        //aTM = responseEntity.getBody();

        //Object[] objects = responseEntity.getBody();
        //MediaType contentType = responseEntity.getHeaders().getContentType();
        //HttpStatus statusCode = responseEntity.getStatusCode();
        //List<Object> objects2 = new ArrayList<Object>();
        System.out.println(responseEntity.getBody().toString());
        return responseEntity.getBody();
    }	
	
}
