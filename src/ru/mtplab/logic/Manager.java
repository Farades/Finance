package ru.mtplab.logic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Класс Manager - основной класс для управления данными и связи GUI с логикой (контроллер).
 */
public class Manager implements DataStore {
    private static Logger logger = LoggerFactory.getLogger(Manager.class);
    private DbHelper db;
    public User currentUser;

    public Manager() {
        db = DbHelper.getInstance();
    }

    //Добавляет пользователя в БД, если такого уже не существует
    @Override
    public boolean addUser(User user) {
        logger.info("Adding new user: {}", user);
        PreparedStatement statement = null;
        try {
            statement = db.getConn().prepareStatement("INSERT INTO USERS (LOGIN, PASSWORD) VALUES (?, ?);");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            int result = statement.executeUpdate();
            logger.info("Add user {} : {}", user, result);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            db.closeResource(statement);
        }
        return true;
    }

    @Override
    public void addAccount(User user, Account account) {

    }

    @Override
    public void addRecord(Account account, Record record) {

    }

    public boolean checkUser(User user) {
        logger.info("Checking user: {}", user);
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = db.getConn().prepareStatement("SELECT * FROM USERS WHERE LOGIN=?");
            statement.setString(1, user.getUsername());
            rs = statement.executeQuery();
            while (rs.next()) {
                String userName = rs.getString(2);
                String password = rs.getString(3);
                if ( userName.equals(user.getUsername()) && password.equals(user.getPassword()) ) {
                    logger.info("Login Successful");
                    return true;
                } else {
                    logger.info("Wrong Username or Password");
                    return false;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            db.closeResource(rs);
            db.closeResource(statement);
        }
        logger.info("Wrong Username or Password");
        return false;
    }

//    Валидация пользователя
//    метод возвращает ArrayList, элементами которого являются текстовые описания ошибок
//    если валидация успешна, то ArrayList вернется пустым
    public ArrayList<String> validateUser(User user) {
        logger.info("Validate user {}", user);
        ArrayList<String> res = new ArrayList<String>();
        if ( user.getPassword().length() < 5 || user.getPassword().length() > 20) {
            res.add("Некорректная длина пароля");
        } else if ( user.getUsername().length() < 5 || user.getUsername().length() > 20) {
            res.add("Некорректная длина логина");
        }
        return res;
    }
}
