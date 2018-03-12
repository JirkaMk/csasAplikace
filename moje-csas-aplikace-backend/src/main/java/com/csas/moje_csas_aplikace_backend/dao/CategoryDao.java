package com.csas.moje_csas_aplikace_backend.dao;

import java.util.List;

import com.csas.moje_csas_aplikace_backend.dto.Category;

public interface CategoryDao {

	
	List<Category> list();
	
	Category get(int id);	
	
	boolean add(Category category); // metoda na pridani kategorii do DB
	boolean update(Category category);
	boolean delete(Category category);
}