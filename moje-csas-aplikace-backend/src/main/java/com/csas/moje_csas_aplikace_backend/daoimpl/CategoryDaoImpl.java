package com.csas.moje_csas_aplikace_backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.csas.moje_csas_aplikace_backend.dao.CategoryDao;
import com.csas.moje_csas_aplikace_backend.dto.Category;

// timhle Springu rikam ze spravuje tento typ objektu - je treba rovnez zaradit Spring context knihovny pod spravu Mavenu (pom.xml)
@Repository("categoryDao")
@Transactional // kazda metoda je transakcni
// BE implementace tlacitek kategorie
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	// vraci list aktivnich kategorii
	@Override
	public List<Category> list() {
		
		// pozor nejde o klasicke SQL, jde o Hibernate
		String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("active", true); // nastavuje parametr na true
						
		return query.getResultList();
	}

	@Override // tato metoda vraci jednu kategorii z DB
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override // tato metoda se stara o pritomnost aktualni verze instanci kategorie v DB
	public boolean add(Category category) {

		try {

			sessionFactory.getCurrentSession().persist(category);

			return true;
		} catch (Exception ex) {

			ex.printStackTrace();
			return false;
		}
	}

	@Override // tato metoda updatuje jednu kategorii
	public boolean update(Category category) {

		try {

			sessionFactory.getCurrentSession().update(category);

			return true;
		} catch (Exception ex) {

			ex.printStackTrace();
			return false;
		}
	}

	@Override // nastavi flag kategorie na false
	public boolean delete(Category category) {
		
		category.setActive(false);
		
		try {

			sessionFactory.getCurrentSession().update(category);

			return true;
		} catch (Exception ex) {

			ex.printStackTrace();
			return false;
		}
	}

}
