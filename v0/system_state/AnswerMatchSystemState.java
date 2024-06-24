package system_state;

import data.operator.DivDoubleOperator;
import data.operator.DoubleOperator;
import quiz.Quiz;

import java.util.List;
import java.util.Scanner;

public class AnswerMatchSystemState implements SystemState {

    List<Quiz> quizList;    
    
    private static class InstanceHolder {
        private static final AnswerMatchSystemState INSTANCE = new AnswerMatchSystemState();
    }

    public static AnswerMatchSystemState getInstance() {
        return AnswerMatchSystemState.InstanceHolder.INSTANCE;
    }

    @Override
    public void operation() {
        checkAnswer();
    }

    private void checkAnswer() {

        for (int i = 0; i< quizList.size(); i++) {
            Quiz quiz = quizList.get(i);

            System.out.println("\n" + (i+1) + "번째 문제입니다.");
            double answer = calcAnswer(quiz);
            double input = getAnswer(quiz);

            if (input == answer) { System.out.println("정답입니다!"); }
            else                 { System.out.println("오답입니다! 정답은 " + answer + "입니다."); }
        }
    }

    public void setQuizList(List<Quiz> quizList) {
        this.quizList = quizList;
    }

    private static double calcAnswer(Quiz quiz) {
        DoubleOperator operator = quiz.getOperator();
        double answer = operator.calculate();
        if (operator instanceof DivDoubleOperator) {
            System.out.println("나눗셈 문제입니다. 소수점 아래 첫째자리까지만 입력해주세요.");
            answer = Math.floor(answer * 10) / 10.0;
        }
        return answer;
    }

    private static double getAnswer(Quiz quiz) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(quiz.getTemplate());
        double input = Double.parseDouble(scanner.nextLine());
        return input;
    }
}
