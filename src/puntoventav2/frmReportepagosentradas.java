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
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
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
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
public class frmReportepagosentradas extends javax.swing.JFrame {

    /**
     * Creates new form frmReportepagosentradas
     */
     private static Connection con = null;
    static ResultSet rs = null;
    private java.sql.Statement stmt = null;
    conectar conexion = new conectar();
    static String fecha1;
    static String fecha2;
    Date  fecha;
    Date fechados;
    public frmReportepagosentradas() 
    {
        initComponents();
        salir();
      
    }
    
    public static void fecha()
     {
        try 
            {
            //jDateChooser el nombre la variable  del componente jdatecgooser
                Date  fecha=date1.getDate();
                Date fechados=date2.getDate();
                DateFormat f=new SimpleDateFormat("yyyy-MM-dd");
                fecha1=f.format(fecha);
                fecha2=f.format(fechados);
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
        date1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        date2 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporte  Pagos de Compras");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(date1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(date2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel1))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)))
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addGap(47, 47, 47))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addGap(3, 3, 3)
                .addComponent(date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Date  fecha=date1.getDate();
        Date fechados=date2.getDate();

        if(fechados.before(fecha))
        {
            JOptionPane.showMessageDialog(null, "Las Fechas no coinciden", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String f = date1.getDateFormatString();
        System.out.println(f);
        double total=0,abonos=0;
        fecha();
        Calendar calendario =Calendar.getInstance();
        int dia1 =calendario.get(calendario.DATE);
        int mes1 = calendario.get(calendario.MONTH)+1;
        int ano1 = calendario.get(calendario.YEAR);
        String myDate = dia1+"/"+mes1+"/"+ano1;
        double utilidad=0,saldo=0;
        System.out.println(myDate);
        System.out.println(fechados+"  "+fecha);
        try
        {
            con = conexion.getConnection();
            stmt = con.createStatement();
            rs=stmt.executeQuery(" SELECT SUM(PentCanditad) as total FROM  tblpagosentradas "
                + "where   PentFecha>= '"+fecha1+"' and   PentFecha <='"+fecha2+"'");
            while(rs.next())
            {
                total=rs.getDouble(1);
            }
            System.out.println(total);
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }

        try
        {
            SimpleDateFormat formateador1 = new SimpleDateFormat("dd/MM/yy");
            
            SimpleDateFormat formateador = new SimpleDateFormat("yyyy-mm-dd");
            Date f1 = formateador.parse(fecha1);
            Date f2 = formateador.parse(fecha2);
            
            SimpleDateFormat form = new SimpleDateFormat("MMMM d yyyy");
            Date fech = new Date();
            String fa = form.format(fech);
            String diapago,mespago,aniopago,fechapago;
            
            
            HashMap param = new HashMap();
            Connection con = conexion.getConnection();
            JasperDesign jd = JRXmlLoader.load(new File("D:\\Prueba").getAbsolutePath()+"\\reportepagocompras.jrxml");
            param.put("fecha1", formateador.format(sumarRestarDiasFecha(f1, 0)));
            param.put("fecha2", formateador.format(sumarRestarDiasFecha(f2, 0)));
            param.put("total",total+"");
            param.put("del", formateador1.format(sumarRestarDiasFecha(f1, 0)));
            param.put("al", formateador1.format(sumarRestarDiasFecha(f2, 0)));
             con = conexion.getConnection();
            stmt = con.createStatement();
            rs=stmt.executeQuery(" SELECT PentFecha FROM  tblpagosentradas "
                + "where   PentFecha>= '"+fecha1+"' and   PentFecha <='"+fecha2+"'");
            while(rs.next())
            {   
               
                diapago=rs.getString(1).substring(8,10);
                mespago=rs.getString(1).substring(5,7);
                aniopago=rs.getString(1).substring(0,4);
                fechapago=diapago+"/"+mespago+"/"+aniopago;
                param.put("fechapago",fechapago);
            }
            //            param.put("Saldo", saldo+"");
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr,param,con);
            OutputStream output = new FileOutputStream(new File("C:\\Users\\usuario\\Desktop\\prueba\\"
                    + ""+"Reporte Pagos Compras"+" "+fa+""+".pdf"));
            JasperExportManager.exportReportToPdfStream(jp, output);
            output.flush();
            output.close();
            File path = new  File("C:\\Users\\usuario\\Desktop\\prueba\\"
                    + ""+"Reporte Pagos Compras"+" "+fa+""+".pdf");
            Desktop.getDesktop().open(path);
        }
        catch (JRException | IOException ex)
        {
            Logger.getLogger(frmnotas.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (ParseException ex)
        {
            Logger.getLogger(frmreporteventasgeneral.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
             Logger.getLogger(frmReportepagosentradas.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(frmReportepagosentradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmReportepagosentradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmReportepagosentradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmReportepagosentradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmReportepagosentradas().setVisible(true);
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
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
