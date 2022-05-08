package by.itacademy.lotys.web.shop.lotyshop.properties;

public class Config {

    //DATA_BASE
    public static final String DB_USERNAME = "postgres";
    public static final String DB_PASSWORD = "docker";
    public static final String DB_DRIVER = "org.postgresql.Driver";
    public static final String DB_URL = "jdbc:postgresql://localhost:5400/data_base_lotyShop";

    //SQL_TABLE_USER
    public static final String SQL_GET_ALL_USERS = "SELECT * FROM table_user";
    public static final String SQL_GET_USER_BY_EMAIL = "SELECT * FROM table_user WHERE email='%1$s'";
    public static final String SQL_GET_USER_BY_ID = "SELECT * FROM table_user WHERE id='%1$s'";
    public static final String SQL_CREATE_USER = "INSERT INTO table_user(email,nick_name,password) VALUES ('%s','%s','%s')";

    //SQL_TABLE_PRODUCT
    public static final String SQL_GET_PRODUCT_BY_ID = "SELECT * FROM table_product WHERE id='%1$s'";
    public static final String SQL_GET_ALL_PRODUCT = "SELECT * FROM table_product";

    //SQL_TABLE_COMPANY
    public static final String SQL_CREATE_COMPANY = "INSERT INTO table_company (name) VALUES ('%s');";
    public static final String SQL_UPDATE_COMPANY = "UPDATE table_company SET name ='%s' WHERE id=%s";
    public static final String SQL_GET_COMPANY_BY_ID= "SELECT * FROM table_company WHERE id='%1$s'";
    public static final String SQL_GET_COMPANY_BY_NAME= "SELECT * FROM table_company WHERE name='%1$s'";
    public static final String SQL_DELETE_COMPANY = "DELETE FROM table_company WHERE id='%s'";
    public static final String SQL_GET_ALL_COMPANIES = "SELECT * FROM table_company";

    //IMAGE_PRODUCT
    public static final String URL_IMAGE_BY_ID= "/image/product_"+"%s"+".jpg";

    //URL_GSP
    public static final String URL_ADMINISTRATION_JSP= "/pages/administration/administration.jsp";
    public static final String URL_ADMINISTRATION_PRODUCTS_JSP= "/pages/administration/products/administrationProducts.jsp";
    public static final String URL_ADMINISTRATION_USERS= "/pages/administration/users/administrationUsers.jsp";
    public static final String URL_ADMINISTRATION_COMPANIES_JSP= "/pages/administration/companies/administrationCompanies.jsp";
}
