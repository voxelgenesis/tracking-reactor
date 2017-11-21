package com.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.model.data.IngredientRepository;
import com.test.model.data.RatingRepository;
import com.test.model.data.RecipeRepository;
import com.test.model.data.TrackingEntryRepository;
import com.test.model.data.UserRepository;

@Controller
@RequestMapping(path = "/webapp")
public class OtherController {

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
	
	@RequestMapping
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping(path = "/addStuff")
	public ModelAndView addStuff() {
		Map<String, Object> params = new HashMap<>();
		params.put("users", userRepository.findAll());
		params.put("recipes", recipeRepository.findAll());
		params.put("ratings",  ratingRepository.findAll());
		params.put("ingredients", ingredientRepository.findAll());
		return new ModelAndView("addStuff", params);
	}
}
