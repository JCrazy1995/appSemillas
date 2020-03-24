/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puntoventav2;

/**
 *
 * @author Francisco Rafael
 */

import traducir.Traducir;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.OutputStream;
import java.util.HashMap;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.lang.Exception;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.engine.*;

public class frmcancelarnotas extends javax.swing.JFrame {
    static java.sql.ResultSet rs=null;
    private Statement stmt=null;
    private Statement stmt1=null;
    conectar conexion = new conectar();
    static DefaultTableModel modeloTabla= new DefaultTableModel();  //modelo de tabla que llevara los datos
   DefaultTableModel modeloTabla2= new DefaultTableModel(); // modelo vacio para la tabla de clientes
    Object filas[]= new Object[5];   
    private int fila; 
    Connection con = null;
    int b=0;
    Double totalenviar=0.0 ;
    Calendar calendario =Calendar.getInstance();
    int dia =calendario.get(calendario.DATE);
    int mes = calendario.get(calendario.MONTH)+1;
    int ano = calendario.get(calendario.YEAR);
    String numeronota="";
    Traducir tra = new Traducir();
        /**
     * Creates new form frmnotas
     */
    public frmcancelarnotas() 
    {
        initComponents();
      
        this.setResizable(false);
        this.setSize(new Dimension(660,750));
        txtcliente.requestFocus();
        configModelo();
        
       
       
        
    }
        
         void configModelo() 
        {
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Producto");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Tipo");
        modeloTabla.addColumn("Total");
        tblnotas.setModel(modeloTabla);

        }
        
    
        public static Date sumarRestarDiasFecha(Date fecha, int dias) 
        {

        Calendar calendar = Calendar.getInstance();


	calendar.setTime(fecha); // Configuramos la fecha que se recibe

        calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0

        return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos

    
        }
        
         
        
          void eliminar()
          {              
            DefaultTableModel tb = (DefaultTableModel) tblnotas.getModel();
            int a = tblnotas.getRowCount()-1;
            for (int i = a; i >= 0; i--) 
            {          
            tb.removeRow(tb.getRowCount()-1);
            }
            
            txtcliente.setText("");
            txtfecha.setText("");
            txtdiascredito.setText("");
            txttelefono.setText("");
            txtncliente.setText("");
            txtcolonia.setText("");
            txttipopago.setText("");
            txtnonota.setText("");
            txtdomicilio.setText("");
            txtfechapago.setText("");
           
            
            
            
          }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtcliente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtfecha = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtdiascredito = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        txttipopago = new javax.swing.JTextField();
        txtcolonia = new javax.swing.JTextField();
        txtncliente = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtnonota = new javax.swing.JTextField();
        txtdomicilio = new javax.swing.JTextField();
        txtfechapago = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblnotas = new javax.swing.JTable();
        btnguardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(795, 600));

        jLabel6.setText("Cliente:");

        txtcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclienteActionPerformed(evt);
            }
        });
        txtcliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtclienteKeyPressed(evt);
            }
        });

        jLabel8.setText("Fecha:");

        txtfecha.setEditable(false);

        jLabel11.setText("Dias Credito");

        txtdiascredito.setEditable(false);
        txtdiascredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiascreditoActionPerformed(evt);
            }
        });

        jLabel15.setText("Telefono");

        txttelefono.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtdiascredito, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdiascredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        txttipopago.setEditable(false);

        txtcolonia.setEditable(false);
        txtcolonia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcoloniaActionPerformed(evt);
            }
        });

        txtncliente.setEditable(false);

        jLabel14.setText("N° Cliente");

        jLabel10.setText("Colonia:");

        jLabel12.setText("Tipo pago:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtncliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcolonia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttipopago, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtncliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtcolonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txttipopago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jLabel9.setText("Domicilio");

        jLabel7.setText("N° Nota");

        txtnonota.setText("1");

        txtdomicilio.setEditable(false);

        txtfechapago.setEditable(false);

        jLabel13.setText("Fecha pago:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(txtfechapago, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtnonota, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtdomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtnonota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(txtfechapago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblnotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblnotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblnotasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblnotas);

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnguardar)
                .addGap(65, 65, 65))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnguardar)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(207, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registrar Notas", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtclienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtclienteKeyPressed
        // TODO add your handling code here:
        int c=0;
        
         if (evt.getKeyCode() == KeyEvent.VK_ENTER)
         {
          try
          {
          con=conexion.getConnection();
          stmt=con.createStatement();
          rs=stmt.executeQuery("select * from tblclientes where cliNombre like '"+txtcliente.getText()+"%'");
           while(rs.next())
            {                        
                c++;
            }
           if (c>1|| c==0)
           {
               JOptionPane.showMessageDialog(null, "Favor de ingresar mas datos");
              
           }
           else
           {
               rs=stmt.executeQuery("select * from tblclientes where  cliNombre  like '"+txtcliente.getText()+"%'");
           while(rs.next())
            {                        
                txtncliente.setText(rs.getString(1));
                txtcliente.setText(rs.getString(2));
                txtdomicilio.setText(rs.getString(3));
                txtcolonia.setText(rs.getString(4));
                String tippago = rs.getString(5);
                if("1".equals(tippago))
                {
                    txttipopago.setText("Contado");
                }
                else
                {
                    txttipopago.setText("Credito");
                }
                
                txtdiascredito.setText(rs.getString(6));
                txttelefono.setText(rs.getString(7));
                 calendario =Calendar.getInstance();
                int dia =calendario.get(calendario.DATE);
                
                String myDate = dia+"/"+mes+"/"+ano;
                
                 SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yy");
                 Date date = formateador.parse(myDate); 
                 txtfecha.setText(formateador.format(sumarRestarDiasFecha(date, 0)));
                 int credito = Integer.parseInt(txtdiascredito.getText());
                 txtfechapago.setText(formateador.format(sumarRestarDiasFecha(date, credito)).toString());

            }
              
                
           }
            con.close();
          }
          catch(SQLException ex)
          {
              JOptionPane.showMessageDialog(null, ex);
          } 
          catch (ParseException ex) 
          {
                Logger.getLogger(frmcancelarnotas.class.getName()).log(Level.SEVERE, null, ex);
           } 
          
             try 
             {      
                 int ultimoid=0;
                 con = conexion.getConnection();
                 stmt = con.createStatement();
                 rs =stmt.executeQuery("select max(id_Nota) from tblNotas ");
                  if(rs.next())
                  {
                       ultimoid=rs.getInt(1)+1;
                      
                  }
                  txtnonota.setText(ultimoid+"");
             } 
             catch (Exception e) 
             {
                 
             }
                 
           
             
          
          
             
    }
        
    }//GEN-LAST:event_txtclienteKeyPressed

    private void txtcoloniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcoloniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcoloniaActionPerformed

    private void txtdiascreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiascreditoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiascreditoActionPerformed

    private void txtclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclienteActionPerformed

    private void tblnotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblnotasMouseClicked
        // TODO add your handling code here:
        fila=tblnotas.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_tblnotasMouseClicked

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
         int filas = modeloTabla.getRowCount();
         String tipo,fechanota,fechapago,nombre,producto;
         double cantidad,precio,totalproducto,totalnota;
         con=conexion.getConnection();    
         int nocliente= Integer.parseInt(txtncliente.getText());
         fechanota= ano+"-"+mes+"-"+dia;      
         String aniopago = txtfechapago.getText().substring(6,8);
         String mespago =txtfechapago.getText().substring(3,5);
         String diapago = txtfechapago.getText().substring(0,2);
         fechapago= aniopago+"-"+mespago+"-"+diapago;
         nombre = txtcliente.getText();
         
         int lasid=0;
         int idarticulo=0;
         double totalexistencia=0;
         double totalinventario=0;
         int c=0;
         String idnotacancelar=txtnonota.getText(); //id de la nota  que se cancela
        
        int confirmacion= JOptionPane.showConfirmDialog(null, "Desea Cancelar la nota", "Confirmación", JOptionPane.YES_NO_OPTION, 1 );
        if (confirmacion == 0)
        {       
                try 
                {       
                con=conexion.getConnection();
                stmt=con.createStatement();
                stmt = con.createStatement();
                  //pongo el status cancelado a la nota
                  
                   PreparedStatement psInsert11= con.prepareStatement("update tblnotas set noStatus='Cancelada'"
                           + "  where id_Nota=? ");
                                psInsert11.setString(1, idnotacancelar);
                                psInsert11.execute();
                               
                }
                
                catch (SQLException e) 
                {
                    JOptionPane.showMessageDialog(null, e);
                }
                //cancelar los movimientos de la nota
                
                try 
                {   int articulo=0;
                    double existencia=0,totalenviar=0,cantidadprodudcto=0;  
                     ResultSet rs12= stmt.executeQuery("select tblnotasmovimientos.id_Articulo,tblnotasmovimientos.movcantidad"
                             + " from tblnotasmovimientos where id_nota='"+idnotacancelar+"'");
                    con=conexion.getConnection();
                    stmt1=con.createStatement();
                     while(rs12.next())
                    {       System.out.println("oli");
                         
                       cantidadprodudcto= rs12.getDouble(2);
                        articulo=rs12.getInt(1);
                        System.out.println(cantidadprodudcto);
                        
                        ResultSet rs13= stmt1.executeQuery("select tblinventario.invexistencia from tblinventario where id_Articulo='"+articulo+"'");
                         if(rs13.next())
                         {
                             existencia=Double.parseDouble(rs13.getString(1));
                         }
                         
                         totalenviar=existencia+cantidadprodudcto;
                         PreparedStatement psInsert2= con.prepareStatement("update tblinventario set invExistencia=? where id_Articulo=? ");
                         psInsert2.setDouble(1, totalenviar);
                         psInsert2.setInt(2,articulo);
                         psInsert2.executeUpdate();
                       
                     }
                } 
                catch (SQLException e) 
                {
                    JOptionPane.showMessageDialog(null, e);
                }
                
                
        

                int filass = modeloTabla.getRowCount();  
                   btnguardar.setEnabled(false);
                  
        }
       
        
    }//GEN-LAST:event_btnguardarActionPerformed

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
            java.util.logging.Logger.getLogger(frmcancelarnotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmcancelarnotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmcancelarnotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmcancelarnotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new frmcancelarnotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTable tblnotas;
    public static javax.swing.JTextField txtcliente;
    public static javax.swing.JTextField txtcolonia;
    public static javax.swing.JTextField txtdiascredito;
    protected static javax.swing.JTextField txtdomicilio;
    public static javax.swing.JTextField txtfecha;
    public static javax.swing.JTextField txtfechapago;
    public static javax.swing.JTextField txtncliente;
    public static javax.swing.JTextField txtnonota;
    public static javax.swing.JTextField txttelefono;
    public static javax.swing.JTextField txttipopago;
    // End of variables declaration//GEN-END:variables
}