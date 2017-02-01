package seedu.addressbook.data.person;

public class Street {
	private String _street;
	
	public Street(String street) {
		this._street = street;
	}

	public String getStreet() {
		return _street;
	}
	
	public void setStreet(String newStreet) {
		this._street = newStreet;
	}

	@Override
	public boolean equals(Object other) {
		return other == this // short circuit if same object
                || (other instanceof Street // instanceof handles nulls
                && this._street.equals(((Street) other).getStreet()));
	}
}
