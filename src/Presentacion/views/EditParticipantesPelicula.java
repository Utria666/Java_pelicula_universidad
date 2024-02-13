/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentacion.views;

import Presentacion.Dashboard;
import Logica.PeliculaParticipanteService;
import Datos.PeliculaParticipante;
import Logica.PeliculaService;
import Datos.Pelicula;
import Logica.ParticipanteService;
import Datos.Participante;
import Logica.CargoParticipanteService;
import Datos.CargoParticipante;
import Logica.TipoPapelService;
import Datos.TipoPapel;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditParticipantesPelicula extends javax.swing.JPanel {
    
    private final PeliculaParticipanteService participantesPeliculaService;
    private final PeliculaService peliculaService;
    private final ParticipanteService participanteService;
    private final CargoParticipanteService cargoParticipanteService;
    private final TipoPapelService tipoPapelService;
    private Dashboard dashboard;
    
    public EditParticipantesPelicula(Dashboard dashboard) {
        this.dashboard = dashboard;
        initComponents();
        InitStyles();
        participantesPeliculaService = new PeliculaParticipanteService();
        peliculaService = new PeliculaService(); 
        participanteService = new ParticipanteService();
        cargoParticipanteService = new CargoParticipanteService();
        tipoPapelService = new TipoPapelService();
        pelicula();
        participante();
        cargoParticipante();
        tipoPapel();
    }
    
    private void InitStyles() {
        titulo.putClientProperty("FlatLaf.style", "font: bold $h1.regular.font");
        titulo.setForeground(Color.white);
        txtNamePelicula.putClientProperty("FlatLaf.style", "font: $h3.regular.font");
        txtNamePelicula.setForeground(Color.white);
        txtNombreParticipante.putClientProperty("FlatLaf.style", "font: $h3.regular.font");
        txtNombreParticipante.setForeground(Color.white);
        txtCargo.putClientProperty("FlatLaf.style", "font: $h3.regular.font");
        txtCargo.setForeground(Color.white);
        txtPapel.putClientProperty("FlatLaf.style", "font: $h3.regular.font");
        txtPapel.setForeground(Color.white);
        txtSueldo.putClientProperty("FlatLaf.style", "font: $h3.regular.font");
        txtSueldo.setForeground(Color.white);
    }
    
    private void pelicula() {
        List<Pelicula> listaPelicula = peliculaService.listarPeliculas();
        inputNombrePelicula.removeAllItems();
            for (Pelicula pelicula : listaPelicula) {
                inputNombrePelicula.addItem(pelicula.getId_pelicula() + " - " + pelicula.getTitulo_pelicula()); 
            }
    }
    
    
    private void participante() {
        List<Participante> listaParticipante = participanteService.listarTodosLosParticipantes();
        inputNombreParticipante.removeAllItems();
            for (Participante participante : listaParticipante) {
                inputNombreParticipante.addItem(participante.getId_participante() + " - " + participante.getNombre_participante()); 
            }
    }
    
    
    private void cargoParticipante() {
        List<CargoParticipante> listaCargo = cargoParticipanteService.listarCargos();
        inputCargo.removeAllItems();
            for (CargoParticipante cargoParticipante : listaCargo) {
                inputCargo.addItem(cargoParticipante.getId_cargo() + " - " + cargoParticipante.getNombre_cargo()); 
            }
    }    

    private void tipoPapel() {
        List<TipoPapel> listaTipoPapel = tipoPapelService.listarTiposPapel();
        inputPapel.removeAllItems();
            for (TipoPapel tipoPapel : listaTipoPapel) {
                inputPapel.addItem(tipoPapel.getId_papel() + " - " + tipoPapel.getNombre_papel()); 
            }
    } 
    

    public boolean validarEntradas() {
    // Validar inputSueldo
    if (inputSueldo.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "El campo 'Sueldo' no puede estar vacío.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    // Validar inputNombrePelicula
    if (inputNombrePelicula.getSelectedIndex() == -1) { // Suponiendo que el índice -1 representa ninguna selección
        JOptionPane.showMessageDialog(this, "Debe seleccionar una pelicula.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
        return false;
    }
        
    // Validar inputNombreParticipante
    if (inputNombreParticipante.getSelectedIndex() == -1) { // Suponiendo que el índice -1 representa ninguna selección
        JOptionPane.showMessageDialog(this, "Debe seleccionar una persona.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    // Validar inputCargo
    if (inputCargo.getSelectedIndex() == -1) { // Suponiendo que el índice -1 representa ninguna selección
        JOptionPane.showMessageDialog(this, "Debe seleccionar un cargo.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    
    // Validar inputPapel
    if (inputPapel.getSelectedIndex() == -1) { // Suponiendo que el índice -1 representa ninguna selección
        JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de papel.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
        return false;
    }


    // Si todas las validaciones son correctas
    return true;
    }
    
    private void limpiarCampos() {
        
        inputSueldo.setText("");
        
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg4 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        txtNamePelicula = new javax.swing.JLabel();
        txtCargo = new javax.swing.JLabel();
        inputSueldo = new javax.swing.JTextField();
        txtNombreParticipante = new javax.swing.JLabel();
        txtPapel = new javax.swing.JLabel();
        inputPapel = new javax.swing.JComboBox<>();
        btnRegresar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        inputNombrePelicula = new javax.swing.JComboBox<>();
        inputNombreParticipante = new javax.swing.JComboBox<>();
        inputCargo = new javax.swing.JComboBox<>();
        txtSueldo = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(750, 300));

        titulo.setText("Asignar un participante a una pelicula");

        txtNamePelicula.setText("Titulo Pelicula");

        txtCargo.setText("Cargo");

        txtNombreParticipante.setText("Nombre Participante");

        txtPapel.setText("Papel");

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

        txtSueldo.setText("Sueldo");

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
                        .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bg4Layout.createSequentialGroup()
                                .addComponent(txtNamePelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(319, 319, 319))
                            .addGroup(bg4Layout.createSequentialGroup()
                                .addComponent(txtCargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(278, 278, 278))
                            .addGroup(bg4Layout.createSequentialGroup()
                                .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputNombrePelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bg4Layout.createSequentialGroup()
                                .addComponent(inputNombreParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addComponent(txtNombreParticipante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPapel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(bg4Layout.createSequentialGroup()
                                .addComponent(inputPapel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 174, Short.MAX_VALUE))))))
            .addGroup(bg4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164))
            .addGroup(bg4Layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(txtSueldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(bg4Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(inputSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bg4Layout.setVerticalGroup(
            bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bg4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bg4Layout.createSequentialGroup()
                        .addComponent(txtNombreParticipante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4)
                        .addComponent(inputNombreParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPapel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputPapel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bg4Layout.createSequentialGroup()
                        .addComponent(txtNamePelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputNombrePelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(txtCargo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGap(29, 29, 29)
                .addComponent(txtSueldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
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
            ParticipantesPelicula participantesPeliculaPanel = new ParticipantesPelicula(dashboard);
            dashboard.ShowJPanel(participantesPeliculaPanel);
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (validarEntradas()) {
        Double sueldo = Double.parseDouble(inputSueldo.getText().trim());
        
        String nombrePeliculaSeleccionada = (String) inputNombrePelicula.getSelectedItem();
        int idPelicula = Integer.parseInt(nombrePeliculaSeleccionada.split(" - ")[0]);
        
        String nombreParticipanteSeleccionado = (String) inputNombreParticipante.getSelectedItem();
        int idParticipante = Integer.parseInt(nombreParticipanteSeleccionado.split(" - ")[0]);
        
        String nombreCargoSeleccionado = (String) inputCargo.getSelectedItem();
        int idCargo = Integer.parseInt(nombreCargoSeleccionado.split(" - ")[0]);   
        
        String papelSeleccionado = (String) inputPapel.getSelectedItem();
        int idPapel = Integer.parseInt(papelSeleccionado.split(" - ")[0]);    

        boolean exito = participantesPeliculaService.registrarPeliculaParticipante(idPelicula, idParticipante, idCargo, idPapel, sueldo);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Participante asignado con éxito.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al asignar un participante a una pelicula.", "Error de Registro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg4;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> inputCargo;
    private javax.swing.JComboBox<String> inputNombreParticipante;
    private javax.swing.JComboBox<String> inputNombrePelicula;
    private javax.swing.JComboBox<String> inputPapel;
    private javax.swing.JTextField inputSueldo;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel txtCargo;
    private javax.swing.JLabel txtNamePelicula;
    private javax.swing.JLabel txtNombreParticipante;
    private javax.swing.JLabel txtPapel;
    private javax.swing.JLabel txtSueldo;
    // End of variables declaration//GEN-END:variables
}
