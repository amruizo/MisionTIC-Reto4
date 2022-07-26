
package Vistas;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ShowUserForm extends javax.swing.JDialog {
    //Declaracion de atributos 
    Conexion conexion = new Conexion();
    Connection connection;
    Statement st;
    ResultSet rs;
    

    public ShowUserForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //Centrar vista 
        this.setLocationRelativeTo(parent);
    }

    //Método para recibir los datos de la tabla User Name 
    public void receiveData(int idEmp, String nombreEmp, String apellidos, String TipoDocumento, String documento, String correo, String sucursal){
        System.out.println(nombreEmp + " " + documento + " " +TipoDocumento+" "+correo );
        txtName.setText(nombreEmp);
        txtLastName.setText(apellidos);
        txtDocument_Type.setText(TipoDocumento);
        txtDocument.setText(documento);
        txtEmail.setText(correo);
        txtSucursal.setText(sucursal);
    }
    
    //Método para actualizar empleados (nombre, Apellido y correo)
    public void updateEmpleado(){
        String document = txtDocument.getText();
        String queryIdEmpleado = "SELECT idEmp FROM empleado WHERE documento = '"+document+"';";
        try{
            connection = conexion.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery(queryIdEmpleado);
            while(rs.next()){
                int idEmp = rs.getInt("idEmp");
                String name = txtName.getText();
                String lastname = txtLastName.getText();
                String email = txtEmail.getText();
                if(name.isEmpty()){
                    JOptionPane.showMessageDialog(this, "El nombre del empleado es un campo requerido.", "", JOptionPane.WARNING_MESSAGE);
                    }else if(lastname.isEmpty()){
                        JOptionPane.showMessageDialog(this, "El apellido del empleado es un campo requerido.", "", JOptionPane.WARNING_MESSAGE);
                    }else if(email.isEmpty()){
                        JOptionPane.showMessageDialog(this, "El correo del empleado es un campo requerido.", "", JOptionPane.WARNING_MESSAGE);
                    }else {
                        String query = "UPDATE empleado SET nombreEmp ='"+name+"', apellidos ='"+lastname+"', correo ='"+email+ "'WHERE idEmp ="+idEmp+";";
                        try{
                            connection = conexion.getConnection();
                            st = connection.createStatement();
                            st.executeUpdate(query);
                            JOptionPane.showMessageDialog(this, "Datos del empleado actualizados.", "",JOptionPane.INFORMATION_MESSAGE);
                        }catch(SQLException e){
                            System.out.println(e);
                            JOptionPane.showMessageDialog(this, "No fue posible actualizar los datos del empleado.", "",JOptionPane.ERROR_MESSAGE);
                        }
                    }
            }
        }catch(SQLException e){
            System.out.println(e);    
        }
    this.dispose();
    }
    
    public void DeleteEmpleado(){
        //Consultar empleado 
        String document = txtDocument.getText();
        String queryIdEmpleado = "SELECT idEmp FROM empleado WHERE documento = '"+document+"';";
       
        //Establecer conexion con la DB
        try{
            connection = conexion.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery(queryIdEmpleado);
            while(rs.next()){
                int idEmp = rs.getInt("idEmp");
                String queryDelete = "DELETE FROM empleado WHERE documento ='"+document+"';";
                try{
                    st.executeUpdate(queryDelete);
                    JOptionPane.showMessageDialog(this, "El empleado ha sido eliminado.");
                    this.dispose();
                }catch(SQLException e){
                    System.out.println(e);
                    JOptionPane.showMessageDialog(this, "No fue posible eliminar el empleado.", "",JOptionPane.ERROR_MESSAGE);
                }
            }
        }catch(SQLException e){
            System.out.println(e);
        }      
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSucursal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDocument = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtDocument_Type = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel1.setText("Sucursal");

        txtSucursal.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel2.setText("Nombre(s)");

        txtName.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel3.setText("Apellido(s)");

        txtLastName.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        txtLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastNameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel4.setText("Tipo Documento");

        jLabel5.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel5.setText("Documento");

        txtDocument.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        txtDocument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel6.setText("Correo");

        txtEmail.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N

        txtDocument_Type.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        txtDocument_Type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocument_TypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 133, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtSucursal)
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(txtDocument_Type, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtDocument))
                        .addGap(18, 18, 18))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(txtDocument, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDocument_Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btnUpdate.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/editUser.png"))); // NOI18N
        btnUpdate.setText("Actualizar");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/deleteUser.png"))); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/back .png"))); // NOI18N
        btnBack.setText("Regresar");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jLabel8.setText("Datos Empleado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(274, 274, 274)
                            .addComponent(jLabel8))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete)
                            .addComponent(btnBack))
                        .addGap(28, 28, 28))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastNameActionPerformed

    private void txtDocumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocumentActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        updateEmpleado();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DeleteEmpleado();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtDocument_TypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocument_TypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocument_TypeActionPerformed

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
            java.util.logging.Logger.getLogger(ShowUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ShowUserForm dialog = new ShowUserForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtDocument;
    private javax.swing.JTextField txtDocument_Type;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSucursal;
    // End of variables declaration//GEN-END:variables
}
