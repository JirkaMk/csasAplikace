package com.csas.moje_csas_aplikace_backend.dao;

import java.util.List;
import com.csas.moje_csas_aplikace_backend.dto.Product;

public interface ProductDao {


	Product get(int productId);
	List<Product> list();	
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	// business methods
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	// vrati list aktualnich produktu dle velikosti listu
	List<Product> getLatestActiveProducts(int count);
}
