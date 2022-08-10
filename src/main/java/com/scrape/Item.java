package com.scrape;

import java.math.BigDecimal;

public class Item {
	// Declaring a variable called title of type String.
	private String title ;
	// Declaring a variable called price of type BigDecimal.
	private BigDecimal price ;
	// Declaring a variable called url of type String.
	private String url ;
	
	/**
	 * > This function returns the title of the book
	 *
	 * @return The title of the book.
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * This function sets the title of the book.
	 *
	 * @param title The title of the post.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * This function returns the price of the item.
	 *
	 * @return The price of the item.
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * This function sets the price of the product.
	 *
	 * @param price The price of the product.
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * > This function returns the url of the current page
	 *
	 * @return The url variable is being returned.
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * > This function sets the url of the current object to the url passed in as a parameter
	 *
	 * @param url The URL of the page to be scraped.
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	

}
