package ru.mtplab.logic;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    private Set<User> users;
    public User currentUser;

    public Manager() {
        users = new HashSet<User>();
        db = DbHelper.getInstance();
    }

    //Добавляет пользователя, если такого уже не существует
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
        if (users.contains(user)) {
            
        }
        return false;
    }
}
