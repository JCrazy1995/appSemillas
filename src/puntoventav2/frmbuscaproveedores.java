/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puntoventav2;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Francisco Rafael
 */
public final class frmbuscaproveedores extends javax.swing.JFrame {

    /**
     * Creates new form frmbuscaproveedores
     */
    private static Connection con = null;
    static ResultSet rs = null;
    private Statement stmt = null;
    conectar conexion = new conectar();
    DefaultTableModel modeloTabla = new DefaultTableModel();  //modelo de tabla que llevara los datos
    Object filas[] = new Object[5];
      DefaultTableModel modeloTabla2 = new DefaultTableModel();
    DefaultListModel modelo = new DefaultListModel();

    public frmbuscaproveedores()
    {
        initComponents();
        configModelo();
        inicio();
        dobleclick();
        salir();
    }
     void configModelo() {
            modeloTabla.addColumn("Numero ");
            modeloTabla.addColumn("nombre");           
            modeloTabla.addColumn("tipo pago");   
            modeloTabla.addColumn("dias"); 
            modeloTabla.addColumn("Telefono");
            tblbuscaproveedores.setModel(modeloTabla);

    }
     
     void eliminar() 
    {

        DefaultTableModel tb = (DefaultTableModel) tblbuscaproveedores.getModel();
        int a = tblbuscaproveedores.getRowCount() - 1;
        for (int i = a; i >= 0; i--) 
        {
            tb.removeRow(tb.getRowCount() - 1);
        }

        //cargaTicket();
    }
     
     void inicio()
     {
           try 
        {
            con = conexion.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * from tblproveedores");
            while (rs.next()) 
            {

                filas[0] = (rs.getString(1));
                filas[1] = (rs.getString(2));
               
                String tipo = (rs.getString(3));
                if ("1".equals(tipo))
                {
                    tipo = "Contado";
                } else 
                {
                    tipo = "credito";
                }
                filas[2] = tipo;
                filas[3] = (rs.getString(4));
                filas[4] = (rs.getString(5));
                modeloTabla.addRow(filas);

                tblbuscaproveedores.setModel(modeloTabla);

            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Ocurrio el siguiente error:" + ex);
        }

     }
     
     
     
      void  dobleclick()
    {
         tblbuscaproveedores.addMouseListener(new MouseAdapter() {
           @Override
           public void mousePressed(MouseEvent Mouse_evt){
               
               if (Mouse_evt.getClickCount()==2) 
               {
                   frmproveedores.lblnoprovedor.setText(tblbuscaproveedores.getValueAt(tblbuscaproveedores.getSelectedRow(), 0).toString());
                    frmproveedores.txtnombreproveedor.setText(tblbuscaproveedores.getValueAt(tblbuscaproveedores.getSelectedRow(), 1).toString());
                   String dato=String.valueOf(modeloTabla.getValueAt(tblbuscaproveedores.getSelectedRow(),2));
                   if ("Contado".equals(dato))
                   {
                        frmproveedores.cmbmetodopago.setSelectedIndex(0);
                   }
                   else
                   {
                        frmproveedores.cmbmetodopago.setSelectedIndex(1);
                   }
                    frmproveedores.txtdiascredito.setText(tblbuscaproveedores.getValueAt(tblbuscaproveedores.getSelectedRow(), 3).toString());
                    frmproveedores.txttelefono.setText(tblbuscaproveedores.getValueAt(tblbuscaproveedores.getSelectedRow(), 4).toString());
                    eliminar();
                    tblbuscaproveedores.setModel(modeloTabla2);
                    cerrar();
               }
           }
       
       });
    }
     void cerrar() 
    {
        this.dispose();
    }
     
       public void salir()
      {
          try 
          {
              this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
              addWindowListener(new WindowAdapter() 
              {
                  public void windowClosing(WindowEvent e)
                  {
                    frmPrincipal.habilitar();
                      cerrar();
                  }
                  
              } );
              this.setVisible(true);
          }
          catch (Exception e) 
          {
              e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbuscaproveedores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(214, 214, 251));

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        jLabel1.setText("Nombre");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tblbuscaproveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblbuscaproveedores);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtNombreKeyPressed
 TableRowSorter trs;
    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        // TODO add your handling code here:
         txtNombre.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent ke){
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtNombre.getText(), 1));
            }
        });
        trs = new TableRowSorter(tblbuscaproveedores.getModel());
        tblbuscaproveedores.setRowSorter(trs);

    }//GEN-LAST:event_txtNombreKeyReleased

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
            java.util.logging.Logger.getLogger(frmbuscaproveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmbuscaproveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmbuscaproveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmbuscaproveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmbuscaproveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblbuscaproveedores;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
