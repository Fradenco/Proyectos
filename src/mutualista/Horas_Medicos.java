package mutualista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class Horas_Medicos extends javax.swing.JFrame {
    private DefaultTableModel model;

    public Horas_Medicos() {
        initComponents();
         // Configura el layout
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    JScrollPane scrollPane = new JScrollPane(tableHorarios);
    add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 650, 300));
        
        // Crear columnas para los días de la semana
        String[] columnas = {"Horario", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
        
        // Crear horarios (filas)
        String[][] datos = {
            {"9:00-9:45", "", "", "", "", ""},
            {"10:00-10:45", "", "", "", "", ""},
            {"11:00-11:45", "", "", "", "", ""},
            {"12:00-12:45", "", "", "", "", ""},
            {"13:00-13:45", "", "", "", "", ""},
            {"14:00-14:45", "", "", "", "", ""},
            {"15:00-15:45", "", "", "", "", ""},
            {"16:00-16:45", "", "", "", "", ""},
            {"17:00-17:45", "", "", "", "", ""}
        };
        
        // Configura el modelo de la tabla
        model = new DefaultTableModel(datos, columnas);
        
        // Configurar la tabla con el modelo
        tableHorarios = new JTable(model);
        add(new JScrollPane(tableHorarios), BorderLayout.CENTER);

        // Llama al método para cargar los horarios
        cargarHorariosMedico();
    }
    
    private void cargarHorariosMedico() {
        if (model == null) {
        System.out.println("El modelo no está inicializado.");
        return;
    }

    model.setRowCount(0); // Limpia la tabla

    String cedulaMedico = UsuarioSesion.getCedula(); // Asegúrate de que esta variable esté inicializada
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mutualista", "root", "");
         PreparedStatement stmt = con.prepareStatement(
                 "SELECT dia_semana, hora_inicio, hora_fin, disponible FROM horarios_medicos WHERE id_medico = ?")) {
        stmt.setString(1, cedulaMedico);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String dia = rs.getString("dia_semana");
            String horario = rs.getString("hora_inicio") + "-" + rs.getString("hora_fin");
            boolean disponible = rs.getBoolean("disponible");

            // Actualiza las filas y columnas según el día
            for (int i = 0; i < model.getRowCount(); i++) {
                if (model.getValueAt(i, 0).equals(horario)) {
                    int col = switch (dia) {
                        case "lunes" -> 1;
                        case "martes" -> 2;
                        case "miércoles" -> 3;
                        case "jueves" -> 4;
                        case "viernes" -> 5;
                        default -> -1;
                    };
                    if (col > 0) {
                        model.setValueAt(disponible ? "Disponible" : "Reservado", i, col);
                    }
                }
            }
        }
    } catch (SQLException e) {
        System.out.println("Error al cargar horarios: " + e.getMessage());
    }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textoagregarcitas1 = new javax.swing.JLabel();
        panel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHorarios = new javax.swing.JTable();
        btn_actualizar = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        buscar = new javax.swing.JTextField();
        bt_edit = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoagregarcitas1.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        textoagregarcitas1.setText("ADMINISTRADOR DE HORAS");
        add(textoagregarcitas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 630, 40));

        panel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/61802.jpg"))); // NOI18N
        panel.setText("jLabel1");
        add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 128));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 650, 310));

        btn_actualizar.setText("Actualizar");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });
        add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 180, 120, 40));

        btn_salir.setText("Salir");
        add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, 120, 40));

        buscar.setText("Buscar");
        add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 270, 30));

        bt_edit.setText("Editar Hs");
        bt_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_editActionPerformed(evt);
            }
        });
        add(bt_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, 120, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void bt_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_editActionPerformed
        Editar_Horas_Admin editar = new Editar_Horas_Admin();
        editar.setVisible(true);
        editar.setLocationRelativeTo(null);
    }//GEN-LAST:event_bt_editActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        cargarHorariosMedico(); // Vuelve a cargar la información de la base de datos
    }//GEN-LAST:event_btn_actualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_edit;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JTextField buscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel panel;
    private javax.swing.JTable tableHorarios;
    private javax.swing.JLabel textoagregarcitas1;
    // End of variables declaration//GEN-END:variables

}