package seedu.address.logic.Queue;

import seedu.address.model.person.Person;

import java.util.LinkedList;

public class Queue {
    private LinkedList<Person> listOfPatients;

    public Queue() {
        listOfPatients = new LinkedList<>();
    }

    public Person poll() {
        return listOfPatients.poll();
    }

    public void add(Person person) {
        listOfPatients.add(person);
    }

    public void remove(Person person) {
        listOfPatients.remove(person);
    }

    public int getSize() {
        return listOfPatients.size();
    }

    public String getListOfAllPatients() {
        String output = "";
        for (Person p : listOfPatients) {
            output += p.toString() + "\n";
        }
        return output;
    }
}
