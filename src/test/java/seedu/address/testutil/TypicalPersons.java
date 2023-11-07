package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.developer.Developer;

/**
 * A utility class containing a list of {@code Developer} objects to be used in tests.
 */
public class TypicalPersons {

    public static final Developer ALICE = new DeveloperBuilder().withName("Alice Pauline")
            .withAddress("123, Jurong West Ave 6, #08-111")
            .withEmail("alice@example.com")
            .withPhone("94351253")
            .withProjects("AndroidApp")
            .withDateJoined("01.01.2019") // Add Date Joined
            .withRole("Developer")
            .withSalary("4500") // Add Salary
            .withGithubId("aliceGitHubID") // Add Github ID
            .withRating("3") // Add Rating
            .build();

    public static final Developer BENSON = new DeveloperBuilder().withName("Benson Meier")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withEmail("benson@example.com")
            .withPhone("98765432")
            .withProjects("AppleBEn", "BigBen")
            .withDateJoined("03.02.2010")
            .withRole("Developer")
            .withSalary("4000")
            .withGithubId("BeNM")
            .withRating("2")
            .build();
    public static final Developer CARL = new DeveloperBuilder().withName("Carl Kurz")
            .withPhone("95352563")
            .withEmail("heinz@example.com")
            .withAddress("WallStreet")
            .withDateJoined("05.15.2015") // Add Date Joined
            .withRole("Developer")
            .withSalary("4800") // Add Salary
            .withGithubId("CarlK")
            .withRating("3") // Add Rating
            .build();
    public static final Developer DANIEL = new DeveloperBuilder().withName("Daniel Meier")
            .withPhone("87652533")
            .withEmail("cornelia@example.com")
            .withAddress("10th street")
            .withProjects("AppleDan")
            .withDateJoined("11.20.2017") // Add Date Joined
            .withRole("Developer")
            .withSalary("4200") // Add Salary
            .withGithubId("DanMeier")
            .withRating("4") // Add Rating
            .build();
    public static final Developer ELLE = new DeveloperBuilder().withName("Elle Meyer")
            .withPhone("94822244")
            .withEmail("werner@example.com")
            .withAddress("michegan ave")
            .withDateJoined("09.08.2016") // Add Date Joined
            .withRole("Developer")
            .withSalary("4300") // Add Salary
            .withGithubId("ElleM")
            .withRating("5") // Add Rating
            .build();
    public static final Developer FIONA = new DeveloperBuilder().withName("Fiona Kunz")
            .withPhone("94824271")
            .withEmail("lydia@example.com")
            .withAddress("little tokyo")
            .withDateJoined("02.14.2018") // Add Date Joined
            .withRole("Developer")
            .withSalary("4400") // Add Salary
            .withGithubId("FionaK")
            .withRating("1") // Add Rating
            .build();
    public static final Developer GEORGE = new DeveloperBuilder().withName("George Best")
            .withPhone("94824424")
            .withEmail("anna@example.com")
            .withAddress("4th street")
            .withDateJoined("07.30.2019") // Add Date Joined
            .withRole("Developer")
            .withSalary("4600") // Add Salary
            .withGithubId("GeorgeB")
            .withRating("5") // Add Rating
            .build();
    // Manually added
    public static final Developer HOON = new DeveloperBuilder().withName("Hoon Meier")
            .withPhone("84824242")
            .withEmail("stefan@example.com")
            .withAddress("little india")
            .withDateJoined("06.10.2016") // Add Date Joined
            .withRole("Developer")
            .withSalary("4600") // Add Salary
            .withGithubId("HoonMeier") // Add Github ID
            .withRating("2") // Add Rating
            .build();
    public static final Developer IDA = new DeveloperBuilder().withName("Ida Mueller")
            .withPhone("8482131")
            .withEmail("hans@example.com")
            .withAddress("chicago ave")
            .withDateJoined("12.05.2017") // Add Date Joined
            .withRole("Developer")
            .withSalary("4300") // Add Salary
            .withGithubId("IdaMueller") // Add Github ID
            .withRating("5") // Add Rating
            .build();

    // Manually added - Developer's details found in {@code CommandTestUtil}
    public static final Developer AMY = new DeveloperBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY).withProjects(VALID_TAG_FRIEND).build();
    public static final Developer BOB = new DeveloperBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB).withProjects(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPersons() {
    } // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Developer developer : getTypicalPersons()) {
            ab.addDeveloper(developer);
        }
        return ab;
    }

    public static List<Developer> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
