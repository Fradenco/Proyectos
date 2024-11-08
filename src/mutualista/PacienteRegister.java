package mutualista;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class PacienteRegister extends javax.swing.JFrame {

    public PacienteRegister() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        PanelBase = new javax.swing.JPanel();
        registro = new javax.swing.JLabel();
        panel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_nombreyapellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_fechadenacimiento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        Registrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        x_contrasena = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        txt_contrasena = new javax.swing.JTextField();
        txt_concontrasena = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelBase.setBackground(new java.awt.Color(255, 255, 255));
        PanelBase.setBorder(new javax.swing.border.MatteBorder(null));
        PanelBase.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        registro.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        registro.setText("REGISTRO");
        PanelBase.add(registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 260, 40));

        panel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/61802.jpg"))); // NOI18N
        panel.setText("jLabel10");
        PanelBase.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 240, 500));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel2.setText("Nombre y apellido");
        PanelBase.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 130, 30));

        txt_nombreyapellido.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txt_nombreyapellido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_nombreyapellidoMousePressed(evt);
            }
        });
        txt_nombreyapellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreyapellidoActionPerformed(evt);
            }
        });
        PanelBase.add(txt_nombreyapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 240, 30));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel4.setText("Fecha de nacimiento");
        PanelBase.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 130, 30));

        txt_fechadenacimiento.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelBase.add(txt_fechadenacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 240, 30));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel6.setText("Telefonos/Celular");
        PanelBase.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 130, 30));

        txt_telefono.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelBase.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 240, 30));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel7.setText("Cédula");
        PanelBase.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 130, 30));

        txt_cedula.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelBase.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 240, 30));

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel8.setText("Contraseña");
        PanelBase.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 130, 30));

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel9.setText("Correo");
        PanelBase.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 130, 30));

        txt_correo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txt_correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_correoActionPerformed(evt);
            }
        });
        PanelBase.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 240, 30));

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        PanelBase.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 620, -1, -1));

        Registrar.setText("Registrar");
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });
        PanelBase.add(Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 570, -1, -1));
        PanelBase.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        aceptar.setText("Registrar");
        aceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        PanelBase.add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 460, 90, -1));

        cancelar.setText("Cancelar");
        cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        PanelBase.add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));

        jLabel10.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel10.setText("Confirmar contraseña");
        PanelBase.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 130, 30));

        x_contrasena.setText("Las contraseñas no coinciden");
        PanelBase.add(x_contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 240, -1));

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Paciente");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        PanelBase.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, 90, -1));

        txt_contrasena.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txt_contrasena.setCaretColor(new java.awt.Color(204, 204, 204));
        txt_contrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contrasenaActionPerformed(evt);
            }
        });
        PanelBase.add(txt_contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 342, 240, 30));

        txt_concontrasena.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txt_concontrasena.setCaretColor(new java.awt.Color(204, 204, 204));
        PanelBase.add(txt_concontrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 240, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBase, javax.swing.GroupLayout.PREFERRED_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_RegistrarActionPerformed

    private void txt_correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_correoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_correoActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void txt_nombreyapellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreyapellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreyapellidoActionPerformed

    private void txt_nombreyapellidoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nombreyapellidoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreyapellidoMousePressed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        // TODO add your handling code here:
        String nombreyapellido = txt_nombreyapellido.getText();
        String fechadenacimiento = txt_fechadenacimiento.getText();
        String telefono = txt_telefono.getText();
        String cedula = txt_cedula.getText();
        String correo = txt_correo.getText();
        String contrasena = txt_contrasena.getText();
        
        Paciente P = new Paciente(nombreyapellido, fechadenacimiento, telefono, cedula, correo, contrasena);
        
        Conexion c = new Conexion();
        c.conectar();
        c.insertar(P);
        
        
    }//GEN-LAST:event_aceptarActionPerformed

    private void txt_contrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contrasenaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBase;
    private javax.swing.JButton Registrar;
    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel panel;
    private javax.swing.JLabel registro;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_concontrasena;
    private javax.swing.JTextField txt_contrasena;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_fechadenacimiento;
    private javax.swing.JTextField txt_nombreyapellido;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JLabel x_contrasena;
    // End of variables declaration//GEN-END:variables
}
