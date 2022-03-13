package SetOfCommands;

import static SetOfCommands.CommandsPack.*;

public class RemoveID extends Command {

    public RemoveID() {
        super("remove", "удалить элемент из коллекции по его id");
    }

    @Override
    public void go() {
        putPeopleDataUp(inputID);
        getPeople_data().pop();
        sortPeopleData();
        System.out.println("Пользователь удалён.");
    }
}
