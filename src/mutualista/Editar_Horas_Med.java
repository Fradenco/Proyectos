package mutualista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Editar_Horas_Med extends javax.swing.JFrame {
    private DefaultTableModel model;
    private boolean cambiosRealizados = false;

    public Editar_Horas_Med() {
        initComponents();
        
         // Configura el layout
        Object[][] datos = {
            {"9:00", "9:45", "Disponible", "Disponible", "Disponible", "Disponible", "Disponible"},
            {"10:00", "10:45", "Disponible", "Disponible", "Disponible", "Disponible", "Disponible"},
            {"11:00", "11:45", "Disponible", "Disponible", "Disponible", "Disponible", "Disponible"},
            {"12:00", "12:45", "Disponible", "Disponible", "Disponible", "Disponible", "Disponible"},
            {"13:00", "13:45", "Disponible", "Disponible", "Disponible", "Disponible", "Disponible"},
            {"14:00", "14:45", "Disponible", "Disponible", "Disponible", "Disponible", "Disponible"},
            {"15:00", "15:45", "Disponible", "Disponible", "Disponible", "Disponible", "Disponible"},
            {"16:00", "16:45", "Disponible", "Disponible", "Disponible", "Disponible", "Disponible"},
            {"17:00", "17:45", "Disponible", "Disponible", "Disponible", "Disponible", "Disponible"}
        };

        // Nombres de las columnas (horas y días de la semana)
        String[] columnas = {"Inicio", "Fin", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};

        // Configuración del modelo de tabla
        model = new DefaultTableModel(datos, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Permitir editar solo las columnas de días de la semana
                return column > 0; 
            }
        };

        // Asignar el modelo a la tabla
        tableHorarios.setModel(model);

        // Configurar las columnas para que usen un JComboBox como editor
        for (int i = 1; i < tableHorarios.getColumnCount(); i++) {
            configurarColumnaConComboBox(tableHorarios, tableHorarios.getColumnModel().getColumn(i));
        }
    }
    
    private void configurarColumnaConComboBox(JTable tableHorarios, javax.swing.table.TableColumn columna) {
    // Crear un JComboBox con las opciones
    JComboBox<String> comboBox = new JComboBox<>();
    comboBox.addItem("Disponible");
    comboBox.addItem("Ocupado");
    comboBox.addItem("Reservado");

    // Asignar el JComboBox como editor de celda
    columna.setCellEditor(new DefaultCellEditor(comboBox));

    // Opcional: Configurar el renderizador para mostrar el JComboBox al pasar el mouse
    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
    renderer.setToolTipText("Click para cambiar el estado");
    columna.setCellRenderer(renderer);
}

    
    private void configurarTabla() {
        model = new DefaultTableModel(new String[][]{}, new String[]{"Horario", "Día", "Disponible"});
        tableHorarios.setModel(model);
        tableHorarios.setDefaultEditor(Object.class, null); // Desactiva edición en las celdas no booleanas
        tableHorarios.setDefaultEditor(Boolean.class, tableHorarios.getDefaultEditor(Boolean.class)); // Editor para booleanos
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
        con.setAutoCommit(false); // Desactiva el autocommit

        String sql = "UPDATE horarios_medicos SET disponible = ? WHERE dia_semana = ? AND hora_inicio = ? AND hora_fin = ? AND id_medico = ?";
        PreparedStatement stmt = con.prepareStatement(sql);

        for (int i = 0; i < model.getRowCount(); i++) {
            String horario = (String) model.getValueAt(i, 0); // Columna de horario
            for (int j = 1; j < model.getColumnCount(); j++) { // Columnas de días de la semana
                Object value = model.getValueAt(i, j);
                boolean disponible;

                if (value instanceof Boolean) {
                    disponible = (Boolean) value;
                } else if (value instanceof String) {
                    disponible = value.equals("Disponible");
                } else {
                    disponible = false; // Valor por defecto
                }

                stmt.setString(1, disponible ? "Disponible" : "Ocupado");
                stmt.setString(2, model.getColumnName(j).toLowerCase()); // Día de la semana
                stmt.setString(3, horario.split("-")[0].trim()); // Hora de inicio
                stmt.setString(4, horario.split("-")[1].trim()); // Hora de fin
                stmt.setString(4, UsuarioSesion.getIdMedico()); // ID del médico

                // Depuración
                System.out.println("Guardando: disponible = " + disponible + 
                                   ", dia_semana = " + model.getColumnName(j).toLowerCase() + 
                                   ", hora_inicio = " + horario.split("-")[0] + 
                                   ", hora_fin = " + horario.split("-")[1] + 
                                   ", id_medico = " + UsuarioSesion.getIdMedico());

                stmt.executeUpdate();
            }
        }

        con.commit(); // Confirma la transacción
        JOptionPane.showMessageDialog(this, "Cambios guardados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al guardar los cambios: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        textoagregarcitas1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHorarios = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        btn_salir = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoagregarcitas1.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        textoagregarcitas1.setText("EDITAR HORARIOS");
        jPanel1.add(textoagregarcitas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 420, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/6180999.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 130));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 650, 310));

        jTextField1.setText("Buscar");
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 270, 30));

        btn_salir.setText("Salir");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        jPanel1.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 440, 120, 50));

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

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        dispose();
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
         guardarCambios(); // Llama al método para guardar los cambios
    }//GEN-LAST:event_btn_actualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tableHorarios;
    private javax.swing.JLabel textoagregarcitas1;
    // End of variables declaration//GEN-END:variables
}
