package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ema
 */
public class CConexion {
    Connection conectar;
    
    String usuario = "root";
    String contrasenia = "";
    String bd = "login";
    String ip = "localhost";
    String puerto ="3306";
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    
    public Connection estableceConexion(){
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena,usuario,contrasenia);
            //JOptionPane.showMessageDialog(null,"Se conecto correctamente a la Base de Datos");
            
        }catch( Exception e){
            JOptionPane.showMessageDialog(null,"Problemas en la conexion"+ e.toString());
        }
        return conectar;
    }
    public void desconectar(){
        conectar = null;
        if(conectar == null){
            JOptionPane.showMessageDialog(null, "Se desconecto correctamente");
        }
    }
    
}
