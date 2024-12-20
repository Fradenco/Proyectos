package mutualista;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;

public class UserRegister extends javax.swing.JFrame {

    public UserRegister() {
        initComponents();
    }
    
    private void registrarPaciente(String cedula, String nombreyapellido, String telefono, String contrasena) {
    Conexion c = new Conexion();
    c.conectar();

    // Paso 1: Registrar en la tabla usuarios
    c.insertarUsuario(cedula, nombreyapellido, telefono, contrasena, "paciente");

    // Paso 2: Registrar en la tabla paciente
    c.insertarPaciente(cedula);

    JOptionPane.showMessageDialog(this, "Paciente registrado correctamente.");
}

private void registrarMedico(String cedula, String nombreyapellido, String telefono, String contrasena, String especialidad) {
    Conexion c = new Conexion();
    c.conectar();

    // Paso 1: Registrar en la tabla usuarios
    c.insertarUsuario(cedula, nombreyapellido, telefono, contrasena, "medico");

    // Paso 2: Registrar en la tabla medico
    c.insertarMedico(cedula, especialidad);

    JOptionPane.showMessageDialog(this, "Médico registrado correctamente.");
}

private void registrarAdministrativo(String cedula, String nombreyapellido, String telefono, String contrasena) {
    Conexion c = new Conexion();
    c.conectar();

    // Paso 1: Registrar en la tabla usuarios
    c.insertarUsuario(cedula, nombreyapellido, telefono, contrasena, "administrativo");

    // Paso 2: Registrar en la tabla administrativo
    c.insertarAdministrativo(cedula);

    JOptionPane.showMessageDialog(this, "Administrativo registrado correctamente.");
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
        jLabel6 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Registrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_regis_usu = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        x_contrasena = new javax.swing.JLabel();
        txt_contrasena = new javax.swing.JTextField();
        txt_concontrasena = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelBase.setBackground(new java.awt.Color(255, 255, 255));
        PanelBase.setBorder(new javax.swing.border.MatteBorder(null));
        PanelBase.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        registro.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        registro.setText("REGISTRO");
        PanelBase.add(registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 260, 40));

        panel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/61802.jpg"))); // NOI18N
        panel.setText("jLabel10");
        PanelBase.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 240, 500));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel2.setText("Nombre y apellido");
        PanelBase.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 130, 30));

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
        PanelBase.add(txt_nombreyapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 240, 30));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel6.setText("Telefonos/Celular");
        PanelBase.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 130, 30));

        txt_telefono.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelBase.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 240, 30));

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel7.setText("Cédula");
        PanelBase.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 130, 30));

        txt_cedula.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        PanelBase.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 240, 30));

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel8.setText("Contraseña");
        PanelBase.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 130, 30));

        Registrar.setText("Registrar");
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });
        PanelBase.add(Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 570, -1, -1));
        PanelBase.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btn_regis_usu.setText("Registrarse como usuario");
        btn_regis_usu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_regis_usu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regis_usuActionPerformed(evt);
            }
        });
        PanelBase.add(btn_regis_usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 210, -1));

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
        PanelBase.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 130, 30));
        PanelBase.add(x_contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 240, -1));

        txt_contrasena.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txt_contrasena.setCaretColor(new java.awt.Color(204, 204, 204));
        txt_contrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contrasenaActionPerformed(evt);
            }
        });
        PanelBase.add(txt_contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 240, 30));

        txt_concontrasena.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txt_concontrasena.setCaretColor(new java.awt.Color(204, 204, 204));
        PanelBase.add(txt_concontrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 240, 30));

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

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
      // TODO add your handling code here:
    }//GEN-LAST:event_RegistrarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        dispose();
        Login_User login = new Login_User();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }//GEN-LAST:event_cancelarActionPerformed

    private void txt_nombreyapellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreyapellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreyapellidoActionPerformed

    private void txt_nombreyapellidoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nombreyapellidoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreyapellidoMousePressed

    private void btn_regis_usuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regis_usuActionPerformed
        
        String cedula = txt_cedula.getText();
    String nombreyapellido = txt_nombreyapellido.getText();
    String telefono = txt_telefono.getText();
    String contrasena = txt_contrasena.getText();
    String confirmarContrasena = txt_concontrasena.getText();

    // Validar que las contraseñas coincidan
    if (!contrasena.equals(confirmarContrasena)) {
        JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.");
        return;
    }

    // Validar que todos los campos obligatorios estén llenos
    if (cedula.isEmpty() || nombreyapellido.isEmpty() || telefono.isEmpty() || contrasena.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Debe completar todos los campos.");
        return;
    }

    // Solicitar el rol
    String[] roles = {"paciente", "medico", "administrativo"};
    String rol = (String) JOptionPane.showInputDialog(this, "Seleccione el rol del usuario:", 
                                                      "Seleccionar Rol", JOptionPane.QUESTION_MESSAGE, 
                                                      null, roles, roles[0]);

    if (rol == null) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar un rol para continuar.");
        return;
    }

    // Si es médico, solicitar la especialidad
    String especialidad = null;
    if (rol.equals("medico")) {
        especialidad = JOptionPane.showInputDialog(this, "Ingrese la especialidad del médico:", 
                                                   "Especialidad", JOptionPane.QUESTION_MESSAGE);

        if (especialidad == null || especialidad.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una especialidad para continuar.");
            return;
        }
    }

    // Registrar al usuario
    Conexion c = new Conexion();
    c.registrarUsuario(cedula, nombreyapellido, telefono, contrasena, rol, especialidad);

    JOptionPane.showMessageDialog(this, rol.substring(0, 1).toUpperCase() + rol.substring(1) + 
                                   " registrado correctamente.");
    Login_User login = new Login_User();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        this.dispose(); // Cerrar la ventana actual después del registro
    }//GEN-LAST:event_btn_regis_usuActionPerformed

    private void txt_contrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contrasenaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBase;
    private javax.swing.JButton Registrar;
    private javax.swing.JButton btn_regis_usu;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel panel;
    private javax.swing.JLabel registro;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_concontrasena;
    private javax.swing.JTextField txt_contrasena;
    private javax.swing.JTextField txt_nombreyapellido;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JLabel x_contrasena;
    // End of variables declaration//GEN-END:variables
}
