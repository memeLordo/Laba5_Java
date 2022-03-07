package SetOfCommands;

import static SetOfCommands.CommandsPack.*;

public class UpdateID extends Command {
    public UpdateID() {
        super("up", "description");
    }

    @Override
    void go() {
        putPeopleDataUp(inputID);
        getPeople_data().pop();
        getPeople_data().push(Add.PersonSet(inputID));
        sortPeopleData();
        System.out.println("Пользователь изменён");
    }
}


