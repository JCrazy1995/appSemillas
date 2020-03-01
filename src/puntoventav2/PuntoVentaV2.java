/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puntoventav2;

import java.awt.EventQueue;


/**
 *
 * @author GLVSistemas
 */
public class PuntoVentaV2 {

    /**
     * @param args the command line arguments
     */
    public static final String db = "bdpuntoventa";
    public static final String User = "root";
    public static final String pass = "0547";
    private static conectar con;

    public static void main(String[] args) {
        conectar conexion = new conectar();
        conexion.getConeConnection();

        frmPrincipal principal = new frmPrincipal();
        principal.setVisible(true);
        principal.setExtendedState(frmPrincipal.MAXIMIZED_BOTH);
         
     
    }

    
}
