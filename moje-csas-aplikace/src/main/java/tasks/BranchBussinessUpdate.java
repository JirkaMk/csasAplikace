package tasks;

import java.sql.Connection;
import java.util.Arrays;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.csas.moje_csas_aplikace_backend.dao.ProductDao;
import com.csas.moje_csas_aplikace_backend.daoimpl.AtmDaoImpl;
import com.csas.moje_csas_aplikace_backend.dto.ATM;



public class BranchBussinessUpdate {
 
/*	@Autowired
	private AtmDaoImpl atmDaoImpl;*/
	
    @Scheduled(fixedRate=5000)  
	public void printMessage() {
        System.out.println("I am called by Spring scheduler");
        
        ATM aTM = new ATM();
        
        aTM = updateATM();
        
        //atmDaoImpl.add(aTM);
        
        //sessionFactory.getCurrentSession().save(aTM.getItems());
        

        
        
        
    }
    
    public ATM updateATM() {
		
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON}));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("WEB-API-key", "883ee272-de8e-4beb-b15a-9146e313f51d");


        RestTemplate restTemplate  = new RestTemplate();

        HttpEntity entity = new HttpEntity(headers);

/*        ResponseEntity<String> response = restTemplate.exchange(
                "https://api.csas.cz/sandbox/webapi/api/v2/places?size=1&page=0", HttpMethod.GET, entity, String.class);
        ResponseEntity<Item> response = restTemplate.exchange(
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