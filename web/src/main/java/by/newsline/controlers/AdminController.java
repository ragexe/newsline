package by.newsline.controlers;

import by.newsline.data.Category;
import by.newsline.data.User;
import by.newsline.exceptons.WebException;
import by.newsline.service.ICategoryService;
import by.newsline.service.ICommentService;
import by.newsline.service.IPageService;
import by.newsline.service.IUserService;
import by.newsline.service.util.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    @Autowired
    IUserService userService;


    @RequestMapping(value = "/menu/adminController", method = RequestMethod.GET)
    public String allPage(ModelMap modelMap) throws WebException {
        List<Category> categories = null;
        List<User> users = null;
        try {
            categories = categoryService.getAllCategories();
            users = userService.getAllUser();
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            throw new WebException(e);
        }
        modelMap.addAttribute("categories", categories);
        modelMap.addAttribute("users", users);

        return "adminController";
    }

    @RequestMapping(value = "/menu/adminController/{id}", method = RequestMethod.GET)
    public String delCategory(@PathVariable(value = "id") Long id, ModelMap modelMap) throws WebException {
        Category delCat = null;
        try {
            categoryService.deleteCategoryById(id);
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            throw new WebException(e);
        }
        modelMap.addAttribute("delCategory", delCat);
        return "redirect:/menu/adminController";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        ModelMap modelMap,
                        HttpServletRequest request) {

        if (error != null) {

            modelMap.addAttribute("error", "Invalid username and password!");

            String targetUrl = getRememberMeTargetUrlFromSession(request);
            System.out.println(targetUrl);
            if (StringUtils.hasText(targetUrl)) {

                modelMap.addAttribute("targetUrl", targetUrl);
                modelMap.addAttribute("loginUpdate", true);
            }
        }

        if (logout != null) {
//            model.addObject("msg", "You've been logged out successfully.");
            modelMap.addAttribute("msg", "You've been logged out successfully.");
        }
//        model.setViewName("login");
        return "login";
    }

    /**
     * If the login in from remember me cookie, refer
     * org.springframework.security.authentication.AuthenticationTrustResolverImpl
     */
    private boolean isRememberMeAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return false;
        }
        return RememberMeAuthenticationToken.class.isAssignableFrom(authentication.getClass());
    }

    /**
     * save targetURL in session
     */
    private void setRememberMeTargetUrlToSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.setAttribute("targetUrl", "/admin/update");
        }
    }

    /**
     * get targetURL from session
     */
    private String getRememberMeTargetUrlFromSession(HttpServletRequest request) {
        String targetUrl = "";
        HttpSession session = request.getSession(false);
        if (session != null) {
            targetUrl = session.getAttribute("targetUrl") == null ? "" : session.getAttribute("targetUrl").toString();
        }
        return targetUrl;
    }


    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Remember Me");
        model.addObject("message", "This page is for ROLE_ADMIN only!");
        model.setViewName("admin");
        return model;
    }

    /**
     * This update page is for user login with password only.
     * If user is logjn via remember me cookie, send login to ask for password again.
     * To avoid stolen remember me cookie to update anything
     */
    @RequestMapping(value = "/admin/update**", method = RequestMethod.GET)
    public ModelAndView updatePage(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        if (isRememberMeAuthenticated()) {
            setRememberMeTargetUrlToSession(request);
            model.addObject("loginUpdate", true);
            model.setViewName("/login");
        } else {
            model.setViewName("update");
        }
        return model;

    }

}
