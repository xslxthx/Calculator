package command;

public class AdditionCommand extends BaseCommand implements Command{
    public AdditionCommand(int operationNumber, String operationName){
        super(operationNumber, operationName);
    }

    @Override
    public double calculate(double firstNumber, double secondNumber){
        return firstNumber + secondNumber;
    }
}