package mutualista;

import java.awt.Color;
import javax.swing.JOptionPane;

public class Login_User extends javax.swing.JFrame {
    public Login_User() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelBase = new javax.swing.JPanel();
        iniciarsesion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panel = new javax.swing.JLabel();
        textci = new javax.swing.JLabel();
        txt_Cedula = new javax.swing.JTextField();
        textpasswd = new javax.swing.JLabel();
        btn_ingresar = new javax.swing.JButton();
        registro = new javax.swing.JButton();
        cansel = new javax.swing.JButton();
        txt_Contrasena = new javax.swing.JPasswordField();
        btn_Limpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelBase.setBackground(new java.awt.Color(255, 255, 255));
        PanelBase.setBorder(new javax.swing.border.MatteBorder(null));
        PanelBase.setPreferredSize(new java.awt.Dimension(800, 500));
        PanelBase.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iniciarsesion.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        iniciarsesion.setText("INICIAR SESIÓN");
        PanelBase.add(iniciarsesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, 380, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/cruz small.png"))); // NOI18N
        PanelBase.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 130));

        panel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/6180999.jpg"))); // NOI18N
        panel.setText("jLabel2");
        panel.setVerifyInputWhenFocusTarget(false);
        PanelBase.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 240, 500));

        textci.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        textci.setText("Cédula");
        PanelBase.add(textci, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 70, 30));

        txt_Cedula.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txt_Cedula.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txt_Cedula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_CedulaMousePressed(evt);
            }
        });
        txt_Cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CedulaActionPerformed(evt);
            }
        });
        PanelBase.add(txt_Cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 300, 30));

        textpasswd.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        textpasswd.setText("Contraseña");
        PanelBase.add(textpasswd, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 100, 30));

        btn_ingresar.setText("Ingresar");
        btn_ingresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
            }
        });
        PanelBase.add(btn_ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 90, -1));

        registro.setText("Registrarse");
        registro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroActionPerformed(evt);
            }
        });
        PanelBase.add(registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 460, -1, -1));

        cansel.setText("Cancelar");
        cansel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cansel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canselActionPerformed(evt);
            }
        });
        PanelBase.add(cansel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));

        txt_Contrasena.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        txt_Contrasena.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_ContrasenaMousePressed(evt);
            }
        });
        txt_Contrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ContrasenaActionPerformed(evt);
            }
        });
        PanelBase.add(txt_Contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 300, 30));

        btn_Limpiar.setText("Limpiar");
        btn_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LimpiarActionPerformed(evt);
            }
        });
        PanelBase.add(btn_Limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 380, 90, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBase, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void canselActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canselActionPerformed
        dispose();
    }//GEN-LAST:event_canselActionPerformed

    private void txt_CedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CedulaActionPerformed

    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
        String cedula = txt_Cedula.getText();
    String contrasena = txt_Contrasena.getText();

    Conexion c = new Conexion();
    String tipoUsuario = c.iniciarSesion(cedula, contrasena);

    switch (tipoUsuario) {
        case "paciente":
            new Citas().setVisible(true); // Abre la interfaz para pacientes
            this.dispose(); // Cierra la ventana de login actual
            break;
            
        case "medico":
            new Horas_Medicos().setVisible(true); // Abre la interfaz para médicos
            this.dispose();
            break;
            
        case "administrativo":
            new Gestionar_Medicos().setVisible(true); // Abre la interfaz para administrativos
            this.dispose();
            break;
            
        default:
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas, usuario no encontrado.");
            break;
    }
        
    }//GEN-LAST:event_btn_ingresarActionPerformed

    private void registroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroActionPerformed
        dispose();
        UserRegister p = new UserRegister();
        p.setVisible(true);
        p.setLocationRelativeTo(null);
    }//GEN-LAST:event_registroActionPerformed

    private void txt_CedulaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_CedulaMousePressed
        if (txt_Cedula.getText().equals("Ingrese su cedula")){
            txt_Cedula.setText("");
        }
        if (String.valueOf(txt_Contrasena.getPassword()).isEmpty()){
            txt_Contrasena.setText("********");
        }
    }//GEN-LAST:event_txt_CedulaMousePressed

    private void txt_ContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ContrasenaActionPerformed

    private void txt_ContrasenaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_ContrasenaMousePressed
        if (String.valueOf(txt_Contrasena.getPassword()).equals("********")){
            txt_Contrasena.setText("");
        }
        if (txt_Cedula.getText().isEmpty()){
            txt_Cedula.setText("Ingrese su cedula");
        }       
    }//GEN-LAST:event_txt_ContrasenaMousePressed

    private void btn_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimpiarActionPerformed
        
        txt_Cedula.setText("");
        txt_Contrasena.setText("");
 
    }//GEN-LAST:event_btn_LimpiarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBase;
    private javax.swing.JButton btn_Limpiar;
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JButton cansel;
    private javax.swing.JLabel iniciarsesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel panel;
    private javax.swing.JButton registro;
    private javax.swing.JLabel textci;
    private javax.swing.JLabel textpasswd;
    private javax.swing.JTextField txt_Cedula;
    private javax.swing.JPasswordField txt_Contrasena;
    // End of variables declaration//GEN-END:variables

}
