package by.itacademy.lotys.web.shop.lotyshop.properties;

public class Config {

    //DATA_BASE
    public static final String DB_USERNAME = "postgres";
    public static final String DB_PASSWORD = "docker";
    public static final String DB_DRIVER = "org.postgresql.Driver";
    public static final String DB_URL = "jdbc:postgresql://localhost:5400/data_base_lotyShop";



    //NAME_TABLE
    public static final String TABLE_USERS = "table_user";
    public static final String TABLE_PRODUCT = "table_product";
    public static final String TABLE_COMPANY = "table_company";

    //SQL_REQUEST
    public static final String SQL_GET_ALL_TABLE = "SELECT * FROM ";
    public static final String SQL_SET_OBJECT = "INSERT INTO ";
    public static final String SQL_UPDATE = "UPDATE ";
    public static final String SQL_DELETE_OBJECT = "DELETE FROM ";


    //SQL_TABLE_USER
    public static final String SQL_GET_ALL_USERS = SQL_GET_ALL_TABLE + TABLE_USERS;
    public static final String SQL_GET_USER_BY_ID =  SQL_GET_ALL_TABLE + TABLE_USERS + " WHERE id='%1$s'";
    public static final String SQL_GET_USER_BY_EMAIL = SQL_GET_ALL_TABLE + TABLE_USERS +" WHERE email='%1$s'";
    public static final String SQL_CREATE_USER = SQL_SET_OBJECT + TABLE_USERS + "(email,nick_name,password) VALUES ('%s','%s','%s')";

    //SQL_TABLE_PRODUCT
    public static final String SQL_GET_ALL_PRODUCT = SQL_GET_ALL_TABLE + TABLE_PRODUCT;
    public static final String SQL_GET_PRODUCT_BY_ID = SQL_GET_ALL_TABLE+ TABLE_PRODUCT +" WHERE id='%1$s'";

    //SQL_TABLE_COMPANY
    public static final String SQL_GET_ALL_COMPANIES = SQL_GET_ALL_TABLE + TABLE_COMPANY;
    public static final String SQL_GET_COMPANY_BY_ID = SQL_GET_ALL_TABLE + TABLE_COMPANY + " WHERE id='%1$s'";
    public static final String SQL_GET_COMPANY_BY_NAME = SQL_GET_ALL_TABLE + TABLE_COMPANY+" WHERE name='%1$s'";

    public static final String SQL_CREATE_COMPANY = SQL_SET_OBJECT + TABLE_COMPANY + "(name) VALUES ('%s');";
    public static final String SQL_UPDATE_COMPANY = SQL_UPDATE + TABLE_COMPANY + " SET name ='%s' WHERE id=%s";
    public static final String SQL_DELETE_COMPANY = SQL_DELETE_OBJECT+ TABLE_COMPANY+" WHERE id='%s'";



    //IMAGE_PRODUCT
    public static final String URL_IMAGE_BY_ID= "/image/product_"+"%s"+".jpg";

    //URL_GSP
    public static final String URL_ADMINISTRATION_JSP= "/pages/administration/administration.jsp";
    public static final String URL_ADMINISTRATION_PRODUCTS_JSP= "/pages/administration/products/administrationProducts.jsp";
    public static final String URL_ADMINISTRATION_USERS= "/pages/administration/users/administrationUsers.jsp";
    public static final String URL_ADMINISTRATION_COMPANIES_JSP= "/pages/administration/companies/administrationCompanies.jsp";
}
