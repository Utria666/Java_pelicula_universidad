/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import Presentacion.views.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JPanel;


public class Dashboard extends javax.swing.JFrame {

    public Dashboard() {
        initComponents();
        InitStyles();
        SetDate();
        InitContent();
    }
    
    private void InitStyles(){
    dateText.putClientProperty("FlatLaf.style", "font: 24 $light.font");
    dateText.setForeground(Color.white);
    }
    
    private void SetDate() {
    LocalDate now = LocalDate.now();
    Locale spanishLocale = new Locale("es", "ES");
    dateText.setText(now.format(DateTimeFormatter.ofPattern("'Hoy es' EEEE dd 'de' MMMM 'de' yyyy", spanishLocale)));
    }
    
    public enum PanelName {
    PRINCIPAL,
    PELICULA,
    PARTICIPANTE,
    PARTICIPANTESPELICULA,
    PREMIOS,
    CREATEPELICULA,
    EDITPELICULA,
    }
    
    public void navigateTo(PanelName panelName) {
    JPanel panelToShow;
        switch (panelName) {
            case PRINCIPAL:
                panelToShow = new Principal();
                break;
            case PELICULA:
                panelToShow = new Pelicula(this); 
                break;
            case PARTICIPANTE:
                panelToShow = new Participante(this);
                break;
            case PARTICIPANTESPELICULA:
                panelToShow = new ParticipantesPelicula(this); 
                break;
            case PREMIOS:
                panelToShow = new Premios(this); 
                break;
            default:
                return;
        }
        ShowJPanel(panelToShow);
    }

    
    private void InitContent() {
        navigateTo(PanelName.PRINCIPAL);
    }
    
    public void ShowJPanel(JPanel p) {
    p.setSize(860, 500);
    p.setLocation(0,0);
    
    content.removeAll();
    content.add(p, BorderLayout.CENTER);
    content.revalidate();
    content.repaint();
    }
    
    public void navigateToEditPelicula(int idPelicula) {
        EditPelicula panelEditarPelicula = new EditPelicula(this);
        panelEditarPelicula.cargarDatosPelicula(idPelicula);
        ShowJPanel(panelEditarPelicula);
    }
    
    public void navigateToEditParticipante(int idParticipante) {
        EditParticipante panelEditarParticipante = new EditParticipante(this);
        panelEditarParticipante.cargarDatosParticipante(idParticipante);
        ShowJPanel(panelEditarParticipante);
    }

    public void navigateToEditPremioPelicula(int idPelicula) {
        EditPremios panelPremios = new EditPremios(this);
        panelPremios.cargarDatosPremiosPelicula(idPelicula);
        ShowJPanel(panelPremios);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        menus = new javax.swing.JPanel();
        btnPelicula = new javax.swing.JButton();
        btnPrincipal = new javax.swing.JButton();
        btnParticipante = new javax.swing.JButton();
        btnParticipantesPelicula = new javax.swing.JButton();
        btnPremios = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        dateText = new javax.swing.JLabel();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1140, 648));

        menus.setPreferredSize(new java.awt.Dimension(270, 640));

        btnPelicula.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPelicula.setText("Peliculas");
        btnPelicula.setBorder(null);
        btnPelicula.setBorderPainted(false);
        btnPelicula.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeliculaActionPerformed(evt);
            }
        });

        btnPrincipal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPrincipal.setText("Principal");
        btnPrincipal.setBorder(null);
        btnPrincipal.setBorderPainted(false);
        btnPrincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrincipalActionPerformed(evt);
            }
        });

        btnParticipante.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnParticipante.setText("Participantes");
        btnParticipante.setBorder(null);
        btnParticipante.setBorderPainted(false);
        btnParticipante.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnParticipante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParticipanteActionPerformed(evt);
            }
        });

        btnParticipantesPelicula.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnParticipantesPelicula.setText("Personajes de Peliculas");
        btnParticipantesPelicula.setBorder(null);
        btnParticipantesPelicula.setBorderPainted(false);
        btnParticipantesPelicula.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnParticipantesPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParticipantesPeliculaActionPerformed(evt);
            }
        });

        btnPremios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPremios.setText("Premios");
        btnPremios.setBorder(null);
        btnPremios.setBorderPainted(false);
        btnPremios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPremios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPremiosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menusLayout = new javax.swing.GroupLayout(menus);
        menus.setLayout(menusLayout);
        menusLayout.setHorizontalGroup(
            menusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnPelicula, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
            .addComponent(btnParticipante, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
            .addComponent(btnPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
            .addComponent(btnParticipantesPelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnPremios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menusLayout.setVerticalGroup(
            menusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menusLayout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(btnPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnParticipantesPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPremios, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(218, Short.MAX_VALUE))
        );

        header.setBackground(new java.awt.Color(44, 44, 44));
        header.setAutoscrolls(true);
        header.setPreferredSize(new java.awt.Dimension(841, 150));

        dateText.setText("Hoy es {dayname} {day} de {month} de {year}");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dateText)
                .addContainerGap(626, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(dateText)
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(menus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menus, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeliculaActionPerformed
        navigateTo(PanelName.PELICULA);
    }//GEN-LAST:event_btnPeliculaActionPerformed

    private void btnPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrincipalActionPerformed
        navigateTo(PanelName.PRINCIPAL);
    }//GEN-LAST:event_btnPrincipalActionPerformed

    private void btnParticipanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParticipanteActionPerformed
        navigateTo(PanelName.PARTICIPANTE);
    }//GEN-LAST:event_btnParticipanteActionPerformed

    private void btnParticipantesPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParticipantesPeliculaActionPerformed
        navigateTo(PanelName.PARTICIPANTESPELICULA);
    }//GEN-LAST:event_btnParticipantesPeliculaActionPerformed

    private void btnPremiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPremiosActionPerformed
        navigateTo(PanelName.PREMIOS);
    }//GEN-LAST:event_btnPremiosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatDarkPurpleIJTheme.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnParticipante;
    private javax.swing.JButton btnParticipantesPelicula;
    private javax.swing.JButton btnPelicula;
    private javax.swing.JButton btnPremios;
    private javax.swing.JButton btnPrincipal;
    private javax.swing.JPanel content;
    private javax.swing.JLabel dateText;
    private javax.swing.JPanel header;
    private javax.swing.JPanel menus;
    // End of variables declaration//GEN-END:variables
}
