import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class QAProjectPolls {
    Scanner scanner = new Scanner(System.in);
    
    public int PollFunction(Statement stmt){
        try {
            String QUERY = "select * from questionn";
            ResultSet rs = stmt.executeQuery(QUERY);

            System.out.println("설문");
            
            int n = 0; // 응답 번호 변수
            
            String[] Answer = new String[4];
            
            while (rs.next()) {
                // 데이터 타입, 갯수 일치
                // Retrieve by column name
                System.out.println("Qnum: " + rs.getString("Qnum"));
                System.out.println(rs.getString("Question"));
                System.out.println("1.만족한다. 2.보통 이다. 3.불만이다.");
                Answer[n] = scanner.nextLine(); // 응답 변수
            }
            
            //Answer 입력
            for(int i=0; i<4; i++){
                QUERY = "Insert into answern (Anum, Answer) " +
                        "values (" + i + ",'"+ Answer[i] + "') ";
                rs = stmt.executeQuery(QUERY);
            }

            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
         }

        return 0; 
    }     
}
