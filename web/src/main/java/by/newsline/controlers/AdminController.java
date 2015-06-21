package by.newsline.controlers;

import by.newsline.exceptons.WebException;
import by.newsline.service.ICategoryService;
import by.newsline.service.ICommentService;
import by.newsline.service.IPageService;
import by.newsline.service.util.exception.ServiceException;
import by.newsline.data.Category;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by User on 21.06.2015.
 */
@Controller
public class AdminController {
    private static final Logger logger = Logger.getLogger(AdminController.class);

    @Autowired
    IPageService pageService;
    @Autowired
    ICategoryService categoryService;
    @Autowired
    ICommentService commentService;


    @RequestMapping(value = "/menu/adminController", method = RequestMethod.GET)
    public String allPage(ModelMap modelMap) throws WebException {
        List<Category> categories = null;
        try {
            categories = categoryService.getAllCategories();
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            throw new WebException(e);
        }
        modelMap.addAttribute("categories",categories);
        return "adminController";
    }

    @RequestMapping(value = "/menu/adminController/{id}", method = RequestMethod.GET)
    public String delCategory(@PathVariable(value = "id")Long id,ModelMap modelMap) throws WebException {
        Category delCat = null;
        try {
            categoryService.deleteCategoryById(id);
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            throw new WebException(e);
        }
        modelMap.addAttribute("delCategory",delCat);
        return "redirect:/menu/adminController";
    }



}
