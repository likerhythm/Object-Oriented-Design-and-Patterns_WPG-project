package quiz;

import data.Interest;
import data.Person;
import data.operand.OperandRange;
import data.operator.DoubleOperator;
import chain.template.*;

import java.util.Random;

public class QuizBuilder {
    private Person person;
    private Interest interest;
    private DoubleOperator operator;
    private double operand1, operand2;
    private QuizTemplateChain quizTemplateChain = new AddQuizTemplateChain();

    public QuizBuilder person(Person[] persons) {
        this.person = (Person) getRandomObject(persons);
        return this;
    }
    public QuizBuilder interest(Interest[] interests) {
        this.interest = (Interest) getRandomObject(interests);
        return this;
    }
    public QuizBuilder operator(DoubleOperator operator) {
        this.operator = operator;
        return this;
    }
    public QuizBuilder operandRange(OperandRange operandRange) {
        setOperand(operandRange);
        return this;
    }

    public Quiz build() {
        setChain();
        String templateFormat = makeTemplate();
        return new Quiz(person, interest, operator, operand1, operand2, templateFormat);
    }

    public Person getPerson() {
        return this.person;
    }

    public Interest getInterest() {
        return this.interest;
    }
    public DoubleOperator getOperator() {
        return this.operator;
    }

    private String makeTemplate() {
        String templateFormat = quizTemplateChain.run(person, interest, operator, operand1, operand2);
        return templateFormat;
    }

    private void setChain() {
        quizTemplateChain.setNext(new SubQuizTemplateChain())
                .setNext(new MultiQuizTemplateChain())
                .setNext(new DivQuizTemplateChain());
    }

    // Person, Interest 랜덤 생성
    private Object getRandomObject(Object[] objects) {
        int length = objects.length;
        Random random = new Random();

        int randomNumber = random.nextInt(length);
        return objects[randomNumber];
    }

    private void setOperand(OperandRange operandRange) {
        Random random = new Random();
        double min = operandRange.getMin();
        double max = operandRange.getMax();
        this.operand1 = Math.round(((min + (max - min) * random.nextDouble()) * 10) / 10.0);
        this.operand2 = Math.round(((min + (max - min) * random.nextDouble()) * 10) / 10.0);
        operator.setO1O2(operand1, operand2);
    }
}
