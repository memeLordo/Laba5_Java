package SetOfCommands;

import static Parameters.Person.*;
import static SetOfCommands.CommandsPack.*;

public class UpdateID extends Command {
    public UpdateID() {
        super("up", "description");
    }

    @Override
    public void go() {
        putPeopleDataUp(inputID);
        getPeople_data().pop();
        getPeople_data().push(PersonSet(inputID));
        sortPeopleData();
        System.out.println("Пользователь изменён");
    }
}


