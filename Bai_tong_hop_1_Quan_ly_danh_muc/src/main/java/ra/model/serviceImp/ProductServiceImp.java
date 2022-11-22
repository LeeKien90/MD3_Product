package ra.model.serviceImp;


import ra.model.dao.IProductDao;
import ra.model.daoImp.ProductDaoImp;
import ra.model.entity.Product;
import ra.model.service.ProductService;

import java.util.List;

public class ProductServiceImp implements ProductService<Product, String> {
    private IProductDao<Product,String> productDao = new ProductDaoImp();
    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public boolean save(Product product) {
        return productDao.save(product);
    }

    @Override
    public boolean update(Product product) {
        return productDao.update(product);
    }

    @Override
    public boolean delete(String id) {
        return productDao.delete(id);
    }

    @Override
    public Product getById(String id) {
        return productDao.getById(id);
    }

    @Override
    public List<Product> seachProductByName(String name) {
        return null;
    }
}
