
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HSR
 */
public class updatePerformance extends javax.swing.JFrame {

    /**
     * Creates new form updatePerformance
     */
    public updatePerformance() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        a1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1050, 560));

        jPanel2.setLayout(null);

        jButton2.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jButton2.setText("Show All Employee Performance");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(40, 220, 480, 110);

        a1.setColumns(20);
        a1.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        a1.setRows(5);
        jScrollPane1.setViewportView(a1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(533, 8, 490, 490);

        jButton1.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(20, 10, 130, 80);

        jButton3.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jButton3.setText("Reset Sales");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(150, 390, 210, 80);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stock2.jpg"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(0, 0, 1060, 510);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1026, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        a1.setText("");
        Function1 f1=new Function1();
        ResultSet rs=null;
        String pc="price";
        String itm="items";
        f1.find();
        }
        public class Function1{
            Connection conn=null;
            ResultSet rs=null;
            PreparedStatement ps=null;
            PreparedStatement ps1=null;
            public ResultSet find(){
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmsproject","root","harshdeep");
                    String sql1="select employeeId,employeeName,sales from employee";
                    ps= conn.prepareStatement(sql1);

                    rs=ps.executeQuery();

                    while(rs.next()) {
                        String ID = rs.getString("employeeId");
                        a1.append(ID);
                        a1.append("\n");
                        String LD = rs.getString("employeeName");
                        a1.append(LD);
                        a1.append("\nSales: ");
                        String MD = rs.getString("sales");
                        a1.append(MD);
                        a1.append("\n\n\n");

                    }
                } catch (Exception e ) {
                    JOptionPane.showMessageDialog(null, e);
                }return rs;}        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new employeeperformance().setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        a1.setText("");
        Function f=new Function();
        ResultSet rs=null;
        String pc="price";
        String itm="items";
        f.find();
        }
        public class Function{
            Connection conn=null;
            ResultSet rs=null;
            ResultSet rs1=null;
            PreparedStatement ps=null;
            PreparedStatement ps1=null;
            public ResultSet find(){
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbmsproject","root","harshdeep");
                    String sql1="update employee set sales=0 where sales!=0";

                    ps= conn.prepareStatement(sql1);

                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(null,"Succefully reset");

                } catch (Exception e ) {
                    JOptionPane.showMessageDialog(null, e);
                }return rs;}        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(updatePerformance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updatePerformance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updatePerformance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updatePerformance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updatePerformance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea a1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
