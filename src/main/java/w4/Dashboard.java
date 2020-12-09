package w4;

import org.kohsuke.github.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Dashboard {

    public static void main(String[] args) throws Exception {
        GitHub gitHub = GitHub.connect();
        // GHRepository repository = gitHub.getRepository("gtpe/java-study");
        GHRepository repository = gitHub.getRepository("whiteship/live-study");

        /*String[] issues = {
                "1주차 과제: JVM은 무엇이며 자바 코드는 어떻게 실행하는 것인가."
                ,"2주차 과제: 자바 데이터 타입, 변수 그리고 배열","3주차 과제: 연산자","4주차 과제: 제어문","5주차 과제: 클래스"
                ,"6주차 과제: 상속","7주차 과제: 패키지","8주자 과제: 인터페이스","9주차 과제: 예외 처리","10주차 과제: 멀티쓰레드 프로그래밍"
                ,"11주차 과제: Enum","12주차 과제: 애노테이션","13주차 과제: I/O","14주차 과제: 제네릭","15주차 과제: 람다식"
                ,"16주차 과제: 문자열","17주차 과제: 콜렉션","18주차 과제: 스트림"
        };
        for (String issue : issues) {
            repository.createIssue(issue).create();
        }*/

        HashMap<String, int[]> userMap = new HashMap<>();
        for(int i=1; i<=18; i++) {
            GHIssue issue = repository.getIssue(i);
            List<GHIssueComment> comments = issue.getComments();
            for (GHIssueComment comment : comments) {
                GHUser user = comment.getUser();
                int[] weeks;
                if(userMap.containsKey(user.getLogin())) {
                    weeks = userMap.get(user.getLogin());
                } else {
                    weeks = new int[18];
                }
                weeks[i-1] = 1;
                userMap.put(user.getLogin(), weeks);
            }
        }

        for (String userName : userMap.keySet()) {
            System.out.print(userName + " ");
            int[] weeks = userMap.get(userName);
            System.out.print(Arrays.toString(weeks) + " ");
            System.out.println(String.format("%.2f", ((float) Arrays.stream(weeks).sum()/18)*100) + " %");
        }
    }

}
