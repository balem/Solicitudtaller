package solicitudtaller;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmBuca.java
 *
 * Created on 01/04/2012, 10:20:57 PM
 */



import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author utic
 */
public class FrmBucarBien extends javax.swing.JDialog {
    DefaultTableModel m = new DefaultTableModel();
    Conexion conn =new Conexion();//instanciamos
    private int posreg;
    private int bande = 0;

    public static String vcod  = "";
    public static String vdes  = "";

    /** Creates new form FrmBuca */
    public FrmBucarBien(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        confiGrilla();
        cargarGrilla();
        this.setLocationRelativeTo(null);//centra
        m = (javax.swing.table.DefaultTableModel)t.getModel();
        cargarGrilla();//lama al metodo para llenar la grilla
        txtNombre.requestFocus();
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        t = new javax.swing.JTable();
        txtCodigo = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();

        jLabel1.setText("Nombre");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });

        t.setModel(m);
        t.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tMouseClicked(evt);
            }
        });
        t.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(t);

        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(53, 53, 53)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(txtDescripcion)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMouseClicked
         eligio();
    }//GEN-LAST:event_tMouseClicked

    private void tKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tKeyPressed
        //presiono escape

        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            vcod = txtCodigo.getText();
            vdes = txtDescripcion.getText();
            dispose();
        }
      if (evt.getKeyCode()== KeyEvent.VK_ENTER)
            eligio();
    }//GEN-LAST:event_tKeyPressed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        filtrarGrilla();// TODO add your handling code here:
          if (t.getRowCount()>0) porteclado(evt);
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtDescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyPressed
         vcod = txtCodigo.getText();
        vdes = txtDescripcion.getText();
         dispose();
    }//GEN-LAST:event_txtDescripcionKeyPressed
    

                                 

    private void tKeyReleased(java.awt.event.KeyEvent evt) {                              
       posreg = t.getSelectedRow();
       txtCodigo.setText(String.valueOf(this.t.getValueAt(posreg,0)));
       txtDescripcion.setText(String.valueOf(this.t.getValueAt(posreg,1)));
    }                             

    private void porteclado(KeyEvent evt){
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
              t.requestFocus();
              txtCodigo.setText(String.valueOf(this.t.getValueAt(posreg,0)));
              txtDescripcion.setText(String.valueOf(this.t.getValueAt(posreg,1)));       
              t.changeSelection(0,0 , false, false);
            }
    }

       private void  filtrarGrilla()
       {
        m.setRowCount(0);//evita duplicacion de datos
        try
        {
            conn.snt = conn.con.createStatement();
            conn.rs = conn.snt.executeQuery("SELECT id, descripcion FROM articulo where descripcion like '%"+txtNombre.getText()+"%'");
           
           while(conn.rs.next())
            {
               m.addRow(new Object[]{conn.rs.getInt("id"), 
                          conn.rs.getString("descripcion")});
                   
            }
        }
        catch (SQLException ex)
        {
              JOptionPane.showMessageDialog(null, "Error de Sintaxis" , "Verifique",
              JOptionPane.INFORMATION_MESSAGE);
              dispose();
        }
    }

    private void cargarGrilla(){
         m.setRowCount(0);//evita duplicacion de datos
        try
        {
            conn.snt = conn.con.createStatement();
            conn.rs =conn.snt.executeQuery("SELECT id, descripcion FROM articulo ");
            while(conn.rs.next()){
                      m.addRow(new Object[]{conn.rs.getInt("id"),conn.rs.getString("descripcion")});
            }
            
         }
         catch (SQLException ex)
         {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos" , "Verifique",
            JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
    }//fin carga de grilla
    
    private void confiGrilla(){
        m.addColumn("id");
        m.addColumn("Descripción");
    }

     public void eligio()
     {
         posreg = t.getSelectedRow();
          if (bande == 0)
          {
                    txtCodigo.setText(String.valueOf(this.t.getValueAt(posreg,0)));
                    txtDescripcion.setText(String.valueOf(this.t.getValueAt(posreg,1)));
                    vcod = txtCodigo.getText();
                    vdes = txtDescripcion.getText();
                    dispose();
           } 
     }
     
     /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmBucarBien dialog = new FrmBucarBien(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

}
