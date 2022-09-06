import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class QAProjectMain {
    public static void main (String[] args){
        final String DB_URL = "jdbc:mysql://localhost/data_biz_polls";
        final String USER = "root";
        final String PASS = "tbrs00002b";
        String QUERY = "";

        QAProjectPolls polls = new QAProjectPolls();
        QAProjectStatics statics = new QAProjectStatics();
        Scanner scanner = new Scanner(System.in);

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // Mysql 새로운 query 생성
            Statement stmt = conn.createStatement();
            // Mysql 데이터 선택 (QUERY문 동작 확인후 입력)
            // ResultSet rs = stmt.executeQuery(QUERY);
            
            boolean END = true;
            while(END){
                System.out.println("통계는 (S), 설문은 (P), 종료는 (Q)를 입력 해주세요.");
                
                String MainInPut = scanner.nextLine(); //MainInPut 메인 화면에서 입력받는 숫자
                
                int val = 0;
                
                switch(MainInPut){
                    case "S":
                        val = statics.StaticsFunction(stmt);
                        break;
                    case "P":
                        val = polls.PollFunction(stmt);
                        break;
                    case "Q":
                        END = false;
                }
            }


          } catch (SQLException e) {
             e.printStackTrace();
          } 

    scanner.close();    
    }
}
