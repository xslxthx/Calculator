package Command;

public class MultiplicationCommand extends BaseCommand implements Command{
    public MultiplicationCommand(int operationNumber, String operationName){
        super(operationNumber, operationName);
    }

    @Override
    public double calculate(double firstNumber, double secondNumber){
        return firstNumber * secondNumber;
    }
}