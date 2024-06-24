package chain.template;

import data.Interest;
import data.Person;
import data.operator.DivDoubleOperator;
import data.operator.DoubleOperator;
import manager.DataManager;

public class DivQuizTemplateChain extends QuizTemplateChain {

    public DivQuizTemplateChain() {
        this.templateList.add("%s은/는 %s을/를 %d개 가지고 있습니다. %s는 %d명의 친구에게 똑같이 나누어 주고 싶습니다." +
                "각각 %s를 몇 개씩 가지게 되나요?");
    }

    @Override
    public String createTemplate(Person person, Interest interest, DoubleOperator operator, double op1, double op2) {
        if (operator instanceof DivDoubleOperator) {
            String childrenName = DataManager.getInstance().getChildrenName();
            int randomNumber = random.nextInt(templateList.size());
            String interestName = interest.getName();

            String template = templateList.get(randomNumber);
            template = String.format(template,
                    childrenName, interestName, (int) op1, childrenName, (int) op2, interestName);
            return template;
        } else if (nextHandler != null) {
            return null;
        }
        return null;
    }
}
