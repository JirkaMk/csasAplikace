package com.csas.moje_csas_aplikace_backend.daoimpl;

import com.csas.moje_csas_aplikace_backend.dao.ProductDao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.csas.moje_csas_aplikace_backend.dto.ATM;
import com.csas.moje_csas_aplikace_backend.dto.Product;


@Repository("aTMDao")
@Transactional
public class AtmDaoImpl  {

	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	 * SINGLE produkt z DB
	 * */
	

	public boolean add(ATM aTM) {
		try {			
			sessionFactory
					.getCurrentSession()
						.save(aTM.getItems().get(1).getLocation());
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}
}

