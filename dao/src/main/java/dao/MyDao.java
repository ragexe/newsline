package dao;

import data.Page;
import data.Users;
import org.apache.log4j.Logger;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MyDao implements Dao {
    private static final Logger log = Logger.getLogger(MyDao.class);
    private static final long serialVersionUID = 4L;
    private Connection connection;
    private String url;
    private String user;
    private String password;
    private Properties properties = new Properties();
    //private static final String FILE_PROPERTIES_NAME = "E:\\News\\News\\config.properties";
    private static final String FILE_PROPERTIES_NAME = "D:\\Projects\\newsline\\dao\\src\\main\\resources\\config.properties";

    private MyDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            log.error("error");
            log.error(e.getMessage());
        }
        try {
            properties.load(new FileInputStream(FILE_PROPERTIES_NAME));
        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        } catch (IOException e1) {
            log.error(e1.getMessage());
            e1.printStackTrace();
        }
        try {
            url = properties.getProperty("db.url");
            user = properties.getProperty("db.user");
            password = properties.getProperty("db.password");
        } catch (NullPointerException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(url, user, password);
            //connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/NewsBase", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    private static MyDao thisDao;

    public static synchronized MyDao getDao() {
        if (thisDao == null)
            thisDao = new MyDao();
        return thisDao;
    }

    @Override
    public Page getPage(String id) {
        Page data = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from pages where id='" + id + "'");
            if (rs.next()) {
                data = new Page();
                data.setId(rs.getString("id"));
                data.setParentid(rs.getString("parentid"));
                data.setTitle(rs.getString("title"));
                data.setTitle4menu(rs.getString("title4menu"));
                data.setUser(rs.getInt("user"));
                data.setDate(rs.getString("date"));
                data.setMaintext(rs.getString("maintext"));
            } else
                return null;
        } catch (SQLException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public List<Page> getPagesByParent(String parentid)
    {
        ArrayList<Page> pages = new ArrayList<Page>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from pages where parentid='" + parentid + "'");
            while (rs.next()) {
                Page data = new Page();

                data.setId(rs.getString("id"));
                data.setParentid(rs.getString("parentid"));
                data.setTitle(rs.getString("title"));
                data.setTitle4menu(rs.getString("title4menu"));
                data.setUser(rs.getInt("user"));
                data.setDate(rs.getString("date"));
                data.setMaintext(rs.getString("maintext"));
                pages.add(data);

            }
        } catch (SQLException e) {
            //log.error(e1.getMessage());
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return pages;
    }

    @Override
    public int addPage(Page p) {
        Page data = null;
        data = p;
        int add = 0;
        String saddPage = properties.getProperty("saddPage");
        //String addPage = "INSERT INTO pages VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pStatement = null;
        try {
            pStatement = connection.prepareStatement(saddPage);
        } catch (SQLException e1) {
            log.error(e1.getMessage());
            e1.printStackTrace();
        }
        try {
            pStatement.setString(1, data.getId());
            pStatement.setString(2, data.getParentid());
            pStatement.setString(3, data.getTitle());
            pStatement.setString(4, data.getTitle4menu());
            pStatement.setInt(5, data.getUser());
            pStatement.setString(6, data.getDate());
            pStatement.setString(7, data.getMaintext());
        } catch (SQLException e1) {
            log.error(e1.getMessage());
            e1.printStackTrace();
        }
        try {
            add = pStatement.executeUpdate();
        } catch (SQLException e1) {
            log.error(e1.getMessage());
            e1.printStackTrace();
        }
        return add;
    }

    @Override
    public int deletePage(Page p) {
        Page data = null;
        data = p;
        int add = 0;
        String sdeletePage = properties.getProperty("sdeletePage");
        //String deletePage = "DELETE FROM pages  Where id=?";
        PreparedStatement pStatement = null;
        try {
            pStatement = connection.prepareStatement(sdeletePage);
        } catch (SQLException e1) {
            log.error(e1.getMessage());
            e1.printStackTrace();
        }
        try {
            pStatement.setString(1, data.getId());
        } catch (SQLException e1) {
            log.error(e1.getMessage());
            e1.printStackTrace();
        }
        try {
            add = pStatement.executeUpdate();
        } catch (SQLException e1) {
            log.error(e1.getMessage());
            e1.printStackTrace();
        }
        return add;
    }

    @Override
    public int editPage(Page p) {
        Page data = null;
        data = p;
        int add = 0;
        String seditPage = properties.getProperty("seditPage");
        //String editPage = "UPDATE pages SET parentid=?, title=?, title4menu=?, user=?, date=?, maintext=? WHERE id=?";
        PreparedStatement pStatement = null;
        try {
            pStatement = connection.prepareStatement(seditPage);
        } catch (SQLException e1) {
            log.error(e1.getMessage());
            e1.printStackTrace();
        }
        try {
            pStatement.setString(1, data.getParentid());
            pStatement.setString(2, data.getTitle());
            pStatement.setString(3, data.getTitle4menu());
            pStatement.setInt(4, data.getUser());
            pStatement.setString(5, data.getDate());
            pStatement.setString(6, data.getMaintext());
            pStatement.setString(7, data.getId());
        } catch (SQLException e1) {
            log.error(e1.getMessage());
            e1.printStackTrace();
        }
        try {
            add = pStatement.executeUpdate();
        } catch (SQLException e1) {
            log.error(e1.getMessage());
            e1.printStackTrace();
        }
        return add;
    }

    @Override
    public Users getUser(String email) {
        Users ussr = new Users();
        //String sgetUserByEmail = properties.getProperty("sgetUserByEmail");
        String usermail = "select * from users where email like '" + email + "'";
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(usermail);
            if (result.next()) {
                ussr.setIdu(result.getInt("idu"));
                ussr.setName(result.getString("name"));
                ussr.setLastname(result.getString("lastname"));
                ussr.setEmail(result.getString("email"));
                ussr.setPassword(result.getString("password"));
                ussr.setRole(result.getInt("role"));
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return ussr;
    }

    public Users getUser(int idu) {
        Users ussr = new Users();
        //String sgetUserByEmail = properties.getProperty("sgetUserByEmail");
        String useridu = "select * from users where idu='" + idu + "'";
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(useridu);
            if (result.next()) {
                ussr.setIdu(result.getInt("idu"));
                ussr.setName(result.getString("name"));
                ussr.setLastname(result.getString("lastname"));
                ussr.setEmail(result.getString("email"));
                ussr.setPassword(result.getString("password"));
                ussr.setRole(result.getInt("role"));
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return ussr;
    }

    @Override
    public List<Users> getUsers() {
        ArrayList<Users> user = new ArrayList<Users>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select idu, name, email, role from users");
            while (rs.next()) {
                Users usr = new Users();
                usr.setIdu(rs.getInt("idu"));
                usr.setName(rs.getString("name"));
                usr.setEmail(rs.getString("email"));
                usr.setRole(rs.getInt("role"));
                user.add(usr);
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return user;
    }
}
