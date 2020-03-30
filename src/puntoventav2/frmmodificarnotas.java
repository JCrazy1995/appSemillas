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

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.OutputStream;
import java.util.HashMap;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.lang.Exception;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.engine.*;

public class frmmodificarnotas extends javax.swing.JFrame {
    static java.sql.ResultSet rs=null;
    private Statement stmt=null;
    private Statement stmt1=null;
    conectar conexion = new conectar();
    static DefaultTableModel modeloTabla= new DefaultTableModel();  //modelo de tabla que llevara los datos
    static DefaultTableModel modeloTabla2= new DefaultTableModel(); // modelo vacio para la tabla de clientes
    Object filas[]= new Object[8];   
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
    public frmmodificarnotas() 
    {
        initComponents();
        txttotal.setEnabled(false);
        txttotalcompra.setEnabled(false);
        this.setResizable(false);
        this.setSize(new Dimension(760,700));
        txtcliente.requestFocus();
        tblnotas.setModel(modeloTabla2);
        configModelo();
        
        
    }
        
    
    void configmodel()
    {
        int t = tblnotas.getColumnCount();
        for(int i =0;i<t;i++)
        {
        tblnotas.getColumnModel().removeColumn(tblnotas.getColumnModel().getColumn(0));
        }
                
    }
   
        public static void configModelo() 
        {  
            
            modeloTabla.setColumnCount(0);
           
            
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Producto");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Precio Compra");
        modeloTabla.addColumn("Tipo");
        modeloTabla.addColumn("Total");
        modeloTabla.addColumn("Total Compra");
        modeloTabla.addColumn("Utilidad ");
        tblnotas.setModel(modeloTabla);
        
        TableColumnModel columnModel = tblnotas.getColumnModel();

        columnModel.getColumn(0).setPreferredWidth(70);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(70);
        columnModel.getColumn(3).setPreferredWidth(110);
        columnModel.getColumn(4).setPreferredWidth(50);
        columnModel.getColumn(5).setPreferredWidth(70);
        columnModel.getColumn(6).setPreferredWidth(110);
        columnModel.getColumn(7).setPreferredWidth(70);
            
       
        }
        
    
        public static Date sumarRestarDiasFecha(Date fecha, int dias) 
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fecha); // Configuramos la fecha que se recib
            calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
            return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
        }
        
          void limpiar()
          {
              txtcantidad.setText("");
              txtproducto.setText("");
              txtprecio.setText("");
              txttotal.setText("");
              txtpreciocompra.setText("");
              txttotalcompra.setText("");
              cmbtipo.setSelectedIndex(0);
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
            lblcliente.setText("");
            lbldiascredito.setText("");
            lbldireccion.setText("");
            lblfecha.setText("");
            lblfechapago.setText("");
            lblnocliente.setText("");
            lblnumeronota.setText("");
            lbltipopago.setText("");
            lbltotal.setText("0.0");
            limpiar();
            
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
        jPanel11 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        btnbuscarnota = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtproducto = new javax.swing.JTextField();
        txtprecio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        cmbtipo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txttotal = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtpreciocompra = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txttotalcompra = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        lblcliente = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblfecha = new javax.swing.JLabel();
        lblfechapago = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        lbltipopago = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbldiascredito = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblnotas = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        lblnocliente = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lbldireccion = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lblnumeronota = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        btnimprimir = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        lblutilidad = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lbltotalcompra = new javax.swing.JLabel();

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

        btnbuscarnota.setText("Buscar Nota");
        btnbuscarnota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarnotaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnAgregar)
                .addGap(38, 38, 38)
                .addComponent(btnnuevo)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnbuscarnota)
                .addGap(53, 53, 53))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnnuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnbuscarnota))
        );

        jLabel1.setText("Producto:");

        jLabel2.setText("Precio:");

        txtproducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtproductoKeyPressed(evt);
            }
        });

        txtprecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtprecioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprecioKeyTyped(evt);
            }
        });

        jLabel3.setText("Cantidad");

        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcantidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadKeyTyped(evt);
            }
        });

        cmbtipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kgs", "Pte" }));

        jLabel4.setText("Tipo:");

        jLabel5.setText("Total:");

        jLabel26.setText("Precio Compra:");

        txtpreciocompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpreciocompraKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpreciocompraKeyTyped(evt);
            }
        });

        jLabel27.setText("Total Compra:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cmbtipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtpreciocompra)
                            .addComponent(txtproducto)
                            .addComponent(txtprecio)
                            .addComponent(txtcantidad)
                            .addComponent(txttotalcompra, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
                .addGap(0, 54, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtpreciocompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txttotalcompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(235, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registrar Notas", jPanel1);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Semillas y Cereales Pacheco");

        jLabel17.setText("Cliente:");

        lblcliente.setText("1");

        jLabel18.setText("Fecha:");

        lblfecha.setText("1");

        lblfechapago.setText("1");

        jLabel19.setText("       Pago:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel18)
                        .addComponent(jLabel17)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblfechapago, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblcliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblfechapago, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel20.setText("Tipo Pago:");

        lbltipopago.setText("1");

        jLabel21.setText("       Dias:");

        lbldiascredito.setText("1");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbldiascredito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltipopago, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(lbltipopago, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lbldiascredito, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel22.setText("N°Cliente:");

        lblnocliente.setText("1");

        jLabel23.setText("Dirección:");

        lbldireccion.setText("1");

        jLabel25.setText("N° Nota");

        lblnumeronota.setText("1");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbldireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(lblnocliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblnumeronota, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(lblnocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(lbldireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(lblnumeronota, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnimprimir.setText("Imprimir");
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btneliminar, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btnguardar)
                .addComponent(btnimprimir))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(btnguardar)
                .addGap(18, 18, 18)
                .addComponent(btnimprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btneliminar)
                .addGap(18, 18, 18))
        );

        lblutilidad.setText("0.00");

        jLabel29.setText("Utilidad:");

        lbltotal.setText("0.00");

        jLabel24.setText("Total:");

        jLabel28.setText("Tota Compral:");

        lbltotalcompra.setText("0.00");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(68, Short.MAX_VALUE))
                    .addComponent(jLabel16)))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addGap(18, 18, 18)
                .addComponent(lbltotalcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addComponent(lbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addComponent(lblutilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(lblutilidad))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(lbltotal)
                        .addComponent(jLabel28)
                        .addComponent(lbltotalcompra)))
                .addContainerGap(162, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Imprimir", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
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
                txtcantidad.requestFocus();       
           }
            con.close();
          }
          catch(SQLException ex)
          {
              JOptionPane.showMessageDialog(null, ex);
          } 
          catch (ParseException ex) 
          {
                Logger.getLogger(frmmodificarnotas.class.getName()).log(Level.SEVERE, null, ex);
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

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       // TODO add your handling code here:
        DecimalFormat df = new DecimalFormat("#.00");     
        if(Double.parseDouble(txtprecio.getText())<Double.parseDouble(txtpreciocompra.getText()))
        {
            JOptionPane.showMessageDialog(null, "El Precio de Compra no Puede ser Mayor al de venta", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            
            if("".equals(txtcliente.getText()) || "".equals(txtcantidad.getText()))
            {
                JOptionPane.showMessageDialog(null,"No dejar campos vacios");
            }
            else
            {
                lblcliente.setText(txtcliente.getText());
                lbldiascredito.setText(txtdiascredito.getText());
                lbldireccion.setText(txtdomicilio.getText()+" "+txtcolonia.getText());
                lblfecha.setText(txtfecha.getText());
                lblfechapago.setText(txtfechapago.getText());
                lblnocliente.setText(txtncliente.getText());
                lbltipopago.setText(txttipopago.getText());
                lblnumeronota.setText(txtnonota.getText());
                Double totalcompraenviar=0.0,utilidadenviar=0.0;
                Double total2 = Double.parseDouble(txttotal.getText());
                Double totalcompra= Double.parseDouble(txttotalcompra.getText());
                Double utilidad = total2-totalcompra;

                filas[0] = txtcantidad.getText();         
                filas[1] = txtproducto.getText();
                filas[2] = txtprecio.getText();
                filas[3]=  txtpreciocompra.getText();
                filas[4]=  cmbtipo.getSelectedItem();
                filas[5] = df.format(total2)+"";
                filas[6]=  df.format(totalcompra)+"";
                filas[7]=  df.format(utilidad)+"";
                modeloTabla.addRow(filas);
                Double total = Double.parseDouble(lbltotal.getText());
                Double totalcompras= Double.parseDouble(lbltotalcompra.getText());
                Double totalutilidad = Double.parseDouble(lblutilidad.getText());
                totalenviar = total+total2;
                totalcompraenviar= totalcompra+totalcompras;
                utilidadenviar= utilidad+totalutilidad;
                lbltotal.setText(df.format(totalenviar)+"");
                lbltotalcompra.setText(df.format(totalcompraenviar)+"");
                lblutilidad.setText(df.format(utilidadenviar)+"");
                limpiar();
            }
            
        }
        
        
        
        
               
          
//         try {
//            Document document = new Document();
//            try {
//                PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\coron\\Desktop\\prueba\\"
//                        +txtcliente.getText()+""+"Nota N° "+""+txtnonota.getText()+".pdf"));
//            } catch (FileNotFoundException fileNotFoundException) {
//                System.out.println("No such file was found to generate the PDF "
//                        + "(No se encontró el fichero para generar el pdf)" + fileNotFoundException);
//            }
//          
//            document.close();
//            System.out.println("Your PDF file has been generated!(¡Se ha generado tu hoja PDF!");
//        } catch (DocumentException documentException) {
//            System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);
//        }
//                
                
           
            
//       txtcantidad.setText("");
//       txtproducto.setText("");
//       txtprecio.setText("");
//       cmbtipo.setSelectedIndex(0);
//       txttotal.setText("");

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        // TODO add your handling code here:
        
         //ORIGINAL
               
        try 
        {   HashMap param = new HashMap();
            Connection con = conexion.getConnection();
            JasperDesign jd = JRXmlLoader.load(new File("C:\\Users\\coron\\JaspersoftWorkspace\\Prueba").getAbsolutePath()+"\\pruebaimpresion.jrxml");
            JRDataSource vacio = new JREmptyDataSource(1); 
            param.put("nonota", txtnonota.getText());
            param.put("total",lbltotal.getText());
            param.put("codigocliente", lblnocliente.getText());
            param.put("nombre", lblcliente.getText());
            param.put("Direccion", lbldireccion.getText());
            param.put("telefono", txttelefono.getText());
            param.put("fecha", lblfecha.getText());
            param.put("metodopago","Efectivo");
            param.put("letras", tra.traducirNumeros(lbltotal.getText(), rootPaneCheckingEnabled) );
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr,param,con);
            OutputStream output = new FileOutputStream(new File("C:\\Users\\coron\\Desktop\\prueba\\"
                        +txtcliente.getText()+""+"Nota N° "+""+txtnonota.getText()+".pdf")); 
            JasperExportManager.exportReportToPdfStream(jp, output); 
            output.flush();
            output.close();
              
        } 
        catch (JRException | IOException ex) 
        {
            Logger.getLogger(frmmodificarnotas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //Copia
        try 
        {   HashMap param = new HashMap();
            Connection con = conexion.getConnection();
            JasperDesign jd = JRXmlLoader.load(new File("C:\\Users\\coron\\JaspersoftWorkspace\\Prueba").getAbsolutePath()+"\\pruebaimpresioncopia.jrxml");
            JRDataSource vacio = new JREmptyDataSource(1); 
            param.put("nonota", txtnonota.getText());
            param.put("total",lbltotal.getText());
            param.put("codigocliente", lblnocliente.getText());
            param.put("nombre", lblcliente.getText());
            param.put("Direccion", lbldireccion.getText());
            param.put("telefono", txttelefono.getText());
            param.put("fecha", lblfecha.getText());
            param.put("metodopago","Efectivo");
            param.put("letras", tra.traducirNumeros(lbltotal.getText(), rootPaneCheckingEnabled) );
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr,param,con);
            OutputStream output = new FileOutputStream(new File("C:\\Users\\coron\\Desktop\\prueba\\"
                        +txtcliente.getText()+""+"Nota N° "+""+txtnonota.getText()+"copia.pdf")); 
            JasperExportManager.exportReportToPdfStream(jp, output); 
            output.flush();
            output.close();
              
        } 
        catch (JRException | IOException ex) 
        {
            Logger.getLogger(frmmodificarnotas.class.getName()).log(Level.SEVERE, null, ex);
        }
      
            //Original
              try 
              {
                 File path = new  File("C:\\Users\\coron\\Desktop\\prueba\\"
                        +txtcliente.getText()+""+"Nota N° "+""+txtnonota.getText()+".pdf");
                 Desktop.getDesktop().open(path);
              }
              catch (IOException ex)
              {
                ex.printStackTrace();
              }
              
              //Copia
               try 
              {
                 File path = new  File("C:\\Users\\coron\\Desktop\\prueba\\"
                        +txtcliente.getText()+""+"Nota N° "+""+txtnonota.getText()+"copia.pdf");
                 Desktop.getDesktop().open(path);
              }
              catch (IOException ex)
              {
                ex.printStackTrace();
              } 
              File fileToPrint = new  File("C:\\Users\\coron\\Desktop\\prueba\\"
                        +txtcliente.getText()+""+"Nota N° "+""+txtnonota.getText()+".pdf");
//        try 
//        {
//            Desktop.getDesktop().print(fileToPrint);
//        } 
//        catch (IOException ex) 
//        {
//            Logger.getLogger(frmbuscaclientes.class.getName()).log(Level.SEVERE, null, ex);
//        }
//       
    }//GEN-LAST:event_btnimprimirActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        DecimalFormat df = new DecimalFormat("#.00");  
        int filavalor;
        double totaln,totallabel,totalfinal;
        String valor;
        filavalor = tblnotas.getSelectedRow();
        valor=  modeloTabla.getValueAt(filavalor, 4).toString();
        totaln = Double.parseDouble(valor);
        totallabel= Double.parseDouble(lbltotal.getText());
        totalfinal=totallabel-totaln;
        lbltotal.setText(totalfinal+"");
        modeloTabla.removeRow(fila);
        
        
        System.out.print(totaln);
        
    
    }//GEN-LAST:event_btneliminarActionPerformed

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
         totalnota= Double.parseDouble(lbltotal.getText());
         int lasid=0;
         int idarticulo=0;
         double totalexistencia=0;
         double totalinventario=0;
         int c=0;
         String idnotacancelar=txtnonota.getText(); //id de la nota  que se cancela
        
        int confirmacion= JOptionPane.showConfirmDialog(null, "Todas la modificaciones son correctas", "Confirmación", JOptionPane.YES_NO_OPTION, 1 );
        if (confirmacion == 0)
        {       
                try 
                {       
                con=conexion.getConnection();
                stmt=con.createStatement();
                stmt = con.createStatement();
                PreparedStatement psInsert= con.prepareStatement("INSERT INTO tblnotas"
                           + "(id_Cliente,no_FechaCreada,noFechaPago,noTotal,noAbono,noSaldo,noPagado,noStatus)"
                           + " VALUES (?,?,?,?,?,?,?,?)");

                
                  psInsert.setInt( 1, nocliente);
                  psInsert.setString(2, fechanota);
                  psInsert.setString(3, fechapago);
                  psInsert.setDouble(4, totalnota);
                  psInsert.setDouble(5, 0);
                  psInsert.setDouble(6, totalnota);
                  psInsert.setString(7,"no" );
                  psInsert.setString(8,"Activa");
                  psInsert.executeUpdate();
                  psInsert.close();
                  
                  ResultSet rs= stmt.executeQuery("select max(id_Nota) from tblnotas");
                  if(rs.next())
                  {
                      lasid=rs.getInt(1);
                      
                  }
                  //pongo el status cancelado a la nota
                  
                   PreparedStatement psInsert11= con.prepareStatement("update tblnotas set noStatus='Cancelada por Actu'"
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
                {       int articulo=0;
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
                
                
                System.out.println(lasid);
                try 
                {  
                    for (int i = 0;i<filas;i++)
                    {   
                       cantidad= Double.parseDouble(tblnotas.getValueAt(i,0 ).toString());
                       producto = tblnotas.getValueAt(i, 1).toString();
                       precio = Double.parseDouble(tblnotas.getValueAt(i,2 ).toString());
                       tipo =   tblnotas.getValueAt(i, 3).toString();
                       totalproducto = Double.parseDouble(tblnotas.getValueAt(i,4 ).toString()); 
                       //tomo el articulo del id para agregar 
                       ResultSet rs20= stmt.executeQuery("select tblarticulos.id_Articulo from tblArticulos where artNombre"
                          + "='"+producto+"'");
                        if(rs20.next())
                         {
                             idarticulo=rs20.getInt(1);
                         }
                            
                         ResultSet rs21= stmt.executeQuery("select tblinventario.invExistencia    from"
                                 + " tblinventario where id_Articulo  ='"+idarticulo+"'");
                        if(rs21.next())
                         {
                             totalexistencia=rs21.getInt(1);
                         }
                            totalinventario=totalexistencia-cantidad;
                            PreparedStatement psInsert20= con.prepareStatement("update tblinventario set invExistencia=? where id_Articulo=? ");
                            psInsert20.setDouble(1,totalinventario);
                            psInsert20.setInt(2, idarticulo);
                            psInsert20.executeUpdate();
                            psInsert20.close();
                            System.out.println(totalinventario);
                       
                       PreparedStatement psInsert21= con.prepareStatement("INSERT INTO tblnotasmovimientos"
                       + "( id_Nota,id_Articulo, movCantidad, movNombre,movTipo,movPrecio,movTotal)"
                        + " VALUES (?,?,?,?,?,?,?)");
                        
                    
                      psInsert21.setInt( 1, lasid);  
                      psInsert21.setInt( 2, idarticulo);
                      psInsert21.setDouble(3, cantidad);
                      psInsert21.setString(4, producto);
                      psInsert21.setString(5, tipo);
                      psInsert21.setDouble(6, precio);
                      psInsert21.setDouble(7, totalproducto);
                      psInsert21.executeUpdate();
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

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        btnguardar.setEnabled(true);
        eliminar();
      configmodel();
      configModelo();
      
//        configModelo();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnbuscarnotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarnotaActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
        eliminar();
        frmbuscarmodificarnotas buscar = new frmbuscarmodificarnotas();
        buscar.setVisible(true);
      
    }//GEN-LAST:event_btnbuscarnotaActionPerformed

    private void tblnotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblnotasMouseClicked
        // TODO add your handling code here:
        fila=tblnotas.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_tblnotasMouseClicked

    private void txtproductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtproductoKeyPressed
        // TODO add your handling code here:
        int c=0;
        float precio,total,cantidad,totalcompra,preciocompra;
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
                            txtprecio.setText(rs.getString(3));
                            txtpreciocompra.setText(rs.getString(5));
                        }
                        txtprecio.requestFocus();
                        precio =Float.parseFloat(txtprecio.getText());
                        cantidad= Float.parseFloat(txtcantidad.getText());
                        total = precio*cantidad;
                        txttotal.setText(total+"");
                        preciocompra= Float.parseFloat(txtpreciocompra.getText());
                        totalcompra=preciocompra*cantidad;
                        txttotalcompra.setText(totalcompra+"");

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

    private void txtprecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioKeyPressed
        // TODO add your handling code here:
        float precio,total,cantidad;
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            if("".equals(txtcantidad.getText()))
            {
                JOptionPane.showMessageDialog(null, "no dejar el campo de cantidad vacio");
            }
            else
            {
                precio =Float.parseFloat(txtprecio.getText());
                cantidad= Float.parseFloat(txtcantidad.getText());
                total = precio*cantidad;
                txttotal.setText(total+"");
            }

            txtpreciocompra.requestFocus();

        }

    }//GEN-LAST:event_txtprecioKeyPressed

    private void txtprecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioKeyTyped
        // TODO add your handling code 1here:
        char car = evt.getKeyChar();
        if((car<'0' || car>'9') && (car<=',' || car>'.')|| (car=='-'))  evt.consume();
    }//GEN-LAST:event_txtprecioKeyTyped

    private void txtcantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            txtproducto.requestFocus();
        }
    }//GEN-LAST:event_txtcantidadKeyPressed

    private void txtcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyTyped
        // TODO add your handling code here:

        char car = evt.getKeyChar();
        if((car<'0' || car>'9') && (car<=',' || car>'.')|| (car=='-'))  evt.consume();
    }//GEN-LAST:event_txtcantidadKeyTyped

    private void txtpreciocompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpreciocompraKeyPressed
        // TODO add your handling code here:
        float precio,total,cantidad;
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            if("".equals(txtcantidad.getText()))
            {
                JOptionPane.showMessageDialog(null, "no dejar el campo de cantidad vacio");
            }
            else
            {
                precio =Float.parseFloat(txtpreciocompra.getText());
                cantidad= Float.parseFloat(txtcantidad.getText());
                total = precio*cantidad;
                txttotalcompra.setText(total+"");
            }

            cmbtipo.requestFocus();

        }
    }//GEN-LAST:event_txtpreciocompraKeyPressed

    private void txtpreciocompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpreciocompraKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if((car<'0' || car>'9') && (car<=',' || car>'.')|| (car=='-'))  evt.consume();
    }//GEN-LAST:event_txtpreciocompraKeyTyped

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
            java.util.logging.Logger.getLogger(frmmodificarnotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmmodificarnotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmmodificarnotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmmodificarnotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new frmmodificarnotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnbuscarnota;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JComboBox<String> cmbtipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JLabel lblcliente;
    public static javax.swing.JLabel lbldiascredito;
    public static javax.swing.JLabel lbldireccion;
    public static javax.swing.JLabel lblfecha;
    public static javax.swing.JLabel lblfechapago;
    public static javax.swing.JLabel lblnocliente;
    public static javax.swing.JLabel lblnumeronota;
    public static javax.swing.JLabel lbltipopago;
    public static javax.swing.JLabel lbltotal;
    public static javax.swing.JLabel lbltotalcompra;
    public static javax.swing.JLabel lblutilidad;
    public static javax.swing.JTable tblnotas;
    private javax.swing.JTextField txtcantidad;
    public static javax.swing.JTextField txtcliente;
    public static javax.swing.JTextField txtcolonia;
    public static javax.swing.JTextField txtdiascredito;
    protected static javax.swing.JTextField txtdomicilio;
    public static javax.swing.JTextField txtfecha;
    public static javax.swing.JTextField txtfechapago;
    public static javax.swing.JTextField txtncliente;
    public static javax.swing.JTextField txtnonota;
    private javax.swing.JTextField txtprecio;
    private javax.swing.JTextField txtpreciocompra;
    private javax.swing.JTextField txtproducto;
    public static javax.swing.JTextField txttelefono;
    public static javax.swing.JTextField txttipopago;
    private javax.swing.JTextField txttotal;
    private javax.swing.JTextField txttotalcompra;
    // End of variables declaration//GEN-END:variables
}
