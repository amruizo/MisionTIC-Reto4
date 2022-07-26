
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection connection;
    String driver = "com.mysql.cj.jdbc.Driver";
    String cadenaConexxion = "jdbc:mysql://localhost:3306/reto1_g55_AngelaRuiz_db";
    String user = "app";
    String password = "Maryo2204*";
    
    public Conexion(){
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(cadenaConexxion, user, password);
            if(connection !=null){
            System.out.println("Conexión exitosa a la BD");
            }
        }catch(ClassNotFoundException | SQLException e){
            System.err.println("No se logro extablecer conexión");
        }
    }
    
    public Connection getConnection(){
        return connection;
    }  
}
