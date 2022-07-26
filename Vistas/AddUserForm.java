//Angela Ruiz 

package Vistas;

import Modelo.*;
import Controlador.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class AddUserForm extends javax.swing.JDialog {
    //Instancia tipo ComboboxModel
    ComboBoxModel ModeloEnumTipoDocumento;
    
    Conexion conexion = new Conexion();
    Connection connection;
    Statement st;
    ResultSet rs;
    cbSucursal CbSucursales;
            

    public AddUserForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        //Iniciar modelo combobox
        ModeloEnumTipoDocumento = new DefaultComboBoxModel(TipoDocumentoEnum.values()); 
        initComponents();
        //Centrar la ventana
        this.setLocationRelativeTo(parent);
               
        //Inscancias de la lista desplegable de sucursales
        CbSucursales = new cbSucursal();
        ArrayList mListSucursales = new ArrayList();
        llenarComboboxSucursales();
        
    }

    public String llenarComboboxSucursales(){
        ArrayList mListSucursales = CbSucursales.getListSucursales();
        Iterator iterator = mListSucursales.iterator();
        while (iterator.hasNext()){
            Sucursal sucursal =(Sucursal)iterator.next();
            CbSucursal.addItem(sucursal);
        }
        String nombreSucursal = CbSucursal.getSelectedItem().toString();
        String query = "SELECT idSucursales FROM Sucursal WHERE nombreSucursal ='"+nombreSucursal+"';";
        return query;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        cbDocument_Type = new javax.swing.JComboBox<>();
        txtDocument = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        CbSucursal = new javax.swing.JComboBox<>();
        btnSubirFoto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSave_Emp = new javax.swing.JButton();
        btnCancel_Emp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel4.setText("Apellidos");

        jLabel5.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel5.setText("Tipo Documento");

        jLabel6.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel6.setText("Documento");

        jLabel7.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel7.setText("Correo");

        txtName.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N

        txtLastName.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N

        cbDocument_Type.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        cbDocument_Type.setModel(ModeloEnumTipoDocumento);
        cbDocument_Type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDocument_TypeActionPerformed(evt);
            }
        });

        txtDocument.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel9.setText("Sucursal");

        CbSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbSucursalActionPerformed(evt);
            }
        });

        btnSubirFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/newUser.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSubirFoto)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)))
                    .addComponent(jLabel3))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDocument_Type, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDocument, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(btnSubirFoto))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(cbDocument_Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDocument, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(CbSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jLabel2.setText("Formulario de Empleados ");

        btnSave_Emp.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        btnSave_Emp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/confirmIcon.png"))); // NOI18N
        btnSave_Emp.setText("Guardar");
        btnSave_Emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave_EmpActionPerformed(evt);
            }
        });

        btnCancel_Emp.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        btnCancel_Emp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/cancelIcon.png"))); // NOI18N
        btnCancel_Emp.setText("Cancelar");
        btnCancel_Emp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancel_EmpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(btnCancel_Emp, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(btnSave_Emp, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel_Emp)
                    .addComponent(btnSave_Emp))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbDocument_TypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDocument_TypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDocument_TypeActionPerformed

    private void btnSave_EmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave_EmpActionPerformed
        String name = txtName.getText();
        String lastname = txtLastName.getText();
        //Tipos de documentos CC|CE|LM|P|Otro
        String document_type = ModeloEnumTipoDocumento.getSelectedItem().toString();
        String document = txtDocument.getText();
        String email = txtEmail.getText();
        String sucursal = CbSucursal.getSelectedItem().toString();
        
        //Validar que existan campos vacios 
        if(name.isEmpty() || lastname.isEmpty() || document.isEmpty() || email.isEmpty()){
            JOptionPane.showMessageDialog(this, "Faltan campos por diligenciar.", "Registro", JOptionPane.WARNING_MESSAGE);
        }else{
            String queryIdSucursal = "SELECT idSucursal FROM Sucursal INNER JOIN empleado ON Sucursal.idSucursal = empleado.FK_idSucursal;";
            try{
                connection = conexion.getConnection();
                st = connection.createStatement();
                //Utilizado para las funciones de crear, eliminar y actualizar la informacion de los empleados
                rs = st.executeQuery(queryIdSucursal);
                while(rs.next()){
                    int idSucursal = rs.getInt("idSucursal");
                    String query = "INSERT INTO empleado(nombreEmp, apellidos, tipoDocumento, documento, correo, FK_idSucursal) VALUES ('"+name+"','"+lastname+"','"+document_type+"','"+document+"','"+email+"',"+idSucursal+")";
                    System.out.println(query);
                    try{
                        st.executeUpdate(query);
                        JOptionPane.showMessageDialog(this, "El usuario ha sido registrado.");
                    }catch(SQLException e){
                        System.out.println(e);
                        JOptionPane.showMessageDialog(this, "El usuario no ha sido registrado.","Empleado",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }catch(SQLException e){
                System.out.println(e);
            }
        this.dispose();
        }
    }//GEN-LAST:event_btnSave_EmpActionPerformed

    private void btnCancel_EmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancel_EmpActionPerformed
        this.dispose(); 
    }//GEN-LAST:event_btnCancel_EmpActionPerformed

    private void CbSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbSucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbSucursalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddUserForm dialog = new AddUserForm(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<Sucursal> CbSucursal;
    private javax.swing.JButton btnCancel_Emp;
    private javax.swing.JButton btnSave_Emp;
    private javax.swing.JButton btnSubirFoto;
    private javax.swing.JComboBox<String> cbDocument_Type;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtDocument;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

    private void ListEmpleados() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
