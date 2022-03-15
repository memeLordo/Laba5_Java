package SetOfCommands;

import static SetOfCommands.CommandsPack.*;
import static SetOfCommands.CommandsPack.sortPeopleData;

public class Remove extends Command {
    public Remove() {
        super("remove", "удалить из коллекции один элемент, значение поля которого эквивалентно заданному");
    }

    @Override
    public void go() {
        if(Contains.findIn(CommandsPack.inputCommand)){
            putPeopleDataUp(Contains.containsPerson().getId());
            getPeople_data().pop();
            sortPeopleData();
            System.out.println("Пользователь удалён.");
        }
    }
}
