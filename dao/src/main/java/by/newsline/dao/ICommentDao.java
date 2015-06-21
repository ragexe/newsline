package by.newsline.dao;

import by.newsline.dao.util.exception.DaoException;
import by.newsline.data.Comment;

import java.util.List;


public interface ICommentDao {

    void saveComment(Comment comment)throws DaoException;
    void deleteCommentById(long id) throws DaoException;
    Comment getById(long id) throws DaoException;
    List<Comment> getAllByPageId(long pageId) throws DaoException;
    List<Comment> getAllByUserId(long userId) throws DaoException;
}
