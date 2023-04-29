/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atminterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author shivb
 */
public class Dbconnection {
    String userid;
     public void delete(String name){
         try{
         Class.forName("com.mysql.cj.jdbc.Driver");  
        Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3307/task1","root",""); 
           Statement statement;
            statement = con.createStatement();            
            System.out.println("ok");
           String sql="Delete from login where userName='shivtejbhor'";
           statement.executeUpdate(sql);
           statement.close();
            con.close();
           
     }catch(Exception e){
         System.out.println(e);
     }
     }
     public String[] retrive(String uid){
         String pass="";
         String number="";
          try{
         Class.forName("com.mysql.cj.jdbc.Driver");  
        Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3307/task1","root",""); 
           Statement statement;
            statement = con.createStatement();            
            ResultSet resultSet;
            resultSet = statement.executeQuery(
                "select * from login where userID='"+uid+"'");
            
            
           while (resultSet.next()) {
                pass = resultSet.getString("password");
                number=resultSet.getString("mobileNo");
            }
           
           statement.close();
            con.close();
           
     }catch(Exception e){
         System.out.println(e);
     }
     this.userid=uid;
         System.out.println("from conn "+this.userid);
      String a[]={pass,number};
     return a;
     }
    
}
