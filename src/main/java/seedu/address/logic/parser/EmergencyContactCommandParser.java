package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.EmergencyContactCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.EmergencyContact;

/**
 * Parses input arguments and creates a new {@code RemarkCommand} object
 */
public class EmergencyContactCommandParser implements Parser<EmergencyContactCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the {@code RemarkCommand}
     * and returns a {@code RemarkCommand} object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public EmergencyContactCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_PHONE);
        Index index;
        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    EmergencyContactCommand.MESSAGE_USAGE), ive);
        }
        String contactName = argMultimap.getValue(PREFIX_NAME).orElse("");
        String contactNumber = argMultimap.getValue(PREFIX_PHONE).orElse("");
        return new EmergencyContactCommand(index, new EmergencyContact(contactName, contactNumber));
    }
}