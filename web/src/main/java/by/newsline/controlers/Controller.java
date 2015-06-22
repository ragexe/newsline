package by.newsline.controlers;

/**
 * Created by HappyQ on 22.06.2015.
 */

import by.newsline.data.User;
import by.newsline.exceptons.WebException;
import by.newsline.service.ICategoryService;
import by.newsline.service.ICommentService;
import by.newsline.service.IPageService;
import by.newsline.service.IUserService;
import by.newsline.service.util.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


public class Controller {
    private static final Logger logger = Logger.getLogger(Controller.class);


    @Autowired
    IPageService pageService;
    @Autowired
    ICategoryService categoryService;
    @Autowired
    ICommentService commentService;
    @Autowired
    IUserService userService;

    @RequestMapping(value = "/menu/adminController/users", method = RequestMethod.GET)
    public String allPage(ModelMap modelMap) throws WebException {
        List<User> users = null;
        try {
            users = userService.getAllUser();
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            throw new WebException(e);
        }
        modelMap.addAttribute("users", users);

        return "adminController";
    }

    @RequestMapping(value = "/menu/adminController/users/{id}", method = RequestMethod.GET)
    public String delCategory(@PathVariable(value = "id")Long id,ModelMap modelMap) throws WebException {
        User delUser = null;
        try {
            userService.deleteUserById(id);
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            throw new WebException(e);
        }
        modelMap.addAttribute("delUser",delUser);
        return "redirect:/menu/adminController/users";
    }

}
