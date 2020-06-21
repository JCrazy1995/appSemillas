/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puntoventav2;

import java.awt.Desktop;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author Francisco Rafael
 */

public class frmreporteventasgeneral extends javax.swing.JFrame {

    /**
     * Creates new form frmreporteventas
     */
    DefaultTableModel modeloTabla = new DefaultTableModel();
    Object filas[] = new Object[5];
     private static Connection con = null;
    static ResultSet rs = null;
    private java.sql.Statement stmt = null;
    conectar conexion = new conectar();
    static String fecha1;
      static String fecha2;
      Date  fecha;
        Date fechados;
    public frmreporteventasgeneral()
    {
        initComponents();
        this.setResizable(false);
        salir();
        
    }
    
    public static void fecha()
     {
 
    try {
        //jDateChooser el nombre la variable  del componente jdatecgooser
        Date  fecha=date1.getDate();
        Date fechados=date2.getDate();
        
      
        DateFormat f=new SimpleDateFormat("yyyy-MM-dd");
         fecha1=f.format(fecha);
         fecha2=f.format(fechados);
        if(fechados.before(fecha))
        {
           JOptionPane.showMessageDialog(null, "Las Fechas no coinciden", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        
        //textFecha nombre de la variable del componenten jtextfiel
     
        } 
        catch (HeadlessException e)
        {
           JOptionPane.showMessageDialog(null, e);
        }
      
     }
        
    
    
    
      public static Date sumarRestarDiasFecha(Date fecha, int dias) 
        {
        Calendar calendar = Calendar.getInstance();
	calendar.setTime(fecha); // Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
        return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
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

        jPanel1 = new javax.swing.JPanel();
        date1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        date2 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        date1.setDateFormatString("dd/MM/y");

        jLabel1.setText("De la Fecha ");

        date2.setDateFormatString("dd/MM/y");

        jLabel2.setText("a la Fecha");

        jButton1.setText("Ver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1)
                        .addGap(129, 129, 129))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(date1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(date2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addGap(8, 8, 8)
                .addComponent(date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
   
        String f = date1.getDateFormatString();
       
        double total=0,abonos=0;
        fecha();
         Calendar calendario =Calendar.getInstance();
         int dia1 =calendario.get(calendario.DATE);
         int mes1 = calendario.get(calendario.MONTH)+1;
         int ano1 = calendario.get(calendario.YEAR);
         String myDate = dia1+"/"+mes1+"/"+ano1;
         double utilidad=0;  
        
       
         try 
        {
            con = conexion.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(" select * from tblnotas where no_fechaCreada>='"+fecha1+"' and no_fechacreada<='"+fecha2+"' and nostatus!='cancelada' and nostatus!='cancelada por actu';");
           while(rs.next())
           {
               
                abonos=abonos+rs.getDouble(6);
                total=total+rs.getDouble(5);
                utilidad=utilidad+rs.getDouble(10);
            }
            con.close();
        } 
         catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(this, "Ocurrio el siguiente error:" + ex);
        }        
          try 
        {     
             SimpleDateFormat formateador = new SimpleDateFormat("yyyy-mm-dd");
            Date f1 = formateador.parse(fecha1);
            Date f2 = formateador.parse(fecha2);
            System.out.println(f1+" "+f2);
             SimpleDateFormat formateador1 = new SimpleDateFormat("dd/MM/yy");
             Date date = formateador1.parse(myDate);  
             
             System.out.println(formateador.format(sumarRestarDiasFecha(f1, 0))+" "+formateador.format(sumarRestarDiasFecha(f2, 0)));
                HashMap param = new HashMap();
                Connection con1 = conectar.getConnection();  
             //   JasperDesign jd = JRXmlLoader.load(new File("C:\\Users\\coron\\JaspersoftWorkspace\\Prueba").getAbsolutePath()+"\\Reporteventas2.jrxml");
                //JRDataSource vacio = new JREmptyDataSource(1); 
                 param.put("fecha1", formateador.format(sumarRestarDiasFecha(f1, 0)));
                param.put("fecha2", formateador.format(sumarRestarDiasFecha(f2, 0)));
                param.put("total",total);
                param.put("Fecha", formateador1.format(sumarRestarDiasFecha(date, 0)));
                param.put("del", formateador1.format(sumarRestarDiasFecha(f1, 0)));
                param.put("al", formateador1.format(sumarRestarDiasFecha(f2, 0)));
                param.put("abonos", abonos+"");
                param.put("utilidad", utilidad+"");
                JasperReport jr = JasperCompileManager.compileReport("D:\\Prueba\\Reporteventas2.jrxml");
                JasperPrint jp = JasperFillManager.fillReport(jr,param,con1);
                OutputStream output = new FileOutputStream(new File("C:\\Users\\usuario\\Desktop\\prueba\\original.pdf")); 
                JasperExportManager.exportReportToPdfStream(jp, output); 
                output.flush();
                output.close();
        } 
        catch (JRException ex) 
        {
            Logger.getLogger(frmnotas.class.getName()).log(Level.SEVERE, null, ex);
        }
          catch (ParseException ex) 
          {
            Logger.getLogger(frmreporteventasgeneral.class.getName()).log(Level.SEVERE, null, ex);
          } catch (FileNotFoundException ex) { 
            Logger.getLogger(frmreporteventasgeneral.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(frmreporteventasgeneral.class.getName()).log(Level.SEVERE, null, ex);
        } 
          try 
              {
                 File path = new  File("C:\\Users\\usuario\\Desktop\\prueba\\original.pdf");
                 Desktop.getDesktop().open(path);
              }
              catch (IOException ex)
              {
                ex.printStackTrace();
              }
          
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(frmreporteventasgeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmreporteventasgeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmreporteventasgeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmreporteventasgeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmreporteventasgeneral().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static com.toedter.calendar.JDateChooser date1;
    private static com.toedter.calendar.JDateChooser date2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
