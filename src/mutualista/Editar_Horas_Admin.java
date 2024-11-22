package mutualista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Editar_Horas_Admin extends javax.swing.JFrame {
    
    private JTable table;
    private boolean cambiosRealizados = false;

    public Editar_Horas_Admin() {
        initComponents();
        
        // Crear modelo de tabla
        String[] columnas = {"Horario", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
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

        DefaultTableModel model = new DefaultTableModel(datos, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column > 0; // Permitir edición solo en días
            }
        };

        table = new JTable(model);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.getSelectedRow();
                int col = table.getSelectedColumn();
                if (col > 0) { // Solo columnas de días
                    String medico = JOptionPane.showInputDialog(null, "Ingrese el nombre del médico:");
                    if (medico != null && !medico.isEmpty()) {
                        table.setValueAt(medico, row, col);
                        cambiosRealizados = true;
                    }
                }
            }
        });

        add(new JScrollPane(table), BorderLayout.CENTER);

        // Botón "Actualizar"
        JButton btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(e -> actualizarHorarios(model));
        add(btnActualizar, BorderLayout.SOUTH);

        // Manejo al cerrar
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                if (cambiosRealizados) {
                    int opcion = JOptionPane.showConfirmDialog(null,
                            "Hay cambios sin guardar. ¿Desea salir sin guardar?",
                            "Advertencia", JOptionPane.YES_NO_OPTION);
                    if (opcion == JOptionPane.YES_OPTION) {
                        dispose();
                    }
                } else {
                    dispose();
                }
            }
        });
    }

    private void configurarEventosTabla() {
    table.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int row = table.rowAtPoint(evt.getPoint());
            int column = table.columnAtPoint(evt.getPoint());

            if (row >= 0 && column > 0) { // Evitar la columna de horas
                mostrarMedicosParaCelda(row, column);
            }
        }

        private void mostrarMedicosParaCelda(int row, int column) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    });
}

    private void actualizarHorarios(DefaultTableModel model) {
        // Guardar cambios en la base de datos
        System.out.println("Guardando cambios...");
        cambiosRealizados = false;
    }


    // Método para cargar los horarios de la base de datos
    private void cargarHorarios() {
        Conexion conexion = new Conexion();
    conexion.conectar();

    // Consulta SQL para obtener los horarios
    String sql = "SELECT h.dia_semana, h.hora_inicio, h.hora_fin, h.disponible, m.nombreyapellido " +
                 "FROM horarios_medicos h " +
                 "JOIN medico m ON h.id_medico = m.id_medico";

    try (PreparedStatement stmt = conexion.getConexion().prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        // Limpia el modelo actual de la tabla antes de agregar filas
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        // Agrega filas con los datos desde la base de datos
        while (rs.next()) {
            String dia = rs.getString("dia_semana");
            String horaInicio = rs.getString("hora_inicio");
            String horaFin = rs.getString("hora_fin");
            String medico = rs.getString("nombreyapellido");
            boolean disponible = rs.getBoolean("disponible");

            // Agrega la fila al modelo
            model.addRow(new Object[]{
                dia,
                horaInicio + " - " + horaFin,
                medico,
                disponible ? "Disponible" : "Ocupado"
            });
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
    
    private List<String> obtenerListaMedicos() {
        List<String> medicos = new ArrayList<>();
        Conexion conexion = new Conexion();
        conexion.conectar();

        String sql = "SELECT nombreyapellido, especialidad FROM medico";
        try (PreparedStatement stmt = conexion.getConexion().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String nombre = rs.getString("nombreyapellido");
                String especialidad = rs.getString("especialidad");
                medicos.add(nombre + " - " + especialidad);
            }
        } catch (SQLException ex) {
            System.out.println("Error al cargar la lista de médicos: " + ex.getMessage());
        }
        return medicos;
    }

@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        textoagregarcitas1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_volver = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        btn_actualizar = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));

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

        btn_volver.setText("Volver");
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });
        jPanel1.add(btn_volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 440, 120, 50));

        jTextField1.setText("Buscar");
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 270, 30));

        btn_actualizar.setText("Actualizar ");
        jPanel1.add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 180, 120, 40));

        btn_reset.setText("Reset");
        jPanel1.add(btn_reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, 120, 40));

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

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
        
        // Confirmar si desea guardar cambios antes de volver
        int opcion = JOptionPane.showConfirmDialog(this, 
            "¿Desea guardar los cambios antes de salir?", 
            "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION);
    
        if (opcion == JOptionPane.YES_OPTION) {
            guardarCambios(); // Llama a tu método para guardar los cambios
        }
        if (opcion != JOptionPane.CANCEL_OPTION) {
            this.dispose(); // Cierra la ventana actual
            Gestionar_Medicos gestionarMedicos = new Gestionar_Medicos();
            gestionarMedicos.setVisible(true); // Abre la ventana anterior
            gestionarMedicos.setLocationRelativeTo(null); // Centra la ventana
        }
    }//GEN-LAST:event_btn_volverActionPerformed

    private void guardarCambios() {
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mutualista", "root", "")) {
        String sql = "UPDATE horarios_medicos SET disponible = ?, id_medico = ? WHERE dia_semana = ? AND hora_inicio = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            for (int i = 0; i < table.getRowCount(); i++) {
                String dia = (String) table.getValueAt(i, 0); // Columna del día
                String hora = (String) table.getValueAt(i, 1); // Hora de inicio (por ejemplo, "9:00")
                String estado = (String) table.getValueAt(i, 2); // "Disponible" u "Ocupado"

                boolean disponible = estado.equals("Disponible");

                // Si tienes un JComboBox en la columna 3 para el médico
                String medicoSeleccionado = (String) table.getValueAt(i, 3); // Asume que aquí está el valor del médico
                String idMedico = medicoSeleccionado.split(" ")[0]; // Si es algo como "123 - Dr. Pérez", toma "123"

                stmt.setBoolean(1, disponible);
                stmt.setString(2, idMedico);
                stmt.setString(3, dia);
                stmt.setString(4, hora);
                stmt.executeUpdate();
            }
            JOptionPane.showMessageDialog(this, "Cambios guardados exitosamente.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al guardar los cambios: " + e.getMessage());
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel textoagregarcitas1;
    // End of variables declaration//GEN-END:variables
}
