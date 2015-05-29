package daofactory;

import dao.IGenDao;
import exception.PersistException;

/**
 * Created by ragexe on 11.04.15.
 *
 * Factory objects to work with the database
 * Methods to connect to and work with databases. Implementing class MYSQLDAOFACTORY.
 */
public interface IDaoFactory {

    /**
     * -= INNER INTARFACE =-
     * Created with a unique method create (Connection connection), returns an object interface IGenericDao
     * IGenericDao-object - an object containing a set of operations on the database on behalf of one of the entities,
     * IGenericDao which implements methods in the code
     */
    interface IDaoCreator {
        IGenDao create();
    }

    /** Returns object to control a persistent state of the object without created connection
     * Connection created in each method */
    IGenDao getDao(Class dtoClass) throws PersistException;

}
