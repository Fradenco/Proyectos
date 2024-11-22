package mutualista;

import javax.swing.*;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class agregarcita extends javax.swing.JFrame {

    public agregarcita() {
        initComponents();
        cargarDatosDesdeBD(); // Carga los datos en la tabla al abrir la ventana
        
        // Crear columnas para la tabla
String[] columnas = {"Nombre y Apellido", "Especialidad", "Fecha", "Inicio", "Fin"};

// Crear filas vacías para inicializar la tabla (puedes agregar datos desde la base de datos)
String[][] datos = {
    {"", "", "", "", ""},
    {"", "", "", "", ""},
    {"", "", "", "", ""},
    {"", "", "", "", ""}
};

// Configurar el modelo de la tabla
DefaultTableModel model = new DefaultTableModel(datos, columnas) {
    @Override
    public boolean isCellEditable(int row, int column) {
        // Hacer que las celdas no sean editables
        return false;
    }
};

// Asignar el modelo a la tabla
tabagendacitas.setModel(model);

// Ajustar el formato de las columnas
tabagendacitas.getColumnModel().getColumn(0).setPreferredWidth(150); // Nombre
tabagendacitas.getColumnModel().getColumn(1).setPreferredWidth(150); // Especialidad
tabagendacitas.getColumnModel().getColumn(2).setPreferredWidth(100); // Fecha
tabagendacitas.getColumnModel().getColumn(3).setPreferredWidth(100); // Inicio
tabagendacitas.getColumnModel().getColumn(4).setPreferredWidth(100); // Fin

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        textoagregarcitas = new javax.swing.JLabel();
        panel = new javax.swing.JLabel();
        agregar = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabagendacitas = new javax.swing.JTable();
        buscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoagregarcitas.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        textoagregarcitas.setText("AGREGAR CITA");
        jPanel1.add(textoagregarcitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 370, 40));

        panel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/61802.jpg"))); // NOI18N
        panel.setText("jLabel1");
        jPanel1.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 130));

        agregar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        agregar.setText("+");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        jPanel1.add(agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 450, -1, -1));

        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        jPanel1.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 120, 40));

        tabagendacitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabagendacitas.setToolTipText("");
        jScrollPane2.setViewportView(tabagendacitas);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 780, 260));

        buscar.setText("Buscar");
        jPanel1.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 270, 30));

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

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_volverActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        // Verificar si se seleccionó una fila
        int selectedRow = tabagendacitas.getSelectedRow();
    if (selectedRow != -1) {
        DefaultTableModel model = (DefaultTableModel) tabagendacitas.getModel();
        int columnCount = model.getColumnCount();
        
        // Depuración
        System.out.println("Columnas en el modelo: " + columnCount);
        
        if (columnCount >= 5) {
            String nombreyapellido = (String) model.getValueAt(selectedRow, 0);
            String especialidad = (String) model.getValueAt(selectedRow, 1);
            String fecha = (String) model.getValueAt(selectedRow, 2);
            String inicio = (String) model.getValueAt(selectedRow, 3);
            String fin = (String) model.getValueAt(selectedRow, 4);

            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mutualista", "root", "");
                 PreparedStatement stmt = con.prepareStatement(
                         "INSERT INTO agenda_citas (id_medico, fecha, hora, id_paciente, estado) VALUES (?, ?, ?, ?, 'pendiente')")) {
                // Aquí debes calcular el `id_medico` e `id_paciente` según tus datos
                stmt.setInt(1, obtenerIdMedico(nombreyapellido)); // Implementa esta función
                stmt.setString(2, fecha);
                stmt.setString(3, inicio);
                stmt.setInt(4, obtenerIdPaciente()); // Implementa esta función
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Cita agregada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al agregar la cita: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Modelo de tabla no contiene suficientes columnas.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_agregarActionPerformed
    
    private void cargarDatosDesdeBD() {
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mutualista", "root", "");
             PreparedStatement stmt = con.prepareStatement("""
                     SELECT 
                         u.nombreyapellido AS nombre_completo, 
                         m.especialidad, 
                         h.dia_semana AS fecha, 
                         h.hora_inicio AS inicio, 
                         h.hora_fin AS fin,
                         h.id_horario AS id_horario
                     FROM 
                         usuarios u
                     JOIN 
                         medico m ON u.cedula = m.cedula
                     JOIN 
                         horarios_medicos h ON m.id_medico = h.id_medico
                     WHERE 
                         h.disponible = 1;
                 """)) {

            ResultSet rs = stmt.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tabagendacitas.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("nombre_completo"),
                    rs.getString("especialidad"),
                    rs.getString("fecha"),
                    rs.getString("inicio"),
                    rs.getString("fin"),
                    rs.getInt("id_horario")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
}

    
    private void cargarTabla() {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mutualista", "root", "");
         PreparedStatement stmt = con.prepareStatement(
             "SELECT " +
             "u.nombreyapellido AS nombreyapellido, " +
             "m.especialidad, " +
             "h.dia_semana AS fecha, " +
             "h.hora_inicio AS inicio, " +
             "h.hora_fin AS fin " +
             "FROM usuarios u " +
             "JOIN medico m ON u.cedula = m.cedula " +
             "JOIN horarios_medicos h ON m.id_medico = h.id_medico " +
             "WHERE h.disponible = 1")) {

        ResultSet rs = stmt.executeQuery();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre Completo");
        model.addColumn("Especialidad");
        model.addColumn("Fecha");
        model.addColumn("Inicio");
        model.addColumn("Fin");

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("nombre_completo"),
                rs.getString("especialidad"),
                rs.getString("fecha"),
                rs.getString("inicio"),
                rs.getString("fin")
            });
        }

        tabagendacitas.setModel(model);
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    private int obtenerIdMedico(String nombreyapellido) {
    int idMedico = -1;
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mutualista", "root", "");
         PreparedStatement stmt = con.prepareStatement(
             "SELECT m.id_medico " +
             "FROM medico m " +
             "JOIN usuarios u ON m.cedula = u.cedula " +
             "WHERE u.nombreyapellido = ?")) {
        stmt.setString(1, nombreyapellido);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            idMedico = rs.getInt("id_medico");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al obtener el ID del médico: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return idMedico;
}

    private int obtenerIdPaciente() {
    int idPaciente = -1;
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mutualista", "root", "");
         PreparedStatement stmt = con.prepareStatement(
             "SELECT id_paciente FROM paciente WHERE cedula = ?")) {
        // Supongamos que tienes una clase UsuarioSesion para almacenar la cédula del usuario logueado
        stmt.setString(1, UsuarioSesion.getCedula()); // Reemplaza con la forma en que obtienes la cédula
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            idPaciente = rs.getInt("id_paciente");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al obtener el ID del paciente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return idPaciente;
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JTextField buscar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel panel;
    private javax.swing.JTable tabagendacitas;
    private javax.swing.JLabel textoagregarcitas;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}