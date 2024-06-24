package system_state;

import factory.QuizFactory;
import chain.template.QuizTemplateChain;
import quiz.Quiz;

import java.util.List;

public class GenerateQuizSystemState implements SystemState {

    private QuizFactory quizFactory;

    private static class InstanceHolder {
        private static final GenerateQuizSystemState INSTANCE = new GenerateQuizSystemState();
    }

    public static GenerateQuizSystemState getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public GenerateQuizSystemState() {
        quizFactory = new QuizFactory();
    }

    @Override
    public void operation() {
        List<Quiz> quizList = quizFactory.createQuiz();

        AnswerMatchSystemState.getInstance().setQuizList(quizList);
    }
}
