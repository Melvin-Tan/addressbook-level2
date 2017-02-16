package seedu.addressbook.data.person;

import org.junit.Test;

public class NameTest {

    @Test
    public void isSimilar_sameName_returnsTrue() {
        Name name1 = new Name("Alice");
        Name name2 = new Name("Alice");
        assertTrue(name1.isSimilar(name2));
    }
}