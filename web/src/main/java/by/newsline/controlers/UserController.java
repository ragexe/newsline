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
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);


    @Autowired
    IPageService pageService;
    @Autowired
    ICategoryService categoryService;
    @Autowired
    ICommentService commentService;
    @Autowired
    IUserService userService;

    @RequestMapping(value="/menu/adminController/users",method = RequestMethod.GET)
    public String banUsers(ModelMap modelMap) throws WebException{
        List<User> users;
        try {
            users = userService.getAllUser();
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            throw new WebException(e);
        }
        modelMap.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(value = "/menu/adminController/users/{id}", method = RequestMethod.GET)
    public String delUser(@PathVariable(value = "id")Long id,ModelMap modelMap) throws WebException {
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
    @RequestMapping(value = "/menu/adminController/banUsers", method = RequestMethod.GET)
    public String getAllBannedUsers(ModelMap modelMap) throws WebException {
        List<User> banUsers;
        try {
            banUsers = userService.getAllBannedUsers();
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            throw new WebException(e);
        }
        modelMap.addAttribute("banUsers",banUsers);
        return "banUsers";
    }

    @RequestMapping(value = "/menu/adminController/banUsers/{id}", method = RequestMethod.GET)
    public String unbanUser(@PathVariable(value = "id")Long id,ModelMap modelMap) throws WebException {
        User unbanUser = null;
        try {
            userService.unBannedUser(id);
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            throw new WebException(e);
        }
        modelMap.addAttribute("unbanUser",unbanUser);
        return "redirect:/menu/adminController/banUsers";
    }

}
