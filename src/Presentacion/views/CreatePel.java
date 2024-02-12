
package Presentacion.views;


import Datos.Critica;
import Datos.Pelicula;
import Logica.CriticaService;
import Logica.PeliculaService;
import java.util.List;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CreatePel extends javax.swing.JPanel {
    
    private final CriticaService criticaService;
    private final PeliculaService peliculaService;


    public CreatePel() {
        initComponents();
        criticaService = new CriticaService();
        peliculaService = new PeliculaService(); 
        criticas();
    }
   
private void criticas() {
    List<Critica> listaCritica = criticaService.listarCriticas();
    inputCritica.removeAllItems();
    for (Critica critica : listaCritica) {
        inputCritica.addItem(critica.getId_critica() + " - " + critica.getNombre_medio()); 
        
    }
}

public boolean validarEntradas() {
    // Validar inputNamePelicula
    if (inputNamePelicula.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "El campo 'Título Película' no puede estar vacío.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    // Validar inputLugarEstreno
    if (inputLugarEstreno.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "El campo 'Lugar de Estreno' no puede estar vacío.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    // Validar inputCritica
    if (inputCritica.getSelectedIndex() == -1) { // Suponiendo que el índice -1 representa ninguna selección
        JOptionPane.showMessageDialog(this, "Debe seleccionar una crítica.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    // Validar inputDate con formato "dd/MM/yyyy"
    String fecha = inputDateMoth3.getText().trim();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setLenient(false); // Esto hace que el parseo sea estricto
    try {
        sdf.parse(fecha);
    } catch (ParseException e) {
        JOptionPane.showMessageDialog(this, "La fecha debe seguir el formato 'dd/MM/yyyy' y ser válida.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    // Si todas las validaciones son correctas
    return true;
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg4 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        txtNamePelicula = new javax.swing.JLabel();
        inputNamePelicula = new javax.swing.JTextField();
        txtLugarEstreno = new javax.swing.JLabel();
        inputLugarEstreno = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        txtFecha = new javax.swing.JLabel();
        txtCritica = new javax.swing.JLabel();
        inputCritica = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        inputDateMoth3 = new javax.swing.JFormattedTextField();

        setPreferredSize(new java.awt.Dimension(750, 427));

        titulo.setText("Registrar nuevo Usuario");

        txtNamePelicula.setText("Titulo Pelicula");

        txtLugarEstreno.setText("Lugar de estreno");

        jSeparator5.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator5.setPreferredSize(new java.awt.Dimension(200, 10));

        txtFecha.setText("Fecha de estreno  \"dd/mm/yyyy\"");

        txtCritica.setText("Critica");

        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        inputDateMoth3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        inputDateMoth3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputDateMoth3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bg4Layout = new javax.swing.GroupLayout(bg4);
        bg4.setLayout(bg4Layout);
        bg4Layout.setHorizontalGroup(
            bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bg4Layout.createSequentialGroup()
                        .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bg4Layout.createSequentialGroup()
                                .addComponent(txtNamePelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(282, 282, 282))
                            .addGroup(bg4Layout.createSequentialGroup()
                                .addComponent(txtLugarEstreno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(241, 241, 241))
                            .addGroup(bg4Layout.createSequentialGroup()
                                .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(inputNamePelicula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                                    .addComponent(inputLugarEstreno, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCritica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(bg4Layout.createSequentialGroup()
                                .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputDateMoth3, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputCritica, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 84, Short.MAX_VALUE))))
                    .addGroup(bg4Layout.createSequentialGroup()
                        .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(256, 256, 256))))
            .addGroup(bg4Layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        bg4Layout.setVerticalGroup(
            bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bg4Layout.createSequentialGroup()
                        .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputDateMoth3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCritica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputCritica, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))
                    .addGroup(bg4Layout.createSequentialGroup()
                        .addComponent(txtNamePelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputNamePelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtLugarEstreno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputLugarEstreno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))
                    .addGroup(bg4Layout.createSequentialGroup()
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (validarEntradas()) {
        String titulo = inputNamePelicula.getText().trim();
        String lugarEstreno = inputLugarEstreno.getText().trim();
        String fechaString = inputDateMoth3.getText().trim();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaEstreno = null;
            try {
                fechaEstreno = sdf.parse(fechaString);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Error al parsear la fecha.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Salir del método si hay un error
            }

        // Suponiendo que los ítems de inputCritica están formateados como "id - nombre"
        String criticaSeleccionada = (String) inputCritica.getSelectedItem();
        int idCritica = Integer.parseInt(criticaSeleccionada.split(" - ")[0]); // Obtiene el id de la crítica

        // Llamar al método para registrar la película
        boolean exito = peliculaService.registrarPelicula(titulo, fechaEstreno, lugarEstreno, idCritica);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Película registrada con éxito.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
                // Opcional: limpiar campos o actualizar la interfaz según sea necesario
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar la película.", "Error de Registro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void inputDateMoth3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputDateMoth3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputDateMoth3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apPLbl;
    private javax.swing.JLabel apPLbl1;
    private javax.swing.JLabel apPLbl2;
    private javax.swing.JLabel apPLbl3;
    private javax.swing.JTextField apPTxt;
    private javax.swing.JTextField apPTxt1;
    private javax.swing.JTextField apPTxt2;
    private javax.swing.JTextField apPTxt3;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel bg1;
    private javax.swing.JPanel bg2;
    private javax.swing.JPanel bg3;
    private javax.swing.JPanel bg4;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton button;
    private javax.swing.JButton button1;
    private javax.swing.JButton button2;
    private javax.swing.JButton button3;
    private javax.swing.JLabel domLbl;
    private javax.swing.JLabel domLbl1;
    private javax.swing.JLabel domLbl2;
    private javax.swing.JLabel domLbl3;
    private javax.swing.JTextField domTxt;
    private javax.swing.JTextField domTxt1;
    private javax.swing.JTextField domTxt2;
    private javax.swing.JTextField domTxt3;
    private javax.swing.JComboBox<String> inputCritica;
    private javax.swing.JFormattedTextField inputDateMoth3;
    private javax.swing.JTextField inputLugarEstreno;
    private javax.swing.JTextField inputNamePelicula;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JLabel nameLbl1;
    private javax.swing.JLabel nameLbl2;
    private javax.swing.JLabel nameLbl3;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JTextField nameTxt1;
    private javax.swing.JTextField nameTxt2;
    private javax.swing.JTextField nameTxt3;
    private javax.swing.JLabel phoneLbl;
    private javax.swing.JLabel phoneLbl1;
    private javax.swing.JLabel phoneLbl2;
    private javax.swing.JLabel phoneLbl3;
    private javax.swing.JTextField phoneTxt;
    private javax.swing.JTextField phoneTxt1;
    private javax.swing.JTextField phoneTxt2;
    private javax.swing.JTextField phoneTxt3;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel title3;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel txtCritica;
    private javax.swing.JLabel txtFecha;
    private javax.swing.JLabel txtLugarEstreno;
    private javax.swing.JLabel txtNamePelicula;
    // End of variables declaration//GEN-END:variables
}
