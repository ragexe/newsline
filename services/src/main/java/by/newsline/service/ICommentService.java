package by.newsline.service;


import by.newsline.service.util.exception.ServiceException;
import data.Comment;

import java.util.List;

/**
 * Created by HappyQ on 10.06.2015.
 */
public interface ICommentService {
    void saveComment(Comment comment)throws ServiceException;
    void deleteCommentById(long id) throws ServiceException;
    Comment getById(long id) throws ServiceException;
    List<Comment> getAllByPageId(long pageId) throws ServiceException;
    List<Comment> getAllByUserId(long userId) throws ServiceException;


}
