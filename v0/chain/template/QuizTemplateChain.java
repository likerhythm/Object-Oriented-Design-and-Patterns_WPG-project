package chain.template;

import data.Interest;
import data.Person;
import data.operator.DoubleOperator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract public class QuizTemplateChain {

    List<String> templateList = new ArrayList<>();
    Random random = new Random();
    QuizTemplateChain nextHandler;

    abstract public String createTemplate(Person person, Interest interest, DoubleOperator operator, double op1, double op2);

    public QuizTemplateChain setNext(QuizTemplateChain nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public String run(Person person, Interest interest, DoubleOperator operator, double op1, double op2) {
        String template = createTemplate(person, interest, operator, op1, op2);
        if (nextHandler != null && template == null) {
            return nextHandler.run(person, interest, operator, op1, op2);
        } else if (template != null) {
            return template;
        }
        return null;
    }

    public void addTemplate(String template) {
        templateList.add(template);
    }

}
