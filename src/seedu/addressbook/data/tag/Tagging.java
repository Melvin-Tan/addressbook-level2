package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Represents a Tagging action in the address book.
 * Guarantees: immutable
 */
public class Tagging {
    public enum Status {
        ADDED, DELETED
    }
    
    private Status _status;
    private Person _person;
    private Tag _tag;
    
    public Tagging(Status status, Person person, Tag tag) {
        this._status = status;
        this._person = person;
        this._tag = tag;
    }
    
    public String toString() {
        String sign = null;
        switch (this._status) {
        case ADDED:
            sign = "+";
            break;
        case DELETED:
            sign = "-";
            break;
        }
        return sign + " " + this._person.getName().toString() + " " + this._tag.toString();
    }
}
