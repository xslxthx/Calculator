import command.Command;
import command.InitialContext;
import datareader.DataReader;

import java.util.Optional;

public class Calculator {
    private static final String SELECT_OPERATION_MESSAGE = "Select operation to calculate";
    private static final String EXIT_OPERATION_MESSAGE = "5. Exit.";
    private static final String INPUT_FIRST_NUMBER_MESSAGE = "Input first number: ";
    private static final String INPUT_SECOND_NUMBER_MESSAGE = "Input second number: ";
    private static final String RESULT_MESSAGE = "Result is: ";
    private static final String INCORRECT_INPUT_MESSAGE = "Incorrect input!";
    private static final String EXIT_OPERATION_NUMBER = "5";
    private static final String UNSUPPORTED_OPERATION_MESSAGE = "Unsupported operation!";
    private final DataReader dataReader;
    private final InitialContext initialContext;

    public Calculator(DataReader dataReader, InitialContext initialContext){
        this.dataReader = dataReader;
        this.initialContext = initialContext;
    }

    public void start(){
        while(true){
            System.out.println(SELECT_OPERATION_MESSAGE);
            initialContext.printAllCommands();
            System.out.println(EXIT_OPERATION_MESSAGE);
            String operationNumber = dataReader.readData();
            Optional<Command> selectedOperation = initialContext.getCommand(Integer.parseInt(operationNumber));
            if (selectedOperation.isPresent()){
                System.out.println(INPUT_FIRST_NUMBER_MESSAGE);
                String firstNumber = dataReader.readData();
                System.out.println(INPUT_SECOND_NUMBER_MESSAGE);
                String secondNumber = dataReader.readData();
                Command command = selectedOperation.get();
                try {
                    double result = command.calculate(Double.parseDouble(firstNumber), Double.parseDouble(secondNumber));
                    System.out.println(RESULT_MESSAGE + result);
                } catch (NumberFormatException e){
                    System.out.println(INCORRECT_INPUT_MESSAGE);
                }
            } else if (operationNumber.equals(EXIT_OPERATION_NUMBER)){
                System.exit(0);
            } else {
                System.out.println(UNSUPPORTED_OPERATION_MESSAGE);
            }
        }
    }
}