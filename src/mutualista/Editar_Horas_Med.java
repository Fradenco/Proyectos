package mutualista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class Editar_Horas_Med extends javax.swing.JFrame {
    private DefaultTableModel model;
    private boolean cambiosRealizados = false;

    public Editar_Horas_Med() {
        initComponents();
        setLocationRelativeTo(null); // Centra la ventana
        configurarTabla();
        cargarHorarios();
        
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
        DefaultTableModel model = new DefaultTableModel(datos, columnas);
        
        // Configura la tabla con el modelo
        JTable tableHorarios = new JTable(model);
        add(new JScrollPane(tableHorarios), BorderLayout.CENTER);
    }
    
    private void configurarTabla() {
        model = new DefaultTableModel(new String[][]{}, new String[]{"Horario", "Día", "Disponible"});
        jTable1.setModel(model);
        jTable1.setDefaultEditor(Object.class, null); // Desactiva edición en las celdas no booleanas
        jTable1.setDefaultEditor(Boolean.class, jTable1.getDefaultEditor(Boolean.class)); // Editor para booleanos
    }
    
    private void cargarHorarios() {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mutualista", "root", "");
             PreparedStatement stmt = con.prepareStatement(
                     "SELECT dia_semana, hora_inicio, hora_fin, disponible FROM horarios_medicos WHERE id_medico = ?")) {
            stmt.setString(1, "medico_actual"); // Cambiar por la cédula del médico logueado
            ResultSet rs = stmt.executeQuery();

            model.setRowCount(0); // Limpia la tabla
            while (rs.next()) {
                String horario = rs.getString("hora_inicio") + "-" + rs.getString("hora_fin");
                String dia = rs.getString("dia_semana");
                boolean disponible = rs.getBoolean("disponible");
                model.addRow(new Object[]{horario, dia, disponible});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los horarios.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void guardarCambios() {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mutualista", "root", "")) {
            String sql = "UPDATE horarios_medicos SET disponible = ? WHERE id_medico = ? AND dia_semana = ? AND hora_inicio = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                for (int i = 0; i < model.getRowCount(); i++) {
                    String horario = (String) model.getValueAt(i, 0);
                    String dia = (String) model.getValueAt(i, 1);
                    Boolean disponible = (Boolean) model.getValueAt(i, 2);

                    stmt.setBoolean(1, disponible);
                    stmt.setString(2, "medico_actual"); // Cambiar por la cédula del médico logueado
                    stmt.setString(3, dia);
                    stmt.setString(4, horario.split("-")[0]); // Hora de inicio
                    stmt.executeUpdate();
                }
                JOptionPane.showMessageDialog(this, "Cambios guardados exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cambiosRealizados = false; // Restablece el estado de cambios
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar los cambios.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        textoagregarcitas1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        btn_volver = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoagregarcitas1.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        textoagregarcitas1.setText("EDITAR HORARIOS");
        jPanel1.add(textoagregarcitas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 420, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/6180999.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 130));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 650, 310));

        jTextField1.setText("Buscar");
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 270, 30));

        btn_volver.setText("Volver");
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });
        jPanel1.add(btn_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 440, 120, 50));

        btn_actualizar.setText("Actualizar ");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 180, 120, 40));

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
    }// </editor-fold>//GEN-END:initComponents

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        dispose();
    }//GEN-LAST:event_btn_volverActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
         guardarCambios(); // Llama al método para guardar los cambios
    }//GEN-LAST:event_btn_actualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel textoagregarcitas1;
    // End of variables declaration//GEN-END:variables
}
