package Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InitialContext {
    private static final List<Command> COMMANDS = new ArrayList<>();

    static {
        COMMANDS.add(new AdditionCommand(1, "1. Addition;"));
        COMMANDS.add(new SubtractionCommand(2, "2. Subtraction;"));
        COMMANDS.add(new MultiplicationCommand(3, "3. Multiplication;"));
        COMMANDS.add(new DivisionCommand(4, "4. Division;"));
    }

    public Optional<Command> getCommand(int operationNumber){
        for (Command command : COMMANDS){
            BaseCommand baseCommand = (BaseCommand) command;
            if (baseCommand.getOperationNumber() == operationNumber){
                return Optional.of(command);
            }
        }
        return Optional.empty();
    }

    public void printAllCommands(){
        for (Command command : COMMANDS){
            BaseCommand baseCommand = (BaseCommand) command;
            System.out.println(baseCommand.getOperationName());
        }
    }
}