/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentacion.views;

import Presentacion.Dashboard;
import Datos.Critica;
import Logica.CriticaService;
import Logica.PeliculaService;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreatePelicula extends javax.swing.JPanel {
    
    private final CriticaService criticaService;
    private final PeliculaService peliculaService;
    private Dashboard dashboard;
    
    public CreatePelicula(Dashboard dashboard) {
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
    
    private void limpiarCampos() {
        
        inputNamePelicula.setText("");
        inputLugarEstreno.setText("");
        inputDateMoth3.setText("");

        if (inputCritica.getItemCount() > 0) {
            inputCritica.setSelectedIndex(0);
        }
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
        btnRegistrar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(750, 300));

        titulo.setText("Registrar nuevo usuario");

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
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            Pelicula peliculaPanel = new Pelicula(dashboard);
            dashboard.ShowJPanel(peliculaPanel);
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void inputDateMoth3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputDateMoth3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputDateMoth3ActionPerformed

    private void inputNamePeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNamePeliculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNamePeliculaActionPerformed

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
                return;
            }

        String criticaSeleccionada = (String) inputCritica.getSelectedItem();
        int idCritica = Integer.parseInt(criticaSeleccionada.split(" - ")[0]);

        boolean exito = peliculaService.registrarPelicula(titulo, fechaEstreno, lugarEstreno, idCritica);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Película registrada con éxito.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar la película.", "Error de Registro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg4;
    private javax.swing.JButton btnRegistrar;
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
