package four;

import java.util.HashSet;
import java.util.Set;

/**
 * 4.2
 * 通过封闭机制来保证线程安全
 */
public class PersonSet {

    private final Set<Person> mySet = new HashSet<>();

    public synchronized void addPerson(Person p) {
        mySet.add(p);
    }

    public synchronized boolean containsPerson(Person p) {
        return mySet.contains(p);
    }

    private class Person {
    }
}
