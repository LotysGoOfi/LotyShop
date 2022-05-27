package by.itacademy.lotys.web.shop.lotyshop.repositories.products;


import by.itacademy.lotys.web.shop.lotyshop.entities.Product;
import by.itacademy.lotys.web.shop.lotyshop.repositories.JDBCRepository;


import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ImplementProductRepository extends JDBCRepository implements ProductRepository {

    private static final String TABLE_PRODUCT = "table_product";
    private static final String ID_PRODUCT = "id_product";
    private static final String ID_COMPANY = "id_company";

    private static final String VALUE_PRODUCT = "value_product";
    private static final String DESCRIPTION_PRODUCT = "description_product";
    private static final String NAME_PRODUCT = "name_product";
    private static final String PRICE_PRODUCT = "price_product";
    private static final String URL_IMAGE_PRODUCT = "url_image_product";
    private static final String ID_CATEGORY = "id_category";
    private static final String TABLE_CATEGORY_PRODUCT = "table_category_product";
    private static final String CATEGORY = "category_product";


    private static final String SQL_GET_ALL_PRODUCT = "SELECT FROM " + TABLE_PRODUCT;
    private static final String SQL_GET_PRODUCT_BY_ID = "SELECT FROM " + TABLE_PRODUCT + " WHERE " + ID_PRODUCT + "='%s'";
    private static final String SQL_CREATE_PRODUCT = "INSERT INTO" + TABLE_PRODUCT + "(" + ID_COMPANY + "," + VALUE_PRODUCT + "," + DESCRIPTION_PRODUCT + "," + NAME_PRODUCT + "," + PRICE_PRODUCT + "," + URL_IMAGE_PRODUCT + "," + ID_PRODUCT + ")" + "VALUES (%s,%s,'%s','%s',%s,'%s',%s);";
    private static final String SQL_UPDATE_PRODUCT = "UPDATE" + TABLE_PRODUCT + "SET" + ID_COMPANY + "= %s" + VALUE_PRODUCT + "= %s" + DESCRIPTION_PRODUCT + "= %s" + NAME_PRODUCT + "= %s" + PRICE_PRODUCT + "= %s" + URL_IMAGE_PRODUCT + "= %s" + ID_CATEGORY + "= %s";
    private static final String SQL_DELETE_PRODUCT = "DELETE FROM " + TABLE_PRODUCT + " WHERE " + ID_PRODUCT + "=%s";
    private static final String SQL_GET_CATEGORY = "SELECT FROM " + TABLE_CATEGORY_PRODUCT + " WHERE " + ID_CATEGORY + "= %s";
    private static final String SQL_GET_CATEGORY_ID = "SELECT FROM " + TABLE_CATEGORY_PRODUCT + " WHERE " + CATEGORY + "= %s";


    @Override
    public Optional<Product> getProduct(int id) {
        String sql = String.format(SQL_GET_PRODUCT_BY_ID, id);
        return Optional.of(execute(sql, this::setProduct));
    }

    @Override
    public void createProduct(Product product) {
        String sql = String.format(SQL_CREATE_PRODUCT
                , product.getCompany().getId()
                , product.getValue()
                , product.getDescription()
                , product.getName()
                , product.getPrice()
                , product.getImage()
                , getIDCategoryByName(product.getCategory()));
        execute(sql);
    }

    @Override
    public Optional<Product> updateProduct(Product product) {
        String sql = String.format(SQL_UPDATE_PRODUCT
                , product.getCompany().getId()
                , product.getValue()
                , product.getDescription()
                , product.getName()
                , product.getPrice()
                , product.getImage()
                , getIDCategoryByName(product.getCategory()));
        execute(sql);
        return getProduct(product.getId());
    }

    @Override
    public void deleteProduct(int id) {
        execute(String.format(SQL_DELETE_PRODUCT,id));
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        executeEach(SQL_GET_ALL_PRODUCT,resultSet -> products.add(setProduct(resultSet)));
        return products;
    }

    @Override
    public Optional<String> getCategory(int id) {
        String sql = String.format(SQL_GET_CATEGORY, id);
        return Optional.of(execute(sql, this::getCategory));
    }

    @Override
    public int getIDCategoryByName(String name) {
        String sql = String.format(SQL_GET_CATEGORY_ID, name);
        return execute(sql, this::getIDCategory);
    }

    private String getCategory(ResultSet resultSet) {
        try {
            return resultSet.getString(CATEGORY);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private int getIDCategory(ResultSet resultSet) {
        try {
            return resultSet.getInt(ID_CATEGORY);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Product setProduct(ResultSet resultSet) {
        try {
            int id = resultSet.getInt(ID_PRODUCT);
            return Product.builder()
                    .id(id)
                    .price(BigDecimal.valueOf(resultSet.getInt(PRICE_PRODUCT)))
                    .name(resultSet.getString(NAME_PRODUCT))
                    .value(resultSet.getInt(VALUE_PRODUCT))
                    .description(resultSet.getString(DESCRIPTION_PRODUCT))
                    .image(resultSet.getString(URL_IMAGE_PRODUCT))
                    .category(getCategory(id).orElse("null"))
                    .build();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }
}
