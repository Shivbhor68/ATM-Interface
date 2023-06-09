/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package atminterface;
import java.time.LocalDateTime;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author shivb
 */
public class Deposit extends javax.swing.JFrame {

    /**
     * Creates new form Deposit
     */
    String id="";
    public Deposit(String id) {
        this.id=id;
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dpamount = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("welcome "+id);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 182, 330, 30));

        jLabel3.setText("Enter Amount to deposit:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 140, 20));
        getContentPane().add(dpamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 120, -1));

        jButton1.setText("Deposit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atminterface/Atm.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        float dpam=Integer.parseInt(this.dpamount.getText());
        float dpamount=(float)dpam;
        LocalDateTime date= LocalDateTime.now();
                
        int dbamount=0;
        try{
         Class.forName("com.mysql.cj.jdbc.Driver");  
        Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3307/task2","root",""); 
           Statement statement;
            statement = con.createStatement();            
            ResultSet rs;
            rs = statement.executeQuery("select Balance from accountbal where Uid= '"+id+"'");
            
           
            
           while (rs.next()) {
                dbamount = rs.getInt("Balance");
                
            }
           
           dbamount+=dpamount;
           statement.executeUpdate("update accountbal set Balance='"+dbamount+"' where Uid= '"+id+"'");
           statement.executeUpdate("insert into transactionh (Uid, trtype, amount, balance, datetime)values('"+id+"','Deposit','"+dpamount+"','"+dbamount+"','"+date+"')");
           JOptionPane.showMessageDialog(null    ,"Money Deposited Successfully");
           statement.close();
            con.close();
           
     }catch(Exception e){
         System.out.println(e);
     
     }   // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
Dashboard db=new Dashboard(id);
dispose();
db.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dpamount;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
