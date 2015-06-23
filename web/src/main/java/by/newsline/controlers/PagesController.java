package by.newsline.controlers;

import by.newsline.exceptons.WebException;
import by.newsline.service.ICategoryService;
import by.newsline.service.ICommentService;
import by.newsline.service.IPageService;
import by.newsline.service.util.exception.ServiceException;
import by.newsline.data.Category;
import by.newsline.data.Comment;
import by.newsline.data.Page;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by User on 20.06.2015.
 */
@Controller
public class PagesController {
    private static final Logger logger = Logger.getLogger(PagesController.class);

    @Autowired
    IPageService pageService;
    @Autowired
    ICategoryService categoryService;
    @Autowired
    ICommentService commentService;

    @RequestMapping(value = "/menu/{id}/{pN}", method = RequestMethod.GET)
    public String allPage(@PathVariable(value = "id") long id,
                          @PathVariable(value = "pN") int pN,
                          ModelMap modelMap) throws WebException{
        List<Page> pages = null;
        List<Category> categories = null;
        System.out.println(pN);
        try {
            categories = categoryService.getAllCategories();
            pages = pageService.getPagesByCriteria(pN, 5, id);
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            throw new WebException(e);
        }
        modelMap.addAttribute("counter", pN);
        modelMap.addAttribute("categoryId", id);
        modelMap.addAttribute("pages",pages);
        modelMap.addAttribute("category",categories);
        return "menu";
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public String aPost(@PathVariable(value = "id")Long id, ModelMap modelMap) throws WebException{
        List<Comment> comments = null;
        Page page = null;
        List<Category> categories = null;
        try {
            page = pageService.getById(id);
            comments = commentService.getAllByPageId(id);
            categories = categoryService.getAllCategories();

        } catch (ServiceException e) {
            logger.error(e.getMessage());
            throw new WebException(e);
        }
        modelMap.addAttribute("page", page);

        modelMap.addAttribute("comments",comments);

        modelMap.addAttribute("category",categories);
        return "post";
    }

    @RequestMapping(value = "/menu/save",method = RequestMethod.POST)
    public String savePage(ModelMap modelMap, @ModelAttribute("newPage") Page page,
                           @RequestParam("categoryId") Integer categoryId)throws WebException{
        System.out.print(categoryId);
        try{
            pageService.savePage(page);

        }catch (ServiceException e){
            logger.error(e.getMessage());
            throw new WebException(e);
        }
        modelMap.addAttribute("add",page);
        return "redirect:/menu";
    }

    @RequestMapping(value = "/menu/add", method = RequestMethod.GET)
    public String addPage(ModelMap model) {
        List<Category> categories = null;
        try {
            categories = categoryService.getAllCategories();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        model.addAttribute("categories",categories);
        model.addAttribute("newPage", new Page());
        return "add";
    }

    @RequestMapping(value = "/menu/adminController/category", method = RequestMethod.GET)
    public String addCategory(ModelMap model) {
        model.addAttribute("newCategory", new Category());
        return "addCategory";
    }

    @RequestMapping(value = "/menu/saveCategory",method = RequestMethod.POST)
    public String saveCategory(ModelMap modelMap, @ModelAttribute("newCategory") Category category)
                                                                                    throws WebException{

        try{
            categoryService.saveCategory(category);
        }catch (ServiceException e){
            logger.error(e.getMessage());
            throw new WebException(e);
        }
        modelMap.addAttribute("addCategory",category);
        return "redirect:/menu/adminController";
    }
}
