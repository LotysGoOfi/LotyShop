package by.itacademy.lotys.web.shop.lotyshop.repositories.products;

import by.itacademy.lotys.web.shop.lotyshop.dao.DAO;
import by.itacademy.lotys.web.shop.lotyshop.dao.DAOLocalDataBase;
import by.itacademy.lotys.web.shop.lotyshop.entities.Product;

import java.util.List;

public class ImplementProductRepository implements ProductRepository {

    private final DAO dao = new DAOLocalDataBase();

    @Override
    public Product getProduct(int id) {
        return dao.getProduct(id);
    }

    @Override
    public Product addProduct() {
        return dao.addProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        return dao.getAllProducts();
    }
}
