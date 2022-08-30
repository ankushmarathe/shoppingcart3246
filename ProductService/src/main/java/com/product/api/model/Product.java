package com.product.api.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;



@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes="the id of the each product is unique")
    private int id;
	@ApiModelProperty(notes="Type of product")
	private String productType;
	@ApiModelProperty(notes="Name of product")
	private String productName;
	@ApiModelProperty(notes="Category of product")
	private String category;
	@ApiModelProperty(notes="Rating of product")
	private int rating;
	@ApiModelProperty(notes="Review of product")
	private String review;
	@ApiModelProperty(notes="Price of product")
	private double price;
	@ApiModelProperty(notes="Description of product")
	private String description;
	@ApiModelProperty(notes="Specification of product")
	private String specification;
	
	public Product(int id, String productType, String productName, String category, int rating, String review,
			double price, String description, String specification) {
		super();
		this.id = id;
		this.productType = productType;
		this.productName = productName;
		this.category = category;
		this.rating = rating;
		this.review = review;
		this.price = price;
		this.description = description;
		this.specification = specification;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productType=" + productType + ", productName=" + productName + ", category="
				+ category + ", rating=" + rating + ", review=" + review + ", price=" + price + ", description="
				+ description + ", specification=" + specification + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(category, description, id, price, productName, productType, rating, review, specification);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(category, other.category) && Objects.equals(description, other.description)
				&& id == other.id && Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(productName, other.productName) && Objects.equals(productType, other.productType)
				&& rating == other.rating && Objects.equals(review, other.review)
				&& Objects.equals(specification, other.specification);
	}

	
	
}
