/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puntoventav2;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Francisco Rafael
 */
public final class frmrsalidas extends javax.swing.JFrame {

    /**
     * Creates new form frmrsalidas
     */
    
      static java.sql.ResultSet rs=null;
    private Statement stmt=null;
    conectar conexion = new conectar();
    DefaultTableModel modeloTabla= new DefaultTableModel();
    Object filas[]= new Object[2];   
    private int fila; 
    Connection con = null;
    static String fecha1;
    int articulo;
    public frmrsalidas() 
    {
        initComponents();
        configModelo();
        iniciarfecha();
        nosalida();
        this.setResizable(false);
        salir();
    }
    
    void iniciarfecha()
    {
        
        Calendar calendario =Calendar.getInstance();
        int dia =calendario.get(calendario.DATE);
        int mes = calendario.get(calendario.MONTH)+1;
        int ano = calendario.get(calendario.YEAR);
        try 
        {   
            String myDate = dia+"/"+mes+"/"+ano;
            SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yy");
            Date fecha = formateador.parse(myDate); 
            System.out.println(fecha);
            date1.setDate(fecha);
        }
        catch (ParseException e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
      
        
    }
   
         void configModelo() 
        {
            modeloTabla.addColumn("Cantidad");
            modeloTabla.addColumn("Producto");

            tblsalidas.setModel(modeloTabla);

            TableColumnModel columnModel = tblsalidas.getColumnModel();

            columnModel.getColumn(0).setPreferredWidth(40);
            columnModel.getColumn(1).setPreferredWidth(150);
        
        }
         
        void limpiar()
        {
            txtcantidad.setText("");
            txtproducto.setText("");
        }
         public static void fecha()
        {
 
            try {
                //jDateChooser el nombre la variable  del componente jdatecgooser
                Date  fech=date1.getDate();
                DateFormat f=new SimpleDateFormat("yyyy-MM-dd");
                 fecha1=f.format(fech);
                System.out.println(fecha1);

                //textFecha nombre de la variable del componenten jtextfiel

                } 
                catch (HeadlessException e)
                {
                   JOptionPane.showMessageDialog(null, e);
                }
      
        }
         void nosalida()
         {
             try 
             {      
                 int ultimoid=0;
                 con = conexion.getConnection();
                 stmt = con.createStatement();
                 rs =stmt.executeQuery("select max(id_SalEsp) from tblSalidasEspeciales ");
                  if(rs.next())
                  {
                       ultimoid=rs.getInt(1)+1;
                      
                  }
                  lblnosalida.setText(ultimoid+"");
             } 
             catch (SQLException e) 
             {
                 
             }
         }
         
        void eliminar()
        {
            DefaultTableModel tb = (DefaultTableModel) tblsalidas.getModel();
            int a = tblsalidas.getRowCount()-1;
            for (int i = a; i >= 0; i--) 
            {          
                tb.removeRow(tb.getRowCount()-1);
            }
        }
        
        
        
        public void salir()
      {
          try 
          {
              this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
              addWindowListener(new WindowAdapter() 
              {
                  @Override
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

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        date1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblsalidas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtproducto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        btnagregar = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblnosalida = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Salidas ");

        jLabel1.setText("Nombre:");

        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnombreKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        date1.setDateFormatString("dd/MM/y");

        jLabel2.setText("Fecha:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(date1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(date1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Registro de Salidas");

        tblsalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblsalidas);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel4.setText("Prodcuto:");

        txtproducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtproductoKeyPressed(evt);
            }
        });

        jLabel5.setText("Cantidad:");

        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcantidadKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnagregar.setText("Agregar");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        jLabel6.setText("N° Salida");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jLabel3)
                .addGap(72, 72, 72)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(lblnosalida, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnagregar)
                        .addGap(28, 28, 28)
                        .addComponent(btnguardar)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(30, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblnosalida, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnagregar)
                            .addComponent(btnguardar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtproductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtproductoKeyPressed
        // TODO add your handling code here:
        
             int c=0;
      
         if (evt.getKeyCode() == KeyEvent.VK_ENTER)
         {
             
              if("".equals(txtcantidad.getText()))
               {
                   JOptionPane.showMessageDialog(null, "no dejar el campo de cantidad vacio");
               }
               else
               {

                  try
                  {
                      con=conexion.getConnection();
                      stmt=con.createStatement();
                      rs=stmt.executeQuery("select * from tblarticulos where artNombre like '%"+txtproducto.getText()+"%'");
                       while(rs.next())
                        {                        
                            c++;
                        }
                       if (c>1)
                       {
                           JOptionPane.showMessageDialog(null, "Favor de ingresar mas datos");

                       }
                       else
                       {
                           rs=stmt.executeQuery("select * from tblarticulos where artNombre like '%"+txtproducto.getText()+"%'");
                           while(rs.next())
                            {                        
                                txtproducto.setText(rs.getString(2));
                                articulo=rs.getInt(1);
                            }

                       }
                        con.close();
                  }
                  catch(SQLException ex)
                  {
                      JOptionPane.showMessageDialog(null, ex);
                  }      
               }
        }
    }//GEN-LAST:event_txtproductoKeyPressed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        // TODO add your handling code here:
        
        if("".equals(txtcantidad.getText())|| "".equals(txtproducto.getText()))
        {
            JOptionPane.showMessageDialog(null, "No Dejar Campos Vacios","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            filas[0]=txtcantidad.getText();
            filas[1]=txtproducto.getText();
            modeloTabla.addRow(filas);
            tblsalidas.setModel(modeloTabla);
            
        }
        
        limpiar();
    }//GEN-LAST:event_btnagregarActionPerformed

    private void txtnombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyPressed
        // TODO add your handling code here:
        
        
         if (evt.getKeyCode() == KeyEvent.VK_ENTER)
         {
             txtcantidad.requestFocus();
         
         }
         
    }//GEN-LAST:event_txtnombreKeyPressed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        
        try 
        {
                fecha();
                con=conexion.getConnection();
                stmt=con.createStatement();
                stmt = con.createStatement();
                PreparedStatement psInsert= con.prepareStatement("INSERT INTO tblsalidasespeciales"
                           + "( salEspNombre,salEspFechaSalida,salEspStatus) VALUES (?,?,?)");
                psInsert.setString(1, txtnombre.getText());
                psInsert.setString(2,  fecha1+"");
                psInsert.setString(3, "Activa");
                psInsert.execute();
        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        try 
        {
            int x=tblsalidas.getRowCount();
            int idarticulo=0;
            Double totalexistencia=0.0,totalinventario=0.0,cantidad=0.0;
            for(int i=0;i<x;i++)
            {   
                
                 cantidad= Double.parseDouble(tblsalidas.getValueAt(i,0 ).toString());
                String producto = tblsalidas.getValueAt(i, 1).toString();
                 ResultSet rs= stmt.executeQuery("select tblarticulos.id_Articulo from tblArticulos where artNombre"
                          + "='"+producto+"'");
                        if(rs.next())
                         {
                             idarticulo=rs.getInt(1);
                         }
                        
                         ResultSet rss= stmt.executeQuery("select tblinventario.invExistencia    from"
                                 + " tblinventario where id_Articulo  ='"+idarticulo+"'");
                        if(rss.next())
                         {
                             totalexistencia=rss.getDouble(1);
                         }
                            totalinventario=totalexistencia-cantidad;
                            PreparedStatement psInsert1= con.prepareStatement("update tblinventario set invExistencia=? where id_Articulo=? ");
                            psInsert1.setDouble(1,totalinventario);
                            psInsert1.setInt(2, idarticulo);
                            psInsert1.execute();
                
                    
                
                   
                    con=conexion.getConnection();
                    stmt=con.createStatement();
                    stmt = con.createStatement();
                    PreparedStatement psInsert= con.prepareStatement("INSERT INTO tblmovimientosespeciales"
                               + "( id_Articulo,id_SalEsp,movEspCantidad) VALUES (?,?,?)");
                    psInsert.setInt(1, articulo);
                    psInsert.setString(2,  lblnosalida.getText());
                    System.out.println(lblnosalida.getText());
                    psInsert.setDouble(3, cantidad);
                    psInsert.execute();
            }
            JOptionPane.showMessageDialog(null, "Guardado Con Exito","Realizado",JOptionPane.PLAIN_MESSAGE);
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        
        
        eliminar();
        nosalida();
        txtnombre.setText("");
        txtcantidad.requestFocus();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtcantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
         {
             txtproducto.requestFocus();
         }
    }//GEN-LAST:event_txtcantidadKeyPressed

    private void txtcantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcantidadKeyReleased

    private void txtcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyTyped
        char car = evt.getKeyChar();
        if((car<'0' || car>'9') && (car<=',' || car>'.')|| (car=='-'))  evt.consume();
    }//GEN-LAST:event_txtcantidadKeyTyped

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
            java.util.logging.Logger.getLogger(frmrsalidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmrsalidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmrsalidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmrsalidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmrsalidas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnguardar;
    public static com.toedter.calendar.JDateChooser date1;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblnosalida;
    private javax.swing.JTable tblsalidas;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtproducto;
    // End of variables declaration//GEN-END:variables
}
