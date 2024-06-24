package chain.input;

import data.Interest;
import manager.DataManager;

public class InterestInputHandler extends InputChain{
    @Override
    protected void process() {
        System.out.println("자녀가 관심있어 하는 항목의 이름을 입력해주세요(공백을 기준으로 중복입력 가능) 예시: 축구공");
        String input = scanner.nextLine();

        // 공백을 기준으로 문자열 자르기
        String[] names = input.split(" ");

        // data.Person 객체 배열 생성
        Interest[] interests = new Interest[names.length];
        for (int i = 0; i < names.length; i++) {
            interests[i] = new Interest(names[i]);
        }

        DataManager.getInstance().setInterests(interests);
    }
}
