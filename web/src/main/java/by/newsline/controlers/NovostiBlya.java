package by.newsline.controlers;

import by.newsline.service.ICategoryService;
import by.newsline.service.ICommentService;
import by.newsline.service.IPageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by HappyQ on 23.06.2015.
 */
@Controller
public class NovostiBlya {
    private static final Logger logger = Logger.getLogger(NovostiBlya.class);
    @Autowired
    IPageService pageService;
    @Autowired
    ICategoryService categoryService;
    @Autowired
    ICommentService commentService;



}
