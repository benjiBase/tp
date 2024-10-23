package seedu.address.logic.commands;

import seedu.address.model.Model;

/**
 * Command to sort person list by priority level from 1 to 3.
 */
public class SortByPriorityCommand extends Command {
    public static final String COMMAND_WORD = "sortpriority";
    public static final String MESSAGE_SUCCESS = "Sorted person by priority.";

    @Override
    public CommandResult execute(Model model) {
        model.sortPersonByPriority();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
