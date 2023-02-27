import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;


public class querries {

    static void Querries(Statement stmt, Connection con) {
        try {   
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter the name of the new table");
            String tableName = br.readLine();
    
            create_table(stmt, tableName);
            System.out.println("Table created.");

            System.out.print("\nDo you want to insert value ? y = yes, other key = no : ");
            String decision = br.readLine();

    
            while(decision.equals("y")) {
                
                insert(stmt);
                show_all(stmt, tableName, con);
                
                System.out.print("\nDo you want to insert value ? y = yes, other key = no : ");
                decision = br.readLine();
            }
        }


        catch(Exception e) {
            System.out.println("Error at inserting");
            System.out.println(e);
        }
    }


    static void create_table(Statement stmt, String tableName) throws Exception {
        String q = String.format("create table %s( RollNo int, FullName varchar(255), Address varchar(255));", tableName);
        stmt.executeUpdate(q);
    }

    static void insert(Statement stmt) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("\nEnter Roll Number : ");
        String roll = br.readLine();

        System.out.print("Enter Name : ");
        String name = br.readLine();

        System.out.print("Enter Address : ");
        String addr = br.readLine();

        // insert querry for student table
        String q = String.format("insert into students value(%s, '%s', '%s')", roll, name, addr);
        stmt.executeUpdate(q);

        System.out.println("\nInserted one new Row.\n");
    }


    static void show_all(Statement stmt, String tableName, Connection con) throws Exception {
        String allRow = String.format("select * from %s", tableName);
        PreparedStatement pstmt = con.prepareStatement(allRow);
        ResultSet res = pstmt.executeQuery(allRow);

        while(res.next()) {
          int rollNo = res.getInt("RollNo");
          String Name = res.getString("FullName");
          String Address = res.getString("Address");

          System.err.println("Roll Number : " + rollNo + ", Name : " + Name + ", Address : " + Address);
        }
    }
}