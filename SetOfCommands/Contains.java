package SetOfCommands;

import Parameters.Person;

import static SetOfCommands.CommandsPack.getPeople_data;
import static SetOfCommands.CommandsPack.isDefaultCommand;
import static SetOfCommands.Show.showPerson;


public class Contains extends Command {
    static Person person;

    public Contains() {
        super("contains", "description");
    }

    public static boolean findIn(Object obj) {
        String line = obj.toString();
        boolean trigger = true;
        for (Person p : getPeople_data()) {
            if (p.getId().toString().equals(line) |
                    p.getName().contains(line) |
                    p.getCoordinates().contains(line) |
                    p.getHeight().toString().equals(line) |
                    p.getWeight().toString().equals(line) |
                    p.getCreationDate().toString().equals(line) |
                    p.getBirthday().toString().equals(line) |
                    p.getEyeColor().toString().equals(line) |
                    p.getLocation().contains(line)){
                if (isDefaultCommand) showPerson(p);
                isDefaultCommand =false;
                person = p;
                trigger = false;
            }
        }
        if (trigger) System.err.println("Нет такого элемента.");
        return !trigger;
    }

    public static Person containsPerson() {
        return person;
    }

    @Override
    public void go() {
        isDefaultCommand = true;
        findIn(CommandsPack.inputCommand);
    }
}
