package com.ema.proyectofinal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;




public class votoCandidato extends javax.swing.JFrame  implements Incidencia{
    
    
    int[] votos = new int[5];
    int votosEnBlanco = 0;
    int votosNulo = 0;
    JTextField dni;
    Clases.CConexion Conexion = new Clases.CConexion();
    
    public votoCandidato(JTextField dni) {
        this.dni = dni;
        initComponents();
        botones();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VOTAR");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("ELECCIONES 2023");
        jLabel1.setToolTipText("Elecciones Nacionales 2023");

        jRadioButton1.setText("Javier Milei");
        jRadioButton1.setMaximumSize(new java.awt.Dimension(297, 233));
        jRadioButton1.setMinimumSize(new java.awt.Dimension(297, 233));

        jRadioButton2.setText("Sergio Massa");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setText("Patricia Bullrich");

        jRadioButton4.setText("Juan Schiaretti");

        jRadioButton5.setText("Myriam Bregman");

        jRadioButton6.setText("Voto Blanco");

        jRadioButton7.setText("Voto Nulo");
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButton1.setText("VOTAR");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton5)
                            .addComponent(jRadioButton6)
                            .addComponent(jRadioButton7)
                            .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jRadioButton1.isSelected()){
            votos[0]++;
            jButton1.setEnabled(false);
            actualizarVoto(dni.getText(), true);
            registrarVoto(1,votos);
            registrarIncidencia("INFO","VOTÓ");
            JOptionPane.showMessageDialog(null, "Usted votó a Javier Milei.");
            this.setVisible(false);
        }
        else if (jRadioButton2.isSelected()){
            votos[4]++;
            jButton1.setEnabled(false);
            actualizarVoto(dni.getText(), true);
            registrarVoto(5,votos);
            registrarIncidencia("INFO","VOTÓ");
            JOptionPane.showMessageDialog(null, "Usted votó a Sergio Massa.");
            this.setVisible(false);
        }
        else if (jRadioButton3.isSelected()){
            votos[2]++;
            jButton1.setEnabled(false);
            actualizarVoto(dni.getText(), true);
            registrarVoto(3,votos);
            registrarIncidencia("INFO","VOTÓ");
            JOptionPane.showMessageDialog(null, "Usted votó a Patricia Bullrich.");
            this.setVisible(false);
        }
        else if (jRadioButton4.isSelected()){
            votos[1]++;
            jButton1.setEnabled(false);
            actualizarVoto(dni.getText(), true);
            registrarVoto(2,votos);
            registrarIncidencia("INFO","VOTÓ");
            JOptionPane.showMessageDialog(null, "Usted votó a Juan Schiaretti.");
            this.setVisible(false);
        }
        else if (jRadioButton5.isSelected()){
            votos[3]++;
            jButton1.setEnabled(false);
            actualizarVoto(dni.getText(), true);
            registrarVoto(4,votos);
            registrarIncidencia("INFO","VOTÓ");
            JOptionPane.showMessageDialog(null, "Usted votó a Myriam Bregman.");
            this.setVisible(false);
        }
        else if (jRadioButton6.isSelected()){
            votosEnBlanco++;
            jButton1.setEnabled(false);
            actualizarVoto(dni.getText(), true);
            registrarIncidencia("INFO","VOTÓ");
            JOptionPane.showMessageDialog(null, "Usted voto en Blanco, el voto será destinado al candidato con mayores votos.");
            this.setVisible(false);
        }
        else if (jRadioButton7.isSelected()){
            votosNulo++;
            jButton1.setEnabled(false);
            actualizarVoto(dni.getText(), true);
            registrarIncidencia("INFO","VOTÓ");
            JOptionPane.showMessageDialog(null, "Usted realizó un voto nulo, su voto no será destinado a ningun candidato.");
            this.setVisible(false);
        }
        else{
            JOptionPane.showMessageDialog(null, "Usted no eligió ninguna opcion.");
            registrarIncidencia("WARNING","NO ELIGIÓ NINGUNA OPCION");
        }
        
        Menu menu = new Menu();
        registrarIncidencia("INFO","SE ABRE EL MENU.");
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton7ActionPerformed
    
    private void actualizarVoto(String dni, boolean voto) {
        try {
            PreparedStatement ps;
            String consulta = "UPDATE padron SET voto = ? WHERE Dni = ?";
            ps = Conexion.estableceConexion().prepareStatement(consulta);
            ps.setBoolean(1, voto);
            ps.setString(2, dni);
            ps.executeUpdate();
            registrarIncidencia("INFO","VOTO REGISTRADO.");
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null,"ERROR "+e.toString());
            registrarIncidencia("ERROR","NO REGISTRO EL VOTO DEL USUARIO.");
        }
    }
    private void registrarVoto(int id, int [] votos){
        try{
            String consulta = "UPDATE candidatos SET Total = Total + ? WHERE Id = ?";
            PreparedStatement ps = Conexion.estableceConexion().prepareStatement(consulta);
        
            for (int i = 0; i < votos.length; i++) {
                ps.setInt(1, votos[i]);
                ps.setInt(2, i+1); // Asumiendo que los IDs de los candidatos empiezan en 1
                int rowsUpdated = ps.executeUpdate();
            }
            registrarIncidencia("INFO","VOTO REGISTRADO EN LA BASE DE DATOS.");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+e.toString());
            registrarIncidencia("ERROR","NO SE REGISTRO EL VOTO EN LA BASE DE DATOS.");
        }
    }
   

    
    private void botones(){
        buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
        buttonGroup.add(jRadioButton3);
        buttonGroup.add(jRadioButton4);
        buttonGroup.add(jRadioButton5);
        buttonGroup.add(jRadioButton6);   
    }
    
    @Override
    public void registrarIncidencia(String nivel, String mensaje) {
            try {
            String consulta = "INSERT INTO incidencias (Nivel, mensaje) VALUES (?, ?)";
            PreparedStatement ps = Conexion.estableceConexion().prepareStatement(consulta);
            ps.setString(1, nivel);
            ps.setString(2, mensaje);
            int rowsInserted = ps.executeUpdate();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+e.toString());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    // End of variables declaration//GEN-END:variables

}
