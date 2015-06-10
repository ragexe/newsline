package daofactory;


import dao.CategoryDao;
import dao.IGenDao;
import dao.PageDao;
import dao.UserDao;
import data.Category;
import data.Page;
import data.User;
import exception.PersistException;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ragexe on 11.04.15.
 * It implements the interface methods to connect to the database for domain entity and building factory
 */
public class DaoFactoryImpl implements IDaoFactory {
    
    private static DaoFactoryImpl instance;
    private Map<Class, IDaoCreator> creators;
    private static final Logger logger = Logger.getLogger(DaoFactoryImpl.class);

    private DaoFactoryImpl() {
        creators = new HashMap<Class, IDaoCreator>();
        //Inherited from IDaoFactory to build a factory to work with a specific domain entity
        creators.put(User.class, new IDaoCreator() {
            @Override
            public IGenDao create() {
                return new UserDao();
            }
        });
        creators.put(Page.class, new IDaoCreator() {
            @Override
            public IGenDao create() {
                return new PageDao();
            }
        });
        creators.put(Category.class, new IDaoCreator() {
            @Override
            public IGenDao create() {
                return new CategoryDao();
            }
        });
//        creators.put(Commentary.class, new IDaoCreator() {
//            @Override
//            public IGenDao create() {
//                return new CommentaryDao();
//            }
//        });
//        creators.put(Category.class, new IDaoCreator() {
//            @Override
//            public IGenDao create() {
//                return new CategoryDao();
//            }
//        });
//        creators.put(UserDetail.class, new IDaoCreator() {
//            @Override
//            public IGenDao create() {
//                return new UserDetailDao();
//            }
//        });
    }

    public static synchronized DaoFactoryImpl getInstance(){
        if (instance == null){
            instance = new DaoFactoryImpl();
        }
        return instance;
    }

    /**
     * Method for creating DAO objects (в моем случае либо Expense либо Receiver)
     * 2. First you need to create a factory, and then through it to create objects for the Dao of the essence,
      * Over which you plan to perform CRUD operations.
     * @param dtoClass class of domain entity for getting dao
     * @return dao for domain entity
     * @throws exception.PersistException
     */
    @Override
    public IGenDao getDao(Class dtoClass) throws PersistException {
        IDaoCreator creator = creators.get(dtoClass);
        if (creator == null) {
            throw new PersistException("Dao object for " + dtoClass + " not found.");
        }
        return creator.create();
    }

}
