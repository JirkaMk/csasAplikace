package com.csas.moje_csas_aplikace_backend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.csas.moje_csas_aplikace_backend.dao.CategoryDao;
import com.csas.moje_csas_aplikace_backend.dto.Category;

// timhle Springu rikam ze spravuje tento typ objektu - je treba rovnez zaradit Spring context knihovny pod spravu Mavenu (pom.xml)
@Repository("categoryDAO") 
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
		category.setId(2);
		category.setName("Mobile");
		category.setDescprition("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
		category.setImageURL("CAT_2.png ");
		
		categories.add(category);
		
		//treti kategorie
		category = new Category();
		category.setId(3);
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
		
		for (Category category : categories) {
			if(category.getId() == id) {
				return category;
			}
		}		
		return null;
	}

}
