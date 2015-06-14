package util;

import data.Category;


import java.util.List;

/**
 * Created by HappyQ on 10.06.2015.
 */
public interface ICategoryService {

    List<Category> getList();
    public Category getCategoryById(long id);

}
