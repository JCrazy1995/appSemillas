/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puntoventav2;

import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel; 

/**
 *
 * @author Francisco Rafael
 */
public class frmarticulos extends javax.swing.JFrame {
    
    /**
     * Creates new form frmarticulos
     */
    Connection con = null;
     static ResultSet rs=null;
    private Statement stmt=null;
    conectar conexion = new conectar();
    DefaultTableModel modeloTabla= new DefaultTableModel();  //modelo de tabla que llevara los datos
    DefaultTableModel modeloTabla2= new DefaultTableModel(); // modelo vacio para la tabla de clientes
    Object filas[]= new Object[7];                          
    public frmarticulos() 
    {
        initComponents();
        ultiArtiiculo();
        salir();
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
      
            void cerrar()
            {
                this.dispose();
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
        lblarticulo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbtipo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtpreciocompra = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        btnbuscarproducto = new javax.swing.JButton();
        btnmodificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(214, 214, 251));

        jPanel1.setBackground(new java.awt.Color(214, 214, 251));

        jPanel2.setBackground(new java.awt.Color(214, 214, 251));

        lblarticulo.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblarticulo.setText("1");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("N° Articulo");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Nombre:");

        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Precio:");

        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnombreKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Tipo:");

        cmbtipo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbtipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kgs", "Pte", "Caja", "Bulto" }));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Precio Compra:");

        txtpreciocompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpreciocompraKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtpreciocompra)
                    .addComponent(lblarticulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbtipo, javax.swing.GroupLayout.Alignment.LEADING, 0, 150, Short.MAX_VALUE))
                .addGap(0, 40, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblarticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtpreciocompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Productos");

        jPanel3.setBackground(new java.awt.Color(214, 214, 251));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnbuscarproducto.setText("Buscar");
        btnbuscarproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarproductoActionPerformed(evt);
            }
        });

        btnmodificar.setText("Modificar");
        btnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregar)
                .addGap(28, 28, 28)
                .addComponent(btnnuevo)
                .addGap(18, 18, 18)
                .addComponent(btnbuscarproducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnmodificar)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnnuevo)
                    .addComponent(btnbuscarproducto)
                    .addComponent(btnmodificar))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void ultiArtiiculo(){
        int lasid=0;
        try
        {
             con = conexion.getConnection();
             stmt=con.createStatement();
             rs =stmt.executeQuery("select max(id_Articulo) from tblArticulos ");
             if(rs.next())
            {
                lasid=rs.getInt(1)+1;
            }
            lblarticulo.setText(lasid+"");
            con.close();
        }
        catch(SQLException ex)
        {
         JOptionPane.showMessageDialog(this,"Ocurrio el siguiente error:"+ex);
        }
    }
        
    public void limpiarCampo()
        {
           ultiArtiiculo();
           txtPrecio.setText("");
           txtnombre.setText("");
           txtpreciocompra.setText("");
           cmbtipo.setSelectedIndex(0);
        }
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
         
         con = conexion.getConnection();
         String nombre= txtnombre.getText();
         float precio = Float.parseFloat(txtPrecio.getText());
         float preciocompra=Float.parseFloat(txtpreciocompra.getText());
         String tipo = cmbtipo.getSelectedItem().toString();
         int lasid=0;
        //Crear aticulos y ademas jalar el ultimo id
        try {
            stmt = con.createStatement();
            PreparedStatement psInsert= con.prepareStatement("INSERT INTO tblArticulos(artNombre,artPrecio,artTipo,artPrecioCompra)"
                   + " VALUES (?,?,?,?)");
           
            psInsert.setString(1, nombre);
            psInsert.setFloat(2, precio);
            psInsert.setString(3,tipo);
            psInsert.setFloat(4, preciocompra);
            psInsert.execute();
            psInsert.close();
            
            ResultSet rs= stmt.executeQuery("select max(id_Articulo) from tblArticulos");
            if(rs.next())
            {
                lasid=rs.getInt(1);
            }
            
            
           
            
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
        //Agregar inventario el articulo con 0 
        try 
        {
           stmt = con.createStatement();

           PreparedStatement psInsert= con.prepareStatement("INSERT INTO tblinventario(Id_Articulo,invExistencia)"
                     + " VALUES (?,?)"); 

           psInsert.setInt(1, lasid);
           psInsert.setFloat(2,0);
           psInsert.execute();
           psInsert.close(); 

             con.close();
            JOptionPane.showMessageDialog(null, "Se ingreso correctamente, gracias");
            
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
        limpiarCampo();
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        // TODO add your handling code here:
         char car = evt.getKeyChar();
        if((car<'0' || car>'9') && (car<=',' || car>'.')|| (car=='-'))  evt.consume();
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
       ultiArtiiculo();
       limpiarCampo();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void btnbuscarproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarproductoActionPerformed
        // TODO add your handling code here:
        frmbuscarproducto buscar = new frmbuscarproducto();
        buscar.setVisible(true);
    }//GEN-LAST:event_btnbuscarproductoActionPerformed

    private void btnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarActionPerformed
        //Verifica que no esten vacios
        if ("".equals(txtnombre.getText()) || "".equals(txtPrecio.getText()))
        {
            JOptionPane.showMessageDialog(null,"No dejar Campos Vacios");
            txtnombre.requestFocus();
            return;
        }
        //Se va actualizar
        else
        {
          int noarticulos = Integer.parseInt(lblarticulo.getText());
          String nombre = txtnombre.getText();
          float precio = Float.parseFloat(txtPrecio.getText());
          String tipo = cmbtipo.getSelectedItem().toString();
          float preciocompra= Float.parseFloat(txtpreciocompra.getText());
            try 
            {
            
             con = conexion.getConnection();
             stmt = con.createStatement();
             PreparedStatement psInsert= con.prepareStatement("update tblarticulos set artNombre=?,artPrecio=?,"
                       + "artTipo=?,artPrecioCompra=? where id_Articulo=?");

              psInsert.setString(1, nombre);
              psInsert.setFloat(2, precio);
              psInsert.setString(3, tipo);
              psInsert.setFloat(4, preciocompra);
              psInsert.setInt( 5, noarticulos);
              psInsert.executeUpdate();
              psInsert.close();

              JOptionPane.showMessageDialog(null, "Se ingreso correctamente, gracias");
            
            } 
            catch (SQLException e) 
            {
                JOptionPane.showMessageDialog(null, e);
            }
            
        }
        limpiarCampo();
    }//GEN-LAST:event_btnmodificarActionPerformed

    private void txtpreciocompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpreciocompraKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpreciocompraKeyTyped

    private void txtnombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyPressed
        // TODO add your handling code here:
          if (evt.getKeyCode() == KeyEvent.VK_ENTER)
         {
             txtPrecio.requestFocus();
         }
    }//GEN-LAST:event_txtnombreKeyPressed

    private void txtPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyPressed
        // TODO add your handling code here:
          if (evt.getKeyCode() == KeyEvent.VK_ENTER)
         {
             txtpreciocompra.requestFocus();
         }
    }//GEN-LAST:event_txtPrecioKeyPressed

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
            java.util.logging.Logger.getLogger(frmarticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmarticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmarticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmarticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmarticulos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnbuscarproducto;
    private javax.swing.JButton btnmodificar;
    private javax.swing.JButton btnnuevo;
    public static javax.swing.JComboBox<String> cmbtipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JLabel lblarticulo;
    public static javax.swing.JTextField txtPrecio;
    public static javax.swing.JTextField txtnombre;
    public static javax.swing.JTextField txtpreciocompra;
    // End of variables declaration//GEN-END:variables
}
