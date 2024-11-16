package mutualista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;

public class Gestionar_Medicos extends javax.swing.JFrame {
    
    public Gestionar_Medicos() {
        initComponents();
        
        setTitle("Gestionar Horarios de Médicos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configura el modelo de la tabla
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Día");
        model.addColumn("Hora");
        model.addColumn("Disponible");

        // Llama al método para cargar los horarios
        cargarHorarios(model);

        // Configura la tabla con el modelo
        tableHorarios = new JTable(model);
        add(new JScrollPane(tableHorarios));
    }

    // Método para cargar los horarios de la base de datos
    private void cargarHorarios(DefaultTableModel model) {
        Conexion conexion = new Conexion();
        conexion.conectar();

        String sql = "SELECT dia, hora, disponible FROM horarios_medicos WHERE cedula_medico = ?";
        
        try (PreparedStatement stmt = conexion.getConexion().prepareStatement(sql)) {
            // Suponiendo que tienes la cédula del médico que está gestionando los horarios
            stmt.setString(1, "1234567890"); // Aquí debes poner la cédula del médico en sesión
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String dia = rs.getString("dia");
                String hora = rs.getTime("hora").toString();
                boolean disponible = rs.getBoolean("disponible");
                model.addRow(new Object[]{dia, hora, disponible ? "Disponible" : "Ocupado"});
            }

        } catch (SQLException ex) {
            System.out.println("Error al cargar horarios: " + ex.getMessage());
        }
    }

    public void iniciarResetSemanal() {
        Timer timer = new Timer();
        Calendar calendario = Calendar.getInstance();

        // Configura el primer reinicio para el próximo sábado a medianoche
        calendario.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        calendario.set(Calendar.HOUR_OF_DAY, 0);
        calendario.set(Calendar.MINUTE, 0);
        calendario.set(Calendar.SECOND, 0);

        // Programa la tarea para repetirse cada semana
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                resetearHorarios();
            }
        }, calendario.getTime(), 7 * 24 * 60 * 60 * 1000); // Repetir cada 7 días
    }

    private void resetearHorarios() {
        Conexion conexion = new Conexion();
        conexion.conectar();
        
        String sql = "UPDATE horarios_medicos SET disponible = TRUE";

        try (PreparedStatement stmt = conexion.getConexion().prepareStatement(sql)) {
            stmt.executeUpdate();
            System.out.println("Horarios restablecidos correctamente.");
        } catch (SQLException ex) {
            System.out.println("Error al restablecer horarios: " + ex.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        textoagregarcitas = new javax.swing.JLabel();
        panel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabagendacitas = new javax.swing.JTable();
        txt_buscar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        textoagregarcitas1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHorarios = new javax.swing.JTable();
        bt_edit = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        btn_admin_usu = new javax.swing.JButton();
        buscar = new javax.swing.JTextField();

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jFrame1.setMinimumSize(new java.awt.Dimension(800, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoagregarcitas.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        textoagregarcitas.setText("AGREGAR CITA");
        jPanel1.add(textoagregarcitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 340, 40));

        panel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/61802.jpg"))); // NOI18N
        panel.setText("jLabel1");
        jPanel1.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 130));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("+");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 450, -1, -1));

        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));

        tabagendacitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Especialidad", "Disponibilidad"
            }
        ));
        tabagendacitas.setToolTipText("");
        jScrollPane2.setViewportView(tabagendacitas);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 780, 260));
        jPanel1.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 290, 30));

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setSize(new java.awt.Dimension(800, 500));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(800, 500));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoagregarcitas1.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        textoagregarcitas1.setText("SISTEMA ADMINISTRADOR");
        jPanel2.add(textoagregarcitas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 610, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/61802.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 130));

        tableHorarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableHorarios);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 650, 310));

        bt_edit.setText("Editar Hs");
        bt_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editActionPerformed(evt);
            }
        });
        jPanel2.add(bt_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 180, 120, 30));

        btn_actualizar.setText("Actualizar tabla");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 220, 120, 30));

        btn_salir.setText("Salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        jPanel2.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 440, 120, 50));

        btn_admin_usu.setText("Admin usuarios");
        btn_admin_usu.setActionCommand("Administrar usuarios");
        btn_admin_usu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_admin_usuActionPerformed(evt);
            }
        });
        jPanel2.add(btn_admin_usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 320, 120, 40));

        buscar.setText("Buscar");
        jPanel2.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 270, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // DESABILITADO
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        dispose();
    }//GEN-LAST:event_btn_salirActionPerformed

    private void bt_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_editActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btn_admin_usuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_admin_usuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_admin_usuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_edit;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_admin_usu;
    private javax.swing.JButton btn_salir;
    private javax.swing.JTextField buscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel panel;
    private javax.swing.JTable tabagendacitas;
    private javax.swing.JTable tableHorarios;
    private javax.swing.JLabel textoagregarcitas;
    private javax.swing.JLabel textoagregarcitas1;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
