package factory;

import data.operator.*;
import chain.template.QuizTemplateChain;
import manager.DataManager;
import quiz.Quiz;
import quiz.QuizBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class QuizFactory {

    private DataManager dataManager = DataManager.getInstance();
    private QuizBuilder quizBuilder = new QuizBuilder();

    private static class InstanceHolder {
        private static final QuizFactory INSTANCE = new QuizFactory();
    }

    public static QuizFactory getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public List<Quiz> createQuiz() {

        int quizCounter = dataManager.getQuizCounter();
        String[] operators = dataManager.getOperators();

        List<Quiz> quizList = new ArrayList<Quiz>();
        for (int i = 0; i<operators.length; i++) {
            for (int j = 0; j < quizCounter; j++) {
                DoubleOperator operator = createOperator(operators[i]);

                Quiz quiz = quizBuilder.person(dataManager.getPersons())
                        .interest(dataManager.getInterests())
                        .operator(operator)
                        .operandRange(dataManager.getOperandRange())
                        .build();
                quizList.add(quiz);
            }
        }
        return quizList;
    }

    private DoubleOperator createOperator(String operators) {
        switch (operators) {
            case "+":
                return new AddDoubleOperator();
            case "-":
                return new SubDoubleOperator();
            case "*":
                return new MultiDoubleOperator();
            case "/":
                return new DivDoubleOperator();
            default:
                return null;
        }
    }
}
