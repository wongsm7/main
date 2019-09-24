package seedu.address.logic.Queue;

import seedu.address.model.person.Person;

import java.util.ArrayList;

public class QueueManager {
    private Queue patientQueue;
    private ArrayList<Room> listOfRooms;

    public QueueManager() {
        this.patientQueue = new Queue();
        this.listOfRooms = new ArrayList<>();
    }

    /**
     * Serve the next patient in queue when a patient leaves a room
     *
     * @param index of the room which a patient left
     * @return A String which shows the patient being assigned to which room
     */
    public String serveNext(int index) {
        Person patient = patientQueue.poll();
        listOfRooms.get(index).done();
        if (isAllFull()) {
            return "All rooms are full";
        }

        int roomNumber = serve(patient);
        return patient.toString() + " is being allocated to " + roomNumber;
    }

    /**
     * Serve the next patient in queue
     *
     * @return A String which shows the patient being assigned to which room
     */
    public String serveNext() {
        Person patient = patientQueue.poll();
        if (isAllFull()) {
            return "All rooms are full";
        }

        int roomNumber = serve(patient);
        return patient.toString() + " is being allocated to " + roomNumber;
    }

    /**
     * Finds an empty room and allocates the patient to the room
     *
     * @return An int which shows the patient being assigned to which room
     */
    public int serve(Person patient) {
        for (int i = 0; i < listOfRooms.size(); i++) {
            if (listOfRooms.get(i).isReadyToServe()) {
                listOfRooms.get(i).serve(patient);
                return i;
            }
        }
        return 0;
    }

    public void addPatient(Person person) {
        patientQueue.add(person);
    }

    public void removePatient(Person person) {
        patientQueue.remove(person);
    }

    public void addRoom(Person person) {
        listOfRooms.add(new Room(person));
    }

    public void removeRoom(int index) {
        listOfRooms.remove(index);
    }

    public String displayQueue() {
        return patientQueue.getListOfAllPatients();
    }

    public String getCurrentlyServed(int index) {
        return listOfRooms.get(index).getPatientCurrentlyBeingServed();
    }

    public int getSizeOfQueue() {
        return patientQueue.getSize();
    }

    public int getNumOfRoomsAvailable() {
        return listOfRooms.size();
    }

    private boolean isAllFull() {
        for (int i = 0; i < listOfRooms.size(); i++) {
            if (listOfRooms.get(i).isReadyToServe()) {
                return false;
            }
        }
        return true;
    }
}
