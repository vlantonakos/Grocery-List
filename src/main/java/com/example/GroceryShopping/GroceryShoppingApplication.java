package com.example.GroceryShopping;

import com.example.GroceryShopping.Repository.ItemRepository;
import com.example.GroceryShopping.model.GroceryItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class GroceryShoppingApplication implements CommandLineRunner {

	@Autowired
    ItemRepository groceryItemRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(GroceryShoppingApplication.class, args);
	}
	
	 // Print details in readable form
    
    public String getItemDetails(GroceryItem item) {

        System.out.println(
        "Item Name: " + item.getName() + 
        ", \nQuantity: " + item.getQuantity() +
        ", \nItem Category: " + item.getCategory()
        );
        
        return "";
    }
	
	//CREATE
    void createGroceryItems() {
        System.out.println("Data creation started...");
        groceryItemRepo.save(new GroceryItem("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks"));
        groceryItemRepo.save(new GroceryItem("Kodo Millet", "XYZ Kodo Millet healthy", 2, "millets"));
        groceryItemRepo.save(new GroceryItem("Dried Red Chilli", "Dried Whole Red Chilli", 2, "spices"));
        groceryItemRepo.save(new GroceryItem("Pearl Millet", "Healthy Pearl Millet", 1, "millets"));
        groceryItemRepo.save(new GroceryItem("Cheese Crackers", "Bonny Cheese Crackers Plain", 6, "snacks"));
        System.out.println("Data creation complete...");
    }
    
    // 1. Show all the data
    public void showAllGroceryItems() {
        
        groceryItemRepo.findAll().forEach(item -> System.out.println(getItemDetails(item)));
    }
     
	public void run(String... args) {
        
        System.out.println("-------------CREATE GROCERY ITEMS-------------------------------\n");
        
        createGroceryItems();
        
        System.out.println("\n----------------SHOW ALL GROCERY ITEMS---------------------------\n");
        
        showAllGroceryItems();
        
    }

}
