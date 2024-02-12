/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentacion.views;

import Presentacion.Dashboard;
import Datos.Critica;
import Datos.Pelicula;
import Logica.CriticaService;
import Logica.PeliculaService;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditPelicula extends javax.swing.JPanel {
    
    private final CriticaService criticaService;
    private final PeliculaService peliculaService;
    private int idPeliculaActual;
    private Dashboard dashboard;
    
    public EditPelicula(Dashboard dashboard) {
        this.dashboard = dashboard;
        initComponents();
        InitStyles();
        criticaService = new CriticaService();
        peliculaService = new PeliculaService(); 
        criticas();
    }
    
    private void InitStyles() {
        titulo.putClientProperty("FlatLaf.style", "font: bold $h1.regular.font");
        titulo.setForeground(Color.white);
        txtNamePelicula.putClientProperty("FlatLaf.style", "font: $h3.regular.font");
        txtNamePelicula.setForeground(Color.white);
        txtFecha.putClientProperty("FlatLaf.style", "font: $h3.regular.font");
        txtFecha.setForeground(Color.white);
        txtLugarEstreno.putClientProperty("FlatLaf.style", "font: $h3.regular.font");
        txtLugarEstreno.setForeground(Color.white);
        txtCritica.putClientProperty("FlatLaf.style", "font: $h3.regular.font");
        txtCritica.setForeground(Color.white);
    }
    private void criticas() {
        List<Critica> listaCritica = criticaService.listarCriticas();
        inputCritica.removeAllItems();
            for (Critica critica : listaCritica) {
                inputCritica.addItem(critica.getId_critica() + " - " + critica.getNombre_medio()); 

            }
    }
     
    public void cargarDatosPelicula(int idPelicula) {
        var pelicula = peliculaService.obtenerPeliculaPorId(idPelicula);
        if (pelicula != null) {
            this.idPeliculaActual = idPelicula; // Almacena el ID de la película
            inputNamePelicula.setText(pelicula.getTitulo_pelicula());
            inputLugarEstreno.setText(pelicula.getLugar_estreno());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            inputDateMoth3.setText(sdf.format(pelicula.getFecha_estreno()));
            // Código para ajustar la selección de la crítica...
        } else {
            JOptionPane.showMessageDialog(this, "Película no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
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
        txtFecha = new javax.swing.JLabel();
        inputDateMoth3 = new javax.swing.JFormattedTextField();
        txtCritica = new javax.swing.JLabel();
        inputCritica = new javax.swing.JComboBox<>();
        btnRegresar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(750, 300));

        titulo.setText("Editar pelicula");

        txtNamePelicula.setText("Titulo Pelicula");

        inputNamePelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNamePeliculaActionPerformed(evt);
            }
        });

        txtLugarEstreno.setText("Lugar de estreno");

        txtFecha.setText("Fecha de estreno  \"dd/mm/yyyy\"");

        inputDateMoth3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        inputDateMoth3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputDateMoth3ActionPerformed(evt);
            }
        });

        txtCritica.setText("Critica");

        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Regresar");
        btnRegresar.setBorderPainted(false);
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.setBorderPainted(false);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
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
                                .addGap(319, 319, 319))
                            .addGroup(bg4Layout.createSequentialGroup()
                                .addComponent(txtLugarEstreno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(278, 278, 278))
                            .addGroup(bg4Layout.createSequentialGroup()
                                .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputLugarEstreno, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputNamePelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCritica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(bg4Layout.createSequentialGroup()
                                .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputCritica, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputDateMoth3, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 82, Short.MAX_VALUE))))
                    .addGroup(bg4Layout.createSequentialGroup()
                        .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(256, 256, 256))))
            .addGroup(bg4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bg4Layout.createSequentialGroup()
                    .addContainerGap(409, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(88, 88, 88)))
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
                        .addGap(18, 18, 18)
                        .addComponent(inputDateMoth3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCritica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputCritica, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bg4Layout.createSequentialGroup()
                        .addComponent(txtNamePelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(inputNamePelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLugarEstreno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputLugarEstreno, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
            .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bg4Layout.createSequentialGroup()
                    .addContainerGap(242, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(140, 140, 140)))
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

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        if (dashboard != null) {
            Presentacion.views.Pelicula peliculaPanel = new Presentacion.views.Pelicula(dashboard);
            dashboard.ShowJPanel(peliculaPanel);
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void inputDateMoth3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputDateMoth3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputDateMoth3ActionPerformed

    private void inputNamePeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNamePeliculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNamePeliculaActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
            // Primero, validar las entradas del usuario
        if (validarEntradas()) {
            // Recuperar los valores ingresados por el usuario
            String titulo = inputNamePelicula.getText();
            String lugarEstreno = inputLugarEstreno.getText();
            Date fechaEstreno;

            // Intentar parsear la fecha de estreno ingresada
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                fechaEstreno = sdf.parse(inputDateMoth3.getText());
            } catch (ParseException e) {
                // Si el parseo falla, mostrar un mensaje de error y detener la ejecución del método
                JOptionPane.showMessageDialog(this, "La fecha debe seguir el formato 'dd/MM/yyyy' y ser válida.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener el ID de la crítica seleccionada
            String itemSeleccionado = (String) inputCritica.getSelectedItem();
            int idCritica = Integer.parseInt(itemSeleccionado.split(" - ")[0]);

            // Llamar al método de actualización del servicio con los valores recogidos
            boolean resultado = peliculaService.actualizarPelicula(idPeliculaActual, titulo, fechaEstreno, lugarEstreno, idCritica);

            // Verificar el resultado de la operación y mostrar un mensaje al usuario
            if (resultado) {
                JOptionPane.showMessageDialog(this, "Película actualizada con éxito.", "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar la película.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Si la validación de entradas falla, no se necesita hacer nada aquí,
            // el método validarEntradas() ya maneja la notificación al usuario.
        }
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg4;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> inputCritica;
    private javax.swing.JFormattedTextField inputDateMoth3;
    private javax.swing.JTextField inputLugarEstreno;
    private javax.swing.JTextField inputNamePelicula;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel txtCritica;
    private javax.swing.JLabel txtFecha;
    private javax.swing.JLabel txtLugarEstreno;
    private javax.swing.JLabel txtNamePelicula;
    // End of variables declaration//GEN-END:variables
}
