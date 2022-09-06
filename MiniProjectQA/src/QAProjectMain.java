import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;s
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
            Statement stmt2 = conn.createStatement();
            // Mysql 데이터 선택 (QUERY문 동작 확인후 입력)
            // ResultSet rs = stmt.executeQuery(QUERY);
            String MainInPut;
            boolean END = true;
            while(END){
                System.out.println("통계는 (S), 설문은 (P), 종료는 (Q)를 입력 해주세요.");
                
                MainInPut = scanner.nextLine(); //MainInPut 메인 화면에서 입력받는 숫자
                
                if (MainInPut.equals("S") || MainInPut.equals("P") || MainInPut.equals("Q")){
                    
                } else{
                    System.out.println("S, P, Q 중 하나를 입력해 주세요.");
                    continue;
                }

                int val = 0;
                
                switch(MainInPut){
                    case "S":
                        System.out.println("1.설문결과 출력");
                        System.out.println("2.질문별 선택된 답변 개수");
                        System.out.println("3.질문별 가장많이 선택된 답변 개수");
                        System.out.println("4.총 설문자수");

                        String MainInPut2 = scanner.nextLine();

                        if (MainInPut2.equals("1")){
                            val = statics.printAllStastics(stmt);
                        } else if (MainInPut2.equals("2")){
                            val = statics.sumAnsFunction(stmt);
                        } else if (MainInPut2.equals("3")){
                            
                        } else if (MainInPut2.equals("4")){
                            val = statics.sumUserFunction(stmt);
                        }
                        
                        break;
                    case "P":
                        val = polls.PollFunction(stmt,stmt2);
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
