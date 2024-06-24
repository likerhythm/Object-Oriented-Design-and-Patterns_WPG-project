package data.operand;

public class OperandRange {
    private double min;
    private double max;

    public OperandRange(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public void setMin(double min) {
        this.min = min;
    }
    public void setMax(double max) {
        this.max = max;
    }
    public double getMin() {
        return min;
    }
    public double getMax() {
        return max;
    }
}
