/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmPrincipal.java
 *
 * Created on 11/03/2012, 11:42:15 PM
 */
package solicitudtaller;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bala
 */
public class FrmPrincipal extends javax.swing.JFrame {
    DefaultTableModel modelo = new DefaultTableModel();
    Conexion z = new Conexion();
    int fb = 0; //filtro Bandera

    /** Creates new form FrmPrincipal */
    public FrmPrincipal() {
            initComponents();
            configGrilla();
            cargarGrilla();
            lbluser.setText(FrmAcceso.usuario);
            int nivel = z.obtenerRol(FrmAcceso.usuario);
            nivelesUsuarios(nivel);
    }
    
    
    
    private void configGrilla(){
        modelo.addColumn("Nro");
        modelo.addColumn("Responsable");
        modelo.addColumn("Fecha de Solicitud");
        modelo.addColumn("Área");
        modelo.addColumn("Estado");
    }
    
    private void cargarGrilla(){
        try {
            String sql = "select * from vsolicitud";
            if(fb == 1){
                sql = sql + " where "+cboFiltro.getSelectedItem().toString()+" like '%"+
                        txtFiltro.getText().toString()+"%'";
            }
            sql = sql+" order by fechasol desc";
                String[] datos = new String[5];
                z.snt = z.con.createStatement();
                z.rs = z.snt.executeQuery(sql);
                while(z.rs.next()){
                    datos[0] = z.rs.getString("nro");
                    datos[1] = z.rs.getString("usrsol");
                    datos[2] = z.rs.getString("rubro");
                    datos[3] = z.rs.getString("programa");
                    datos[4] = z.rs.getString("estado");
                    modelo.addRow(datos);
                }
        } catch (SQLException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lbluser = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cboFiltro = new javax.swing.JComboBox();
        txtFiltro = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        menArchivo = new javax.swing.JMenu();
        menSolicitud = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        menHerramientas = new javax.swing.JMenu();
        menGrupos = new javax.swing.JMenuItem();
        menUsuarios = new javax.swing.JMenuItem();
        menAreas = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menAcerca = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Solicitudes"));

        tabla.setModel(modelo);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setText("Usuario: ");

        lbluser.setText("jLabel2");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"));

        cboFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "descripcion", "usrsol", "rubro", "programa", "estado", "area" }));

        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(cboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        menArchivo.setText("Archivo");
        menArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menArchivoActionPerformed(evt);
            }
        });

        menSolicitud.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menSolicitud.setText("Solicitud");
        menSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menSolicitudActionPerformed(evt);
            }
        });
        menArchivo.add(menSolicitud);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menArchivo.add(jMenuItem1);

        jMenuBar1.add(menArchivo);

        menHerramientas.setText("Herramientas");

        menGrupos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menGrupos.setText("Grupos");
        menGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menGruposActionPerformed(evt);
            }
        });
        menHerramientas.add(menGrupos);

        menUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menUsuarios.setText("Usuarios");
        menUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menUsuariosActionPerformed(evt);
            }
        });
        menHerramientas.add(menUsuarios);

        menAreas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menAreas.setText("Áreas");
        menAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menAreasActionPerformed(evt);
            }
        });
        menHerramientas.add(menAreas);

        jMenuBar1.add(menHerramientas);

        jMenu2.setText("Ayuda");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        menAcerca.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        menAcerca.setText("Acerca de");
        menAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menAcercaActionPerformed(evt);
            }
        });
        jMenu2.add(menAcerca);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lbluser))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbluser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menArchivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menArchivoActionPerformed

    private void menGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menGruposActionPerformed
        new FrmRol().setVisible(true);
    }//GEN-LAST:event_menGruposActionPerformed

    private void menUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menUsuariosActionPerformed
        new FrmUsuario().setVisible(true);
    }//GEN-LAST:event_menUsuariosActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        new FrmAcerca().setVisible(true);
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void menAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menAcercaActionPerformed
        new FrmAcerca().setVisible(true);
    }//GEN-LAST:event_menAcercaActionPerformed

    private void menAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menAreasActionPerformed
        new FrmArea().setVisible(true);
    }//GEN-LAST:event_menAreasActionPerformed

    private void menSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menSolicitudActionPerformed
        FrmSolicitud sol = new FrmSolicitud();
        sol.setVisible(true);
        sol.setLocationRelativeTo(null);
    }//GEN-LAST:event_menSolicitudActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void limpiarGrilla(){
        while (modelo.getRowCount() > 0){
            modelo.removeRow(0);
        }
    }
    
    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        fb = 1;
        limpiarGrilla();
        cargarGrilla();
        
    }//GEN-LAST:event_txtFiltroKeyReleased

    
    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked

            FrmSolicitud sol = new FrmSolicitud();
            sol.setVisible(true);
        
            
    }//GEN-LAST:event_tablaMouseClicked
           
    public final void nivelesUsuarios(int nivel){
        if (nivel == 3){
            menHerramientas.setVisible(false);
        }
        
        if(nivel == 2){
            menAreas.setVisible(false);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbluser;
    private javax.swing.JMenuItem menAcerca;
    private javax.swing.JMenu menArchivo;
    private javax.swing.JMenuItem menAreas;
    private javax.swing.JMenuItem menGrupos;
    private javax.swing.JMenu menHerramientas;
    private javax.swing.JMenuItem menSolicitud;
    private javax.swing.JMenuItem menUsuarios;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}