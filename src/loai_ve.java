import com.toedter.calendar.JCalendar;
import java.awt.event.MouseEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class loai_ve extends javax.swing.JFrame {
    private String LV_loai;
      private int LV_gia;
    /**
     * Creates new form loai_ve
     */
    public loai_ve() {
        initComponents();
         hienthi_lv();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ud_loai = new javax.swing.JButton();
        quaylai_nut = new javax.swing.JButton();
        gia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        dsv = new javax.swing.JTable();
        phipv = new javax.swing.JTextField();
        loai = new javax.swing.JTextField();
        phu_thu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        them_ve = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        ud_loai.setText("C???p nh???t gi??");
        ud_loai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ud_loaiMouseClicked(evt);
            }
        });
        ud_loai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ud_loaiActionPerformed(evt);
            }
        });

        quaylai_nut.setText("Quay l???i");
        quaylai_nut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quaylai_nutMouseClicked(evt);
            }
        });
        quaylai_nut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quaylai_nutActionPerformed(evt);
            }
        });

        gia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                giaActionPerformed(evt);
            }
        });

        dsv.setModel(new javax.swing.table.DefaultTableModel(
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
        dsv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dsvMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dsv);

        phipv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phipvActionPerformed(evt);
            }
        });

        loai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loaiActionPerformed(evt);
            }
        });

        phu_thu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phu_thuActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Lo???i v??");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("LO???I V??");

        jLabel1.setIcon(new javax.swing.ImageIcon("E:\\qtdl\\abc.png")); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("Gi?? ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("Ph?? ph???c v???");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setText("Ph??? thu");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel11.setText("Danh s??ch lo???i v??");

        them_ve.setText("Th??m");
        them_ve.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                them_veMouseClicked(evt);
            }
        });
        them_ve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                them_veActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("VAT: 10%");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loai, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(gia, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(phu_thu, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(phipv, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(them_ve))
                        .addGap(61, 61, 61)
                        .addComponent(ud_loai)
                        .addGap(49, 49, 49)
                        .addComponent(quaylai_nut))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(212, 212, 212)
                        .addComponent(jLabel2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(396, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(350, 350, 350))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(548, 548, 548))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(loai, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(jLabel4)
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel5))
                            .addComponent(gia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(phipv, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(phu_thu, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(them_ve)
                            .addComponent(ud_loai)
                            .addComponent(quaylai_nut))))
                .addContainerGap(64, Short.MAX_VALUE))
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
    Connection conn=null;
    PreparedStatement pStmt=null;
    ResultSet rs=null, rs1=null;
    Statement Stmt=null, Stmt1=null;
    int dem=0;
    private void dem_loai(){
        try{
            Stmt=conn.createStatement();
            rs1= Stmt.executeQuery("select Max(LV_loai) from ql_loaive");
            rs1.next();
            dem=rs1.getInt(1)+1;
        }
        catch(Exception e){}
    }
    
    private void xoa_loai(){
        loai.setText("");
        gia.setText("");
        phipv.setText("");
        phu_thu.setText("");
    }
    private void hienthi_lv(){
        try{
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ariline_data?user=root");
          Stmt = conn.createStatement();
          rs=Stmt.executeQuery("Select * from ql_loaive");
          dsv.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e){   
        }
    }
    private void ud_loaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ud_loaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ud_loaiActionPerformed

    private void quaylai_nutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quaylai_nutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quaylai_nutActionPerformed

    private void giaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_giaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_giaActionPerformed

    private void phipvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phipvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phipvActionPerformed

    private void loaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loaiActionPerformed

    private void phu_thuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phu_thuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phu_thuActionPerformed

    private void them_veActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_them_veActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_them_veActionPerformed

    private void quaylai_nutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quaylai_nutMouseClicked
        new ql_ve().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_quaylai_nutMouseClicked
    int key=0;
    private void them_veMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_them_veMouseClicked
        if(loai.getText().isEmpty() || gia.getText().isEmpty() || phipv.getText().isEmpty() || phu_thu.getText().isEmpty())
       {
            JOptionPane.showMessageDialog(this,"Nh???p thi???u");
        }else{
            try {
                dem_loai();
                String connStr="jdbc:mysql://localhost/ariline_data?user=root";
                Connection conn = DriverManager.getConnection(connStr);
                CallableStatement cStmt10 = conn.prepareCall("{call themloai(?,?,?,?)}");
                cStmt10.setString(1, loai.getText());
                cStmt10.setString(2, gia.getText());
                cStmt10.setString(3, phipv.getText());
                cStmt10.setString(4, phu_thu.getText());
                cStmt10.execute();
                ResultSet rs10 = cStmt10.executeQuery("SELECT * FROM ql_loaive");//join ql_hanhkhach on ql_hanhkhach.HK_id=ql_datve.HK_id
                JOptionPane.showMessageDialog(this,"???? th??m lo???i lo???i");  key=0;
                conn.close();
                hienthi_lv();
                //key=0;
                xoa_loai();
            }
            catch (Exception e){
                JOptionPane.showMessageDialog(this,e);
            }
        };
    }//GEN-LAST:event_them_veMouseClicked

    private void ud_loaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ud_loaiMouseClicked
       if(loai.getText().isEmpty() || gia.getText().isEmpty() || phipv.getText().isEmpty() || phu_thu.getText().isEmpty())
       {
            JOptionPane.showMessageDialog(this,"Nh???p thi???u");
        }else{
            try{
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ariline_data?user=root");
                PreparedStatement Ud=conn.prepareStatement("Update ql_loaive set LV_gia=?, LV_phipv=?, LV_phuthu=? where LV_loai=?");
                Ud.setString(4, loai.getText());
                Ud.setString(1, gia.getText());
                Ud.setString(2, phipv.getText());
                Ud.setString(3, phu_thu.getText());
               
                int row=Ud.executeUpdate();
                JOptionPane.showMessageDialog(this,"???? c???p nh???t h??nh kh??ch");
                conn.close();
                hienthi_lv();
                key=0;
                xoa_loai();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this,e);
            }
        }
    }//GEN-LAST:event_ud_loaiMouseClicked

    private void dsvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dsvMouseClicked
        DefaultTableModel model=(DefaultTableModel)dsv.getModel();
                int myindex=dsv.getSelectedRow();
                loai.setText(model.getValueAt(myindex,0).toString());
                gia.setText(model.getValueAt(myindex,1).toString());
                phipv.setText(model.getValueAt(myindex,2).toString());
                phu_thu.setText(model.getValueAt(myindex,3).toString());
    }//GEN-LAST:event_dsvMouseClicked
  
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
            java.util.logging.Logger.getLogger(loai_ve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loai_ve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loai_ve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loai_ve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loai_ve().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dsv;
    private javax.swing.JTextField gia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField loai;
    private javax.swing.JTextField phipv;
    private javax.swing.JTextField phu_thu;
    private javax.swing.JButton quaylai_nut;
    private javax.swing.JButton them_ve;
    private javax.swing.JButton ud_loai;
    // End of variables declaration//GEN-END:variables
}
