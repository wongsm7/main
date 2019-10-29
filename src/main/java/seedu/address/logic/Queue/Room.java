package seedu.address.logic.Queue;

import seedu.address.model.person.Person;

public class Room {
    private Person patientCurrentlyBeingServed;
    private Person doctor;
    private boolean isReady;

    public Room(Person person) {
        this.doctor = person;
        isReady = true;
    }

    public boolean isReadyToServe() {
        return isReady;
    }

    public void serve(Person person) {
        patientCurrentlyBeingServed = person;
        isReady = false;
    }

    public void done() {
        patientCurrentlyBeingServed = null;
        isReady = true;
    }

    public String getPatientCurrentlyBeingServed() {
        return patientCurrentlyBeingServed.toString();
    }
}
