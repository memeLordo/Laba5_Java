package SetOfCommands;

public class Clear extends Command{
    public Clear(String name, String description) {
        super(name, description);
    }

    @Override
    void go() {
        while(!CommandsPack.getPeople_data().empty())
        CommandsPack.getPeople_data().pop();
    }

}
