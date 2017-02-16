package seedu.addressbook.data.person;

import static org.junit.Assert.assertFalse;
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
    
    @Test
    public void isSimilar_spelledBackwards_returnsFalse() throws IllegalValueException {
        Name name1 = new Name("Alice");
        Name name2 = new Name("Ecila");
        assertFalse(name1.isSimilar(name2));
    }
    
    @Test
    public void isSimilar_similarName_returnsTrue() throws IllegalValueException {
        Name name1 = new Name("Patricia Alice Stephanie");
        Name name2 = new Name("Alice Low Mei Li");
        assertTrue(name1.isSimilar(name2));
    }
}