package manager;

import data.Interest;
import data.Person;
import data.operand.OperandRange;

public class DataManager {

    private String childrenName;
    private Person[] persons;
    private Interest[] interests;
    private String[] operators;
    private OperandRange operandRange;
    private int quizCounter;

    private static class InstanceHolder {
        private static final DataManager INSTANCE = new DataManager();
    }

    public static DataManager getInstance() { return InstanceHolder.INSTANCE; }

    public void         setChildrenName(String childrenName) { this.childrenName = childrenName; }
    public void         setPersons(Person[] persons) { this.persons = persons; }
    public void         setInterests(Interest[] interests) { this.interests = interests; }
    public void         setOperators(String[] operators) { this.operators = operators; }
    public void         setOperandRange(OperandRange operandRange) { this.operandRange = operandRange; }
    public void         setQuizCounter(int quizCounter) { this.quizCounter = quizCounter; }
    public String       getChildrenName() { return childrenName; }
    public Person[]     getPersons() { return persons; }
    public Interest[]   getInterests() { return interests; }
    public String[]     getOperators() { return operators; }
    public OperandRange getOperandRange() { return operandRange; }
    public int          getQuizCounter() { return quizCounter; }

}
