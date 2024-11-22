package mutualista;

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.TableRowSorter;
import mutualista.Editar_Usuario;


public class Editar_Usuario extends javax.swing.JFrame {
    
    // Declaración de atributos de la clase
    private TableRowSorter<DefaultTableModel> sorter; // Declaración de 'sorter'
    private DefaultTableModel model; // Puedes inicializar el modelo también aquí si lo usas repetidamente

    public Editar_Usuario() {
        initComponents();
        
        // Configura el modelo de la tabla
        DefaultTableModel model = new DefaultTableModel(
        new String[]{"Cédula", "Nombre y Apellido", "Teléfono", "Contraseña", "Rol"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return column > 0; // Permitir editar todas las columnas excepto la cédula
        }
    };
    tableUsuarios.setModel(model); // Asigna el modelo a la tabla

    // Inicializa el sorter
    sorter = new TableRowSorter<>(model);
    tableUsuarios.setRowSorter(sorter);

    cargarUsuarios(); // Llama al método para cargar los datos
    
    
// Agregar el DocumentListener al JTextField de búsqueda
    txt_BuscarUsuarios.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
        @Override
        public void insertUpdate(javax.swing.event.DocumentEvent e) {
            applyFilter();
        }

        @Override
        public void removeUpdate(javax.swing.event.DocumentEvent e) {
            applyFilter();
        }

        @Override
        public void changedUpdate(javax.swing.event.DocumentEvent e) {
            applyFilter();
        }

        // Método para aplicar el filtro
        private void applyFilter() {
            String filterText = txt_BuscarUsuarios.getText().trim();
            if (filterText.isEmpty()) {
                sorter.setRowFilter(null); // Sin filtro
            } else {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + filterText)); // Filtro insensible a mayúsculas
            }
        }
    });
    }
    
    private void cargarUsuarios() {
    DefaultTableModel model = (DefaultTableModel) tableUsuarios.getModel();
    model.setRowCount(0); // Limpia la tabla antes de cargar nuevos datos

    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mutualista", "root", "");
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT cedula, nombreyapellido, telefono, contrasena, rol FROM usuarios")) {

        boolean hasData = false;
        while (rs.next()) {
            hasData = true;
            model.addRow(new Object[]{
                rs.getString("cedula"),
                rs.getString("nombreyapellido"),
                rs.getString("telefono"),
                rs.getString("contrasena"),
                rs.getString("rol")
            });
        }

        if (!hasData) {
            JOptionPane.showMessageDialog(this, "No se encontraron usuarios.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al cargar los usuarios.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        textoagregarcitas1 = new javax.swing.JLabel();
        panel = new javax.swing.JLabel();
        txt_BuscarUsuarios = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUsuarios = new javax.swing.JTable();
        volver = new javax.swing.JButton();
        actializar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoagregarcitas1.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        textoagregarcitas1.setText("EDITAR USUARIO");
        jPanel1.add(textoagregarcitas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 40));

        panel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/6180999.jpg"))); // NOI18N
        panel.setText("jLabel1");
        jPanel1.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 130));

        txt_BuscarUsuarios.setText("Buscar");
        txt_BuscarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_BuscarUsuariosActionPerformed(evt);
            }
        });
        txt_BuscarUsuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarUsuariosKeyReleased(evt);
            }
        });
        jPanel1.add(txt_BuscarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 270, 30));

        tableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableUsuarios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 650, 310));

        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        jPanel1.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 440, 120, 50));

        actializar.setText("Actualizar");
        actializar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actializarActionPerformed(evt);
            }
        });
        jPanel1.add(actializar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 180, 120, 40));

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, 120, 30));

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

    private void txt_BuscarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_BuscarUsuariosActionPerformed
        DefaultTableModel model = (DefaultTableModel) tableUsuarios.getModel();
    model.setRowCount(0); // Limpia la tabla antes de cargar los resultados

    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mutualista", "root", "");
         PreparedStatement stmt = con.prepareStatement("SELECT * FROM usuario WHERE cedula LIKE ? OR nombreyapellido LIKE ? OR rol LIKE ?")) {
        String query = "%" + txt_BuscarUsuarios.getText() + "%";
        stmt.setString(1, query);
        stmt.setString(2, query);
        stmt.setString(3, query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("cedula"),
                rs.getString("nombreyapellido"),
                rs.getString("telefono"),
                rs.getString("contrasena"),
                rs.getString("rol")
            });
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al buscar usuarios.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_txt_BuscarUsuariosActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this, "Hay cambios sin guardar. ¿Desea salir sin guardar?", "Advertencia", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            dispose(); // Cierra esta ventana
        }
    }//GEN-LAST:event_volverActionPerformed

    private void actializarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actializarActionPerformed
        DefaultTableModel model = (DefaultTableModel) tableUsuarios.getModel();

    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mutualista", "root", "")) {
        String sql = "UPDATE usuarios SET nombreyapellido = ?, telefono = ?, contrasena = ?, rol = ? WHERE cedula = ?";
        PreparedStatement stmt = con.prepareStatement(sql);

        for (int i = 0; i < model.getRowCount(); i++) {
            String cedula = (String) model.getValueAt(i, 0);
            String nombre = (String) model.getValueAt(i, 1);
            String telefono = (String) model.getValueAt(i, 2);
            String contrasena = (String) model.getValueAt(i, 3);
            String rol = (String) model.getValueAt(i, 4);

            stmt.setString(1, nombre);
            stmt.setString(2, telefono);
            stmt.setString(3, contrasena);
            stmt.setString(4, rol);
            stmt.setString(5, cedula);

            stmt.executeUpdate();
        }

        JOptionPane.showMessageDialog(this, "Cambios guardados exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al guardar los cambios.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_actializarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        int selectedRow = tableUsuarios.getSelectedRow();

    if (selectedRow != -1) {
        String cedula = (String) tableUsuarios.getValueAt(selectedRow, 0);
        String rol = (String) tableUsuarios.getValueAt(selectedRow, 4); // Asume que la columna 4 contiene el rol del usuario
        int confirm = JOptionPane.showConfirmDialog(this, 
                "¿Está seguro de que desea eliminar este usuario?", 
                "Confirmar eliminación", 
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mutualista", "root", "")) {
                switch (rol.toLowerCase()) {
                    case "medico":
                        // Elimina las dependencias de la tabla `medico`
                        try (PreparedStatement stmt = con.prepareStatement("DELETE FROM medico WHERE cedula = ?")) {
                            stmt.setString(1, cedula);
                            stmt.executeUpdate();
                        }
                        break;
                        
                    case "paciente":
                        // Elimina las dependencias de la tabla `paciente`
                        try (PreparedStatement stmt = con.prepareStatement("DELETE FROM paciente WHERE cedula = ?")) {
                            stmt.setString(1, cedula);
                            stmt.executeUpdate();
                        }
                        break;
                        
                    case "administrador":
                        // No hay dependencias adicionales para el administrador (puedes añadir lógica aquí si es necesario)
                        break;

                    default:
                        JOptionPane.showMessageDialog(this, 
                                "El rol especificado no es válido o no tiene lógica de eliminación implementada.", 
                                "Error", 
                                JOptionPane.ERROR_MESSAGE);
                        return;
                }

                // Finalmente elimina al usuario de la tabla `usuarios`
                try (PreparedStatement stmt = con.prepareStatement("DELETE FROM usuarios WHERE cedula = ?")) {
                    stmt.setString(1, cedula);
                    stmt.executeUpdate();
                }

                // Elimina la fila de la tabla en la interfaz
                ((DefaultTableModel) tableUsuarios.getModel()).removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Usuario eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione un usuario para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_eliminarActionPerformed

    private void txt_BuscarUsuariosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarUsuariosKeyReleased
         txt_BuscarUsuariosActionPerformed(null); // Reutiliza el método de ActionPerformed
    }//GEN-LAST:event_txt_BuscarUsuariosKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actializar;
    private javax.swing.JButton eliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel panel;
    private javax.swing.JTable tableUsuarios;
    private javax.swing.JLabel textoagregarcitas1;
    private javax.swing.JTextField txt_BuscarUsuarios;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
