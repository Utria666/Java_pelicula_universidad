/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentacion.views;

import Presentacion.Dashboard;
import Logica.PremioPeliculaService;
import Logica.PremioService;
import Datos.Premio;
import Logica.PeliculaService;
import Datos.Pelicula;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;

public class EditPremios extends javax.swing.JPanel {
    
    private final PremioPeliculaService premioPeliculaService;
    private final PeliculaService peliculaService;
    private final PremioService premioService;
    private int idPeliculaActual;
    private Dashboard dashboard;
    
    public EditPremios(Dashboard dashboard) {
        this.dashboard = dashboard;
        initComponents();
        InitStyles();
        premioPeliculaService = new PremioPeliculaService();
        peliculaService = new PeliculaService(); 
        premioService = new PremioService();
        pelicula();
        participante();
    }
    
    private void InitStyles() {
        titulo.putClientProperty("FlatLaf.style", "font: bold $h1.regular.font");
        titulo.setForeground(Color.white);
        txtPremios.putClientProperty("FlatLaf.style", "font: $h3.regular.font");
        txtPremios.setForeground(Color.white);
        txtPeliculas.putClientProperty("FlatLaf.style", "font: $h3.regular.font");
        txtPeliculas.setForeground(Color.white);
        txtNombreCertamen.putClientProperty("FlatLaf.style", "font: $h3.regular.font");
        txtNombreCertamen.setForeground(Color.white);
        txtCiudad.putClientProperty("FlatLaf.style", "font: $h3.regular.font");
        txtCiudad.setForeground(Color.white);
    }
    
    private void pelicula() {
        List<Pelicula> listaPelicula = peliculaService.listarPeliculas();
        inputPeliculas.removeAllItems();
            for (Pelicula pelicula : listaPelicula) {
                inputPeliculas.addItem(pelicula.getId_pelicula() + " - " + pelicula.getTitulo_pelicula()); 
            }
    }
    
    
    private void participante() {
        List<Premio> listaPremios= premioService.listarPremios();
        inputPremios.removeAllItems();
            for (Premio premios : listaPremios) {
                inputPremios.addItem(premios.getId_premio()+ " - " +  premios.getNombre_premio()); 
            }
    }
    
    public void cargarDatosPremiosPelicula(int idPelicula) {
        var premioPelicula = premioPeliculaService.obtenerPremioPeliculaPorId(idPelicula);
        if (premioPelicula != null) {
            this.idPeliculaActual = idPelicula;
            inputCiudad.setText(premioPelicula.getCiudad_celebracion());
            inputNombreCertamen.setText(premioPelicula.getNombre_certamen());

            for (int i = 0; i < inputPremios.getItemCount(); i++) {
                if (inputPremios.getItemAt(i).startsWith(premioPelicula.getPremio().getId_premio() + " -")) {
                    inputPremios.setSelectedIndex(i);
                    break;
                }
            }

            for (int i = 0; i < inputPeliculas.getItemCount(); i++) {
                if (inputPeliculas.getItemAt(i).startsWith(premioPelicula.getPelicula().getId_pelicula() + " -")) {
                    inputPeliculas.setSelectedIndex(i);
                    break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Premio película no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    public boolean validarEntradas() {
        // Validar inputNombreCertamen
        if (inputNombreCertamen.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo 'Nombre del certamen' no puede estar vacío.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validar inputCiudad
        if (inputCiudad.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo 'Ciudad de celebracion' no puede estar vacío.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validar inputPremios
        if (inputPremios.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un premio.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validar inputPeliculas
        if (inputPeliculas.getSelectedIndex() == -1) { 
            JOptionPane.showMessageDialog(this, "Debe seleccionar una pelicula.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    // Si todas las validaciones son correctas
    return true;
    }
    
    private void limpiarCampos() {
        inputNombreCertamen.setText("");
        inputCiudad.setText("");
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg4 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        txtPremios = new javax.swing.JLabel();
        txtNombreCertamen = new javax.swing.JLabel();
        txtPeliculas = new javax.swing.JLabel();
        txtCiudad = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        inputPremios = new javax.swing.JComboBox<>();
        inputPeliculas = new javax.swing.JComboBox<>();
        inputCiudad = new javax.swing.JTextField();
        inputNombreCertamen = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(750, 300));

        titulo.setText("Asignar un participante a una pelicula");

        txtPremios.setText("Premios");

        txtNombreCertamen.setText("Nombre del certamen");

        txtPeliculas.setText("Peliculas");

        txtCiudad.setText("Ciudad de celebracion");

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
                        .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(256, 256, 256))
                    .addGroup(bg4Layout.createSequentialGroup()
                        .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bg4Layout.createSequentialGroup()
                                .addComponent(txtPremios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(319, 319, 319))
                            .addGroup(bg4Layout.createSequentialGroup()
                                .addComponent(txtNombreCertamen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(278, 278, 278))
                            .addGroup(bg4Layout.createSequentialGroup()
                                .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputPremios, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inputNombreCertamen, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bg4Layout.createSequentialGroup()
                                .addComponent(inputCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(bg4Layout.createSequentialGroup()
                                .addComponent(inputPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(174, Short.MAX_VALUE))
                            .addComponent(txtPeliculas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
            .addGroup(bg4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(txtPeliculas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(4, 4, 4)
                        .addComponent(inputPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCiudad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(bg4Layout.createSequentialGroup()
                        .addComponent(txtPremios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputPremios, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(txtNombreCertamen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputNombreCertamen, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)))
                .addGroup(bg4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(141, 141, 141))
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
            Premios premiosPanel = new Premios(dashboard);
            dashboard.ShowJPanel(premiosPanel);
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (validarEntradas()) {
        String nombreCertemen = inputNombreCertamen.getText().trim();
        String ciudad = inputCiudad.getText().trim();
        
        String nombrePremiosSeleccionado = (String) inputPremios.getSelectedItem();
        int idPremios = Integer.parseInt(nombrePremiosSeleccionado.split(" - ")[0]);
        
        String nombrePeliculasSeleccionada = (String) inputPeliculas.getSelectedItem();
        int idPeliculas = Integer.parseInt(nombrePeliculasSeleccionada.split(" - ")[0]);
          

        boolean exito = premioPeliculaService.actualizarPremioPelicula(idPremios, nombreCertemen, ciudad, idPeliculas);

            if (exito) {
                JOptionPane.showMessageDialog(this, "El premio se ha actualizada con éxito.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar el premio.", "Error de Registro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg4;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JTextField inputCiudad;
    private javax.swing.JTextField inputNombreCertamen;
    private javax.swing.JComboBox<String> inputPeliculas;
    private javax.swing.JComboBox<String> inputPremios;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel txtCiudad;
    private javax.swing.JLabel txtNombreCertamen;
    private javax.swing.JLabel txtPeliculas;
    private javax.swing.JLabel txtPremios;
    // End of variables declaration//GEN-END:variables
}
