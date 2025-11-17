package com.travelsguru.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "destination_categories")
public class DestinationCategory {

	@Id
	private String destiCategoryId;
	private String destiCategoryName;
	private String image;
	private String description;
	public DestinationCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DestinationCategory(String destiCategoryId, String destiCategoryName, String image, String description) {
		super();
		this.destiCategoryId = destiCategoryId;
		this.destiCategoryName = destiCategoryName;
		this.image = image;
		this.description = description;
	}
	public String getDestiCategoryId() {
		return destiCategoryId;
	}
	public void setDestiCategoryId(String destiCategoryId) {
		this.destiCategoryId = destiCategoryId;
	}
	public String getDestiCategoryName() {
		return destiCategoryName;
	}
	public void setDestiCategoryName(String destiCategoryName) {
		this.destiCategoryName = destiCategoryName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "DestinationCategory [destiCategoryId=" + destiCategoryId + ", destiCategoryName=" + destiCategoryName
				+ ", image=" + image + ", description=" + description + "]";
	}

	
}
