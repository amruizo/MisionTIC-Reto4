
package Vistas;

import Controlador.*;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class GestionarSucursalesForm extends javax.swing.JDialog {
    ComboBoxModel MEnumDepartamento, MEnumTipoCalle, MEnumZona;
    
    Conexion conexion = new Conexion();
    Connection connection;
    Statement st;
    ResultSet rs;

    public GestionarSucursalesForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        MEnumDepartamento = new DefaultComboBoxModel(EnumDepartamento.values()); 
        MEnumTipoCalle = new DefaultComboBoxModel(EnumTipoCalle.values()); 
        MEnumZona = new DefaultComboBoxModel(EnumZona.values()); 
        
        initComponents();
        this.setLocationRelativeTo(this);
    }
    
    public void recibirDatosSucursal(int idSucursal){
        String query ="SELECT nombreSucursal, nombreDepartamento, zona, tipoCalle, numero1, numero2, numero3 FROM Sucursal INNER JOIN Direccion WHERE FK_idDireccion = idDireccion AND idSucursal = "+idSucursal+";";
        System.out.println(query);
        try{
            connection = conexion.getConnection();
            st = connection.createStatement();
            rs =st.executeQuery(query);
            while(rs.next()){
                txtSucursal.setText(rs.getString("nombreSucursal"));
                txtNum1.setText(rs.getString("numero1"));
                txtNum2.setText(rs.getString("numero2"));
                txtNum3.setText(rs.getString("numero3"));
                MEnumDepartamento.setSelectedItem(rs.getString("nombreDepartamento"));
                MEnumTipoCalle.setSelectedItem(rs.getString("tipoCalle"));
                MEnumZona.setSelectedItem(rs.getString("zona"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    
    public void actualizarSucursal(){
        String nombreSucursal = txtSucursal.getText();
        String queryIdSucursal =  "SELECT idSucursal, idDireccion FROM Sucursal INNER JOIN Direccion WHERE FK_idDireccion = idDireccion AND nombreSucursal = '"+nombreSucursal+"';";
        try{
            connection = conexion.getConnection();
            st = connection.createStatement();
            rs =st.executeQuery(queryIdSucursal);
            while(rs.next()){
                int idSucursal = rs.getInt("idSucursal");
                int idDireccion = rs.getInt("idDireccion");
                String sucursal = txtNuevaSucursal.getText();
                if(sucursal.isEmpty()){
                    sucursal = txtSucursal.getText();
                }else{
                    sucursal = sucursal;
                    String queryActualizarSucursal = "UPDATE Sucursal SET nombreSucursal='"+sucursal+ "'WHERE idSucursal = "+idSucursal+ ";";
                    try{
                        st.executeUpdate(queryActualizarSucursal);
                    }catch(SQLException e){
                        System.out.println(e);
                    }
                }
            System.out.println(sucursal);
            String numero1 =txtNum1.getText();
            String numero2 =txtNum2.getText();
            String numero3 =txtNum3.getText();
            String departamento = cbDepartamentos.getSelectedItem().toString();
            String zona = cbZona.getSelectedItem().toString();
            String tipoCalle = cbTipoCalle.getSelectedItem().toString();
            String queryActualizar = "UPDATE Direccion SET `zona`='" + zona + "',`tipoCalle`='" +tipoCalle+"',`numero1`='"+numero1+"',`numero2`='"+numero2+"',`numero3`='"+numero3+"',`nombreDepartamento`='"+departamento+"' WHERE idDireccion = "+idDireccion+";";
                try{
                    st.executeUpdate(queryActualizar);
                    this.dispose();
                }catch(SQLException e){
                    System.out.println(e);
                }
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void eliminarSucursal(){
       String nombreSucursal = txtSucursal.getText();
       String queryIdSucursal = "SELECT idDireccion, idSucursal FROM Sucursal INNER JOIN Direccion WHERE sucursal.FK_idDireccion = direccion.idDireccion AND sucursal.nombreSucursal = '"+nombreSucursal+"';";
       try{
           connection = conexion.getConnection();
           st = connection.createStatement();
           rs =st.executeQuery(queryIdSucursal);
           while(rs.next()){
               int idSucursal = rs.getInt("idSucursal");
               int idDireccion = rs.getInt("idDireccion");
               String queryEliminarS = "DELETE FROM Sucursal WHERE idSucursal = "+idSucursal+";";
               try{
                   st.executeUpdate(queryEliminarS);
                   String queryEliminarD = "DELETE FROM Direccion WHERE idDireccion="+idDireccion+";";
                   try{
                       st.executeUpdate(queryEliminarD);
                   }catch(SQLException e){
                       System.out.println(e);
                   }
                   this.dispose();
                   JOptionPane.showMessageDialog(this,"La Sucursal ha sido eliminada");
               }catch(SQLException e){
                  System.out.println(e); 
                  JOptionPane.showMessageDialog(this,"o se logro actualiar la información de la sucursal", " ", JOptionPane.WARNING_MESSAGE);
               }
           }
       }catch(SQLException e){
           System.out.println(e);
       }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSucursal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbDepartamentos = new javax.swing.JComboBox<>();
        cbTipoCalle = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbZona = new javax.swing.JComboBox<>();
        txtNum1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNum2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnActualizarSuc = new javax.swing.JButton();
        btnEliminarSuc = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtNum3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNuevaSucursal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel1.setText("Sucursal");

        txtSucursal.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel3.setText("Departamento");

        jLabel4.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel4.setText("Tipo Calle");

        cbDepartamentos.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        cbDepartamentos.setModel(MEnumDepartamento);

        cbTipoCalle.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        cbTipoCalle.setModel(MEnumTipoCalle);

        jLabel5.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel5.setText("Zona");

        cbZona.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        cbZona.setModel(MEnumZona);

        txtNum1.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        txtNum1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNum1ActionPerformed(evt);
            }
        });

        txtNum2.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel7.setText("-");

        btnActualizarSuc.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        btnActualizarSuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/editUser.png"))); // NOI18N
        btnActualizarSuc.setText("Actualizar");
        btnActualizarSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarSucActionPerformed(evt);
            }
        });

        btnEliminarSuc.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        btnEliminarSuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/deleteUser.png"))); // NOI18N
        btnEliminarSuc.setText("Eliminar");
        btnEliminarSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarSucActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/back .png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel8.setText("#");

        txtNum3.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jLabel10.setText("Actualizar Sucursal ");

        jLabel2.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel2.setText("Nueva Sucursal");

        txtNuevaSucursal.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnActualizarSuc)
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(btnEliminarSuc)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNuevaSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(cbTipoCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtNum1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(btnCancelar)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel8)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtNum2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel7)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtNum3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))))))))))
                .addGap(186, 186, 186)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txtSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNuevaSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbTipoCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNum1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtNum2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtNum3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizarSuc)
                    .addComponent(btnEliminarSuc)
                    .addComponent(btnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNum1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNum1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNum1ActionPerformed

    private void btnEliminarSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarSucActionPerformed
        eliminarSucursal();
    }//GEN-LAST:event_btnEliminarSucActionPerformed

    private void btnActualizarSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarSucActionPerformed
        actualizarSucursal();
    }//GEN-LAST:event_btnActualizarSucActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionarSucursalesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarSucursalesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarSucursalesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarSucursalesForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GestionarSucursalesForm dialog = new GestionarSucursalesForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarSuc;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarSuc;
    private javax.swing.JComboBox<String> cbDepartamentos;
    private javax.swing.JComboBox<String> cbTipoCalle;
    private javax.swing.JComboBox<String> cbZona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtNuevaSucursal;
    private javax.swing.JTextField txtNum1;
    private javax.swing.JTextField txtNum2;
    private javax.swing.JTextField txtNum3;
    private javax.swing.JTextField txtSucursal;
    // End of variables declaration//GEN-END:variables
}
