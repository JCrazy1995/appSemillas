/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puntoventav2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Francisco Rafael
 */
public class conectar {
       public static final String db="bdSemillas";
       private static final String User="root";
       private static final String pass="0547";
       static String url = "jdbc:mysql://localhost:3306/"+db+"?serverTimezone=UTC";
   
   private static Connection Conn=null;
   
   public static Connection getConnection()
   {
        try {
        
        Conn=DriverManager.getConnection(url,User,pass);
  
          
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, "Error de conexion "+e.getMessage());
       }
       return Conn;
   }
   public Connection getConeConnection() throws ClassNotFoundException{
       
       return Conn;
   }
}