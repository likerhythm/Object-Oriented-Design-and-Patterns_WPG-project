package chain.input;

import data.Person;
import manager.DataManager;

public class PersonInputHandler extends InputChain{
    @Override
    protected void process() {
        System.out.println("자녀의 이름을 입력해주세요");
        String childrenName = scanner.nextLine();

        DataManager.getInstance().setChildrenName(childrenName);

        System.out.println("자녀가 관심있어 하는 사람의 이름을 입력해주세요(공백을 기준으로 중복입력 가능)");
        String input = scanner.nextLine();

        // 공백을 기준으로 문자열 자르기
        String[] names = input.split(" ");

        // data.Person 객체 배열 생성
        Person[] persons = new Person[names.length];
        for (int i = 0; i < names.length; i++) {
            persons[i] = new Person(names[i]);
        }

        DataManager.getInstance().setPersons(persons);
    }
}
