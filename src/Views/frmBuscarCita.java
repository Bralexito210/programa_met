/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Views;

import Controllers.CitaDao;
import Models.Cita;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author david
 */
public class frmBuscarCita extends javax.swing.JInternalFrame {
    CitaDao oci=new CitaDao("Cita.txt");
    TableRowSorter<TableModel> elQueOrdena;
    DefaultTableModel dtmTrata= new DefaultTableModel();
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    DateTimeFormatter calendario = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public frmBuscarCita() {
        initComponents();
        llenaCabecera();
        carga_init();
        //cotas actuales que lista noma
        jDateChooser1.setDate(java.sql.Date.valueOf(LocalDateTime.now().format(calendario)));
        filtra(formato.format(jDateChooser1.getCalendar().getTime()));
    }
    

    public void llenaCabecera(){
        dtmTrata.addColumn("DNI");
        dtmTrata.addColumn("Nombres");
        dtmTrata.addColumn("Apellido");
        dtmTrata.addColumn("Motivo");
        dtmTrata.addColumn("Fecha");
        dtmTrata.addColumn("Hora");
        tblTrata.setModel(dtmTrata);
        tblTrata.setAutoCreateRowSorter(true);
        elQueOrdena = new TableRowSorter<>(dtmTrata);
        tblTrata.setRowSorter(elQueOrdena);
    }
    private void carga_init(){
        
        TableColumn fecha = tblTrata.getColumnModel().getColumn(4);
        fecha.setMaxWidth(0);
        fecha.setMinWidth(0);
        fecha.setPreferredWidth(0);
        
        TableColumn dni = tblTrata.getColumnModel().getColumn(0);
        dni.setPreferredWidth(60);
        TableColumn motivo = tblTrata.getColumnModel().getColumn(3);
        motivo.setPreferredWidth(45);
        TableColumn hora = tblTrata.getColumnModel().getColumn(5);
        hora.setPreferredWidth(30);
        
        llena();
    }
    public void llena(){
        if (oci.tamaño() == 0) {
            JOptionPane.showMessageDialog(this, "Lista sin Elementos!", "Validar", 2);
        } else {
            dtmTrata.setRowCount(0);//Limpia las filas del JTable
            for (int i = 0; i < oci.tamaño(); i++) {
                //int idCita, int dniE,int DNI 2, String nombre 3, String apellido + String motivo 4, String fecha 5, String hora 1
                //23;72305530;999;david;guevara;revision;03/12/2023;08:00
                // 0;       1;  2;    3;      4;       5;         6;    7
                Object vec[] = new Object[6];
                vec[0] = oci.obtener(i).getDNI();
                vec[1] = oci.obtener(i).getNombre();
                vec[2] = oci.obtener(i).getApellido();
                vec[3] = ((Cita)oci.obtener(i)).getMotivo();
                vec[4] = ((Cita)oci.obtener(i)).getFecha();
                vec[5] = ((Cita)oci.obtener(i)).getHora();
                //Agregar elementos al JTable
                dtmTrata.addRow(vec);
            }
            tblTrata.setModel(dtmTrata);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jpopEnviar = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTrata = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        jpopEnviar.setText("Enviar");
        jpopEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpopEnviarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jpopEnviar);

        setTitle("Buscar Cita");

        tblTrata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblTrata.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(tblTrata);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Tabla de Citas Registradas");

        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Fltro por Fecha: ");

        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpopEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpopEnviarActionPerformed
       int fill = tblTrata.getSelectedRow();
       if(fill== -1)
            JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna fila.");
       else{
           String dni = tblTrata.getValueAt(fill, 0).toString();
           String nombre = tblTrata.getValueAt(fill, 1).toString();
           String apellido = tblTrata.getValueAt(fill, 2).toString();
           frmTratamiento.jTextField6.setText(dni);
           frmTratamiento.jTextField7.setText(nombre);
           frmTratamiento.jTextField8.setText(apellido);
           this.dispose();
           frmTratamiento.estado_btn(false,false,true,true,false,true);
       }
        
    }//GEN-LAST:event_jpopEnviarActionPerformed

    private void filtra(String date){
        try{
            elQueOrdena.setRowFilter(RowFilter.regexFilter(date,4));
        }catch(Exception e){}
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        if(evt.getOldValue() != null){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            filtra(formato.format(jDateChooser1.getDate()));
        }
    }//GEN-LAST:event_jDateChooser1PropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem jpopEnviar;
    private javax.swing.JTable tblTrata;
    // End of variables declaration//GEN-END:variables
}
