
package mutualista;

public class agregarcita extends javax.swing.JFrame {

    public agregarcita() {
        initComponents();
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
        setMaximumSize(new java.awt.Dimension(800, 500));
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
        jPanel1.add(agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 450, -1, -1));

        volver.setText("Volver");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        jPanel1.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 120, 40));

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
