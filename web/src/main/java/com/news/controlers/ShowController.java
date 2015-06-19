package com.news.controlers;

import data.Category;
import data.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import by.newsline.service.ICategoryService;
import by.newsline.service.PageService;

import java.util.List;

@Controller
public class ShowController {

    @Autowired
    ICategoryService categoryService;
    private List<Page> pages;
    private PageService pageService;

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String helloTest(ModelMap model) {
        List<Category> categories = categoryService.getList();
        model.addAttribute("category",categories);

        return "cat";
    }

    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String category(ModelMap model){
        List<Category> categories = categoryService.getList();
        model.addAttribute("category",categories);
        return "main";
    }
}
