package three;


import java.awt.*;
import java.sql.Connection;
import java.util.*;

public class SafeListener {

    private final EventListener eventListener;

    private SafeListener() {
        eventListener = new EventListener() {
        };
    }

//    public static SafeListener newInstance(EventSource source) {
//        SafeListener safeListener = new SafeListener();
//    }

    public int loadTheArk(Collection<Animal> candidates) {
        SortedSet<Animal> animals;
        int numPairs = 0;
        Animal candidate = null;

        //
        animals = new TreeSet<Animal>(new SpeciesGenderComparator());
        animals.addAll(candidates);

        for (Animal animal : animals) {
            if (candidate == null || !candidate.isPotentialMate(animal)) {
                candidate = animal;
            } else {

            }
        }

        return numPairs;
    }

    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {
        @Override
        protected Connection initialValue() {
            return super.initialValue();
        }
    };

    public static Connection getConnection() {
        return connectionHolder.get();
    }

    private static class Animal {

        public boolean isPotentialMate(Animal animal) {
            return true;
        }
    }

    private static class SpeciesGenderComparator implements Comparator {

        public int compare(Object o1, Object o2) {
            return 0;
        }
    }
}
