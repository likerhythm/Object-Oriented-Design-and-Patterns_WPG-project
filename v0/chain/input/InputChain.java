package chain.input;

import manager.DataManager;

import java.util.Scanner;

public abstract class InputChain {

    protected InputChain nextHandler = null;
    protected Scanner scanner = new Scanner(System.in);

    // 체인 세팅
    public InputChain setNext(InputChain nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    // 핸들러가 수행할 로직
    protected abstract void process();

    public void run() {
        process();
        if (nextHandler != null) {
            nextHandler.run();
        } else {
            DataManager dataManager = DataManager.getInstance();
        }
    }
}
