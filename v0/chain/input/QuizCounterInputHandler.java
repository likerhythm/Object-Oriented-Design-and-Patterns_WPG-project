package chain.input;

import manager.DataManager;

public class QuizCounterInputHandler extends InputChain{
    @Override
    protected void process() {
        System.out.println("연산자 당 생성할 문제의 개수를 정수로 입력해주세요.");
        int quizCounter = Integer.parseInt(scanner.nextLine());

        DataManager.getInstance().setQuizCounter(quizCounter);
    }
}
