package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

public class SortByPriorityTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_sortByPriority_success() {
        new SortByPriorityCommand().execute(model);

        // Update expected model's internal list to reflect the sorted order
        expectedModel.sortPatientsByPriority(PREDICATE_SHOW_ALL_PERSONS);

        // Assert command success
        assertCommandSuccess(new SortByPriorityCommand(), model, SortByPriorityCommand.MESSAGE_SUCCESS, expectedModel);
        assertEquals(expectedModel.getAddressBook().getPersonList(), model.getAddressBook().getPersonList());
    }
}
