package SetOfCommands;

import Parameters.Person;

public class Head extends Command{

    public Head() {
        super("head", " : вывести первый элемент коллекции");
    }

    @Override
    void go() {
        Person jew = null;
        if(CommandsPack.isPeopleDataEmpty()){
            for (Person person:CommandsPack.getPeople_data()) jew = person;
            assert jew != null;
            Show.showPerson(jew);
        }
    }
}
