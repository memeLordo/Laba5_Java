package SetOfCommands;

import Parameters.Person;

import java.time.LocalDate;

import static SetOfCommands.CommandsPack.*;
import static SetOfCommands.InfoData.getColumns;

public class MaxElement extends Command {
    public MaxElement() {
        super("maxby", "вывести любой объект из коллекции, значение заданного поля которого является максимальным");
    }

    @Override
    public void go() {
        int maxId = 0;
        long maxHeight = 0;
        double maxWeight = 0;
        LocalDate maxBirth = LocalDate.ofEpochDay(0);
        for (Person chel : getPeople_data()) {
            maxId = chel.getId() > maxId ? chel.getId() : maxId;
            maxHeight = chel.getHeight() > maxHeight ? chel.getHeight() : maxHeight;
            maxWeight = chel.getWeight() > maxWeight ? chel.getWeight() : maxWeight;
            maxBirth = chel.getBirthday().isAfter(maxBirth) ? chel.getBirthday() : maxBirth;
        }
        isDefaultCommand = true;
        if (inputCommand.equals(getColumns()[0])) Contains.findIn(maxId);
        else if (inputCommand.equals(getColumns()[3])) Contains.findIn(maxHeight);
        else if (inputCommand.equals(getColumns()[4])) Contains.findIn(maxWeight);
        else if (inputCommand.equals(getColumns()[5])) Contains.findIn(maxBirth);
        else System.err.println("Такого элемента нет. Введите 'info' для справки.");
    }
}
