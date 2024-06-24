package chain.template;

import data.Interest;
import data.Person;
import data.operator.AddDoubleOperator;
import data.operator.DoubleOperator;
import manager.DataManager;

public class AddQuizTemplateChain extends QuizTemplateChain {

    public AddQuizTemplateChain() {
        this.templateList.add("%s은/는 %s을/를 %d개 가지고 있습니다. %s는 %s을 %d개 가지고 있습니다." +
                "그들이 가지고 있는 %s은/는 모두 몇 개입니까?");
    }

    @Override
    public String createTemplate(Person person, Interest interest, DoubleOperator operator, double op1, double op2) {
        if (operator instanceof AddDoubleOperator) {
            String childrenName = DataManager.getInstance().getChildrenName();
            int randomNumber = random.nextInt(templateList.size());
            String template = templateList.get(randomNumber);

            String interestName = interest.getName();

            template = String.format(template,
                    childrenName, interestName, (int) op1, person.getName(), interestName, (int) op2, interestName);
            return template;
        } else if (nextHandler != null) {
            return null;
        }

        return null;
    }
}
