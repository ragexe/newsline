package by.newsline.dao;

import by.newsline.dao.util.exception.DaoException;
import by.newsline.data.Comment;
import by.newsline.data.util.StatusEnum;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.intellij.lang.annotations.Language;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("commentDao")
@Transactional(propagation = Propagation.MANDATORY)
public class CommentDaoImpl extends AbstractDao implements ICommentDao {
    private static final Logger logger = Logger.getLogger(CommentDaoImpl.class);

    public void saveComment(Comment comment) throws DaoException {
        persist(comment);
    }

    public void deleteCommentById(long id) throws DaoException {
        try {
            StatusEnum status = StatusEnum.DELETED;
            @Language("HQL") String hql = "UPDATE Comment SET Comment.status=:status WHERE Comment.id=:id";
            Query query = getSession().createQuery(hql)
                    .setParameter("status", status);
            int res = query.executeUpdate();
            if (res > 1) {
                logger.warn("delete more than one line at deleteCommentById-method");
            }
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw new DaoException(e);
        }
    }

    public Comment getById(long id) throws DaoException {
        Comment comment = null;
        try {
            StatusEnum status = StatusEnum.SAVED;
            @Language("HQL") String hql = "SELECT c FROM Comment c WHERE c.id=:id and c.status=:status";
            Query query = getSession().createQuery(hql)
                    .setParameter("id", id)
                    .setParameter("status", status);
            comment = (Comment) query.uniqueResult();
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw new DaoException(e);
        }
        return comment;
    }

    public List<Comment> getAllByPageId(long pageId) throws DaoException {
        List<Comment> comments = null;
        try {
            StatusEnum status = StatusEnum.SAVED;
            @Language("HQL") String hql = "SELECT c FROM Comment c WHERE c.status=:status and c.page.id=:pageId ORDER BY c.date asc";
            Query query = getSession().createQuery(hql)
                    .setParameter("status", status)
                    .setParameter("pageId", pageId);
            comments = query.list();
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw new DaoException(e);
        }
        return comments;
    }

    public List<Comment> getAllByUserId(long userId) throws DaoException{
        List<Comment> comments = null;
        try {
            StatusEnum status = StatusEnum.SAVED;
            @Language("HQL") String hql = "SELECT c FROM Comment c WHERE c.status=:status and c.user.id=:userId";
            Query query = getSession().createQuery(hql)
                    .setParameter("status", status)
                    .setParameter("userId", userId);
            comments = query.list();
        } catch (HibernateException e) {
            logger.error(e.getMessage());
            throw new DaoException(e);
        }
        return comments;
    }
}

