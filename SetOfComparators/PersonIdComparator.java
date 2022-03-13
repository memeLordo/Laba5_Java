package SetOfComparators;

import Parameters.Person;

import java.util.Comparator;

public class PersonIdComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getId() - p2.getId();
    }
}

