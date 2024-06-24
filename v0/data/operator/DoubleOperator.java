package data.operator;

abstract public class DoubleOperator {

    double o1, o2;

    abstract public double calculate();

    public void setO1O2(double o1, double o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    public void printOperand() {
        System.out.println("o1 = " + o1 + " o2 = " + o2);
    }
}
