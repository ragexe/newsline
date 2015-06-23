package by.newsline.service;

import by.newsline.service.util.exception.ServiceException;
import by.newsline.data.Page;
import java.util.List;


public interface IPageService {
    void savePage(Page page) throws ServiceException;
    void deletePageById(long id) throws ServiceException;
    Page getById(long id) throws ServiceException;
    List<Page> getAllPages() throws ServiceException;
    List<Page> getAllPagesByCategoryId(long id) throws ServiceException;
    List<Page> getPagesByCriteria(int pageNumber, int pageSize, long categoryId) throws ServiceException;
    void savePage(long categoryId, Page page) throws ServiceException;

//    List<Page> getMostPopularPageList();
   // List<Page> getListOfPageByPageId(String pageId);
}
