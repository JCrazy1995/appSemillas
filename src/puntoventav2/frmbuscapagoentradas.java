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
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableColumnModel;
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
public final class frmbuscapagoentradas extends javax.swing.JFrame {

    /**
     * Creates new form frmbuscapagoentradas
     */
    private static Connection con = null;
    static ResultSet rs = null;
    private java.sql.Statement stmt = null;
    conectar conexion = new conectar();
    DefaultTableModel modeloTabla = new DefaultTableModel();
    Object filas[] = new Object[6];
     DefaultTableModel modeloTabla2 = new DefaultTableModel();
    private int fila;
    frmabonoentradas abono = new frmabonoentradas();
    public frmbuscapagoentradas() 
    {
        initComponents();
        configModelo();
        iniciotabla();
        dobleclick();
        setResizable(false);
        salir();
    }

    void configModelo() 
    {
        modeloTabla.addColumn("Numero");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Fecha");
        modeloTabla.addColumn("Saldo");
        modeloTabla.addColumn("Total");
        modeloTabla.addColumn("Pagada");
        tblbuscaentradas.setModel(modeloTabla);
        
        
        
        TableColumnModel columnModel = tblbuscaentradas.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(70);
        columnModel.getColumn(4).setPreferredWidth(70);
        columnModel.getColumn(5).setPreferredWidth(50);
    }
    
    
     public   void iniciotabla()
        {
            
           
            eliminar();
            
            String nombre="1";
        try 
        {
            con = conexion.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(" select * from tblentradas where   entStatus!='Cancelada' and entStatus !='Cancelada por Actu' and entPago='no'");
            while (rs.next()) 
            {     stmt = con.createStatement();
                  ResultSet rss= stmt.executeQuery("select tblproveedores.proNombre from tblproveedores where id_proveedor='"+rs.getString(2)+"'");
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
                filas[3]= rs.getString(7);
                filas[2] = dia+"/"+mes+"/"+ano;
                filas[4] = (rs.getString(5));
                filas[5] = (rs.getString(8));
                modeloTabla.addRow(filas);
                tblbuscaentradas.setModel(modeloTabla);

            }
            con.close();
        } catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(this, "Ocurrio el siguiente error:" + ex);
        }

                    
        }
    
        void eliminar() 
    {

        DefaultTableModel tb = (DefaultTableModel) tblbuscaentradas.getModel();
        int a = tblbuscaentradas.getRowCount() - 1;
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
                abono.setVisible(true);
                con = conexion.getConnection();
                stmt = con.createStatement();
                
                String nombrecliente= tblbuscaentradas.getValueAt(tblbuscaentradas.getSelectedRow(),1).toString();
                String idnota = tblbuscaentradas.getValueAt(tblbuscaentradas.getSelectedRow(), 0).toString();
                ResultSet rs = stmt.executeQuery("SELECT * from tblentradas where id_entradas='"+idnota+"'");              
                if(rs.next())
                {
                    frmabonoentradas.lblcliente.setText(nombrecliente);
                    frmabonoentradas.lblnoentrada.setText(rs.getString(1));
                    frmabonoentradas.lbltotal.setText(rs.getString(5));
                    frmabonoentradas.txtabono.setText("");
                    frmabonoentradas.lblsaldo.setText(rs.getString(7));
                    frmabonoentradas.lblpagado.setText(rs.getString(8));
                    frmabonoentradas.lblabonado.setText(rs.getString(6));
                }
                
                cerrar();
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
        txtnombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Busca Compras ");

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
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(0, 27, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblbuscaentradasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbuscaentradasMouseClicked
        // TODO add your handling code here:
        fila=tblbuscaentradas.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_tblbuscaentradasMouseClicked
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
            java.util.logging.Logger.getLogger(frmbuscapagoentradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmbuscapagoentradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmbuscapagoentradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmbuscapagoentradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new frmbuscapagoentradas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblbuscaentradas;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
