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
public class frmbuscasalidascancelar extends javax.swing.JFrame {

    /**
     * Creates new form frmbuscasalidascancelar
     */
    private static Connection con = null;
    static ResultSet rs = null;
    private java.sql.Statement stmt = null;
    private java.sql.Statement stmtt = null;
    conectar conexion = new conectar();
    DefaultTableModel modeloTabla = new DefaultTableModel();
    Object filas[] = new Object[3];
     DefaultTableModel modeloTabla2 = new DefaultTableModel();
    Object filas2[] = new Object[2];
    private int fila;
   
    public frmbuscasalidascancelar() 
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
        modeloTabla.setColumnCount(0);
        modeloTabla.addColumn("Numero Salidas");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Fecha");
        tblbuscasalidas.setModel(modeloTabla);

    }
    
    
        void iniciotabla()
        {
            String nombre="1";
        try 
        {
            con = conexion.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(" select * from tblsalidasespeciales where salEspStatus !='cancelada'");
            while (rs.next()) 
            {    
                filas[0] = (rs.getString(1));
                filas[1] = rs.getString(2);
                String fecha = (rs.getString(3));
                String dia= fecha.substring(8,10);
                String mes = fecha.substring(5,7);
                String ano = fecha.substring(0,4);
                filas[2] = dia+"/"+mes+"/"+ano;
                modeloTabla.addRow(filas);
                tblbuscasalidas.setModel(modeloTabla);

            }
            con.close();
        } catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(this, "Ocurrio el siguiente error:" + ex);
        }

                    
        }
    
        void eliminar() 
    {

        DefaultTableModel tb = (DefaultTableModel) tblbuscasalidas.getModel();
        int a = tblbuscasalidas.getRowCount() - 1;
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

            int idarticulo = 0;
            String nompreproducto="";
            String nombre= tblbuscasalidas.getValueAt(tblbuscasalidas.getSelectedRow(),1).toString();
            frmcancelarsalidas.txtnombre.setText(nombre);
            String idsalida = tblbuscasalidas.getValueAt(tblbuscasalidas.getSelectedRow(), 0).toString();
            frmcancelarsalidas.txtnosalida.setText(idsalida);
                ResultSet rss= stmt.executeQuery("select * from tblsalidasespeciales where  id_SalEsp='"+idsalida+"'");
                while(rss.next())
                {    String fecha, fechapago,anio,aniopago,mes,mespago,dias,diaspago;   

                     anio =rss.getString(3).substring(0,4);
                     mes =rss.getString(3).substring(5,7);
                     dias = rss.getString(3).substring(8,10);
                     fecha=dias+"/"+mes+"/"+anio;
                     frmcancelarsalidas.txtfecha.setText(fecha);
                   
                }
                ResultSet rs1= stmt.executeQuery("select    tblmovimientosespeciales.id_Articulo from "
                         + "tblmovimientosespeciales where  id_SalEsp='"+idsalida+"'");
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

                ResultSet rs3= stmt.executeQuery("select * from tblmovimientosespeciales where  id_SalEsp='"+idsalida+"'");
                while(rs3.next())
                {   filas2[0] =   rs3.getString(4);
                    filas2[1] =  nompreproducto;
                   
                    frmcancelarsalidas.modeloTabla.addRow(filas2);
                    frmcancelarsalidas.tblsalidas.setModel(frmcancelarsalidas.modeloTabla);
                }
                con.close();
                 cerrar();   
            
    }
            
              
        catch (SQLException ex) 
            {
                JOptionPane.showMessageDialog(this, "Ocurrio el siguiente error:" + ex);
            }         
        }
        
        
          void dobleclick() 
            {
                tblbuscasalidas.addMouseListener(new MouseAdapter() 
                {
                    @Override
                    public void mousePressed(MouseEvent Mouse_evt) 
                    {  
                        if (Mouse_evt.getClickCount() == 2)
                        { 
                            frmcancelarsalidas cance= new frmcancelarsalidas();
                            cance.setVisible(true);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblbuscasalidas = new javax.swing.JTable();
        txtnombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reimprimir Notas");

        tblbuscasalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblbuscasalidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbuscasalidasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblbuscasalidas);

        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombreKeyReleased(evt);
            }
        });

        jLabel1.setText("Nombre:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblbuscasalidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbuscasalidasMouseClicked
        // TODO add your handling code here:
        fila=tblbuscasalidas.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_tblbuscasalidasMouseClicked
 TableRowSorter trs; 
    private void txtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyReleased
        // TODO add your handling code here:
       
        txtnombre.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent ke){
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtnombre.getText(), 1));
            }
        });
        trs = new TableRowSorter(tblbuscasalidas.getModel());
        tblbuscasalidas.setRowSorter(trs);
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
            java.util.logging.Logger.getLogger(frmbuscasalidascancelar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmbuscasalidascancelar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmbuscasalidascancelar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmbuscasalidascancelar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new frmbuscasalidascancelar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblbuscasalidas;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
