package com.csas.moje_csas_aplikace_backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.csas.moje_csas_aplikace_backend.dao.CategoryDao;
import com.csas.moje_csas_aplikace_backend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context; // objekt pro pristup k beans - objektum springu
	
	private static CategoryDao categoryDao;	
	
	private Category category;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.csas.moje_csas_aplikace_backend");
		context.refresh();
		categoryDao = (CategoryDao)context.getBean("categoryDao");
	}
	
	
	// test na pridani kategorie do H2 databaze
	/*@Test
	public void testAddCategory() {
		
		category = new Category();
		
		category.setName("Laptop2");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("CAT_105.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDao.add(category));
		
		
	}*/
	
	/*@Test
	public void testGetCategory() {
		
		category = categoryDao.get(4);

		
		assertEquals("Successfully fetched a single category from the table!","Laptop",category.getName());	
		
	}*/
	
	/*@Test
	public void testUpdateCategory() {
		
		category = categoryDao.get(3);
		
		category.setName("Televison");
		
		assertEquals("Successfully updated a single category in the table!",true,categoryDao.update(category));
		
		
	}*/	

	/*@Test
	public void testDeleteCategory() {
		
		category = categoryDao.get(3);		
		assertEquals("Successfully deleted a single category in the table!",true,categoryDao.delete(category));
				
	}
	
		
	@Test
	public void testListCategory() {
					
		assertEquals("Successfully fetched the list of categories from the table!",3,categoryDao.list().size());
		
		
	}*/
	

	
	@Test
	public void testCRUDCategory() {
		
		// add operation
		category = new Category();
		
		category.setName("Laptop");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDao.add(category));
		
		
		category = new Category();
		
		category.setName("Television");
		category.setDescription("This is some description for television!");
		category.setImageURL("CAT_2.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDao.add(category));

		
		// fetching and updating the category
		category = categoryDao.get(2);
		
		category.setName("TV");
		
		assertEquals("Successfully updated a single category in the table!",true,categoryDao.update(category));
		
		
		// delete the category
		assertEquals("Successfully deleted a single category in the table!",true,categoryDao.delete(category));
		
		
		//fetching the list
		assertEquals("Successfully fetched the list of categories from the table!",1,categoryDao.list().size());		
				
		
	}	
	
	
}
