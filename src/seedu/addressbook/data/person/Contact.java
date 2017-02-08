package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's contact in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidContact(String)}
 */
public class Contact {

    public final String value;
    private boolean isPrivate;
    private static String CONTACT_VALIDATION_REGEX;

    /**
     * Validates given contact number.
     *
     * @throws IllegalValueException if given contact string is invalid.
     */
    public Contact(String contact, boolean isPrivate, String MESSAGE_CONTACT_CONSTRAINTS, String CONTACT_VALIDATION_REGEX) throws IllegalValueException {
        this.isPrivate = isPrivate;
        Contact.CONTACT_VALIDATION_REGEX = CONTACT_VALIDATION_REGEX;
        String trimmedContact = contact.trim();
        if (!isValidContact(trimmedContact)) {
            throw new IllegalValueException(MESSAGE_CONTACT_CONSTRAINTS);
        }
        this.value = trimmedContact;
    }

    /**
     * Checks if a given string is a valid person contact.
     */
    public static boolean isValidContact(String test) {
        return test.matches(CONTACT_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Contact // instanceof handles nulls
                && this.value.equals(((Contact) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}