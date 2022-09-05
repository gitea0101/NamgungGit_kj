import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QAProjectMain {
    static void main (String[] args){
        static final String DB_URL = "jdbc:mysql://localhost/world";
        static final String USER = "root";
        static final String PASS = "tbrs00002b";
        public static String QUERY = "";

        QAProjectPolls polls = new QAProjectPolls();
        QAProjectStatics statics = new QAProjectStatics();

        try {



          } catch (SQLException e) {
             e.printStackTrace();
          } 


    }
}
