package BANK_MANAGEMENT_SYSTEM;
import java.sql.*;



public class conn {
Connection c ;
Statement s ;

    public conn(){
        try{
              
            
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","pmonishcool123");
            s = c.createStatement();
            

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
