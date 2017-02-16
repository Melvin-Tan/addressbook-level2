package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Name {

    public static final String EXAMPLE = "John Doe";
    public static final String MESSAGE_NAME_CONSTRAINTS = "Person names should be spaces or alphabetic characters";
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alpha} ]+";
    public final String fullName;

    /**
     * Validates given name.
     *
     * @throws IllegalValueException if given name string is invalid.
     */
    public Name(String name) throws IllegalValueException {
        String trimmedName = name.trim();
        if (!isValidName(trimmedName)) {
            throw new IllegalValueException(MESSAGE_NAME_CONSTRAINTS);
        }
        this.fullName = trimmedName;
    }

    /**
     * Returns true if a given string is a valid person name.
     */
    public static boolean isValidName(String test) {
        return test.matches(NAME_VALIDATION_REGEX);
    }

    /**
     * Retrieves a listing of every word in the name, in order.
     */
    public List<String> getWordsInName() {
        return Arrays.asList(fullName.split("\\s+"));
    }

    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                && this.fullName.equals(((Name) other).fullName)); // state check
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }
    
    /**
     * Returns true of the other name is very similar to this name.
     * Two names are considered similar if 
     *     - They share the same substring with length of at least 6 (Note: case-insensitive).
     *     - If one of the names have length of less than 6, check whether this name is a substring of the other.
     */
     public boolean isSimilar(Name other) {
         
         // This is to determine the minimumSubstringLength for comparison.
         int shorterLength = (fullName.length() < other.fullName.length()) ? fullName.length() : other.fullName.length();
         final int minimumSubstringLength = (shorterLength < 6) ? shorterLength : 6;
         
         for (int i = 0; i < fullName.length() - minimumSubstringLength + 1; i++) {
             String fullNameSubstring = fullName.substring(i, i + minimumSubstringLength);
             for (int j = 0; j < other.fullName.length() - minimumSubstringLength + 1; j++) {    
                 String otherFullNameSubstring = other.fullName.substring(j, j + minimumSubstringLength);
                 if (fullNameSubstring.equals(otherFullNameSubstring)) {
                     return true;
                 }
             }
         }
         return false;
     }
}
