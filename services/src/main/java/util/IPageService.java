package util;

import data.Page;
import java.util.List;


public interface IPageService {
    Page getPageByPK(Long PK);
    Page getPageByPageId(long id);
    List<Page> getListOfPageByPersonId(Long personId);
    List<Page> getListOfPageByCategory(Long categoryId);
    List<Page> getListPageByParentid(long id);
    Long savePage(Page news);
    Page updatePage(Page news);
    Page deletePage(Page news);
    void removePage(Page news);

//    List<Page> getMostPopularPageList();
   // List<Page> getListOfPageByPageId(String pageId);
}
