
package Presentacion;


public class peliculas extends javax.swing.JInternalFrame {

    public peliculas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelRegistrarPelicula = new javax.swing.JPanel();
        TxtLugarEstreno = new javax.swing.JTextField();
        TxtNombrePelicula = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();

        PanelRegistrarPelicula.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos pelicula"));

        TxtLugarEstreno.setBorder(javax.swing.BorderFactory.createTitledBorder("Lugar De Estreno"));
        TxtLugarEstreno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtLugarEstrenoActionPerformed(evt);
            }
        });

        TxtNombrePelicula.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre"));
        TxtNombrePelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNombrePeliculaActionPerformed(evt);
            }
        });

        jComboBox1.setBorder(javax.swing.BorderFactory.createTitledBorder("Critica"));

        javax.swing.GroupLayout PanelRegistrarPeliculaLayout = new javax.swing.GroupLayout(PanelRegistrarPelicula);
        PanelRegistrarPelicula.setLayout(PanelRegistrarPeliculaLayout);
        PanelRegistrarPeliculaLayout.setHorizontalGroup(
            PanelRegistrarPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegistrarPeliculaLayout.createSequentialGroup()
                .addGroup(PanelRegistrarPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRegistrarPeliculaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(TxtLugarEstreno, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelRegistrarPeliculaLayout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(PanelRegistrarPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelRegistrarPeliculaLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(TxtNombrePelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(253, Short.MAX_VALUE)))
        );
        PanelRegistrarPeliculaLayout.setVerticalGroup(
            PanelRegistrarPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegistrarPeliculaLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtLugarEstreno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(PanelRegistrarPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelRegistrarPeliculaLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(TxtNombrePelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(120, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelRegistrarPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelRegistrarPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TxtLugarEstrenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtLugarEstrenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtLugarEstrenoActionPerformed

    private void TxtNombrePeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNombrePeliculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNombrePeliculaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelRegistrarPelicula;
    private javax.swing.JTextField TxtLugarEstreno;
    private javax.swing.JTextField TxtNombrePelicula;
    private javax.swing.JComboBox<String> jComboBox1;
    // End of variables declaration//GEN-END:variables
}
