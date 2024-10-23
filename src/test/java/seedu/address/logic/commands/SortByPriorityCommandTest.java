package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;

public class SortByPriorityCommandTest {
    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();

    @Test
    public void execute_sortByPriority_success() {
        CommandResult expectedCommandResult = new CommandResult(SortByPriorityCommand.MESSAGE_SUCCESS);
        assertCommandSuccess(new SortByPriorityCommand(), model, expectedCommandResult, expectedModel);
    }
}
