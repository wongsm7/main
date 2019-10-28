package seedu.address.logic.commands.utils;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyAppointmentBook;
import seedu.address.model.common.ReferenceId;
import seedu.address.model.events.Event;
import seedu.address.model.person.Person;
import seedu.address.model.queue.QueueManager;
import seedu.address.model.queue.Room;
import seedu.address.model.userprefs.ReadOnlyUserPrefs;

/**
 * A default model stub that have all of the methods failing.
 */
public class ModelStub implements Model {
    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public GuiSettings getGuiSettings() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public Path getAddressBookFilePath() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void setAddressBookFilePath(Path addressBookFilePath) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public Path getAppointmentBookFilePath() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void setAppointmentBookFilePath(Path appointmentBookFilePath) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void addPerson(Person person) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void setAddressBook(ReadOnlyAddressBook newData) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public ReadOnlyAddressBook getAddressBook() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public boolean hasPerson(Person person) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public boolean hasPerson(ReferenceId person) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public boolean hasExactPerson(Person person) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void deletePerson(Person target) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void setPerson(Person target, Person editedPerson) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public ObservableList<Person> getFilteredPersonList() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void updateFilteredPersonList(Predicate<Person> predicate) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public QueueManager getQueueManager() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void removeFromQueue(ReferenceId target) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void enqueuePatient(ReferenceId id) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void enqueuePatientToIndex(ReferenceId id, int index) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public boolean isPatientInQueue(ReferenceId id) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public ObservableList<Room> getConsultationRoomList() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void addRoom(Room room) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void addRoomToIndex(Room room, int indexOfRoom) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void removeRoom(Room target) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public boolean hasRoom(Room room) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void setSchedule(ReadOnlyAppointmentBook schedule) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public ReadOnlyAppointmentBook getAppointmentBook() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public boolean hasEvent(Event event) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public boolean hasExactEvent(Event event) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void deleteEvent(Event event) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void addEvent(Event event) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void setEvent(Event target, Event editedEvent) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public ObservableList<Event> getFilteredEventList() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void updateFilteredEventList(Predicate<Event> predicate) {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public void updateFilteredEventList(ReferenceId referenceId) {

    }

    @Override
    public void updateFilteredEventList() {

    }

    @Override
    public void updateToMissedEventList() {

    }

    @Override
    public void displayApprovedAndAckedPatientEvent(ReferenceId referenceId) {

    }


    @Override
    public Boolean isPatientList() {
        return null;
    }

    @Override
    public Boolean isMissedList() {
        return null;
    }

    @Override
    public ObservableList<ReferenceId> getQueueList() {
        throw new AssertionError("This method should not be called.");
    }

    @Override
    public Person resolve(ReferenceId person) {
        throw new AssertionError("This method should not be called.");
    }
}
