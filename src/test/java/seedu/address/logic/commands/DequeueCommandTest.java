package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.assertUndoCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertUndoCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showPatientAtIndex;
import static seedu.address.logic.commands.CommandTestUtil.showPersonAtIndex;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;
import static seedu.address.testutil.TypicalPersons.getTypicalQueueManager;


import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;

/**
 * Contains integration tests (interaction with the Model, UndoCommand and RedoCommand) and unit tests for
 * {@code DeleteCommand}.
 */
public class DequeueCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs(), getTypicalQueueManager());

    @Test
    public void execute_validIndexUnfilteredList_success() {
        Person personToDelete = model.getFilteredPatientList().get(INDEX_FIRST_PERSON.getZeroBased());
        DequeueCommand dequeueCommand = new DequeueCommand(INDEX_FIRST_PERSON);

        String expectedMessage1 = String.format(DequeueCommand.MESSAGE_DEQUEUE_SUCCESS, personToDelete);
        String expectedMessage2 = String.format(DequeueCommand.MESSAGE_UNDO_DEQUEUE_SUCCESS, personToDelete);

        ModelManager expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs(), model.getQueueManager());
        expectedModel.removePatient(personToDelete);

        //ensures that undo can not be executed before the actual command
        assertUndoCommandFailure(dequeueCommand, model, DequeueCommand.MESSAGE_UNDO_DEQUEUE_ERROR);

        assertCommandSuccess(dequeueCommand, model, expectedMessage1, expectedModel);

        //ensures undo capability
        expectedModel.addPatient(personToDelete);
        assertUndoCommandSuccess(dequeueCommand, model, expectedMessage2, expectedModel);

        //ensures that undo can not be executed again
        assertUndoCommandFailure(dequeueCommand, model, DequeueCommand.MESSAGE_UNDO_DEQUEUE_ERROR);
    }

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredPersonList().size() + 1);
        DequeueCommand dequeueCommand = new DequeueCommand(outOfBoundIndex);

        assertCommandFailure(dequeueCommand, model, Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
    }

    @Test
    public void execute_validIndexFilteredList_success() {
        showPatientAtIndex(model, INDEX_FIRST_PERSON);

        Person personToDelete = model.getFilteredPatientList().get(INDEX_FIRST_PERSON.getZeroBased());
        DequeueCommand dequeueCommand = new DequeueCommand(INDEX_FIRST_PERSON);

        String expectedMessage = String.format(DequeueCommand.MESSAGE_DEQUEUE_SUCCESS, personToDelete);

        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs(), model.getQueueManager());
        expectedModel.removePatient(personToDelete);
        showNoPatient(expectedModel);

        assertCommandSuccess(dequeueCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexFilteredList_throwsCommandException() {
        showPatientAtIndex(model, INDEX_FIRST_PERSON);

        Index outOfBoundIndex = INDEX_SECOND_PERSON;
        // ensures that outOfBoundIndex is still in bounds of address book list
        assertTrue(outOfBoundIndex.getZeroBased() < model.getQueueManager().getPatientList().size());

        DequeueCommand dequeueCommand = new DequeueCommand(outOfBoundIndex);

        assertCommandFailure(dequeueCommand, model, Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        DequeueCommand dequeueFirstCommand = new DequeueCommand(INDEX_FIRST_PERSON);
        DequeueCommand dequeueSecondCommand = new DequeueCommand(INDEX_SECOND_PERSON);

        // same object -> returns true
        assertTrue(dequeueFirstCommand.equals(dequeueFirstCommand));

        // same values -> returns true
        DequeueCommand dequeueFirstCommandCopy = new DequeueCommand(INDEX_FIRST_PERSON);
        assertTrue(dequeueFirstCommand.equals(dequeueFirstCommandCopy));

        // different types -> returns false
        assertFalse(dequeueFirstCommand.equals(1));

        // null -> returns false
        assertFalse(dequeueFirstCommand.equals(null));

        // different person -> returns false
        assertFalse(dequeueFirstCommand.equals(dequeueSecondCommand));
    }

    /**
     * Updates {@code model}'s filtered list to show no one.
     */
    private void showNoPerson(Model model) {
        model.updateFilteredPersonList(p -> false);

        assertTrue(model.getFilteredPersonList().isEmpty());
    }

    /**
     * Updates {@code model}'s filtered list to show no one.
     */
    private void showNoPatient(Model model) {
        model.updateFilteredPatientList(p -> false);

        assertTrue(model.getFilteredPatientList().isEmpty());
    }
}
