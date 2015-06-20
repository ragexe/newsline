package by.newsline.dao;

import by.newsline.dao.util.exception.DaoException;
import data.Page;

import java.util.List;


public interface IPageDao {
    void savePage(Page page) throws DaoException;
    void deletePageById(long id) throws DaoException;
    Page getById(long id) throws DaoException;
    List<Page> getAllPages() throws DaoException;
    List<Page> getAllPagesByCategoryId(long id) throws DaoException;
}
