package by.newsline.service;


import by.newsline.dao.ICategoryDao;
import by.newsline.dao.ICommentDao;
import by.newsline.dao.util.exception.DaoException;
import by.newsline.service.util.exception.ServiceException;
import data.Category;
import data.Comment;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//import by.newsline.dao.util.exception.PersistException;

/**
 * Created by HappyQ on 10.06.2015.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CommentService implements ICommentService {
    private static final Logger logger = Logger.getLogger(CommentService.class);

    @Autowired
    private ICommentDao commentDao;

    //    public void saveCategory(Category comment) throws ServiceException{
//        try {
//            commentDao.saveCategory(comment);
//        } catch (DaoException e) {
//            logger.error(e.getMessage());
//            throw new ServiceException(e);
//        }
//    }
//
//    public void deleteCategoryById(long id) throws ServiceException {
//        try {
//            commentDao.deleteCommentById(id);
//        } catch (DaoException e) {
//            logger.error(e.getMessage());
//            throw new ServiceException(e);
//        }
//    }
//
//    public Category getById(long id) throws ServiceException{
//        try {
//            return commentDao.getById(id);
//        } catch (DaoException e) {
//            logger.error(e.getMessage());
//            throw new ServiceException();
//        }
//    }
//
//    public List<Category> getAllCategories() throws ServiceException{
//        try {
//            return commentDao.getAllCategories();
//        } catch (DaoException e) {
//            logger.error(e.getMessage());
//            throw new ServiceException();
//        }
//    }
    public void saveComment(Comment comment)throws ServiceException{
        try {
            commentDao.saveComment(comment);
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException(e);
        }
    }
    public void deleteCommentById(long id) throws ServiceException{
        try {
            commentDao.deleteCommentById(id);
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException(e);
        }
    }
    public Comment getById(long id) throws ServiceException{
        try {
            return commentDao.getById(id);
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException();
        }
    }
    public List<Comment> getAllByPageId(long pageId) throws ServiceException{
        try {
            return commentDao.getAllByPageId(pageId);
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException();
        }
    }
    public List<Comment> getAllByUserId(long userId) throws ServiceException{
        try {
            return commentDao.getAllByUserId(userId);
        } catch (DaoException e) {
            logger.error(e.getMessage());
            throw new ServiceException();
        }
    }
}
