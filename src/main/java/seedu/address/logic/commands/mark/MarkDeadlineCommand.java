package seedu.address.logic.commands.mark;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DEADLINE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.TabIndex;
import seedu.address.logic.commands.edit.EditProjectCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.edit.EditProjectCommandParser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.project.Deadline;
import seedu.address.model.project.Project;

public class MarkDeadlineCommand extends Command {
    public static final String COMMAND_WORD = "mark-deadline";
    public static final String MESSAGE_SUCCESS = "The deadline has been marked as completed!";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Marks the specified deadline of the specified project "
            + "as done. \n"
            + "DEADLINE_INDEX must be a positive integer representing the index of the deadline in the displayed "
            + "deadline table, and PROJECT_INDEX must be a positive integer which is the project's index number in the "
            + "displayed project list. \n"
            + "Parameters: "
            + "PROJECT_INDEX DEADLINE_INDEX \n"
            + "DEADLINE_INDEX (must be a positive integer, representing the index of the deadline in the "
            + "displayed deadline table) "
            + "Example: " + COMMAND_WORD + " 1 2";

    private final Index deadlineIndex;
    private final Index projIndex;

    public MarkDeadlineCommand(Index projIndex, Index deadlineIndex) {
        this.deadlineIndex = deadlineIndex;
        this.projIndex = projIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Project> lastShownList = model.getFilteredProjectList();
        if (projIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PROJECT_DISPLAYED_INDEX);
        }

        Project projectToEdit = lastShownList.get(projIndex.getZeroBased());

        if (deadlineIndex.getZeroBased() >= projectToEdit.deadlineListSize()) {
            throw new CommandException(Messages.MESSAGE_INVALID_DEADLINE_DISPLAYED_INDEX);
        }

        EditProjectCommand edit;
        
        try {
            edit = new EditProjectCommandParser().parse(editProjectArgs(
                    projectToEdit.markDeadlineStringRep(deadlineIndex.getZeroBased()),
                    projIndex.getOneBased()));
        } catch (ParseException pe) {
            throw new CommandException(pe.getMessage());
        }
        
        edit.execute(model);
        return new CommandResult(MESSAGE_SUCCESS, TabIndex.Project);
    }

    /**
     * Formats each element in a list of String representations into a String that will be used as the arguments
     * parsed by an EditProjectCommandParser.
     * 
     * @param stringRep The list containing the string representations of the Deadlines to be passed into the parser.
     * @param index The index of the Project to edit.
     * @return A String containing the index of the projects and the deadlines including the marked deadline.
     */
    private String editProjectArgs(List<String> stringRep, int index) {
        String res = "" + index;
        for (String s : stringRep) {
            res += " " + PREFIX_DEADLINE + s;
        }
        return res;
    }
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof MarkDeadlineCommand)) {
            return false;
        }

        MarkDeadlineCommand otherMarkDeadlineCommand = (MarkDeadlineCommand) other;
        return deadlineIndex == otherMarkDeadlineCommand.deadlineIndex
                && projIndex.equals(otherMarkDeadlineCommand.projIndex);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("deadlineIndex", deadlineIndex)
                .add("projIndex", projIndex)
                .toString();
    }
}