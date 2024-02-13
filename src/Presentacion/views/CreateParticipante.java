/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentacion.views;

import Presentacion.Dashboard;
import Logica.ParticipanteService;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateParticipante extends javax.swing.JPanel {
    
    private final ParticipanteService participanteService;
    private Dashboard dashboard;
    
    public CreateParticipante(Dashboard dashboard) {
        this.dashboard = dashboard;
        initComponents();
        InitStyles();
        participanteService = new ParticipanteService(); 
    }
    
    private void InitStyles() {
        titulo.putClientProperty("FlatLaf.style", "font: bold $h1.regular.font");
        titulo.setForeground(Color.white);
        inputNameParticipante.putClientProperty("FlatLaf.style", "font: $h3.regular.font");
        inputNameParticipante.setForeground(Color.white);
        inputFechaNacimiento.putClientProperty("FlatLaf.style", "font: $h3.regular.font");
        inputFechaNacimiento.setForeground(Color.white);
        inputTelefono.putClientProperty("FlatLaf.style", "font: $h3.regular.font");
        inputTelefono.setForeground(Color.white);
        inputDireccion.putClientProperty("FlatLaf.style", "font: $h3.regular.font");
        inputDireccion.setForeground(Color.white);
        inputLugarNacimiento.putClientProperty("FlatLaf.style", "font: $h3.regular.font");
        inputLugarNacimiento.setForeground(Color.white);
        inputEstadoCivil.putClientProperty("FlatLaf.style", "font: $h3.regular.font");
        inputEstadoCivil.setForeground(Color.white);
    }

    public boolean validarEntradas() {
        // Validar inputNamePelicula
        if (inputNameParticipante.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo 'Nombre completo participante' no puede estar vacío.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validar inputDireccion
        if (inputDireccion.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo 'Direccion' no puede estar vacío.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validar inputDate con formato "dd/MM/yyyy"
        String fecha = inputFechaNacimiento.getText().trim();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // Esto hace que el parseo sea estricto
        try {
            sdf.parse(fecha);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "La fecha debe seguir el formato 'dd/MM/yyyy' y ser válida.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //Validar inputEstadoCivil
        if (inputEstadoCivil.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "El campo 'Estado Civil' no puede estar vacío.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validar inputTelefono
        String telefono = inputTelefono.getText().trim();
        if (telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo 'Teléfono' no puede estar vacío.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (telefono.length() > 10) {
            JOptionPane.showMessageDialog(this, "El campo 'Teléfono' no puede contener más de 10 dígitos.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!telefono.matches("\\d+")) { // Esta expresión regular verifica que solo haya dígitos
            JOptionPane.showMessageDialog(this, "El campo 'Teléfono' solo puede contener números.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        //Validar inputLugarNacimiento
        if (inputLugarNacimiento.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "El campo 'Lugar Nacimiento' no puede estar vacío.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    // Si todas las validaciones son correctas
    return true;
    }
    
    private void limpiarCampos() {
        
        inputNameParticipante.setText("");
        inputDireccion.setText("");
        inputFechaNacimiento.setText("");
        inputTelefono.setText("");
        inputLugarNacimiento.setText("");
        inputEstadoCivil.setText("");

    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg4 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        txtNamePelicula = new javax.swing.JLabel();
        inputNameParticipante = new javax.swing.JTextField();
        txtLugarEstreno = new javax.swing.JLabel();
        inputDireccion = new javax.swing.JTextField();
        txtFecha = new javax.swing.JLabel();
        inputFechaNacimiento = new javax.swing.JFormattedTextField();
        txtCritica = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        inputTelefono = new javax.swing.JTextField();
        txtLugarEstreno1 = new javax.swing.JLabel();
        inputLugarNacimiento = new javax.swing.JTextField();
        txtLugarEstreno2 = new javax.swing.JLabel();
        inputEstadoCivil = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(750, 300));

        titulo.setText("Registrar nuevo participante");

        txtNamePelicula.setText("Nombre completo participante");

        inputNameParticipante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNameParticipanteActionPerformed(evt);
            }
        });

        txtLugarEstreno.setText("Telefono");

        txtFecha.setText("Fecha Nacimiento dd/mm/yyyy");

        inputFechaNacimiento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        inputFechaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputFechaNacimientoActionPerformed(evt);
            }
        });

        txtCritica.setText("Direccion");

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

        txtLugarEstreno1.setText("Lugar nacimiento");

        txtLugarEstreno2.setText("Estado civil");

        javax.swing.GroupLayout bg4Layout = new javax.swing.GroupLayout(bg4);
        bg4.setLayout(bg4Layout);
        bg4Layout.setHorizontalGroup(
            bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bg4Layout.createSequentialGroup()
                        .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(256, 256, 256))
                    .addGroup(bg4Layout.createSequentialGroup()
                        .addComponent(txtLugarEstreno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(504, 504, 504))
                    .addGroup(bg4Layout.createSequentialGroup()
                        .addComponent(txtNamePelicula, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                        .addGap(524, 524, 524))
                    .addGroup(bg4Layout.createSequentialGroup()
                        .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputNameParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(bg4Layout.createSequentialGroup()
                .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bg4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLugarEstreno1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputLugarNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bg4Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bg4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(bg4Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCritica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                            .addGroup(bg4Layout.createSequentialGroup()
                                .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(inputEstadoCivil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                                        .addComponent(txtLugarEstreno2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(inputDireccion, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(inputFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        bg4Layout.setVerticalGroup(
            bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bg4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCritica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(249, 249, 249))
                    .addGroup(bg4Layout.createSequentialGroup()
                        .addComponent(txtNamePelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(inputNameParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLugarEstreno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLugarEstreno1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtLugarEstreno2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputLugarNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64)
                        .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50))))
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
            Participante participantePanel = new Participante(dashboard);
            dashboard.ShowJPanel(participantePanel);
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void inputFechaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFechaNacimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputFechaNacimientoActionPerformed

    private void inputNameParticipanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNameParticipanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNameParticipanteActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (validarEntradas()) {
        String nombre = inputNameParticipante.getText().trim();
        String direccion = inputDireccion.getText().trim();
        String telefono = inputTelefono.getText().trim();
        String fechaString= inputFechaNacimiento.getText().trim();
        String lugarNacimiento = inputLugarNacimiento.getText().trim();
        String estadoCivil = inputEstadoCivil.getText().trim();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaNacimiento = null;
            try {
                fechaNacimiento = sdf.parse(fechaString);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Error al parsear la fecha.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

        boolean exito = participanteService.registrarParticipante(nombre,direccion,telefono,fechaNacimiento, lugarNacimiento, estadoCivil);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Participante registrada con éxito.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar la Participante.", "Error de Registro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg4;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JTextField inputDireccion;
    private javax.swing.JTextField inputEstadoCivil;
    private javax.swing.JFormattedTextField inputFechaNacimiento;
    private javax.swing.JTextField inputLugarNacimiento;
    private javax.swing.JTextField inputNameParticipante;
    private javax.swing.JTextField inputTelefono;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel txtCritica;
    private javax.swing.JLabel txtFecha;
    private javax.swing.JLabel txtLugarEstreno;
    private javax.swing.JLabel txtLugarEstreno1;
    private javax.swing.JLabel txtLugarEstreno2;
    private javax.swing.JLabel txtNamePelicula;
    // End of variables declaration//GEN-END:variables
}
