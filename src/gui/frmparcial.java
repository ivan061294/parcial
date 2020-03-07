package gui;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class frmparcial extends javax.swing.JFrame {

    public frmparcial() {
        initComponents();
        mostrar();

    }

    public static Connection conectar() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/tienda?user=root&&password=mysqladmin";
            con = (Connection) DriverManager.getConnection(url);
            if (con != null) {
                System.out.println("te has conectado");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
    void mostrar() {
        DefaultTableModel mdltabla = new DefaultTableModel();
        mdltabla.addColumn("id_registro");
        mdltabla.addColumn("DNI");
        mdltabla.addColumn("Multa");
        mdltabla.addColumn("Monto");
        mdltabla.addColumn("correo");
        tbl1.setModel(mdltabla);
        Statement st = null;
        String[] dato = new String[5];
        try {
            st = conectar().createStatement();
            String query = "select * from registrar";
            ResultSet res = st.executeQuery(query);
            while (res.next()) {
                dato[0] = res.getString(1);
                dato[1] = res.getString(2);
                dato[2] = res.getString(3);
                dato[3] = res.getString(4);
                dato[4] = res.getString(5);
                mdltabla.addRow(dato);

            }
        } catch (Exception e) {
        }
    }
    void mostrar2() {
        DefaultTableModel mdltabla = new DefaultTableModel();
        mdltabla.addColumn("id_registro");
        mdltabla.addColumn("DNI");
        mdltabla.addColumn("Multa");
        mdltabla.addColumn("Monto");
        mdltabla.addColumn("correo");
        tbl1.setModel(mdltabla);
        Statement st = null;
        String[] dato = new String[5];
        try {
            st = conectar().createStatement();
            String query = "select * from registrar where multa="+"'"+cbomulta.getSelectedItem().toString()+"'";
            ResultSet res = st.executeQuery(query);
            while (res.next()) {
                dato[0] = res.getString(1);
                dato[1] = res.getString(2);
                dato[2] = res.getString(3);
                dato[3] = res.getString(4);
                dato[4] = res.getString(5);
                mdltabla.addRow(dato);

            }
        } catch (SQLException e) {
            System.err.print(e.getMessage());
        }
    }

    void insertar() {
        try {
            String Query = "call usp_insert2(?,? , ?, ?, ?)";
            PreparedStatement ps = conectar().prepareStatement(Query);
            ps.setString(1, txtregistro.getText());
            ps.setString(2, txtdni.getText());
            ps.setString(3, cbomulta.getSelectedItem().toString());
            ps.setString(4, txtmonto.getText());
            ps.setString(5, txtcorreo.getText());
            ps.executeUpdate();
            conectar().close();
            JOptionPane.showMessageDialog(null, "se agrego el producto");
            conectar().close();
            mostrar();
        } catch (SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
        void actualizar() {
        try {
            String Query = "call usp_actualizar2(?, ? , ?, ?, ?)";
            PreparedStatement ps = conectar().prepareStatement(Query);
              ps.setString(1, txtregistro.getText());
            ps.setString(2, txtdni.getText());
            ps.setString(3, cbomulta.getSelectedItem().toString());
            ps.setString(4, txtmonto.getText());
            ps.setString(5, txtcorreo.getText());
            ps.executeUpdate();
            conectar().close();
            JOptionPane.showMessageDialog(null, "se actualizo el producto");
            conectar().close();
            mostrar();
        } catch (SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
     void eliminar() {
        try {
            String Query = "call usp_eliminar2(? )";
            PreparedStatement ps = conectar().prepareStatement(Query);
            ps.setString(1, txtregistro.getText());
            ps.executeUpdate();
            conectar().close();
            JOptionPane.showMessageDialog(null, "se elimino el producto");
            conectar().close();
            mostrar();
        } catch (SQLException | NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtdni = new javax.swing.JTextField();
        txtmonto = new javax.swing.JTextField();
        txtcorreo = new javax.swing.JTextField();
        cbomulta = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtregistro = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl1);

        jButton1.setText("Reporte");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("REGISTRAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cbomulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "alta velocidad", "pico y placa ", "se paso la luz roja", "mato un perro" }));

        jLabel1.setText("DNI:");

        jLabel2.setText("MONTO");

        jLabel3.setText("MULTA");

        jLabel4.setText("CORREO");

        jButton3.setText("FILTRAR MULTA");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setText("id_registro");

        jButton4.setText("ACTUALIZAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("ELIMINAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3)))
                            .addGap(53, 53, 53)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtcorreo)
                                .addComponent(cbomulta, 0, 145, Short.MAX_VALUE))))
                    .addComponent(txtregistro, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(114, 114, 114)
                        .addComponent(jButton3)
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)))))
                .addContainerGap(199, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtregistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbomulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        insertar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(frmparcial.class.getResource("./newReport.jasper"));
            JasperPrint jp = JasperFillManager.fillReport(jr, null, conectar());
            JasperViewer jv = new JasperViewer(jp);
            jv.show();
        } catch (Exception e) {
            System.err.print(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MousePressed
        if (evt.getClickCount() == 2) {
            int fila = tbl1.getSelectedRow();
            txtregistro.setText(tbl1.getValueAt(fila,0).toString());
            txtdni.setText(tbl1.getValueAt(fila, 1).toString());
            txtmonto.setText(tbl1.getValueAt(fila, 3).toString());
            txtcorreo.setText(tbl1.getValueAt(fila, 4).toString());
    }//GEN-LAST:event_tbl1MousePressed
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       mostrar2();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
 actualizar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
eliminar();
    }//GEN-LAST:event_jButton5ActionPerformed
    

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmparcial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbomulta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl1;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtmonto;
    private javax.swing.JTextField txtregistro;
    // End of variables declaration//GEN-END:variables
}
