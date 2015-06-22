package by.newsline.controlers;

import by.newsline.data.Category;
import by.newsline.exceptons.WebException;
import by.newsline.service.ICategoryService;
import by.newsline.service.util.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ShowController {
    private static final Logger logger = Logger.getLogger(ShowController.class);

    @Autowired
    ICategoryService categoryService;

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String helloTest(ModelMap model) throws WebException{
        List<Category> categories = null;
        try {
            categories = categoryService.getAllCategories();
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            throw new WebException(e);
        }
        model.addAttribute("category",categories);

        return "cat";
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String category(ModelMap model) throws WebException{
        List<Category> categories = null;
        try {
            categories = categoryService.getAllCategories();
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            throw new WebException(e);
        }
        model.addAttribute("category",categories);
        return "menu";
    }
    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public String categories(ModelMap model) throws WebException{
        List<Category> categories = null;
        try {
            categories = categoryService.getAllCategories();
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            throw new WebException(e);
        }
        model.addAttribute("category",categories);
        return "post";
    }




}
