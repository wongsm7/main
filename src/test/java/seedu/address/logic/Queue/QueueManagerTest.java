package seedu.address.logic.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

import static seedu.address.testutil.TypicalPersons.AMY;
import static seedu.address.testutil.TypicalPersons.BOB;

class QueueManagerTest {

    private QueueManager queueManager;

    @Test
    void serveNext_success() {
        queueManager = new QueueManager();
        Person patient = new PersonBuilder(AMY).build();
        Person doctor = new PersonBuilder(BOB).build();

        queueManager.addPatient(patient);
        queueManager.addRoom(doctor);
        queueManager.serveNext();
        assertEquals("", queueManager.displayQueue());
    }

    @Test
    void addPatient_success() {
        queueManager = new QueueManager();
        Person patient = new PersonBuilder(AMY).build();
        Person doctor = new PersonBuilder(BOB).build();
        queueManager.addPatient(patient);
        assertEquals(1, queueManager.getSizeOfQueue());
    }

    @Test
    void removePatient_success() {
        queueManager = new QueueManager();
        Person patient = new PersonBuilder(AMY).build();
        queueManager.addPatient(patient);
        queueManager.removePatient(patient);
        assertEquals(0, queueManager.getSizeOfQueue());
    }

    @Test
    void addRoom() {
        queueManager = new QueueManager();
        Person doctor = new PersonBuilder(BOB).build();
        queueManager.addRoom(doctor);
        assertEquals(1, queueManager.getNumOfRoomsAvailable());
    }

    @Test
    void removeRoom() {
        queueManager = new QueueManager();
        Person doctor = new PersonBuilder(BOB).build();
        queueManager.addRoom(doctor);
        queueManager.removeRoom(0);
        assertEquals(0, queueManager.getNumOfRoomsAvailable());
    }

    @Test
    void getCurrentlyServed() {
        queueManager = new QueueManager();
        Person patient = new PersonBuilder(AMY).build();
        Person doctor = new PersonBuilder(BOB).build();

        queueManager.addPatient(patient);
        queueManager.addRoom(doctor);
        queueManager.serveNext();
        assertEquals(patient.toString(), queueManager.getCurrentlyServed(0));
    }
}