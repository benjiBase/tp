package seedu.address.logic.commands;

import seedu.address.model.Model;

/**
 * Command to sort persons by priority level.
 */
public class SortByPriorityCommand extends Command {
    public static final String COMMAND_WORD = "sortPriority";
    public static final String MESSAGE_SUCCESS = "Sorted persons by priority.";

    @Override
    public CommandResult execute(Model model) {
        model.sortPersonByPriority();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
