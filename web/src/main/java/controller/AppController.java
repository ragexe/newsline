package controller;


import data.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import util.CategoryService1Impl;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	CategoryService1Impl service;

	/*
	 * This method will list all existing categories.
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listCategorys(ModelMap model) {

		List<Category> categories = service.getAllCategories();
		model.addAttribute("categories", categories);
		return "allcategories";
	}

	/*
	 * This method will provide the medium to add a new category.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newCategory(ModelMap model) {
		Category category = new Category();
		model.addAttribute("category", category);
		return "registration";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving category in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveCategory(@Valid 
								  	Category category, 
							   		BindingResult result,
							   		ModelMap model) {
		if (result.hasErrors()) {
			return "registration";
		}

		service.saveCategory(category);

		model.addAttribute("success", "Category " + category.getTitle()
				+ " registered successfully");
		return "success";
	}

	/*
	 * This method will delete an category by it's SSN value.
	 */
	@RequestMapping(value = { "/delete-{id}-category" }, method = RequestMethod.GET)
	public String deleteCategory(@PathVariable long id) {
		service.deleteCategoryById(id);
		return "redirect:/list";
	}

}
