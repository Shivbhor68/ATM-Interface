/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atminterface;

/**
 *
 * @author shivb
 */
class User {
    private int Trid;
    private float amount ,balance;
    private String Uid,trtype,datetime;
     

    User(int aInt, String string, String string0, String string1, String string2, String string3, String string4, String string5) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

    public int getTrid() {
        return Trid;
    }



    public float getAmount() {
        return amount;
    }



    public float getBalance() {
        return balance;
    }



    public String getUid() {
        return Uid;
    }



    public String getTrtype() {
        return trtype;
    }



    public String getDatetime() {
        return datetime;
    }



    public User(String Uid, int Trid, String trtype, float amount, float balance, String datetime){

         this.Uid=Uid;
         this.Trid=Trid;
         this.trtype=trtype;
         this.amount=amount;
         this.balance=balance;
         this.datetime=datetime;
         
    }
    
    
}
