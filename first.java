import java.sql.*; 

public class first {

    public static void main(String[] args) {
        try{
            // load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Create Connection
            String url = "jdbc:mysql://localhost:3306/JDBC_TUTORIAL";
            Connection con = DriverManager.getConnection(url, "root", "sqlpasswordroot");
            
            if(con.isClosed()) {
                System.out.println("Connection is closed.");
                return;
            }
            else {
                System.out.println("Connected to database");
            }

            Statement stmt = con.createStatement();

            querries.Querries(stmt, con);
            
            con.close();
            
        }
        catch(Exception e) {
            System.out.println("Error at connection.");
            e.printStackTrace();
        }
    }
}
























