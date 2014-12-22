package ru.mtplab.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by tess on 22.12.2014.
 */
public class DbHelper {

    private static Logger logger = LoggerFactory.getLogger(DbHelper.class);
    private static Connection conn;
    private static DbHelper instance;
    private static String dbURL = "jdbc:sqlite:finance.sqlite";

    public static DbHelper getInstance() {
        if (instance == null) {
            instance = new DbHelper();
        }
        return instance;
    }

    private DbHelper() {
        try {
            Class.forName("org.sqlite.JDBC");
            logger.info("Opening db: {}", dbURL);
            conn = DriverManager.getConnection(dbURL);

            if (!isTablesExist()) {
                Statement stmt = conn.createStatement();
                String createSql = readResource(DbHelper.class, "create.sql");
                stmt.executeUpdate(createSql);

                String insertSql = readResource(DbHelper.class, "insert.sql");
                stmt.executeUpdate(insertSql);
                stmt.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public Connection getConn() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(dbURL);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }


    boolean isTablesExist() throws Exception {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT count(*) FROM sqlite_master WHERE type='table' AND name='USERS';");
        boolean result = true;
        int count = rs.getInt(1);
        if (count == 0) {
            result = false;
        }
        rs.close();
        stmt.close();
        return result;
    }

    String readResource(Class cpHolder, String path) throws Exception {
        java.net.URL url = cpHolder.getResource(path);
        java.nio.file.Path resPath = java.nio.file.Paths.get(url.toURI());
        return new String(java.nio.file.Files.readAllBytes(resPath), "UTF8");
    }

    static void closeResource(AutoCloseable res) {
        try {
            if (res != null) {
                res.close();
                res = null;
            }
        } catch (Exception e) {
            logger.warn("Failed to close resource: {}", res);
        }
    }

    static void closeConnection() {
        closeResource(conn);
        conn = null;
    }
}
