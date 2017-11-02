package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/products", produces=MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@RequestMapping("/{id}")
	public Product getById(@PathVariable("id") int id){						
		return productService.getProductById(id);		
	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.POST)
	public List<Product> getByName(@PathVariable("name") String name){
		return productService.getProductByName(name);		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void remove(@PathVariable("id") int id){
		productService.remove(id);
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void add(@RequestBody Product product){
		productService.add(product);
	}
}
