/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puntoventav2;


import com.itextpdf.text.BaseColor;
import java.awt.Image;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.Desktop;
import java.io.FileOutputStream;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Francisco Rafael
 */
public class frmbuscaclientes extends javax.swing.JFrame {

    /**
     * Creates new form frmbuscaclientes
     */
    private static Connection con=null; 
     static ResultSet rs=null;
    private Statement stmt=null;
    conectar conexion = new conectar();
    DefaultTableModel modeloTabla= new DefaultTableModel();  //modelo de tabla que llevara los datos
    DefaultTableModel modeloTabla2= new DefaultTableModel(); // modelo vacio para la tabla de clientes
    Object filas[]= new Object[7]; 
    
      DefaultListModel modelo=new DefaultListModel();
      
      
      
    public frmbuscaclientes() 
    {
        initComponents();     
        dobleclick();
        configModelo();
        inicio();
       txtNombre.requestFocus();
    }

     void configModelo()
        {
            modeloTabla.addColumn("Numero ");
            modeloTabla.addColumn("nombre");
            modeloTabla.addColumn("Direccion");
            modeloTabla.addColumn(" Colonia");
            modeloTabla.addColumn("tipo pago");   
            modeloTabla.addColumn("dias"); 
            modeloTabla.addColumn("Telefono");
            tblbuscaclientes.setModel(modeloTabla);
             
        }
    
    void eliminar(){
        
        DefaultTableModel tb = (DefaultTableModel) tblbuscaclientes.getModel();
        int a = tblbuscaclientes.getRowCount()-1;
        for (int i = a; i >= 0; i--) {          
        tb.removeRow(tb.getRowCount()-1);
        }
        
            
        //cargaTicket();
    }
    
    
//    void pdf() 
//    {
//      Document documento = new Document();
//      FileOutputStream ficheroPdf;
//      try 
//        {
//         ficheroPdf = new FileOutputStream("C:\\Users\\coron\\Desktop\\prueba\\ejemplo.PDF");
//         PdfWriter.getInstance(
//                               documento, 
//                               ficheroPdf
//                               ).setInitialLeading(20);
//        }
//        catch (Exception ex) 
//        {
//         System.out.println(ex.toString());
//        }
//      
//      try{
//         documento.open();
//               //aqui agregamos todo el contenido del PDF...
//              documento.add(new Paragraph("nuestro texto"));
//                Paragraph parrafo2 = new Paragraph("nuestro segundo Texto");
//                parrafo2.setAlignment(1);//el 1 es para centrar
//                documento.add(parrafo2);
//                documento.add(new Paragraph(" "));
//                PdfPTable tabla = new PdfPTable(7);
//                //el numero indica la cantidad de Columnas
//                
//                tabla.setWidthPercentage(100);
//                //Datos del ancho de cada columna.
//                tabla.setWidths(new float[] {15, 20, 10, 10, 10, 10, 20});
//
//                //Añadimos los títulos a la tabla. 
//                Paragraph columna1 = new Paragraph("Numero");
//                columna1.getFont().setStyle(Font.BOLD);
//                columna1.getFont().setSize(10);
//                tabla.addCell(columna1);               
//               
//                
//                Paragraph columna2 = new Paragraph("Nombre");
//                columna1.getFont().setStyle(Font.BOLD);
//                columna1.getFont().setSize(10);
//                tabla.addCell(columna2);
//               
//                
//                Paragraph columna3 = new Paragraph("Direccion");
//                columna1.getFont().setStyle(Font.BOLD);
//                columna1.getFont().setSize(10);
//                tabla.addCell(columna3);
//                
//                
//                Paragraph columna4 = new Paragraph("colonia");
//                columna1.getFont().setStyle(Font.BOLD);
//                columna1.getFont().setSize(10);
//                tabla.addCell(columna4);
//             
//                
//                Paragraph columna5 = new Paragraph("Pago");
//                columna1.getFont().setStyle(Font.BOLD);
//                columna1.getFont().setSize(10);
//                tabla.addCell(columna5);
//               
//                
//                Paragraph columna6 = new Paragraph("Dias");
//                columna1.getFont().setStyle(Font.BOLD);
//                columna1.getFont().setSize(10);
//                tabla.addCell(columna6);
//           
//                
//                
//                Paragraph columna7 = new Paragraph("Telefono");
//                columna1.getFont().setStyle(Font.BOLD);
//                columna1.getFont().setSize(10);
//                tabla.addCell(columna7);
//              int b= tblbuscaclientes.getRowCount();
//           
//                  
//                      tabla.addCell(tblbuscaclientes.getValueAt(tblbuscaclientes.getSelectedRow(), 0).toString());
//                  
//              
//                
//                
//                documento.add(tabla);
//         documento.close();
//        }catch(Exception ex){
//         System.out.println(ex.toString());
//        }
      
//      try {
//            File path = new File ("C:\\Users\\coron\\Desktop\\prueba\\ejemplo.PDF");
//            Desktop.getDesktop().open(path);
//            }catch (IOException ex) {
//            ex.printStackTrace();
//}
//    }
    
    
    
    
    
    void cerrar()
    {
        this.dispose();
    }
    
    void  dobleclick()
    {
         tblbuscaclientes.addMouseListener(new MouseAdapter() {
           public void mousePressed(MouseEvent Mouse_evt){
               JTable tabla = (JTable) Mouse_evt.getSource();
               Point point = Mouse_evt.getPoint();
               int row = tabla.rowAtPoint(point);
               if (Mouse_evt.getClickCount()==2) 
               {
//                    frmclientes clientes = new frmclientes();
//                    clientes.setVisible(true);
//                   frmclientes.jLabel8.setText(tblbuscaclientes.getValueAt(tblbuscaclientes.getSelectedRow(), 0).toString());
//                   frmclientes.txtnombrecliente.setText(tblbuscaclientes.getValueAt(tblbuscaclientes.getSelectedRow(), 1).toString());
//                   frmclientes.txtcolonia.setText(tblbuscaclientes.getValueAt(tblbuscaclientes.getSelectedRow(), 3).toString());
//                   frmclientes.txtdireccion.setText(tblbuscaclientes.getValueAt(tblbuscaclientes.getSelectedRow(), 2).toString());
//                   frmclientes.txtdiascredito.setText(tblbuscaclientes.getValueAt(tblbuscaclientes.getSelectedRow(), 5).toString());
//                   frmclientes.txttelefono.setText(tblbuscaclientes.getValueAt(tblbuscaclientes.getSelectedRow(), 6).toString());
                    eliminar();
                    tblbuscaclientes.setModel(modeloTabla2);
                   cerrar();
                   
               }
           }
       
       });
    }
    
    void inicio ()
    {      
         
         eliminar();
       
        int b=0;
           String valor="";
        int valor1=0;
  
         try{
         con=conexion.getConeConnection();
         stmt=con.createStatement();
         rs=stmt.executeQuery("SELECT * from tblclientes");
    while(rs.next()){
    
        filas[0]=(rs.getString(1));
        filas[1]=(rs.getString(2));
        filas[2]=(rs.getString(3));
        filas[3]=(rs.getString(4));
        String tipo=(rs.getString(5));
        if("1".equals(tipo))
        {
            tipo="Contado";
        }
        else
        {
            tipo="credito";
        }
        filas[4]=tipo;
        filas[5]=(rs.getString(6));
        filas[6]=(rs.getString(7));
        modeloTabla.addRow(filas);
      
        tblbuscaclientes.setModel(modeloTabla);
        
      
     }
    con.close();
     }catch(SQLException ex){
         JOptionPane.showMessageDialog(this,"Ocurrio el siguiente error:"+ex);
     }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbuscaclientes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnbuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblbuscaclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblbuscaclientes);

        jLabel1.setText("Nombre");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(btnbuscar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(btnbuscar)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(56, 56, 56))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed

        
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        // TODO add your handling code here:
       if(this.txtNombre.getText().isEmpty()){
            modelo.clear();
        }else{
                 try{
         con=conexion.getConeConnection();
         stmt=con.createStatement();
         String texto = txtNombre.getText();
         if("".equals(texto))
         {
             
         }
         else
         {
             
         
         rs=stmt.executeQuery("SELECT * from tblclientes where nombre like '"+texto+"%'");
         eliminar();
    while(rs.next()){
    
        filas[0]=(rs.getString(1));
        filas[1]=(rs.getString(2));
        filas[2]=(rs.getString(3));
        filas[3]=(rs.getString(4));
        String tipo=(rs.getString(5));
        if("1".equals(tipo))
        {
            tipo="Contado";
        }
        else
        {
            tipo="credito";
        }
        filas[4]=tipo;
        filas[5]=(rs.getString(6));
        filas[6]=(rs.getString(7));
        modeloTabla.addRow(filas);
      
        tblbuscaclientes.setModel(modeloTabla);
        
      
     }
         }
    con.close();
     }catch(SQLException ex){
         JOptionPane.showMessageDialog(this,"Ocurrio el siguiente error:"+ex);
     }
        }
        
        
        
        
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        // TODO add your handling code here:
        
          if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE)
         {
             if("".equals(txtNombre.getText()));
             {
                 eliminar();
             }
         }
    }//GEN-LAST:event_txtNombreKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmbuscaclientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmbuscaclientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmbuscaclientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmbuscaclientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmbuscaclientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblbuscaclientes;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
