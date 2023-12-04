package com.ema.proyectofinal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class consultaDatos extends javax.swing.JFrame implements Incidencia {
    
    Clases.CConexion Conexion = new Clases.CConexion();
    
    public consultaDatos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CONSULTA TU PADRON");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PADRON ELECTORAL");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ingresá el D.N.I:");

        txtDNI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDNI.setToolTipText("Ingresa DNI, solo numeros.");
        txtDNI.setBorder(null);

        btnConsultar.setText("CONSULTA");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDNI, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnConsultar)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        validarUsuario(txtDNI);
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void validarUsuario(JTextField dni){
        
        String texto = dni.getText();
        
        try{
            
            int documento = Integer.parseInt(texto);
            
            try{
                ResultSet rs;
                PreparedStatement ps;
            
                String consulta = "select * from padron where DNI = (?) ";
            
                ps = Conexion.estableceConexion().prepareStatement(consulta);
                ps.setString(1,dni.getText());
            
                rs = ps.executeQuery();
            
                if(rs.next()){ 
                    if(rs.getBoolean("voto")) {
                        JOptionPane.showMessageDialog(null,"Usted ya ha votado y no puede votar nuevamente.");
                        registrarIncidencia("WARNING","INGRESÓ UN DNI YA REGISTRADO");
                        limpiarTxt(dni);
                    } else {
                        String datosUsuario = "USTED ESTÁ EN EL PADRÓN.\n" +
                                          "Nombre: " + rs.getString("Nombre") + "\n" +
                                          "Apellido: " + rs.getString("Apellido") + "\n" +
                                          "DNI: " + rs.getString("DNI");
                        JOptionPane.showMessageDialog(null, datosUsuario);
                        registrarIncidencia("INFO","SE ENCONTRARON LOS DATOS");
                        votoCandidato candidato = new votoCandidato(dni);  // Pasa 'dni' al constructor de 'votoCandidato'
                        registrarIncidencia("INFO","INGRESO A VOTO CANDIDATO");
                        candidato.setVisible(true);
                        candidato.setLocationRelativeTo(null);
                        this.dispose(); 
                }}else{
                    JOptionPane.showMessageDialog(null,"El DNI es incorrecto,vuelva a intentar");
                    registrarIncidencia("WARNING","DNI INCORRECTO");
                    limpiarTxt(dni);
                }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"ERROR "+e.toString());
                }
            }catch(Exception e){   
            JOptionPane.showMessageDialog(null,"ERROR, No se permiten caracteres ");
            registrarIncidencia("ERROR","INGRESO CARACTERES INVALIDOS");
            limpiarTxt(dni);
        }
              
    }
    private void limpiarTxt(JTextField dni){
        dni.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtDNI;
    // End of variables declaration//GEN-END:variables

    @Override
    public void registrarIncidencia(String nivel, String mensaje) {
            try {
            String consulta = "INSERT INTO incidencias (Nivel, Mensaje) VALUES (?, ?)";
            PreparedStatement ps = Conexion.estableceConexion().prepareStatement(consulta);
            ps.setString(1, nivel);
            ps.setString(2, mensaje);
            int rowsInserted = ps.executeUpdate();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error"+e.toString());
        }
    }
}
