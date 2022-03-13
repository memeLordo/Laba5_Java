package SetOfCommands;

public class Clear extends Command {
    public Clear() {
        super("clear", "очистить коллекцию");
    }

    @Override
    public void go() {
        while (!CommandsPack.getPeople_data().empty())
            CommandsPack.getPeople_data().pop();
        System.out.println("Коллекция очищена.");
    }

}
