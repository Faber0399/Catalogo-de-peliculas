package datosPeliculas;

import java.sql.*;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER= "root";
    private static final String JDBC_PW= "admin";

    public static Connection getConnection() throws SQLException{  
        return  DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PW); 
    }
    public static void close ( ResultSet rs) throws SQLException{
        rs.close();
    }
    public static void close (Statement rs) throws SQLException{
        rs.close();
    }
    public static void close (PreparedStatement rs) throws SQLException{
        rs.close();
    }
    public static void close(Connection rs) throws SQLException{
        rs.close();
    }
}