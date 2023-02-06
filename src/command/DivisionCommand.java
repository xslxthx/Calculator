package command;

public class DivisionCommand extends BaseCommand implements Command{
    public DivisionCommand(int operationNumber, String operationName){
        super(operationNumber, operationName);
    }

    public double calculate(double firstNumber, double secondNumber){
        return firstNumber / secondNumber;
    }
}