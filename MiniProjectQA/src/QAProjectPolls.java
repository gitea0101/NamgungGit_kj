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
                n=n+1;
            }
            
            int n2 = 1; // AnswerN 저장 번호 변수 

            //Answer 입력
            String QUERY2 = "select * from answern";
            ResultSet rs2 = stmt.executeQuery(QUERY2);
            
            while(rs2.next()){
                n2++;
            }
            /* Count 함수를 써서 테이블 크기를 받는 방법?
            String QUERY3 = "Select Count(*) from answern";
            ResultSet rs3 = stmt.executeQuery(QUERY3);
            n2 = rs3.getInt("Count(*)");
            */

            for(int i =0; i<4; i++){
                QUERY = "Insert into answern (Anum, Answer) " +
                        "values (" + n2 + ",'" + Answer[i] + "')";
                n2++;

                int val = stmt.executeUpdate(QUERY);
            }
            return 1;
            
        } catch (SQLException e) {
            e.printStackTrace();
         }

        return 0; 
    }     
}
