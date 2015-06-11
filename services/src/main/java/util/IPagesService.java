package util;

import data.Pages;

import java.util.List;

/**
 * Created by HappyQ on 11.06.2015.
 */
public interface IPagesService {
    Pages getPageByPageId(long id);
    List<Pages> getListOfPageByCategory(Long categoryId);
    List<Pages> getListPageByParentid(long id);

}
