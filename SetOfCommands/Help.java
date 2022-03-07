package SetOfCommands;

import java.util.Map;
import java.util.Objects;

public class Help extends Command{

    public Help() {
        super("help", "вывести справку по доступным командам");
    }

    @Override
    void go() {
        for(Map.Entry<String, Command> set: CommandsPack.getMap().entrySet()) {

            System.out.print(set.getKey());
            if (set.getKey().equals(new Add().getName()) | set.getKey().equals(new UpdateID().getName()))
                System.out.print(" <element>");
            System.out.println(" : " + set.getValue().getDescription());
        }
    }
}
