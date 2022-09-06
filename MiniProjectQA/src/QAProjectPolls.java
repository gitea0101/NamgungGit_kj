import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.Query;

public class QAProjectPolls {
    Scanner scanner = new Scanner(System.in);
    
    public int PollFunction(Statement stmt){
        try {
            String QUERY = "select * from questionn";
            String QUERY2 = "select * from AnswerN";
            ResultSet rs = stmt.executeQuery(QUERY);
            ResultSet rs2 = stmt.executeQuery(QUERY2);

            System.out.println("이름을 입력해 주세요.");
            String UserName = scanner.nextLine(); // 유저 이름 변수
            int UserNum = 1;
            // UID 테이블에 이름이 있을시 UserNum 검사

            int n = 0; // 응답 번호 변수
            
            String[] Answer = new String[4];
            
            while (rs.next()) {// 설문 응답 코드
                // 데이터 타입, 갯수 일치
                // Retrieve by column name
                System.out.println("Qnum: " + rs.getString("Qnum"));
                System.out.println(rs.getString("Question"));
                while(rs2.next()){
                    int a = 1;
                    System.out.print( a + "." + rs2.getString("Answer") +" ");
                    a++;
                }
                Answer[n] = scanner.nextLine(); // 응답 변수
                n=n+1;
            }

            // 설문 SQl 입력 코드
            int n2 = 1; // table 번호 변수 
            
            // UserNum 입력(이름이 없을때)
            QUERY2 = "Insert into User (UserNum, NAME)" +
                            "values (" + n2 + ",'" + UserNum + "')";
            
            rs2 = stmt.executeQuery(QUERY2);

            while(rs2.next()){
                n2++;
                UserNum++;
            }

            int val = stmt.executeUpdate(QUERY);
            
            n2 = 1; // table 번호 변수 초기화

            //Answer 입력
            QUERY2 = "select * from answern";
            rs2 = stmt.executeQuery(QUERY2);
            
            while(rs2.next()){
                n2++;
            }
            val = stmt.executeUpdate(QUERY);

            /* Count 함수를 써서 테이블 크기를 받는 방법?
            String QUERY3 = "Select Count(*) from answern";
            ResultSet rs3 = stmt.executeQuery(QUERY3);
            n2 = rs3.getInt("Count(*)");
            */

            for(int i =0; i<4; i++){
                QUERY = "Insert into answern (Anum, An) " +
                        "values (" + n2 + ",'" + Answer[i] + "')";
                n2++;

                val = stmt.executeUpdate(QUERY);
            }
            //QA 데이터 입력

            for(int i =0; i<4; i++){
                QUERY = "Insert into QA (QAnum, UserNum, Qnum, An) " +
                        "values (" + 1 + ",'" + 2 +", " + 3 + ", " + 4 + ")";

                val = stmt.executeUpdate(QUERY);
            }
            
            return 1;
            
        } catch (SQLException e) {
            e.printStackTrace();
         }

        return 0; 
    }     
}
