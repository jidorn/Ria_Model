package fr.afcepf.al26.ria.utils;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * Created by Stagiaire on 16/03/2016.
 */
public class RiaDataSource implements DataSource {
    private static String login;
    private static String mdp;
    private static String url;
    private static String driver;
    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(RiaDataSource.class);

    static {
        ResourceBundle rb = ResourceBundle.getBundle("al26");
        url = rb.getString("url");
        login = rb.getString("login");
        mdp = rb.getString("mdp");
        driver = rb.getString("driver");
        try {
            //charger une classe dans le classLoader
            Class.forName(driver);
        } catch (ClassNotFoundException paramE) {
            paramE.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        Connection cnx = DriverManager.getConnection(url,login, mdp);
        return cnx;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
