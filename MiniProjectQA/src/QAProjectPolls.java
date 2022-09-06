import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class QAProjectPolls {
    Scanner scanner = new Scanner(System.in);
    
    public int PollFunction(Statement stmt, Statement stmt2){
        try {
            String QUERY = "select * from QuestionN";
            String QUERY2 = "select * from AnswerN";
            ResultSet rs = stmt.executeQuery(QUERY);
            ResultSet rs2 = stmt2.executeQuery(QUERY2);

            System.out.println("이름을 입력해 주세요.");
            String UserName = scanner.nextLine(); // 유저 이름 변수
            int UserNum = 1;
            // UID 테이블에 이름이 있을시 UserNum 검사

            int n = 0; // 응답 번호 변수
            
            String[] Answer = new String[4];

            try{
                while (rs.next()) {// 설문 응답 코드
                    System.out.println("Qnum: " + rs.getString("Qnum"));
                    System.out.println(rs.getString("Question"));

                    rs2 = stmt2.executeQuery(QUERY2);
                    int a = 1;
                    while(rs2.next()){
                        System.out.print( a + "." + rs2.getString("Answer") +" ");
                        a++;
                    }
                    Answer[n] = scanner.nextLine(); // 응답 변수
                    n=n+1;
                    }
                    
                    for(int i=0;i<4;i++){
                       if (Integer.parseInt(Answer[i]) > 3 || Integer.parseInt(Answer[i]) < 1 ){
                        throw new Exception();
                       }

                }
            } catch(Exception e){
                System.out.println("1,2,3 중 하나를 입력해 주세요.");
                return 1;
            }

            // 설문 SQl 입력 코드
            int n2 = 1; // table 번호 변수 
            
            
            
            // UserNum 입력(이름이 없을때)
            QUERY2 = "select * from User";

            rs2 = stmt2.executeQuery(QUERY2);

            while(rs2.next()){
                UserNum++;
            }

            QUERY2 = "Insert into User (UserNum, NAME) " +
                    "values (" + UserNum + ",'" + UserName + "')";

            int val = stmt2.executeUpdate(QUERY2);
            
            n2 = 1; // table 번호 변수 초기화
            
            //Answer 입력
            QUERY2 = "select * from QAtable";
            rs2 = stmt2.executeQuery(QUERY2);
            
            while(rs2.next()){
                n2++;
            }
            

            /* Count 함수를 써서 테이블 크기를 받는 방법?
            String QUERY3 = "Select Count(*) from QAtable";
            ResultSet rs3 = stmt.executeQuery(QUERY3);
            n2 = rs3.getInt("Count(*)");
            */

            for(int i =0; i<4; i++){
                QUERY2 = "Insert into QAtable (Qnum, Anum, QAnum) " +
                        "values (" + (i+1) + "," + Answer[i] + "," + n2 + ")";
                n2++;

                val = stmt2.executeUpdate(QUERY2);
            }
            //QA 데이터 입력


            return 1;
            
        } catch (SQLException e) {
            e.printStackTrace();
         }

        return 0; 
    }     
}
