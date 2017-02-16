package seedu.addressbook.data.person;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

    @Test
    public void isSimilar_sameName_returnsTrue() throws IllegalValueException {
        Name name1 = new Name("Alice");
        Name name2 = new Name("Alice");
        assertTrue(name1.isSimilar(name2));
    }
}