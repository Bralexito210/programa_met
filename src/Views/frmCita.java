/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Views;

import Controllers.ClienteDAO;
import Controllers.CitaDao;
import Models.Cliente;
import Models.Persona;
import Models.Cita;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author david
 */
public final class frmCita extends javax.swing.JInternalFrame {
    //para cargar la informacion
    ClienteDAO oclie=new ClienteDAO("Clientes.txt");
    CitaDao oci=new CitaDao("Cita.txt");
    private int correativo;
    //modificar los modelos por defecto
    DefaultTableModel dtmCita= new DefaultTableModel();

    //formato para las fechas y horas
    DateTimeFormatter calendario = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    SimpleDateFormat fechaReg = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat formatoHoraMinuto = new SimpleDateFormat("HH:mm");
    //alterar el funcionamiento de las tablas
    TableRowSorter<TableModel> elQueOrdena;
    //obtener un objeto de tipo fecha
    Date fechaHoraIngresada = new Date();
    //instancias de la clase 
    Persona per = new Cliente();
    Object[] user= frmPrincipal.user;
    // spinner personalizado, usando la herencia y abstraccion de la misma clase
    SpinnerNumberModel sn1 = new SpinnerNumberModel(00,00,45,15){
        public Object getNextValue(){
            if(getValue().toString().equals("45"))
                return super.getMinimum();
            return super.getNextValue();
        }
        public Object getPreviousValue(){
            if(getValue().toString().equals("0"))
                return super.getMaximum();
            return super.getPreviousValue();
        }
    };
    SpinnerNumberModel sn2 = new SpinnerNumberModel(8,8,22,1);
    
    public frmCita() {
        initComponents();
        jDateChooser1.setMinSelectableDate(new Date());
        llenaCabecera();
        carga_init();
        jLidCita.setVisible(true); // id
        est_label(false,false);
        jSpinner2.setModel(sn1);
        jSpinner1.setModel(sn2);
        filtra(fechaReg.format(jCalendar1.getCalendar().getTime()));
        System.out.println(""+fechaReg.format(jCalendar1.getCalendar().getTime()));
        est_btn(false, false, false, true,false);
        busca(false,false);
    }
    
    private void est_btn(boolean btnSave,boolean btnEdit,boolean btnDel,boolean btnNew,boolean btnCan){
        jbtnGuardar.setEnabled(btnSave);
        jbtnModificar.setEnabled(btnEdit);
        jbtnEliminar.setEnabled(btnDel);
        jbtnNuevo.setEnabled(btnNew);
        jbtnCancelar.setEnabled(btnCan);
    }
    private void est_label(boolean nom,boolean ape){
        jTextField2.setEditable(nom);
        jTextField3.setEditable(ape);
    }
    private void busca(boolean dni,boolean busca){
        btnBuscarCliente.setEnabled(dni);
        jTextField1.setEditable(busca);
    }
    public void llenaCabecera(){
        dtmCita.addColumn("idCita");                // 0
        dtmCita.addColumn("dniE");                  // 1
        dtmCita.addColumn("DNI");                   // 2
        dtmCita.addColumn("Nombres");               // 3
        dtmCita.addColumn("Apellido");              // 4
        dtmCita.addColumn("Motivo");                // 5
        dtmCita.addColumn("Fecha");                 // 6
        dtmCita.addColumn("Hora");                  // 7
        tblCita.setModel(dtmCita);
        tblCita.setAutoCreateRowSorter(true);
        elQueOrdena = new TableRowSorter<>(dtmCita);
        tblCita.setRowSorter(elQueOrdena);
    }
    /*
    - 2: buscar en la lista y cargar su informacion
    - 3: poder guardar
    - 3: poder editar
    - 3: poder eliminar
    - 4: si y si al escojer la fecha y cargar la informacion se puede ediar o modificar.
    
    */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RbtnGrupo = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jpopEnviar = new javax.swing.JMenuItem();
        jPanel7 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCita = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnPresente = new javax.swing.JButton();
        jLidCita = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPanel3 = new javax.swing.JPanel();
        jbtnModificar = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();
        jbtnGuardar = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();
        jbtnNuevo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnRev = new javax.swing.JRadioButton();
        btnTra = new javax.swing.JRadioButton();

        jpopEnviar.setText("Enviar");
        jpopEnviar.setToolTipText("");
        jpopEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpopEnviarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jpopEnviar);

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel4.setText("horario del dia");

        tblCita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "idCita", "dniE", "DNI", "Paciente", "Motivo", "Fecha", "Motivo"
            }
        ));
        tblCita.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tblCita);

        jLabel1.setText("Cronograma");

        btnPresente.setText("Hoy");
        btnPresente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPresenteActionPerformed(evt);
            }
        });

        jLidCita.setText("jLabel3");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(114, 114, 114)
                        .addComponent(jLabel4))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(btnPresente, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLidCita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPresente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLidCita))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jLabel5.setText("mes");

        jCalendar1.setDate(java.sql.Date.valueOf(calendario.format(LocalDateTime.now())));
        jCalendar1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendar1PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));

        jbtnModificar.setText("modificar");
        jbtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnModificarActionPerformed(evt);
            }
        });

        jbtnEliminar.setText("Elminar");
        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
            }
        });

        jbtnGuardar.setText("Grabar");
        jbtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGuardarActionPerformed(evt);
            }
        });

        jbtnCancelar.setText("Cancelar");
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        jbtnNuevo.setText("Nuevo");
        jbtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jbtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jbtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jbtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jbtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 51));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("registro de cita");

        jPanel6.setBackground(new java.awt.Color(204, 255, 204));

        jDateChooser1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel6.setText("Buscar DNI");

        jTextField1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        btnBuscarCliente.setIcon(new javax.swing.ImageIcon("C:\\Users\\david\\Documents\\NetBeansProjects\\metodologia_prog\\src\\Icons\\search-20.png")); // NOI18N
        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        jLabel7.setText("hora de cita");

        jLabel8.setText("Fecha a agendar");

        jLabel9.setText("Nombre");

        jLabel10.setText("Apellido");

        jLabel11.setText("motivo");

        jSpinner1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jSpinner1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jSpinner1KeyTyped(evt);
            }
        });

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(0, 0, 45, 15));
        jSpinner2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jSpinner2KeyTyped(evt);
            }
        });

        jLabel12.setText("hora:");

        jLabel13.setText("minuto:");

        RbtnGrupo.add(btnRev);
        btnRev.setText("Revision");

        RbtnGrupo.add(btnTra);
        btnTra.setText("Tratamiento");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(0, 4, Short.MAX_VALUE)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(btnRev)
                                        .addGap(40, 40, 40)))
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnTra)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jTextField1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarCliente))
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField3))))
                .addGap(9, 9, 9))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel11))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRev)
                            .addComponent(btnTra))))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String motivo(){
        if(btnRev.isSelected()){ return "revision";}
        else if(btnTra.isSelected()){ return "tratamiento";}
        else{ return "no definido";}
    }
    private void carga_init(){
        
        TableColumn idCita = tblCita.getColumnModel().getColumn(0);
        colHidden(idCita);
        TableColumn dniE = tblCita.getColumnModel().getColumn(1);
        colHidden(dniE);
        TableColumn fecha = tblCita.getColumnModel().getColumn(6);
        colHidden(fecha);
        
        
        TableColumn dni = tblCita.getColumnModel().getColumn(2);
        dni.setPreferredWidth(100);
        TableColumn nombre = tblCita.getColumnModel().getColumn(3);
        nombre.setPreferredWidth(90);
        TableColumn apellido = tblCita.getColumnModel().getColumn(4);
        apellido.setPreferredWidth(90);
        TableColumn motivo = tblCita.getColumnModel().getColumn(5);
        motivo.setPreferredWidth(60);
        TableColumn hora = tblCita.getColumnModel().getColumn(7);
        hora.setPreferredWidth(40);
        
        llena();
    }
    private void colHidden(TableColumn nombre){
        nombre.setMaxWidth(0);
        nombre.setMinWidth(0);
        nombre.setPreferredWidth(0);
    }
    public void llena(){
        if (oci.tamaño() == 0) {
            JOptionPane.showMessageDialog(this, "Lista sin Elementos!", "Validar", 2);
        } else {
            dtmCita.setRowCount(0);//Limpia las filas del JTable
            for (int i = 0; i < oci.tamaño(); i++) {
                //int idCita, int dniE,int DNI 2, String nombre 3, String apellido + String motivo 4, String fecha 5, String hora 1
                Object vec[] = new Object[8];
                vec[0] = ((Cita)oci.obtener(i)).getIdCita();
                vec[1] = ((Cita)oci.obtener(i)).getDniE();
                vec[2] = oci.obtener(i).getDNI();
                vec[3] = oci.obtener(i).getNombre();
                vec[4] = oci.obtener(i).getApellido();
                vec[5] = ((Cita)oci.obtener(i)).getMotivo();
                vec[6] = ((Cita)oci.obtener(i)).getFecha();
                vec[7] = ((Cita)oci.obtener(i)).getHora();
                //Agregar elementos al JTable
                dtmCita.addRow(vec);
            }
            tblCita.setModel(dtmCita);
        }
    }
    
    private void btnPresenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPresenteActionPerformed
        try {
            LocalDateTime local = LocalDateTime.now();
            String fecha = calendario.format(local);
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
            jCalendar1.setDate(date);
            filtra(fechaReg.format(jCalendar1.getCalendar().getTime()));
        } catch (ParseException ex) {
            Logger.getLogger(frmCita.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnPresenteActionPerformed

    private void filtra(String index){
        try{
            elQueOrdena.setRowFilter(RowFilter.regexFilter(index,6));
        }catch(Exception e){}
    }
    
    private void jCalendar1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendar1PropertyChange
        //si el ultimo valor seleccionado es nulo
        //no ha seleecionado ningun valor
        if(evt.getOldValue() != null){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            filtra(sdf.format(jCalendar1.getCalendar().getTime()));
        }
    }//GEN-LAST:event_jCalendar1PropertyChange

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        String text_dni = jTextField1.getText();
        int dni=0;
        if(text_dni.isEmpty()){
            JOptionPane.showMessageDialog(this, "ingresar un dni!", "Notificacion", 1);
        }else{
            dni = Integer.parseInt(text_dni);
            per=oclie.buscarCliente(dni);
            if(per!=null){
                est_btn(true, false, false, false,true);
                jTextField2.setText(per.getNombre());
                jTextField3.setText(per.getApellido());
                
            } else {
                JOptionPane.showMessageDialog(this, "No se encontro Cliente!", "Notificacion", 1);
            }
        }

        
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private String hora(){
        int hora= Integer.parseInt(jSpinner1.getValue().toString());
        int min= Integer.parseInt(jSpinner2.getValue().toString());
        fechaHoraIngresada.setHours(hora);
        fechaHoraIngresada.setMinutes(min);
        String horaMinutoFormateado = formatoHoraMinuto.format(fechaHoraIngresada);
        return horaMinutoFormateado;
    }
    private void jbtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGuardarActionPerformed
        //correlativo,
        String nombre = jTextField2.getText();
        String apellido = jTextField3.getText();
        if(nombre.equals("")){ 
        }
        else{
            //correlativo y dni empleado que esta en objeto user del menu
            //idCita, int dniE,int DNI 2, String nombre 3, String apellido + String motivo 4, String fecha 5, String hora 1
            //23;72305530;999;david;guevara;revision;03/12/2023;08:00
           Persona p = new Cita(
                   oci.getCorrelativo(),
                   Integer.parseInt(user[2].toString()),
                   Integer.parseInt(jTextField1.getText()),
                   jTextField2.getText(),
                   jTextField3.getText(),
                   motivo(),
                   fechaReg.format(jDateChooser1.getDate()),
                   hora()
           );
           oci.adicionar((Cita)p);
           llena();
           oci.grabar();
        }
    }//GEN-LAST:event_jbtnGuardarActionPerformed

    
    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        System.out.println("me estoy cerrando");
    }//GEN-LAST:event_formInternalFrameClosing

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        est_btn(false, false, false, true,false);
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        busca(false,false);
        jDateChooser1.setCalendar(null);
        //spinner
        jSpinner1.setValue(0);
        jSpinner2.setValue(0);
        
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed
        int cita = Integer.parseInt(jLidCita.getText());
        int i= JOptionPane.showConfirmDialog(this, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE);
        //0 es cancelar
        if(i==0){
            per=oci.buscarCita(cita);
            oci.eliminar(per);
            oci.grabar();
            llena(); 
            est_btn(false, false, false, true,false);
        }
        //2 es aceptar
        else{
            System.out.println(""+i);
        }
    }//GEN-LAST:event_jbtnEliminarActionPerformed

    private void jbtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNuevoActionPerformed
        est_btn(false, false, false, false,true);
        est_label(false,false);
        busca(true,true);
    }//GEN-LAST:event_jbtnNuevoActionPerformed

    private void jbtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnModificarActionPerformed
        int cita = Integer.parseInt(jLidCita.getText());
        per=oci.buscarCita(cita);
        System.out.println(((Cita)per).getIdCita()+": "+per.getApellido());
        //set que tengan q ver con modiifcar
        // solo se tendra en cuenta la fecha, hora y motivo
        ((Cita)per).setFecha(fechaReg.format(jDateChooser1.getDate())); //fecha ingresada en el formulario
        ((Cita)per).setHora(hora());
        ((Cita)per).setMotivo(motivo());
        //editar solo cambiar fecha, hora y tratamiento
        int i= JOptionPane.showConfirmDialog(this, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if(i==0){
            oci.grabar();
            llena();
            est_btn(false, false, false, true,false);
        }
    }//GEN-LAST:event_jbtnModificarActionPerformed

    private void jpopEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpopEnviarActionPerformed
        int fill = tblCita.getSelectedRow();
        if(fill== -1)
            JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila.");
       else{
            try {
                est_btn(false, true, true, false,true);
                busca(false,false);
                Date date = new SimpleDateFormat("dd/MM/yyyy").parse(tblCita.getValueAt(fill, 6).toString());
                String[] hora= tblCita.getValueAt(fill, 7).toString().split(":");
                jTextField1.setText(tblCita.getValueAt(fill, 2).toString());
                jTextField2.setText(tblCita.getValueAt(fill, 3).toString());
                jTextField3.setText(tblCita.getValueAt(fill, 4).toString());
                jDateChooser1.setDate(date);
                System.out.println(tblCita.getValueAt(fill, 7).toString());

                jSpinner1.setValue(Integer.parseInt(hora[0]));
                jSpinner2.setValue(Integer.parseInt(hora[1]));
                String motivo= tblCita.getValueAt(fill, 5).toString();
                if(motivo.equals("revision")) btnRev.setSelected(true);
                else btnTra.setSelected(true);

                jLidCita.setText(tblCita.getValueAt(fill, 0).toString());
                tblCita.clearSelection();
            } catch (ParseException ex) {
                Logger.getLogger(frmCita.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
    }//GEN-LAST:event_jpopEnviarActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        int key = evt.getKeyChar();
        boolean numero = key >= 48 && key <=57;
        if(!numero){
            evt.consume();
        }
        if(jTextField1.getText().length() >= 8){
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jSpinner1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSpinner1KeyTyped
        int key = evt.getKeyChar();
        boolean numero = key >= 48 && key <=57;
        if(!numero){
            evt.consume();
        }
        if(jTextField1.getText().length() >= 8){
            evt.consume();
        }
    }//GEN-LAST:event_jSpinner1KeyTyped

    private void jSpinner2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSpinner2KeyTyped
        int key = evt.getKeyChar();
        boolean numero = key >= 48 && key <=57;
        if(!numero){
            evt.consume();
        }
        if(jTextField1.getText().length() >= 8){
            evt.consume();
        }
    }//GEN-LAST:event_jSpinner2KeyTyped

    private void jSpinner1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSpinner1KeyPressed
        int key = evt.getKeyChar();
        boolean numero = key >= 48 && key <=57;
        if(!numero){
            evt.consume();
        }
        if(jTextField1.getText().length() >= 8){
            evt.consume();
        }
    }//GEN-LAST:event_jSpinner1KeyPressed
    //System.out.println(jSpinner2.getNextValue()+"");

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup RbtnGrupo;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnPresente;
    private javax.swing.JRadioButton btnRev;
    private javax.swing.JRadioButton btnTra;
    private com.toedter.calendar.JCalendar jCalendar1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLidCita;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    protected static javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnGuardar;
    private javax.swing.JButton jbtnModificar;
    private javax.swing.JButton jbtnNuevo;
    private javax.swing.JMenuItem jpopEnviar;
    private javax.swing.JTable tblCita;
    // End of variables declaration//GEN-END:variables
}
