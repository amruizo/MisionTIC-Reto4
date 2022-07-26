
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
import javax.swing.table.DefaultTableModel;

public final class UserMenu extends javax.swing.JFrame {
    //Iniciando el modelo de lista desplegable
    ComboBoxModel ModeloEnumDepartamento, ModeloEnumTipoCalle, ModeloEnumZona;
    
    Conexion conexion = new Conexion();
    Connection connection;
    Statement st;
    ResultSet rs;
    DefaultTableModel contenidoTablaEmpleados, contenidoTablaDepartamento;
    
    //Constructor de la la clase
    public UserMenu() {
         
        //Iniciar los modelos combobox
        ModeloEnumDepartamento = new DefaultComboBoxModel(EnumDepartamento.values()); 
        ModeloEnumTipoCalle = new DefaultComboBoxModel(EnumTipoCalle.values()); 
        ModeloEnumZona = new DefaultComboBoxModel(EnumZona.values()); 
        
        initComponents();
        //Centradno la JFrame
        this.setLocationRelativeTo(this);
        //Iniciando los metodos de la clase 
        ListEmpleados();
        ListDepartamentos();
    }

    private void ListEmpleados(){
    String filtroBusqueda = txtSearchEmp.getText();
    //Si no hay nada en el campo de busqueda se muetsrab todos los empleados 
    if(filtroBusqueda.isEmpty()){
        String queryConsulta = "SELECT nombreEmp,apellidos,tipoDocumento,documento,correo, nombreSucursal FROM empleado INNER JOIN Sucursal ON empleado.FK_idSucursal = Sucursal.idSucursal";
            try{
                connection = conexion.getConnection();
                //Creamos la consulta query a la base de datos 
                st = connection.createStatement();
                rs =st.executeQuery(queryConsulta);
                //Asignar los datos en un objeto los datos que devuelve cada registro
                Object [] empleado = new Object[6];
                contenidoTablaEmpleados = (DefaultTableModel)tblEmpleados.getModel();
                //Resultado de la consulta es determina la cantidad de empleados
                while(rs.next()){
                    empleado[0] = rs.getString("nombreEmp");
                    empleado[1] = rs.getString("apellidos");
                    empleado[2] = rs.getString("tipoDocumento");
                    empleado[3] = rs.getString("documento");
                    empleado[4] = rs.getString("Correo");
                    empleado[5] = rs.getString("nombreSucursal");
                    //En la tabla creamos fila con los atributos del empleado 
                    contenidoTablaEmpleados.addRow(empleado);
                    tblEmpleados.setModel(contenidoTablaEmpleados);
                         System.out.println("nombre: "+empleado[0]+", apellido: "+empleado[1]+", documento: "+empleado[2]+" "
                            +empleado[3]+" ,correo"+empleado[4]+", Sucursal: "+empleado[5]);
                }
        
                }catch(SQLException e){
                    System.out.println(e);
                    System.out.println("Error");
                }
    }else{
        String query = "SELECT nombreEmp,apellidos,tipoDocumento,documento,correo, nombreSucursal FROM empleado INNER JOIN Sucursal WHERE empleado.FK_idSucursal = Sucursal.idSucursal AND nombreEmp LIKE '%" + filtroBusqueda + "%' OR apellidos LIKE '%" + filtroBusqueda +"%'";
        try{
            connection = conexion.getConnection();
            //Creamos la consulta query a la base de datos 
            st = connection.createStatement();
            rs =st.executeQuery(query);
            Object [] empleado = new Object[6];
                contenidoTablaEmpleados = (DefaultTableModel)tblEmpleados.getModel();
                //Resultado de la consulta es determina la cantidad de empleados
                while(rs.next()){
                    empleado[0] = rs.getString("nombreEmp");
                    empleado[1] = rs.getString("apellidos");
                    empleado[2] = rs.getString("tipoDocumento");
                    empleado[3] = rs.getString("documento");
                    empleado[4] = rs.getString("Correo");
                    empleado[5] = rs.getString("nombreSucursal");
                //En la tabla creamos fila con los atributos del empleado 
                    contenidoTablaEmpleados.addRow(empleado);
                    tblEmpleados.setModel(contenidoTablaEmpleados);
                }
                
        }catch(SQLException e){
        System.out.println(e);
        System.out.println("Error");
        }
    }
       
    }
    
    private void DeleteTableRecords(){
        for(int i = 0; i < tblEmpleados.getRowCount(); i++){
            contenidoTablaEmpleados.removeRow(i);
            //Menos filar por eliminar 
            i = i-1;
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbDepartamento = new javax.swing.JComboBox<>();
        cbZona = new javax.swing.JComboBox<>();
        cbTipoCalle = new javax.swing.JComboBox<>();
        txtnum1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtnum2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtnum3 = new javax.swing.JTextField();
        btnSaveSuc = new javax.swing.JButton();
        btnVerSucursal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDepartamentos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSearchSucursal = new javax.swing.JButton();
        txtSearchSucursal = new javax.swing.JTextField();
        btnAddEmpleado = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        btnAddUser1 = new javax.swing.JButton();
        btnColsult1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtSearchEmp = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setFont(new java.awt.Font("Ubuntu Light", 0, 16)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel7.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel7.setText("Departamento");

        jLabel8.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel8.setText("Zona");

        jLabel9.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel9.setText("Tipo de Calle");

        cbDepartamento.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        cbDepartamento.setModel(ModeloEnumDepartamento);
        cbDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDepartamentoActionPerformed(evt);
            }
        });

        cbZona.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        cbZona.setModel(ModeloEnumZona);

        cbTipoCalle.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        cbTipoCalle.setModel(ModeloEnumTipoCalle);

        txtnum1.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N

        txtnum2.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel11.setText("#");

        jLabel12.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel12.setText("-");

        txtnum3.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N

        btnSaveSuc.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        btnSaveSuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/confirmIcon.png"))); // NOI18N
        btnSaveSuc.setText("Guardar");
        btnSaveSuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveSucActionPerformed(evt);
            }
        });

        btnVerSucursal.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        btnVerSucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/showUser.png"))); // NOI18N
        btnVerSucursal.setText("Ver Sucursales");
        btnVerSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerSucursalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveSuc, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnVerSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cbTipoCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtnum1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(cbDepartamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtnum2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtnum3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbTipoCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnum1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtnum2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtnum3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSaveSuc)
                            .addComponent(btnVerSucursal))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tblDepartamentos.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        tblDepartamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sucursal", "Departamento", "Dirección"
            }
        ));
        tblDepartamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDepartamentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDepartamentos);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jLabel3.setText("Sucursales Activas");

        btnSearchSucursal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/vector-find-icon1.png"))); // NOI18N
        btnSearchSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchSucursalActionPerformed(evt);
            }
        });

        txtSearchSucursal.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        txtSearchSucursal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchSucursalActionPerformed(evt);
            }
        });

        btnAddEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/AddEmpleado.png"))); // NOI18N
        btnAddEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(txtSearchSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearchSucursal)
                        .addGap(110, 110, 110)
                        .addComponent(btnAddEmpleado))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(391, 391, 391)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 897, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSearchSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearchSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddEmpleado)))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );

        jTabbedPane1.addTab("Sucursales", jPanel1);

        jPanel8.setBackground(new java.awt.Color(153, 153, 153));

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));

        tblEmpleados.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido(s)", "Tipo de Documento", "Documento", "Correo", "Sucursal"
            }
        ));
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblEmpleados);

        btnAddUser1.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        btnAddUser1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/avatar.png"))); // NOI18N
        btnAddUser1.setText("Nuevo");
        btnAddUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUser1ActionPerformed(evt);
            }
        });

        btnColsult1.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        btnColsult1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/showUser.png"))); // NOI18N
        btnColsult1.setText("Consultar");
        btnColsult1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColsult1ActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/logo.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jLabel5.setText("Empleados");

        jLabel6.setFont(new java.awt.Font("Ubuntu Light", 1, 18)); // NOI18N
        jLabel6.setText("MisiónTIC 2022");

        jLabel1.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel1.setText("Nombre");

        txtSearchEmp.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        txtSearchEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchEmpActionPerformed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/buscar.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(371, 371, 371)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(358, 358, 358)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(0, 27, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 895, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnColsult1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearchEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnColsult1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Empleados", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 983, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        DeleteTableRecords();
        ListEmpleados();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtSearchEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchEmpActionPerformed

    private void btnColsult1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColsult1ActionPerformed
        ListEmpleados();
    }//GEN-LAST:event_btnColsult1ActionPerformed

    private void btnAddUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUser1ActionPerformed
        AddUserForm addUserForm = new AddUserForm(this, true);
        addUserForm.setVisible(true);
        DeleteTableRecords();
        ListEmpleados();
    }//GEN-LAST:event_btnAddUser1ActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        //Capturar el número de fila seleccionada
        int row = tblEmpleados.getSelectedRow();
        System.out.println("Fila Seleccionada: "+row);
        //Validar si el usuario ha seleccionado una fila o no
        if(row < 0){
            JOptionPane.showMessageDialog(this, "Seleccione un empleado.", " ", JOptionPane.WARNING_MESSAGE);
        }else{
            //Indicamos de la fila del empleado (nombre,tipo documento, documento, correo, sucursal)
            String name = (String)tblEmpleados.getValueAt(row, 0);
            String lastname = (String)tblEmpleados.getValueAt(row, 1);
            String document_type = (String)tblEmpleados.getValueAt(row, 2);
            String document = (String)tblEmpleados.getValueAt(row, 3);
            String email = (String)tblEmpleados.getValueAt(row, 4);
            String sucursal = (String)tblEmpleados.getValueAt(row, 5);
            
            String queryidEmpleado ="SELECT idEmp FROM empleado WHERE documento = '"+document+"';";
                try{
                   connection = conexion.getConnection();
                   st = connection.createStatement();
                   rs = st.executeQuery(queryidEmpleado);
                   while(rs.next()){
                       int idEmp = rs.getInt("idEmp");
                       ShowUserForm showUserForm = new ShowUserForm(this, true);
                       showUserForm.receiveData(idEmp, name, lastname, document_type, document, email, sucursal);
                       showUserForm.setVisible(true);
                       this.DeleteTableRecords();
                       this.ListEmpleados();
                   }
                }catch(SQLException e){
                    System.out.println(e);
                }
        }
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void btnAddEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddEmpleadoActionPerformed
        int FilaSeleccionada = tblDepartamentos.getSelectedRow();
        if(FilaSeleccionada==-1){
        JOptionPane.showMessageDialog(this, "Debe seleccionar una sucursal", "Gestión Sucursales", JOptionPane.ERROR_MESSAGE);
        }else{
           String sucursal = tblDepartamentos.getValueAt(FilaSeleccionada, 0).toString();
           String queryIdSucursal ="SELECT idSucursal FROM Sucursal WHERE nombreSucursal = '"+sucursal+"';";
           System.out.println(queryIdSucursal);
           try{
               connection = conexion.getConnection();
               st = connection.createStatement();
               rs = st.executeQuery(queryIdSucursal);
               while(rs.next()){
                   int idSucursal = rs.getInt("idSucursal");
                   EmpleadosLista empleadosLista = new EmpleadosLista(this, true);
                   empleadosLista.setVisible(true);
                   empleadosLista.recibirIdSucursal(idSucursal);
                }
            }catch(SQLException e){
            System.out.println(e);
            }  
        }
     
    }//GEN-LAST:event_btnAddEmpleadoActionPerformed

    private void txtSearchSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchSucursalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchSucursalActionPerformed

    private void btnSearchSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchSucursalActionPerformed
        borrarDatosTablaDepartamentos();
        ListDepartamentos();
    }//GEN-LAST:event_btnSearchSucursalActionPerformed

    private void tblDepartamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDepartamentosMouseClicked
        int row = tblDepartamentos.getSelectedRow();
        String sucursal = (String)tblDepartamentos.getValueAt(row, 0);
        System.out.println(sucursal);
        String departamento = (String)tblDepartamentos.getValueAt(row, 1);
        String queryIdSucursal = "SELECT idSucursal FROM Sucursal INNER JOIN Direccion WHERE FK_idDireccion = idDireccion AND nombreSucursal = '"+sucursal+"';";
        try{
            connection = conexion.getConnection();
            st = connection.createStatement();
            rs =st.executeQuery(queryIdSucursal);
            while(rs.next()){
                int idSucursal = rs.getInt("idSucursal");
                GestionarSucursalesForm gestionarSucursal = new GestionarSucursalesForm(this, true);
                gestionarSucursal.recibirDatosSucursal(idSucursal);
                gestionarSucursal.setVisible(true);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }//GEN-LAST:event_tblDepartamentosMouseClicked

    private void btnVerSucursalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerSucursalActionPerformed
        ListDepartamentos();
    }//GEN-LAST:event_btnVerSucursalActionPerformed

    private void btnSaveSucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveSucActionPerformed
        String departamentoOption = ModeloEnumDepartamento.getSelectedItem().toString();
        String zonaOption = ModeloEnumZona.getSelectedItem().toString();
        String tipoCalleOption = ModeloEnumTipoCalle.getSelectedItem().toString();
        String numero1 = txtnum1.getText();
        String numero2 = txtnum2.getText();
        String numero3 = txtnum3.getText();
        System.out.println("Departamento: "+ departamentoOption +" zona: "+zonaOption+" Tipo Calle: "+tipoCalleOption+" "+numero1+ " # "+numero2+" - "+numero3);
        
        String queryDireccion = "INSERT INTO Direccion(zona,tipoCalle,numero1,numero2,numero3,nombreDepartamento) VALUES('"+zonaOption+"','"+tipoCalleOption+"','"+numero1+"','"+numero2+"','"+numero3+"','"+departamentoOption+"')";
        System.out.println(queryDireccion);
        try{
            connection = conexion.getConnection();
            st = connection.createStatement();
            st.executeUpdate(queryDireccion);
            
            //Query para crear direccion
            String queryIdDireccion ="SELECT idDireccion FROM Direccion WHERE nombreDepartamento ='"+departamentoOption+"'AND zona='"+zonaOption+"' AND tipoCalle = '"
                    +tipoCalleOption+"'AND numero1 ='"+numero1+"'AND numero2 ='"+numero2+"'AND numero3 ='"+numero3+"';";
                try{
                    rs = st.executeQuery(queryIdDireccion);
                    while(rs.next()){
                        int idDireccion = rs.getInt("idDireccion");
                        //Creación de la instancia de la vista sucursal 
                        SucursalFrom sucursalFrom = new SucursalFrom(this, true);
                        sucursalFrom.setVisible(true);
                        sucursalFrom.recibeDatosDireccion(idDireccion);
                    }
                borrarDatosTablaDepartamentos();
                ListDepartamentos();
                }catch(SQLException e){
                System.out.println(e);
                }
            JOptionPane.showMessageDialog(this, "Sucursal creada exitosamente");
        }catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "No se logro crear la sucursal", "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveSucActionPerformed

    private void cbDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbDepartamentoActionPerformed
   
    public void ListDepartamentos(){
        String filtro= txtSearchSucursal.getText();
        if(filtro.isEmpty()){
        String query = "SELECT nombreSucursal, nombreDepartamento, CONCAT('Zona',zona,'.',tipoCalle,' ',numero1,'#',numero2,' - ',numero3) AS Direccion FROM Direccion INNER JOIN Sucursal WHERE idDireccion = FK_idDireccion AND nombreDepartamento LIKE '%"+filtro+"%'ORDER BY nombreDepartamento;";
            try{
                connection = conexion.getConnection();
                //Creamos la consulta query a la base de datos 
                st = connection.createStatement();
                rs = st.executeQuery(query);
                Object[] departamento = new Object[3];
                contenidoTablaDepartamento = (DefaultTableModel)tblDepartamentos.getModel();
                    while (rs.next()){
                        departamento[0] =rs.getString("nombreSucursal");
                        departamento[1] = rs.getString("NombreDepartamento");
                        departamento[2] = rs.getString("Direccion");
                        contenidoTablaDepartamento.addRow(departamento);
                        tblDepartamentos.setModel(contenidoTablaDepartamento);
                        }
            }catch(SQLException e){
                System.out.println(e);
                }
        }else{
            String query = "SELECT nombreSucursal, nombreDepartamento, CONCAT('Zona',zona,'.',tipoCalle,' ',numero1,'#',numero2,' - ',numero3) AS Direccion FROM Direccion INNER JOIN Sucursal WHERE idDireccion = FK_idDireccion AND nombreDepartamento LIKE '%" + filtro +"%'ORDER BY nombreDepartamento;";  
            try{
                connection = conexion.getConnection();
                //Creamos la consulta query a la base de datos 
                st = connection.createStatement();
                rs = st.executeQuery(query);
                Object[] departamento = new Object[3];
                contenidoTablaDepartamento = (DefaultTableModel)tblDepartamentos.getModel();
                    while (rs.next()){
                        departamento[0] =rs.getString("nombreSucursal");
                        departamento[1] = rs.getString("nombreDepartamento");
                        departamento[2] = rs.getString("Direccion");
                        contenidoTablaDepartamento.addRow(departamento);
                        tblDepartamentos.setModel(contenidoTablaDepartamento);
                        }
            }catch(SQLException e){
                System.out.println(e);
                }
        }
    }
    
    public void borrarDatosTablaDepartamentos(){
        for (int i = 0; i < tblDepartamentos.getRowCount(); i++) {
            contenidoTablaDepartamento.removeRow(i);
            i = i-1;
        }
        cbDepartamento.setSelectedIndex(0);
        cbTipoCalle.setSelectedIndex(0);
        cbZona.setSelectedIndex(0);
        txtnum1.setText("");
        txtnum2.setText("");
        txtnum3.setText("");
    }
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddEmpleado;
    private javax.swing.JButton btnAddUser1;
    private javax.swing.JButton btnColsult1;
    private javax.swing.JButton btnSaveSuc;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearchSucursal;
    private javax.swing.JButton btnVerSucursal;
    private javax.swing.JComboBox<String> cbDepartamento;
    private javax.swing.JComboBox<String> cbTipoCalle;
    private javax.swing.JComboBox<String> cbZona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblDepartamentos;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtSearchEmp;
    private javax.swing.JTextField txtSearchSucursal;
    private javax.swing.JTextField txtnum1;
    private javax.swing.JTextField txtnum2;
    private javax.swing.JTextField txtnum3;
    // End of variables declaration//GEN-END:variables
}
