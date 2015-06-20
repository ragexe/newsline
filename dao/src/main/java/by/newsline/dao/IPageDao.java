package by.newsline.dao;

import data.Page;

import java.util.List;


public interface IPageDao {
    void savePage(Page page);
    void deletePageById(long id);
    Page getById(long id);
    List<Page> getAllPages();
    List<Page> getAllPagesByCategoryId(long id);
}
