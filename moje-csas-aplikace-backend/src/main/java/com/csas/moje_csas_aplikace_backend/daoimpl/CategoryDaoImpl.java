package com.csas.moje_csas_aplikace_backend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import com.csas.moje_csas_aplikace_backend.dao.CategoryDao;
import com.csas.moje_csas_aplikace_backend.dto.Category;

// BE implementace tlacitek kategorie 
public class CategoryDaoImpl implements CategoryDao{

	private static List<Category> categories = new ArrayList<>();
	
	static {
		
		Category category;
		
		//prvni kategorie
		category = new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescprition("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		category.setImageURL("CAT_1.png ");
		
		categories.add(category);
		
		//druha kategorie
		category = new Category();
		category.setId(1);
		category.setName("Mobile");
		category.setDescprition("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		category.setImageURL("CAT_2.png ");
		
		categories.add(category);
		
		//treti kategorie
		category = new Category();
		category.setId(1);
		category.setName("Laptop");
		category.setDescprition("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		category.setImageURL("CAT_3.png ");
		
		categories.add(category);		
		
	}
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {	
		return null;
	}

}
