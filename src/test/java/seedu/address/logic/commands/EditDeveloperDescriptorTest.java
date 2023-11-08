package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.logic.commands.CommandTestUtil.*;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.edit.EditDeveloperCommand;
import seedu.address.testutil.EditDeveloperDescriptorBuilder;

public class EditDeveloperDescriptorTest {

    @Test
    public void equals() {
        // same values -> returns true
        EditDeveloperDescriptorBuilder descriptorWithSameValues = new EditDeveloperDescriptorBuilder(DESC_AMY);
        assertTrue(DESC_AMY.equals(descriptorWithSameValues));

        // same object -> returns true
        assertTrue(DESC_AMY.equals(DESC_AMY));

        // null -> returns false
        assertFalse(DESC_AMY.equals(null));

        // different types -> returns false
        assertFalse(DESC_AMY.equals(5));

        // different values -> returns false
        assertFalse(DESC_AMY.equals(DESC_BOB));

        // different name -> returns false
        EditDeveloperCommand.EditDeveloperDescriptor editedAmy = new EditDeveloperDescriptorBuilder(DESC_AMY).withName(VALID_NAME_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different phone -> returns false
        editedAmy = new EditDeveloperDescriptorBuilder(DESC_AMY).withPhone(VALID_PHONE_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different email -> returns false
        editedAmy = new EditDeveloperDescriptorBuilder(DESC_AMY).withEmail(VALID_EMAIL_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different address -> returns false
        editedAmy = new EditDeveloperDescriptorBuilder(DESC_AMY).withAddress(VALID_ADDRESS_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // different tags -> returns false
        editedAmy = new EditDeveloperDescriptorBuilder(DESC_AMY).withProjects(VALID_PROJECT_1_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));
    }

    @Test
    public void toStringMethod() {
        EditDeveloperCommand.EditDeveloperDescriptor editDeveloperDescriptor =
                new EditDeveloperDescriptorBuilder().build();
        String expected = EditDeveloperDescriptorBuilder.class.getCanonicalName() + "{name="
                + editDeveloperDescriptor.getName().orElse(null) + ", phone="
                + editDeveloperDescriptor.getPhone().orElse(null) + ", email="
                + editDeveloperDescriptor.getEmail().orElse(null) + ", address="
                + editDeveloperDescriptor.getAddress().orElse(null) + ", tags="
                + editDeveloperDescriptor.getProjects().orElse(null) + "}";
        assertEquals(expected, editDeveloperDescriptor.toString());
    }
}
