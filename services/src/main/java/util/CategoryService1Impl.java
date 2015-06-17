package util;

import dao.CategoryDaoImpl;
import data.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by ragexe on 17.06.2015.
 */

@Service("categoryService")
@Transactional
public class CategoryService1Impl implements ICategoryService1 {

    @Autowired
    private CategoryDaoImpl dao;

    @Override
    public void saveCategory(Category category) {
        dao.saveCategory(category);
    }

    @Override
    public void deleteCategoryById(long id) {
        dao.deleteCategoryById(id);
    }

    @Override
    public Category getById(long id) {
        return dao.getById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return dao.getAllCategories();
    }
}
