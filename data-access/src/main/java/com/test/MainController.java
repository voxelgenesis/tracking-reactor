package com.test;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/demo") // This means URL's start with /demo (after
								// Application path)
public class MainController {
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private RatingRepository ratingRepository;
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@Autowired
	private TrackingEntryRepository trackingRepository;
	
	@Autowired
	private IngredientRepository ingredientRepository;

	@GetMapping(path = "/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String title, @RequestParam String item, @RequestParam String rating) {
		// @ResponseBody means the returned String is the response, not a view
		// name
		// @RequestParam means it is a parameter from the GET or POST request

		User n = new User();
		n.setName(name);
		User savedUser = userRepository.save(n);
		
		TrackingEntry entry = new TrackingEntry();
		entry.setName(title);
		TrackingEntry savedEntry = trackingRepository.save(entry);
		
		Rating r = new Rating();
		r.setTrackingEntry(savedEntry);
		r.setUser(savedUser);
		r.setValue(rating);
		Rating savedRating = ratingRepository.save(r);
		
		Recipe rec = new Recipe();
		rec.setAuthor("author" + name);
		rec.setBook("book" + title);
		rec.setTrackingEntry(savedEntry);
		Ingredient ing1 = new Ingredient();
		ing1.setAmount("50" + rating);
		ing1.setUnit("unit");
		ing1.setItem("broccoli");
		ing1.setRecipe(rec);
		rec.setIngredients(Collections.singleton(ing1));
		
		Recipe savedRecipe = recipeRepository.save(rec);
		
		return "Saved: " + savedUser + "\nRating: " + savedRating + "\nRecipe: " + savedRecipe;
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
}