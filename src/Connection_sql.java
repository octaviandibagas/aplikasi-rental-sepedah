import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.*; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_sql {
    Connection con;
    Statement stm;
    String user="root";
    String pswd ="";
    String host="localhost";
    String db="db_rental_sepeda";
    String url="";
    
    public void config(){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                String url="jdbc:mysql://"+ host +"/"+ db +"?user=" + user + "&password="+ pswd; 
                con=DriverManager.getConnection(url);
            //here sonoo is database name, root is username and password  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("select * from tb_rental");  
            JOptionPane.showMessageDialog(null, "koneksi berhasil ");
            while(rs.next())  
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(4));  
            }catch(Exception e){ 
            JOptionPane.showMessageDialog(null, "koneksi gagal "+e.getMessage());
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "koneksi gagal "+e.getMessage());
            }  
    }
    public Connection get_con(){
        config();
        return con;
    }
}
