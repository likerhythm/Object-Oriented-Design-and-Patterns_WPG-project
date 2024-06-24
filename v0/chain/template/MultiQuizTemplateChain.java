package chain.template;

import data.Interest;
import data.Person;
import data.operator.DoubleOperator;
import data.operator.MultiDoubleOperator;
import manager.DataManager;

public class MultiQuizTemplateChain extends QuizTemplateChain {
    public MultiQuizTemplateChain() {
        this.templateList.add("%s은/는 %d개의 %s을/를 %d묶음 가지고 있습니다. %s는 %s을/를 전부 몇 개 가지고 있습니까?");
    }

    @Override
    public String createTemplate(Person person, Interest interest, DoubleOperator operator, double op1, double op2) {
        if (operator instanceof MultiDoubleOperator) {
            String childrenName = DataManager.getInstance().getChildrenName();
            int randomNumber = random.nextInt(templateList.size());
            String interestName = interest.getName();

            String template = templateList.get(randomNumber);
            template = String.format(template,
                    childrenName, (int) op1, interestName, (int) op2, childrenName, interestName);
            return template;
        } else if (nextHandler != null) {
            return null;
        }

        return null;
    }
}
