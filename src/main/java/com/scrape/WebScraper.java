package com.scrape;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class WebScraper {

	public static void main(String[] args) {

	    // A variable that is used to store the search query.
	    String searchQuery = "" ;
		// The base URL of the website.
		String baseUrl = " " ;
		// Creating a new instance of the WebClient class.
		WebClient client = new WebClient();
		// Disabling the CSS.
		client.getOptions().setCssEnabled(false);
		// Disabling the JavaScript.
		client.getOptions().setJavaScriptEnabled(false);
		try {
			// Creating the URL for the search query.
			String searchUrl = baseUrl + "search/sss?sort=rel&query=" + URLEncoder.encode(searchQuery, "UTF-8");
			// Getting the HTML page from the URL.
			HtmlPage page = client.getPage(searchUrl);
			
			List<HtmlElement> items = page.getByXPath("//li[@class='result-row']");
			if(items.isEmpty()){
				System.out.println("No items found !");
			}else{

				// Iterating through the list of items.
				for(HtmlElement htmlItem : items){
					HtmlAnchor itemAnchor = htmlItem.getFirstByXPath(".//p[@class='result-info']/a");
					HtmlElement spanPrice = htmlItem.getFirstByXPath(".//a/span[@class='result-price']");

					// This is a ternary operator. It is a shorthand way of writing an if-else statement.
					String itemPrice = spanPrice == null ? "0.0" : spanPrice.asNormalizedText() ;

					
					// Creating a new Item object and setting the title and url.
					Item item = new Item();
					item.setTitle(itemAnchor.asNormalizedText());
					item.setUrl( baseUrl + itemAnchor.getHrefAttribute());
					
					// Removing the dollar sign from the price.
					item.setPrice(new BigDecimal(itemPrice.replace("€", "")));
				
					
					// Creating a new instance of the ObjectMapper class.
					ObjectMapper mapper = new ObjectMapper();
					// Converting the item object to a JSON string.
					String jsonString = mapper.writeValueAsString(item) ;
					
					System.out.println(jsonString);
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}

	}

}
