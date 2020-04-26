/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puntoventav2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Francisco Rafael
 */
public final class frmbuscaentradasmodificar extends javax.swing.JFrame {

    /**
     * Creates new form frmbuscaentradas
     */
    private static Connection con = null;
    static ResultSet rs = null;
    private java.sql.Statement stmt = null;
    conectar conexion = new conectar();
    DefaultTableModel modeloTabla = new DefaultTableModel();
    Object filas[] = new Object[5];
     DefaultTableModel modeloTabla2 = new DefaultTableModel();
    Object filas2[] = new Object[5];
    private int fila;
    frmmodificarentradas modificar= new frmmodificarentradas();
    public frmbuscaentradasmodificar() 
    {
        initComponents();
        configModelo();
        iniciotabla();
        dobleclick();
        salir();
    }
    
    
    
     void configModelo() 
    {
         modeloTabla.addColumn("N° Nota");
         modeloTabla.addColumn("Proveedor");
         modeloTabla.addColumn("Fecha");
         modeloTabla.addColumn("Total");
         modeloTabla.addColumn("Pagada");
         tblbuscaentradas.setModel(modeloTabla);
         TableColumnModel columnModel = tblbuscaentradas.getColumnModel();
         columnModel.getColumn(0).setPreferredWidth(70);
         columnModel.getColumn(1).setPreferredWidth(150);
         columnModel.getColumn(2).setPreferredWidth(70);
         columnModel.getColumn(3).setPreferredWidth(70);
         columnModel.getColumn(4).setPreferredWidth(80);
    }
     
    void eliminar() 
        {
            DefaultTableModel tb = (DefaultTableModel) tblbuscaentradas.getModel();
            int a = tblbuscaentradas.getRowCount() - 1;
            for (int i = a; i >= 0; i--) 
            {
                tb.removeRow(tb.getRowCount() - 1);
            }
        }
        void cerrar()
        {
            this.dispose();
        }
    
    void iniciotabla()
        {
                String nombre="1";
            try 
            {
                con = conexion.getConnection();
                stmt = con.createStatement();
                rs = stmt.executeQuery(" select * from tblentradas where entstatus!='cancelada' and entstatus!='cancelada por actu';");
                while (rs.next()) 
                {     stmt = con.createStatement();
                      ResultSet rss= stmt.executeQuery("select tblproveedores.pronombre from tblproveedores where id_proveedor='"+rs.getString(2)+"'");
                      if(rss.next())
                      {
                          nombre = rss.getString(1);                      
                      }
                      
                    filas[0] = (rs.getString(1));
                    filas[1] = nombre;
                    String fecha = (rs.getString(3));
                    String dia= fecha.substring(8,10);
                    String mes = fecha.substring(5,7);
                    String ano = fecha.substring(0,4);
                    filas[2] = dia+"/"+mes+"/"+ano;
                    filas[3] = (rs.getString(5));
                    filas[4] = (rs.getString(8));
                    modeloTabla.addRow(filas); 
                    tblbuscaentradas.setModel(modeloTabla);
                }
                con.close();
            } catch (SQLException ex) 
            {
                JOptionPane.showMessageDialog(this, "Ocurrio el siguiente error:" + ex);
            }       
        }    
    
         void enviardatos()
        {   
            try 
            {   
                double totalcompra=0;
                int lasid=0;
                con = conexion.getConnection();
                stmt = con.createStatement();
                
                int idarticulo=0;
                String nompreproducto = null;
                String nombrecliente= tblbuscaentradas.getValueAt(tblbuscaentradas.getSelectedRow(),1).toString();
                String identrada = tblbuscaentradas.getValueAt(tblbuscaentradas.getSelectedRow(), 0).toString();
                int c=0;
                ResultSet rs11 = stmt.executeQuery("SELECT * from tblentradasmovimientos where id_entradas='"+identrada+"'");              
                if(rs11.next())
                {   
                    modificar.setVisible(true);
                    rs = stmt.executeQuery("SELECT * from tblproveedores where proNombre='"+nombrecliente+"'");
          
                while(rs.next())
                {
                   frmmodificarentradas.txtnoproveedor.setText(rs.getString(1));
                   frmmodificarentradas.txtproveedor.setText(rs.getString(2));
                   String tippago = rs.getString(3);
                if("1".equals(tippago))
                {    frmmodificarentradas.txttipopago.setText("Contado");
                     frmmodificarentradas.lbltipopago.setText("Contado");
                }
                else
                {    frmmodificarentradas.txttipopago.setText("Credito");
                     frmmodificarentradas.lbltipopago.setText("Credito");                    
                } 
                    frmmodificarentradas.txtdiascredito.setText(rs.getString(4));
                    frmmodificarentradas.lbldiascredito.setText(rs.getString(4)); 
                    frmmodificarentradas.txttelefono.setText(rs.getString(5));
                }
                ResultSet rss= stmt.executeQuery("select * from tblentradas where  id_Entradas='"+identrada+"'");
                while(rss.next())
                {    String fecha, fechapago,anio,aniopago,mes,mespago,dias,diaspago;   
                    
                     anio =rss.getString(3).substring(0,4);
                     mes =rss.getString(3).substring(5,7);
                     dias = rss.getString(3).substring(8,10);
                     fecha=dias+"/"+mes+"/"+anio;
                     frmmodificarentradas.txtfecha.setText(fecha);
                     frmmodificarentradas.lblfecha.setText(fecha);
                     frmmodificarentradas.txtnoentrada.setText(rss.getString(1));  
                     aniopago =rss.getString(4).substring(0,4);
                     mespago =rss.getString(4).substring(5,7);
                     diaspago = rss.getString(4).substring(8,10);
                     fechapago=diaspago+"/"+mespago+"/"+aniopago;   
                     frmmodificarentradas.txtfechapago.setText(fechapago);
                     frmmodificarentradas.lblfechapago.setText(fechapago);
                     frmmodificarentradas.lbltotal.setText(rss.getString(5));
                    
                    
                }
                 ResultSet rs1= stmt.executeQuery(" select   tblentradasmovimientos.id_Articulo from "
                         + "tblentradasmovimientos where  id_Entradas='"+identrada+"'");
                if(rs1.next())
                {    
                    idarticulo=rs1.getInt(1);
                }
                
                ResultSet rs2= stmt.executeQuery("select tblarticulos.artNombre from "
                        + "tblarticulos where  id_Articulo='"+idarticulo+"'");
                if(rs2.next())
                {
                    nompreproducto=rs2.getString(1);
                }
                Double totalcompras =0.0,utilidad=0.0;
                ResultSet rs3= stmt.executeQuery("select * from tblentradasmovimientos where id_entradas='"+identrada+"'");
                while(rs3.next())
                {   
                   
                    filas2[0] =   rs3.getString(4);
                    filas2[1] =   nompreproducto;
                    filas2[2] =   rs3.getString(5);
                    filas2[3]=    rs3.getString(7);
                    filas2[4]=    rs3.getString(6);
                  
                    frmmodificarentradas.modeloTabla.addRow(filas2);  
                    
                }
                con.close();
                 cerrar();
                }
            }
              
        catch (SQLException ex) 
            {
                JOptionPane.showMessageDialog(this, "Ocurrio el siguiente error:" + ex);
            }         
        }  
     
         
          void dobleclick() 
            {
                tblbuscaentradas.addMouseListener(new MouseAdapter() 
                {
                    @Override
                    public void mousePressed(MouseEvent Mouse_evt) 
                    {  
                        if (Mouse_evt.getClickCount() == 2)
                        { 
                            enviardatos();
                        }
                    }
                });
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbuscaentradas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtnombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblbuscaentradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblbuscaentradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbuscaentradasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblbuscaentradas);

        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombreKeyReleased(evt);
            }
        });

        jLabel1.setText("Nombre:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
 TableRowSorter trs; 
    private void txtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyReleased
        // TODO add your handling code here:

        txtnombre.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke){
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtnombre.getText(), 1));
            }
        });
        trs = new TableRowSorter(tblbuscaentradas.getModel());
        tblbuscaentradas.setRowSorter(trs);
    }//GEN-LAST:event_txtnombreKeyReleased

    private void tblbuscaentradasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbuscaentradasMouseClicked
        // TODO add your handling code here:
        fila=tblbuscaentradas.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_tblbuscaentradasMouseClicked

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
            java.util.logging.Logger.getLogger(frmbuscaentradasmodificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmbuscaentradasmodificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmbuscaentradasmodificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmbuscaentradasmodificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmbuscaentradasmodificar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblbuscaentradas;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
