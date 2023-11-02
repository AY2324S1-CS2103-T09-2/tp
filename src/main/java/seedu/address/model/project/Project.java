package seedu.address.model.project;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATEJOINED;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DEADLINE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DOCUMENT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GITHUBID;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ORGANISATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PROJECT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_RATING;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ROLE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SALARY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.parser.Prefix;
import seedu.address.model.commons.Name;
import seedu.address.model.person.Person;

/**
 * Represents a Project in the address book.
 * Guarantees: immutable; fields are validated.
 */
public class Project {

    private final Name projectName;
    private final Description description;
    private final List<Deadline> deadlines;
    public static final Prefix[] unusedPrefixes = new Prefix[]{ PREFIX_DATEJOINED, PREFIX_SALARY, PREFIX_RATING,
            PREFIX_GITHUBID, PREFIX_ADDRESS, PREFIX_DOCUMENT, PREFIX_EMAIL, PREFIX_ORGANISATION, PREFIX_PHONE, 
            PREFIX_PROJECT, PREFIX_ROLE };

    public static final Prefix[] unusedPrefixesForEdit = new Prefix[]{ PREFIX_DATEJOINED, PREFIX_SALARY, PREFIX_RATING,
            PREFIX_GITHUBID, PREFIX_ADDRESS, PREFIX_DOCUMENT, PREFIX_EMAIL, PREFIX_ORGANISATION, PREFIX_PHONE,
            PREFIX_PROJECT, PREFIX_ROLE, PREFIX_NAME };
    
    private static final Set<String> projectNameList = new HashSet<>();

    /**
     * Constructs a {@code Tag}.
     *
     * @param projectName A valid project name.
     */
    public Project(Name projectName, Description desc, List<Deadline> deadlines) {
        requireAllNonNull(projectName, desc, deadlines);
        this.projectName = projectName;
        this.description = desc;
        this.deadlines = deadlines;
    }
    public Project(String projectName) {
        this(new Name(projectName),new Description(""),new ArrayList<>());
    }
    public String getName() {
        return projectName.fullName;
    }
    
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Project)) {
            return false;
        }

        Project otherTag = (Project) other;
        return projectName.equals(otherTag.projectName)
                && description.equals(otherTag.description)
                && deadlines.equals(otherTag.deadlines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName, description, deadlines);
    }

    /**
     * Returns the name of the Project.
     */
    @Override
    public String toString() {
        return projectName.toString();
    }
    
    public Name getProjectName() {
        return projectName;
    }

    public Description getProjectDescription() {
        return description;
    }

    /**
     * Returns a list with each element being the String representation of the respective deadline.
     * The element at the given index is the String representation of the respective deadline such that it is completed.
     * 
     * @param index The index of the deadline to mark as completed.
     * @return A list containing String representations of deadlines.
     */
    public List<String> markDeadlineStringRep(int index) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < deadlines.size() ; i++) {
            if (i == index) {
                res.add(deadlines.get(i).getDoneStringRepresentation());
            } else {
                res.add(deadlines.get(i).getStringRepresentation());
            }
        }
        return res;
    }

    /**
     * Returns a list with each element being the String representation of the respective deadline.
     * The element at the given index is the String representation of the respective deadline such that it is incomplete.
     *
     * @param index The index of the deadline to mark as incomplete.
     * @return A list containing String representations of deadlines.
     */
    public List<String> unmarkDeadlineStringRep(int index) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < deadlines.size() ; i++) {
            if (i == index) {
                res.add(deadlines.get(i).getUndoneStringRepresentation());
            } else {
                res.add(deadlines.get(i).getStringRepresentation());
            }
        }
        return res;
    }

    /**
     * Returns the size of the deadlines list.
     * 
     * @return An integer representing the size of the deadlines list.
     */
    public int deadlineListSize() {
        return deadlines.size();
    }
    
    /**
     * Returns an immutable list, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public List<Deadline> getProjectDeadlines() {
        return Collections.unmodifiableList(deadlines);
    }
    public boolean isSameProject(Project otherProject) {
        if (otherProject == this) {
            return true;
        }

        return otherProject != null
                && otherProject.getName().equals(getName());
    }

    /**
     * Returns true if a given String is a valid project name.
     * 
     * @param test The String to test.
     */
    public static boolean isValidProject(String test) {
        return projectNameList.contains(test);
    }

    /**
     * Adds the name of the project to projectNameList.
     * 
     * @param project The project with the name to add.
     */
    public static void addProjectName(Project project) {
        projectNameList.add(project.getProjectName().fullName);
    }

    /**
     * Deletes the name of the project from projectNameList.
     *
     * @param project The project with the name to delete.
     */
    public static void deleteProjectName(Project project) {
        projectNameList.remove(project.getProjectName().fullName);
    }
}
