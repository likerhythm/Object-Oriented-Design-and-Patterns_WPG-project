package quiz;

import data.Interest;
import data.Person;
import data.operator.DoubleOperator;

public class Quiz {
    private Person person;
    private Interest interest;
    private DoubleOperator operator;
    private double operand1, operand2;
    private String template;

    public Quiz(Person person, Interest interest, DoubleOperator operator,
                double operand1, double operand2, String template) {
        this.person = person;
        this.interest = interest;
        this.operator = operator;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.template = template;
    }

    public DoubleOperator getOperator() { return operator; }
    public Person   getPerson()   { return person;   }
    public Interest getInterest() { return interest; }
    public String   getTemplate() { return template; }
    public double   getOperand1() { return operand1; }
    public double   getOperand2() { return operand2; }
}
