package by.newsline.controlers;

import by.newsline.exceptons.WebException;
import by.newsline.service.ICategoryService;
import by.newsline.service.IPageService;
import by.newsline.service.util.exception.ServiceException;
import data.Page;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by User on 20.06.2015.
 */
@Controller
public class PagesController {
    private static final Logger logger = Logger.getLogger(PagesController.class);

    @Autowired
    IPageService pageService;

    @RequestMapping(value = "pages", method = RequestMethod.GET)
    public String allPage(ModelMap modelMap) throws WebException{
        List<Page> pages = null;
        try {
            pages = pageService.getAllPages();
        } catch (ServiceException e) {
            logger.error(e.getMessage());
            throw new WebException(e);
        }
        modelMap.addAttribute("pages",pages);
        return "/test/test";

    }



}
