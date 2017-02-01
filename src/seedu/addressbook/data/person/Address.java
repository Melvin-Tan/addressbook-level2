package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be in this format: BLOCK, STREET, UNIT, POSTAL_CODE";

    public final Block block;
    public final Street street;
    public final Unit unit;
    public final PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        String[] addressDetails = trimmedAddress.split(",");
        this.block = new Block(addressDetails[0].trim());
        this.street = new Street(addressDetails[1].trim());
        this.unit = new Unit(addressDetails[2].trim());
        this.postalCode = new PostalCode(addressDetails[3].trim());
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
    	int countComma = 0;
    	for (char c : test.toCharArray()) {
    		if (c == ',') {
    			countComma++;
    		}
    	}
    	return countComma == 3;
    }

    @Override
    public String toString() {
        return block.getBlock() + ", "
        		+ street.getStreet() + ", "
        		+ unit.getUnit() + ", "
        		+ postalCode.getPostalCode();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.block.equals(((Address) other).block)
                && this.street.equals(((Address) other).street)
                && this.unit.equals(((Address) other).unit)
                && this.postalCode.equals(((Address) other).postalCode)); // state check
    }

    @Override
    public int hashCode() {
        return this.block.hashCode()
        		+ this.street.hashCode()
        		+ this.unit.hashCode()
        		+ this.postalCode.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
