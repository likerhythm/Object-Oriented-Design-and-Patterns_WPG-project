package chain.input;

import data.operator.*;
import manager.DataManager;

public class OperatorInputHandler extends InputChain{
    @Override
    protected void process() {
        System.out.println("연산자를 입력해주세요.(공백을 기준으로 중복입력 가능)");
        String input = scanner.nextLine();

        // 공백을 기준으로 문자열 자르기
        String[] names = input.split(" ");

        DataManager.getInstance().setOperators(names);
    }
}
