import java.sql.ResultSet;
import java.sql.Statement;

public class QuPrint {
    public String quprint(Statement stmt) {
        String QUERY = "select Qnum, Question " +
                    "from questionn " +
                    "Where 1 = 1 ";
                    
            ResultSet rs = stmt.executeQuery(QUERY);
            // resylt grid, check action output
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("문항 " + rs.getInt("Qnum "));
                System.out.println(" : " + rs.getString("Question"));
                

            }
        
        }
}


