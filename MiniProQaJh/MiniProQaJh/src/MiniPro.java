import java.sql.*;
import java.util.Scanner;


public class MiniPro {
    public void main(String[] args){
        final String DB_URL = "jdbc:mysql://localhost/data_biz_polls";
        final String USER = "root";
        final String PASS = "tbrs00002b";

        Scanner sc = new Scanner(System.in);

        Connection conn;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        

        } catch (SQLException e) {
            
            e.printStackTrace();
        }

        QuPrint qprnt = new QuPrint(stmt)
        
        return;
    }
    
}