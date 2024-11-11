package mutualista;

import java.sql.Connection;
import javax.swing.*;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class Citas extends javax.swing.JFrame {
    public Citas() {
        initComponents();
        cargarTabla();
    }
    
    private void cargarTabla(){
        try{
            ResultSet rs = DatabaseConnection.getCitas();
            
            Vector<Vector<Object>> data = new Vector<>();
            Vector<String> columnNames = new Vector<>();
            columnNames.add("Cita Nº");
            columnNames.add("Fecha y Hora");
            columnNames.add("Medico");
            columnNames.add("Area");
            columnNames.add("Cancelar");
            
            boolean isFirstRow = true;
            
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getInt("Cita_numero"));
                row.add(rs.getString("Fecha_Hora"));
                row.add(rs.getString("Medico"));
                row.add(rs.getString("Area"));
                row.add(false);
                data.add(row);
                
            }
            
            DefaultTableModel model = new DefaultTableModel(data, columnNames){
                @Override
                public Class<?> getColumnClass(int column) {
                    if (column == 4) return Boolean.class; // Columna del JCheckBox
                    return super.getColumnClass(column);
                }
                
                @Override
                public boolean isCellEditable(int row, int column) {
                    // Lógica para habilitar/deshabilitar el JCheckBox en función de las reglas
                    boolean esCitaEditable = verificarCitaEditable(row); // Aquí va tu lógica
                    return column == 4 && esCitaEditable;
                }
            };
            tablausuario.setModel(model); //nombre de tabla
            tablausuario.getColumn("Cancelar").setCellRenderer(new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    JCheckBox checkBox = new JCheckBox();
                    checkBox.setSelected((Boolean) value);
                    checkBox.setEnabled(verificarCitaEditable(row));  // Controla si está habilitado
                    return checkBox;
                }
            });
            
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private boolean verificarCitaEditable(int row) {
        // Implementa tu lógica para determinar si una cita es editable (ej., próxima cita pendiente)
        return true;  // Placeholder, ajusta según tus reglas
    }

    private static class TablaPredefinida extends DefaultTableModel{

        public TablaPredefinida(Vector<Vector<Object>> data, Vector<String> columnNames) {
            super(data, columnNames);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        textocitas = new javax.swing.JLabel();
        panel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablausuario = new javax.swing.JTable();
        agregarcita = new javax.swing.JButton();
        cerrar = new javax.swing.JButton();
        buscar = new javax.swing.JTextField();
        desagendar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textocitas.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        textocitas.setText("CITAS E HISTORIAL");
        jPanel3.add(textocitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 42));

        panel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/61802.jpg"))); // NOI18N
        panel.setText("jLabel1");
        jPanel3.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 130));

        tablausuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablausuario);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 780, 260));

        agregarcita.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        agregarcita.setText("+");
        agregarcita.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        agregarcita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarcitaActionPerformed(evt);
            }
        });
        jPanel3.add(agregarcita, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 450, -1, -1));

        cerrar.setText("Volver");
        cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });
        jPanel3.add(cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 120, 40));

        buscar.setText("Buscar");
        jPanel3.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 270, 30));

        desagendar.setText("Desagendar");
        jPanel3.add(desagendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 450, 100, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cerrarActionPerformed

    private void agregarcitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarcitaActionPerformed
        // TODO add your handling code here:
        agregarcita a = new agregarcita();
        a.setVisible(true);
    }//GEN-LAST:event_agregarcitaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
       
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarcita;
    private javax.swing.JTextField buscar;
    private javax.swing.JButton cerrar;
    private javax.swing.JButton desagendar;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel panel;
    private javax.swing.JTable tablausuario;
    private javax.swing.JLabel textocitas;
    // End of variables declaration//GEN-END:variables

    
}
