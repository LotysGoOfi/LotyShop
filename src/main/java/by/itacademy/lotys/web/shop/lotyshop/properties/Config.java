package by.itacademy.lotys.web.shop.lotyshop.properties;

public class Config {

    //DATA_BASE
    public static final String DB_USERNAME = "postgres";
    public static final String DB_PASSWORD = "docker";
    public static final String DB_DRIVER   = "org.postgresql.Driver";
    public static final String DB_URL      = "jdbc:postgresql://localhost:5400/data_base_lotyShop";


    //TABLE_USER
    public static final String TABLE_USERS                      = "table_user";
    public static final String TABLE_USER_COLUMN_ID_USER        = "id_user";
    public static final String TABLE_USER_COLUMN_EMAIL_USER     = "email_user";
    public static final String TABLE_USER_COLUMN_NICK_NAME_USER = "nick_name_user";
    public static final String TABLE_USER_COLUMN_PASSWORD_USER  = "password_user";
    public static final String TABLE_USER_COLUMN_ID_ROLE_USER   = "id_role_user";




    //TABLE_USER_ROLE
    private static final String TABLE_USER_ROLE = "table_user_role";
    public static final String TABLE_USER_ROLE_COLUMN_ID_USER_ROLE = "id_user_role";
    public static final String TABLE_USER_ROLE_COLUMN_NAME_USER_ROLE = "name_user_role";

    //TABLE_ESTIMATES_PRODUCT
    private static final String TABLE_ESTIMATES_PRODUCT = "table_estimates_product";
    public static final String TABLE_ESTIMATES_PRODUCT_COLUMN_APPRAISAL_PRODUCT = "appraisal_product";
    public static final String TABLE_ESTIMATES_PRODUCT_COLUMN_ID_USER = "id_user";
    public static final String TABLE_ESTIMATES_PRODUCT_COLUMN_ID_PRODUCT = "id_product";






    //SQL_REQUEST
    private static final String SQL_GET_ALL_TABLE = "SELECT * FROM ";
    private static final String SQL_SET_OBJECT = "INSERT INTO ";
    private static final String SQL_UPDATE = "UPDATE ";
    private static final String SQL_DELETE_OBJECT = "DELETE FROM ";


    //SQL_TABLE_ESTIMATES_PRODUCT
    public static final String SQL_GET_APPRAISAL_BY_ID_PRODUCT = SQL_GET_ALL_TABLE +TABLE_ESTIMATES_PRODUCT+ " WHERE " + TABLE_ESTIMATES_PRODUCT_COLUMN_ID_PRODUCT+"=%s";


    //SQL_TABLE_USER
    public static final String SQL_GET_ALL_USERS      = SQL_GET_ALL_TABLE + TABLE_USERS;
    public static final String SQL_GET_USER_BY_ID     =  SQL_GET_ALL_TABLE + TABLE_USERS + " WHERE " + TABLE_USER_COLUMN_ID_USER + "=%s";
    public static final String SQL_GET_USER_BY_EMAIL  = SQL_GET_ALL_TABLE + TABLE_USERS +" WHERE "+TABLE_USER_COLUMN_EMAIL_USER + "='%s'";
    public static final String SQL_CREATE_USER        = SQL_SET_OBJECT + TABLE_USERS + "(email,nick_name,password) VALUES ('%s','%s','%s')";



    //SQL_TABLE_COMPANY



    //IMAGE_PRODUCT
    public static final String URL_IMAGE_BY_ID= "/image/product_"+"%s"+".jpg";

    //URL_GSP
    public static final String URL_ADMINISTRATION_JSP= "/pages/administration/administration.jsp";
    public static final String URL_ADMINISTRATION_PRODUCTS_JSP= "/pages/administration/products/administrationProducts.jsp";
    public static final String URL_ADMINISTRATION_USERS= "/pages/administration/users/administrationUsers.jsp";
    public static final String URL_ADMINISTRATION_COMPANIES_JSP= "/pages/administration/companies/administrationCompanies.jsp";
}
