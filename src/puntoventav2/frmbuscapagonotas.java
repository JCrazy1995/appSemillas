package puntoventav2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
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
public final class frmbuscapagonotas extends javax.swing.JFrame {

    /**
     * Creates new form frmbuscapagonotas
     */
    private static Connection con = null;
    static ResultSet rs = null;
    private java.sql.Statement stmt = null;
    conectar conexion = new conectar();
    DefaultTableModel modeloTabla = new DefaultTableModel();
    Object filas[] = new Object[6];
     DefaultTableModel modeloTabla2 = new DefaultTableModel();
    private int fila;
    frmabononotas abono = new frmabononotas();
    public frmbuscapagonotas() 
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
        modeloTabla.addColumn("Saldo");
        modeloTabla.addColumn("Total");
        modeloTabla.addColumn("Pagada");
        tblbuscanotas.setModel(modeloTabla);

    }
    
    
     public   void iniciotabla()
        {
            
           
            eliminar();
            
            String nombre="1";
        try 
        {
            con = conexion.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(" select * from tblnotas where   noStatus!='Cancelada' and noStatus !='Cancelada por Actu' and noPagado='no'");
            while (rs.next()) 
            {     stmt = con.createStatement();
                  ResultSet rss= stmt.executeQuery("select tblclientes.cliNombre from tblclientes where id_Cliente='"+rs.getString(2)+"'");
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
                abono.setVisible(true);
                con = conexion.getConnection();
                stmt = con.createStatement();
                
                String nombrecliente= tblbuscanotas.getValueAt(tblbuscanotas.getSelectedRow(),1).toString();
                String idnota = tblbuscanotas.getValueAt(tblbuscanotas.getSelectedRow(), 0).toString();
                ResultSet rs = stmt.executeQuery("SELECT * from tblnotas where id_nota='"+idnota+"'");              
                if(rs.next())
                {
                    frmabononotas.lblcliente.setText(nombrecliente);
                    frmabononotas.lblnonota.setText(rs.getString(1));
                    frmabononotas.lbltotal.setText(rs.getString(5));
                    frmabononotas.txtabono.setText("");
                    frmabononotas.lblsaldo.setText(rs.getString(7));
                    frmabononotas.lblpagado.setText(rs.getString(8));
                    frmabononotas.lblabonado.setText(rs.getString(6));
                    
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
                tblbuscanotas.addMouseListener(new MouseAdapter() 
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
            java.util.logging.Logger.getLogger(frmbuscapagonotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmbuscapagonotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmbuscapagonotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmbuscapagonotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmbuscapagonotas().setVisible(true);
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
