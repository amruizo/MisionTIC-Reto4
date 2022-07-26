
package Controlador;

import Modelo.Conexion;
import Modelo.Sucursal;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author angela
 */
public class cbSucursal {
    Connection connection;
    Conexion conexion = new Conexion();
    Statement st;
    ResultSet rs;
    
    public cbSucursal(){
    }
    
    public ArrayList getListSucursales(){
        ArrayList mListSucursales = new ArrayList();
        Sucursal sucursal = null;
        String querySucursales = "SELECT idSucursal, nombreSucursal FROM Sucursal;";
        try{
            connection =conexion.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery(querySucursales);
            while(rs.next()){
                sucursal = new Sucursal();
                //Consultamos y asignamos lo que devuele la BD
                sucursal.setIdSucursal(rs.getInt("idSucursal"));
                sucursal.setNombreSucursal(rs.getNString("nombreSucursal"));
                mListSucursales.add(sucursal);
            }
        }catch(SQLException e){
            System.out.print(e);
        }
        System.out.print(mListSucursales);
        return mListSucursales; 
    }
}
