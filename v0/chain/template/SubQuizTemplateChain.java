package chain.template;

import data.Interest;
import data.Person;
import data.operator.DoubleOperator;
import data.operator.SubDoubleOperator;
import manager.DataManager;

public class SubQuizTemplateChain extends QuizTemplateChain {

    public SubQuizTemplateChain() {
        this.templateList.add("%s은/는 %s을/를 %d개 가지고 있습니다. %s는 %s에게 %s %d개를 주었습니다. %s에게 몇 개의 %s가 남았습니까?");
    }

    @Override
    public String createTemplate(Person person, Interest interest, DoubleOperator operator, double op1, double op2) {
        if (operator instanceof SubDoubleOperator) {
            String childrenName = DataManager.getInstance().getChildrenName();
            int randomNumber = random.nextInt(templateList.size());
            String interestName = interest.getName();

            String template = templateList.get(randomNumber);
            template = String.format(template,
                    childrenName, interestName, (int) op1, childrenName,
                    person.getName(), interestName, (int) op2, childrenName, interestName);
            return template;
        } else if (nextHandler != null) {
            return null;
        }

        return null;
    }
}
