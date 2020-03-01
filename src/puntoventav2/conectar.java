/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puntoventav2;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Francisco Rafael
 */
public class conectar {
       public static final String db="bdpuntoventa";
       public static final String User="root";
       public static final String pass="0547";
       static String url = "jdbc:mysql://localhost:3306/"+db+"?serverTimezone=UTC";
   
   private static Connection Conn=null;
   
//   public static Connection getConnection(){
//       
//       return Conn;
//   }
//   public Connection getConeConnection(){
//        try {
//           Conn=DriverManager.getConnection(url,User,pass);
//           JOptionPane.showMessageDialog(null,"Conexion exitosa");
//          
//       } catch (SQLException e) {
//           JOptionPane.showMessageDialog(null, "Error de conexion "+e.getMessage());
//       }
//       return Conn;
//   }
    private String driver;
   
   public conectar(String driver,String url)
   {
       this.driver = driver;
       
   }
   public void conectarbd()
   {
       try {
           Class.forName(this.driver);
           Conn=DriverManager.getConnection(this.url,"root","0547");
           JOptionPane.showMessageDialog(null, pass);
       }
       catch (ClassNotFoundException e) 
       {
           e.printStackTrace();
       }
       catch (SQLException e) 
       {
           e.printStackTrace();
       }
       
   }
   
}