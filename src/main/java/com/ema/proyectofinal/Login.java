package com.ema.proyectofinal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends javax.swing.JFrame implements Incidencia{
    Clases.CConexion Conexion = new Clases.CConexion();
    public Login() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsuario = new javax.swing.JTextField();
        txtContrasenia = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Apertura");

        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setToolTipText("Ingrese Usuario");
        txtUsuario.setBorder(null);
        txtUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        txtContrasenia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtContrasenia.setToolTipText("Ingrese Contraseña");
        txtContrasenia.setBorder(null);
        txtContrasenia.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButton1.setText("INGRESAR");
        jButton1.setToolTipText("Logear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuario:");

        jLabel2.setText("Contraseña:");

        jLabel3.setFont(new java.awt.Font("Consolas", 2, 18)); // NOI18N
        jLabel3.setText("ELECCIONES 2023: APERTURA");
        jLabel3.setToolTipText("Elecciones Nacionales 22 de Septiembre");

        jButton2.setText("LIMPIAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(txtUsuario)
                    .addComponent(txtContrasenia)
                    .addComponent(jLabel1)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(txtUsuario)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(txtContrasenia)
                .addGap(14, 14, 14)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtUsuario.setText("");
        txtContrasenia.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        validarUsuario(txtUsuario, txtContrasenia);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed
    
    private void validarUsuario(JTextField usuario,JPasswordField contrasenia){
        try{
            ResultSet rs;
            PreparedStatement ps;
            String consultaSQL = " SELECT * FROM login WHERE usuario=(?) and Contrasenia = ? ";
            ps = Conexion.estableceConexion().prepareStatement(consultaSQL);
            ps.setString(1,usuario.getText());
            String contra = String.valueOf(contrasenia.getPassword());
            ps.setString(2, contra);
             rs = ps.executeQuery();

            if(rs.next()){ 
                //boolean sesionIniciada = rs.getBoolean("sesion_iniciada");
                //if (!sesionIniciada) {
                registrarIncidencia("INFO","NUEVO ACCESO AL SISTEMA");
                JOptionPane.showMessageDialog(null,"El usuario es correcto");
                Menu menu = new Menu();
                menu.setVisible(true);
                menu.setLocationRelativeTo(null);
                this.dispose();
                /*consultaDatos consultar = new consultaDatos();
                consultar.setVisible(true);
                consultar.setLocationRelativeTo(null);
                this.dispose();*/
                registrarAcceso(usuario.getText(), Conexion.estableceConexion());
                //}else {
                //    JOptionPane.showMessageDialog(null,"El usuario ya ha iniciado sesión");
                //}
            }else{
                JOptionPane.showMessageDialog(null,"El usuario es incorrecto,vuelva a intentar");
                limpiarTxt(usuario,contrasenia);
            }
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR "+e.toString());
        }
    }
    private void registrarAcceso(String ingresoUsuario, Connection conn) {
        String sql = "UPDATE usuarios SET hora_acceso = ?, ultimo_acceso = ?, WHERE usuario = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            LocalDateTime now = LocalDateTime.now();
            pstmt.setObject(1, now);
            pstmt.setObject(2, now);
            //pstmt.setBoolean(3, true);
            pstmt.setString(3, ingresoUsuario);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }   
    private void limpiarTxt(JTextField usuario, JPasswordField contrasenia){
        usuario.setText("");
        contrasenia.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

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
}
