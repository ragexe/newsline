package by.newsline.service;

import data.Category;
import data.Page;
import java.util.List;


public interface IPageService {
    Page getPageByPK(Long PK);
    Page getPageByPageId(long id);
    List<Page> getListOfPageByPersonId(Long personId);
    List<Page> getListOfPageByCategory(Category category);
    List<Page> getListOfPageByCategoryId(long categoryId);
    List<Page> getAllPages();
    Long savePage(Page news);
    Page updatePage(Page news);
    Page deletePage(Page news);
    void removePage(Page news);

//    List<Page> getMostPopularPageList();
   // List<Page> getListOfPageByPageId(String pageId);
}
