package chain.input;

import data.operand.OperandRange;
import manager.DataManager;

import java.util.Arrays;

public class DoubleOperandRangeInputHandler extends InputChain{
    @Override
    protected void process() {
        System.out.println("피연산자 범위를 공백을 기준으로 정수로 입력해주세요. (예시: 1 10)");
        String input = scanner.nextLine();

        // 공백을 기준으로 range의 min, max값 나누기
        int[] range = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int min = range[0];
        int max = range[1];

        OperandRange operandRange = new OperandRange(min, max);

        DataManager.getInstance().setOperandRange(operandRange);
    }
}
