import system_state.AnswerMatchSystemState;
import system_state.GenerateQuizSystemState;
import system_state.InputSystemState;
import system_state.SystemState;

import java.util.Scanner;

public class WPGSystem {
    private SystemState systemState;

    public void setSystemState(SystemState systemState) {
        this.systemState = systemState;
    }

    public void request() {
        systemState.operation();
    }

    public void run() {
        setSystemState(InputSystemState.getInstance());
        request();
        setSystemState(GenerateQuizSystemState.getInstance());
        request();
        setSystemState(AnswerMatchSystemState.getInstance());
        request();

        System.out.println("시스템이 종료되었습니다. 창을 닫으려면 아무 키나 입력해주세요.");
        new Scanner(System.in).nextLine();
    }
}
