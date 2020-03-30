package puntoventav2;

import java.awt.Desktop;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Francisco Rafael
 */
public class frmbuscacancelarnotas extends javax.swing.JFrame {

    /**
     * Creates new form frmbuscacancelarnotas
     */
    private static Connection con = null;
    static ResultSet rs = null;
    private java.sql.Statement stmt = null;
    private java.sql.Statement stmtt = null;
    conectar conexion = new conectar();
    DefaultTableModel modeloTabla = new DefaultTableModel();
    Object filas[] = new Object[5];
     DefaultTableModel modeloTabla2 = new DefaultTableModel();
    Object filas2[] = new Object[5];
    private int fila;
    frmcancelarnotas cancelar = new frmcancelarnotas();
    public frmbuscacancelarnotas() 
    {
        initComponents();
        configModelo();
        iniciotabla();
        dobleclick();
        setResizable(false);
    }

    void configModelo() 
    {
        modeloTabla.addColumn("Numero Nota");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Fecha");
        modeloTabla.addColumn("Total");
        modeloTabla.addColumn("Pagada");
        tblbuscanotas.setModel(modeloTabla);

    }
    
     void configModelo2() 
        {
        modeloTabla2.addColumn("Cantidad");
        modeloTabla2.addColumn("Producto");
        modeloTabla2.addColumn("Precio");
        modeloTabla2.addColumn("Tipo");
        modeloTabla2.addColumn("Total");
        frmcancelarnotas.tblnotas.setModel(modeloTabla);

        }
        void iniciotabla()
        {
            String nombre="1";
        try 
        {
            con = conexion.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(" select * from tblnotas where nostatus!='cancelada' and nostatus!='cancelada por actu';");
            while (rs.next()) 
            {     stmt = con.createStatement();
                  ResultSet rss= stmt.executeQuery("select tblclientes.cliNombre from tblclientes where id_Cliente='"+rs.getString(2)+"'");
                  if(rss.next())
                  {
                      nombre = rss.getString(1);                      
                  }
                System.out.println(nombre);
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
                tblbuscanotas.setModel(modeloTabla);

            }
            con.close();
        } catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(this, "Ocurrio el siguiente error:" + ex);
        }

                    
        }
    
        void eliminar() 
    {

        DefaultTableModel tb = (DefaultTableModel) tblbuscanotas.getModel();
        int a = tblbuscanotas.getRowCount() - 1;
        for (int i = a; i >= 0; i--) 
        {
            tb.removeRow(tb.getRowCount() - 1);
        }

        //cargaTicket();
    }
        void cerrar()
        {
            this.dispose();
        }
        
        
        void enviardatos()
        {   
        try 
            {   
                int lasid=0;
                con = conexion.getConnection();
                stmt = con.createStatement();
                stmtt = con.createStatement();
                
                int idarticulo=0;
                String nompreproducto;
                String nombrecliente= tblbuscanotas.getValueAt(tblbuscanotas.getSelectedRow(),1).toString();
                String idnota = tblbuscanotas.getValueAt(tblbuscanotas.getSelectedRow(), 0).toString();
                int c=0;
                ResultSet rs11 = stmt.executeQuery("SELECT * from tblnotasmovimientos where id_nota='"+idnota+"'");              
                if(rs11.next())
                {
                    cancelar.setVisible(true);
                    rs = stmt.executeQuery("SELECT * from tblclientes where cliNombre='"+nombrecliente+"'");
                configModelo2();
                while(rs.next())
                {
                    frmcancelarnotas.txtncliente.setText(rs.getString(1));
                    frmcancelarnotas.txtcliente.setText(rs.getString(2));
                    frmcancelarnotas.txtdomicilio.setText(rs.getString(3));
                    frmcancelarnotas.txtcolonia.setText(rs.getString(4));
                   String tippago = rs.getString(5);
                if("1".equals(tippago))
                {    frmcancelarnotas.txttipopago.setText("Contado");
                    
                }
                else
                {    frmcancelarnotas.txttipopago.setText("Credito");
                    ;
                } 
                    frmcancelarnotas.txtdiascredito.setText(rs.getString(6));
                    frmcancelarnotas.txttelefono.setText(rs.getString(7));
                   
                }
                ResultSet rss= stmt.executeQuery("select * from tblnotas where  id_Nota='"+idnota+"'");
                while(rss.next())
                {    String fecha, fechapago,anio,aniopago,mes,mespago,dias,diaspago;   
                    
                     anio =rss.getString(3).substring(0,4);
                     mes =rss.getString(3).substring(5,7);
                     dias = rss.getString(3).substring(8,10);
                     fecha=dias+"/"+mes+"/"+anio;
                     frmcancelarnotas.txtfecha.setText(fecha);
                     frmcancelarnotas.txtnonota.setText(rss.getString(1));                   
                       
                     aniopago =rss.getString(4).substring(0,4);
                     mespago =rss.getString(4).substring(5,7);
                     diaspago = rss.getString(4).substring(8,10);
                     fechapago=diaspago+"/"+mespago+"/"+aniopago;   
                     frmcancelarnotas.txtfechapago.setText(fechapago);
                    
                }
                 ResultSet rs1= stmt.executeQuery("select   tblnotasmovimientos.id_Articulo from "
                         + "tblnotasmovimientos where  id_Nota='"+idnota+"'");
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
                
                ResultSet rs3= stmt.executeQuery("select * from tblnotasmovimientos where  id_Nota='"+idnota+"'");
                while(rs3.next())
                {   filas2[0] =   rs3.getString(4);
                    filas2[1] =   rs3.getString(5);
                    filas2[2] =   rs3.getString(7);
                    filas2[3]=    rs3.getString(6);
                    filas2[4]=    rs3.getString(8);
                    frmcancelarnotas.modeloTabla.addRow(filas2);
                    frmcancelarnotas.tblnotas.setModel(frmcancelarnotas.modeloTabla);
                }
                con.close();
                 cerrar();   
                }
                else
                {
                    
                    
                      cancelar.setVisible(true);
                    rs = stmt.executeQuery("SELECT * from tblclientes where cliNombre='"+nombrecliente+"'");
                configModelo2();
                while(rs.next())
                {
                    frmcancelarnotas.txtncliente.setText(rs.getString(1));
                    frmcancelarnotas.txtcliente.setText(rs.getString(2));
                    frmcancelarnotas.txtdomicilio.setText(rs.getString(3));
                    frmcancelarnotas.txtcolonia.setText(rs.getString(4));
                   String tippago = rs.getString(5);
                if("1".equals(tippago))
                {    frmcancelarnotas.txttipopago.setText("Contado");
                    
                }
                else
                {    frmcancelarnotas.txttipopago.setText("Credito");
                    ;
                } 
                    frmcancelarnotas.txtdiascredito.setText(rs.getString(6));
                    frmcancelarnotas.txttelefono.setText(rs.getString(7));
                   
                }
                ResultSet rss= stmt.executeQuery("select * from tblnotas where  id_Nota='"+idnota+"'");
                while(rss.next())
                {    String fecha, fechapago,anio,aniopago,mes,mespago,dias,diaspago;   
                    
                     anio =rss.getString(3).substring(0,4);
                     mes =rss.getString(3).substring(5,7);
                     dias = rss.getString(3).substring(8,10);
                     fecha=dias+"/"+mes+"/"+anio;
                     frmcancelarnotas.txtfecha.setText(fecha);
                     frmcancelarnotas.txtnonota.setText(rss.getString(1));                   
                       
                     aniopago =rss.getString(4).substring(0,4);
                     mespago =rss.getString(4).substring(5,7);
                     diaspago = rss.getString(4).substring(8,10);
                     fechapago=diaspago+"/"+mespago+"/"+aniopago;   
                     frmcancelarnotas.txtfechapago.setText(fechapago);
                    
                }
                 ResultSet rs1= stmt.executeQuery("select   tblnotasmovimientos.id_Articulo from "
                         + "tblnotasmovimientos where  id_Nota='"+idnota+"'");
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
                
                    frmcancelarnotas.tblnotas.setModel(frmcancelarnotas.modeloTabla);
                    
                  //  JOptionPane.showMessageDialog(null, "La nota no Tiene Movimientos", "Error", 2);
                }
                
                
            }
            
              
        catch (Exception ex) 
            {
                JOptionPane.showMessageDialog(this, "Ocurrio el siguiente error:" + ex);
            }         
        }
        
        
          void dobleclick() 
            {
                tblbuscanotas.addMouseListener(new MouseAdapter() 
                {
                    @Override
                    public void mousePressed(MouseEvent Mouse_evt) 
                    {  JTable tabla = (JTable) Mouse_evt.getSource();
                        Point point = Mouse_evt.getPoint();
                        int row = tabla.rowAtPoint(point);
                        if (Mouse_evt.getClickCount() == 2)
                        { 
                            
                            enviardatos();
                            

                        }
                    }
                });
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
        tblbuscanotas = new javax.swing.JTable();
        txtnombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reimprimir Notas");

        tblbuscanotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblbuscanotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbuscanotasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblbuscanotas);

        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombreKeyReleased(evt);
            }
        });

        jLabel1.setText("Nombre:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblbuscanotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbuscanotasMouseClicked
        // TODO add your handling code here:
        fila=tblbuscanotas.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_tblbuscanotasMouseClicked
 TableRowSorter trs; 
    private void txtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyReleased
        // TODO add your handling code here:
       
        txtnombre.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent ke){
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtnombre.getText(), 1));
            }
        });
        trs = new TableRowSorter(tblbuscanotas.getModel());
        tblbuscanotas.setRowSorter(trs);
    }//GEN-LAST:event_txtnombreKeyReleased

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
            java.util.logging.Logger.getLogger(frmbuscacancelarnotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmbuscacancelarnotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmbuscacancelarnotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmbuscacancelarnotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmbuscacancelarnotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblbuscanotas;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
