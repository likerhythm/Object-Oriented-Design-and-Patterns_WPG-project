package system_state;


import chain.input.*;

public class InputSystemState implements SystemState {

    InputChain personInputHandler;
    InputChain interestInputHandler;
    InputChain operatorInputHandler;
    InputChain quizCounterInputHandler;
    InputChain operandRangeInputHandler;

    private static class InstanceHolder {
        private static final InputSystemState INSTANCE = new InputSystemState();
    }

    public static InputSystemState getInstance() {
        return InputSystemState.InstanceHolder.INSTANCE;
    }


    public InputSystemState() {
        personInputHandler = new PersonInputHandler();
        interestInputHandler = new InterestInputHandler();
        operatorInputHandler = new OperatorInputHandler();
        quizCounterInputHandler = new QuizCounterInputHandler();
        operandRangeInputHandler = new DoubleOperandRangeInputHandler();
    }

    @Override
    public void operation() {
        setInputChain();
        personInputHandler.run(); // 입력 받고 DataManager 세팅
    }

    private void setInputChain() {
        personInputHandler.setNext(interestInputHandler)
                .setNext(operatorInputHandler)
                .setNext(quizCounterInputHandler)
                .setNext(operandRangeInputHandler);
    }
}
