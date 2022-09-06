import java.sql.*;

public class QAProjectStatics {
    String QUERY = "";

    public int printAllStastics(Statement stmt) throws SQLException {
        QUERY = "select User.name, QAtable.QAnum, QAtable.Qnum, QAtable.Anum " +
                "from (User left join QAseq " +
                "On User.UserNum = QAseq.UserNum) left join QAtable " +
                "On QAtable.QANum = QAseq.QANum";
        ResultSet rs = stmt.executeQuery(QUERY);
        
        

        while (rs.next()) {
            System.out.print("이름 : " + rs.getString("User.name"));
            System.out.print("    질문 번호 : " + rs.getInt("QAtable.Qnum"));
            System.out.println("    답변 번호 : " + rs.getInt("QAtable.Anum"));
        }
        return 1;

    }

    public int sumAnsFunction(Statement stmt) throws SQLException{//답변의 합
        QUERY = "SELECT QNUM " +
                ",count(case when Anum=1  then 1 end) as A1 " +
                ",count(case when Anum=2 then 1 end) as A2 " +
                ",count(case when Anum=3 then 1 end) as A3 " +
                "FROM qatable group by QNUM ";
        ResultSet rs = stmt.executeQuery(QUERY);
        rs = stmt.executeQuery(QUERY);
        while (rs.next()) {
            // 데이터 타입, 갯수 일치
            // Retrieve by column name
            System.out.print("질문 번호 : " + rs.getInt("QNUM"));
            System.out.print("    1번 : " + rs.getString("A1"));
            System.out.print("    2번 : " + rs.getString("A2"));
            System.out.println("    3번 : " + rs.getString("A3"));
        }
        

        return 1;
     }

    

        public int mostSelectFunction(){

        return 1;
    }

    public int sumUserFunction(Statement stmt) throws SQLException{
        QUERY ="select Count(UserNum) from User";
        ResultSet rs = stmt.executeQuery(QUERY);
        rs = stmt.executeQuery(QUERY);

        while (rs.next()) {
            System.out.println("총 설문자 수 : " + rs.getInt("Count(UserNum)"));
        }
        return 1;
    }
}
