package com.test.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.Ingredient;
import com.test.model.Rating;
import com.test.model.Recipe;
import com.test.model.TrackingEntry;
import com.test.model.User;
import com.test.model.data.IngredientRepository;
import com.test.model.data.RatingRepository;
import com.test.model.data.RecipeRepository;
import com.test.model.data.TrackingEntryRepository;
import com.test.model.data.UserRepository;

@RestController 
@RequestMapping(path = "/demo") // This means URL's start with /demo (after	Application path)
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
	
	private String[] authors = {"Jack Kerouac", "Albert Camus", "Vladimir Nabokov", "Andrew Stearn", "Rebecca Wells", "Rachel Einhorn", "Walter Davis"};
	private String[] books = {"Vegan Superfooods", "BBQ Masters", "Tofu All Day Long", "100 Holiday Favorites", "Fish Dishes", "100% Meat Recipes"};
	private String[] ingredients = {"carrot", "onion", "green bell pepper", "red bell pepper", "tofu", "bacon", "garlic", "black pepper", "eggplant", "steak", "cilantro", "ginger"};
	private String[] units = {"cup", "teaspoon", "tablespoon", "quart", "spoonful", "dash"};
	private String[] trackingEntry = {"entry1", "entry2", "entry3", "entry4", "entry5", "entry6", "entry7", "entry8"};
	
	@GetMapping(path = "/addForTesting")
	public String addForTesting(@RequestParam String name) {
		User user = new User();
		user.setName(name);
		User savedUser = userRepository.save(user);
		
		TrackingEntry entry = new TrackingEntry();
		entry.setName("entry" + ThreadLocalRandom.current().nextInt(10, 1000));
		TrackingEntry savedEntry = trackingRepository.save(entry);
		
		Rating rating = new Rating();
		rating.setTrackingEntry(savedEntry);
		rating.setUser(savedUser);
		rating.setValue("" + ThreadLocalRandom.current().nextInt(0, 11));
		Rating savedRating = ratingRepository.save(rating);
		
		Recipe recipe = new Recipe();
		recipe.setAuthor(authors[ThreadLocalRandom.current().nextInt(0, authors.length)]);
		recipe.setBook(books[ThreadLocalRandom.current().nextInt(0, books.length)]);
		recipe.setTrackingEntry(savedEntry);
		
		int count = ThreadLocalRandom.current().nextInt(1, 7);
		Set<Ingredient> ings = new HashSet<>();
		for (int i = 0; i < count; i++) {
			Ingredient ingredient = new Ingredient();
			ingredient.setRecipe(recipe);
			ingredient.setAmount("" + ThreadLocalRandom.current().nextInt(0, 101));
			ingredient.setUnit(units[ThreadLocalRandom.current().nextInt(0, units.length)]);
			ingredient.setItem(ingredients[ThreadLocalRandom.current().nextInt(0, ingredients.length)]);
			ings.add(ingredient);
		}
		recipe.setIngredients(ings);
		Recipe savedRecipe = recipeRepository.save(recipe);
		
		return "Saved: " + savedUser + "\nRating: " + savedRating + "\nRecipe: " + savedRecipe;
	}

	@GetMapping(path = "/add") // Map ONLY GET Requests
	public String addNewUser(@RequestParam String name, @RequestParam String title, @RequestParam String item, @RequestParam String rating) {

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

	@GetMapping(path = "/users")
	public Iterable<User> getUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
	
	@GetMapping(path = "/user")
	public User getUser(@RequestParam String name) {
		return userRepository.findByName(name);
	}
	
	@GetMapping(path = "/ingredient")
	public Collection<Ingredient> getIngredient(@RequestParam String item) {
		return ingredientRepository.findByItem(item);
	}
	
	@GetMapping(path = "/ingredients")
	public Iterable<Ingredient> getIngredients() {
		return ingredientRepository.findAll();
	}
	
	@GetMapping(path = "/recipes") 
	public Iterable<Recipe> getRecipes() {
		return recipeRepository.findAll();
	}
	
	@GetMapping(path = "/ratings")
	public Iterable<Rating> getRatings() {
		return ratingRepository.findAll();
	}
}