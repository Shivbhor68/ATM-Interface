/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package atminterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shivb
 */
public class TransactionH extends javax.swing.JFrame {

    /**
     * Creates new form TransactionH
     */
    String id="";
    public TransactionH(String id) {
        this.id=id;
        initComponents();
        new javax.swing.table.DefaultTableModel(
    new Object [][] {

    },
    new String [] {
        "Uid", "Trid", "trtype", "amount", "balance", "datetime"
    }
);
        show_user();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(536, 761));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Deposit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jButton2.setText("Withdraw");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        jButton3.setText("Transfer");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setText("EXIT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, -1));

        jButton5.setText("Dashboard");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Uid", "Trid", "trtype", "amount", "balance", "datetime"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setHeaderValue("Uid");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Trid");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("trtype");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("amount");
            jTable1.getColumnModel().getColumn(4).setHeaderValue("balance");
            jTable1.getColumnModel().getColumn(5).setHeaderValue("datetime");
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 520, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atminterface/Atm.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 536, 761));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    Deposit ds=new Deposit(id);
        dispose();
        ds.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      Withdraw wd=new Withdraw(id);
      dispose();
    wd.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    Transfer tf= new Transfer(id);
    dispose();
    tf.setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    Dashboard db=new Dashboard(id);
        dispose();
        db.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed
public ArrayList<User> userList(){
            ArrayList<User> userList=new ArrayList<>();
             try{
         Class.forName("com.mysql.cj.jdbc.Driver");  
        Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3307/task2","root",""); 
           Statement statement;
            statement = con.createStatement();            
            ResultSet rs;
            rs = statement.executeQuery("select * from transactionh where Uid= 'shivbhor44'");
            User user;
            
           while (rs.next()) {
               user=new User(rs.getString("Uid"),rs.getInt("Trid"),rs.getString("trtype"),rs.getFloat("amount"),rs.getFloat("balance"),rs.getString("datetime"));
               userList.add(user);
               System.out.println(user.toString());
              
           }
                 
           
           statement.close();
            con.close();
           
     }catch(Exception e){
         System.out.println(e);
     
     }
             return userList;
    }
public void show_user(){
        
        ArrayList<User> list=userList();
        DefaultTableModel model1=(DefaultTableModel) jTable1.getModel();
        Object[] row=new Object[6];
        for(int i=0;i<list.size();i++){
            row[0]=list.get(i).getUid();
            row[1]=list.get(i).getTrid();
            row[2]=list.get(i).getTrtype();
            row[3]=list.get(i).getAmount();
            row[4]=list.get(i).getBalance();
            row[5]=list.get(i).getDatetime();
            
            model1.addRow(row);
        }
    
    }
    /**
     * @param args the command line arguments
     */
    
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       
        //</editor-fold>

        /* Create and display the form */
      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
