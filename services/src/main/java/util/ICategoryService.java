package util;

import data.Page;

import java.util.List;

/**
 * Created by HappyQ on 10.06.2015.
 */
public interface ICategoryService {
    Page getPageByPageId(long id);
    List<Page> getListPageByParentid(long id);

}
