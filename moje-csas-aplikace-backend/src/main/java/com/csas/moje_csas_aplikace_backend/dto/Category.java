package com.csas.moje_csas_aplikace_backend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//trida predstavujici objektove zastoupeni tlacitka kategorie v levem menu

@Entity 
public class Category{

	@Id // rikam Springu ze tohle je primarni ID
	@GeneratedValue (strategy = GenerationType.IDENTITY) // rikam tim ze id je tvoreno automaticky
	private int id;
	
	private String name; // v tomto pripade je roven nazvu objektu nazvu v databazi
	
	private String description;
	
	@Column(name = "image_url") // rikam Springu ze imageURL je rovna v databazi image_urls
	private String imageURL;
	
	@Column(name = "is_active")
	private boolean active = true;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", imageURL=" + imageURL
				+ ", active=" + active + "]";
	}
	
	
	
}
