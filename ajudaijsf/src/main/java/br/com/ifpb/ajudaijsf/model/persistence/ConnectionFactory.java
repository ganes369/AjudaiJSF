package br.com.ifpb.ajudaijsf.model.persistence;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static String url;
    private static String usuario;
    private static String senha;
    private static String driver;


    static {
        InputStream inputStream = ConnectionFactory.class.getClassLoader().getResourceAsStream("configurations/" +
                "config.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            url = properties.getProperty("ajudaijsf.banco.url");
            usuario = properties.getProperty("ajudaijsf.banco.usuario");
            senha = properties.getProperty("ajudaijsf.banco.senha");
            driver = properties.getProperty("ajudaijsf.banco.driver");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        return DriverManager.getConnection(url,usuario,senha);
    }
}
