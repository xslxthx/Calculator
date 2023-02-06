package Command;

public class SubtractionCommand extends BaseCommand implements Command{
    public SubtractionCommand(int operationNumber, String operationName){
        super(operationNumber, operationName);
    }

    @Override
    public double calculate(double firstNumber, double secondNumber){
        return firstNumber - secondNumber;
    }
}