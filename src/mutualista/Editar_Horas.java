package mutualista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class Editar_Horas extends javax.swing.JFrame {
    
    private JTable tableHorarios;
    private DefaultTableModel model;

    public Editar_Horas() {
        initComponents();

        setTitle("Editar Horarios de Médicos");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Configura el modelo de la tabla
        model = new DefaultTableModel();
        model.addColumn("Día");
        model.addColumn("Hora");
        model.addColumn("Médico");
        model.addColumn("Estado");

        // Llama al método para cargar los horarios
        cargarHorarios();

        // Configura la tabla con el modelo
        tableHorarios = new JTable(model) {
            // Sobrescribe para permitir un JComboBox en la columna de Médico
            @Override
            public Class<?> getColumnClass(int column) {
                return column == 2 ? JComboBox.class : String.class;
            }
        };

        // Añade la tabla a un scroll pane
        add(new JScrollPane(tableHorarios), BorderLayout.CENTER);

        // Botón para guardar los cambios
        JButton btnGuardarCambios = new JButton("Guardar Cambios");
        btnGuardarCambios.addActionListener(e -> guardarCambios());
        add(btnGuardarCambios, BorderLayout.SOUTH);
    }

    // Método para cargar los horarios de la base de datos
    private void cargarHorarios() {
        Conexion conexion = new Conexion();
        conexion.conectar();

        String sql = "SELECT dia, hora, cedula_medico, disponible FROM horarios_medicos";
        
        try (PreparedStatement stmt = conexion.getConexion().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String dia = rs.getString("dia");
                String hora = rs.getTime("hora").toString();
                String medico = rs.getString("cedula_medico");
                boolean disponible = rs.getBoolean("disponible");

                // Cargar los médicos en un JComboBox para cada fila
                JComboBox<String> comboMedico = cargarComboMedico();
                comboMedico.setSelectedItem(medico); // Selecciona el médico actual

                // Agrega una fila a la tabla
                model.addRow(new Object[]{dia, hora, comboMedico, disponible ? "Disponible" : "Ocupado"});
            }

        } catch (SQLException ex) {
            System.out.println("Error al cargar horarios: " + ex.getMessage());
        }
    }

    // Método para cargar el JComboBox con la lista de médicos
    private JComboBox<String> cargarComboMedico() {
        JComboBox<String> comboMedico = new JComboBox<>();
        Conexion conexion = new Conexion();
        conexion.conectar();

        String sql = "SELECT cedula_medico, nombreyapellido, especialidad FROM medico";
        
        try (PreparedStatement stmt = conexion.getConexion().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String cedula = rs.getString("cedula_medico");
                String nombre = rs.getString("nombreyapellido");
                String especialidad = rs.getString("especialidad");
                comboMedico.addItem(cedula + " - " + nombre + " (" + especialidad + ")");
            }

        } catch (SQLException ex) {
            System.out.println("Error al cargar lista de médicos: " + ex.getMessage());
        }

        return comboMedico;
    }

    // Método para guardar los cambios realizados en la tabla
    private void guardarCambios() {
        Conexion conexion = new Conexion();
        conexion.conectar();

        String sql = "UPDATE horarios_medicos SET cedula_medico = ?, disponible = ? WHERE dia = ? AND hora = ?";

        try (PreparedStatement stmt = conexion.getConexion().prepareStatement(sql)) {
            for (int i = 0; i < model.getRowCount(); i++) {
                String dia = (String) model.getValueAt(i, 0);
                String hora = (String) model.getValueAt(i, 1);
                JComboBox<String> comboMedico = (JComboBox<String>) model.getValueAt(i, 2);
                String medicoSeleccionado = (String) comboMedico.getSelectedItem();
                String cedulaMedico = medicoSeleccionado.split(" ")[0]; // Extrae la cédula

                String estado = (String) model.getValueAt(i, 3);
                boolean disponible = estado.equals("Disponible");

                stmt.setString(1, cedulaMedico);
                stmt.setBoolean(2, disponible);
                stmt.setString(3, dia);
                stmt.setTime(4, Time.valueOf(hora + ":00"));
                stmt.executeUpdate();
            }

            JOptionPane.showMessageDialog(this, "Cambios guardados exitosamente.");

        } catch (SQLException ex) {
            System.out.println("Error al guardar cambios: " + ex.getMessage());
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
        jButton1 = new javax.swing.JButton();

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

        jButton1.setText("Volver");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 440, 120, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel textoagregarcitas1;
    // End of variables declaration//GEN-END:variables
}
