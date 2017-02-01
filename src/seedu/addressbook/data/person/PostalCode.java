package seedu.addressbook.data.person;

public class PostalCode {
	private String _postalCode;
	
	public PostalCode(String postalCode) {
		this._postalCode = postalCode;
	}

	public String getPostalCode() {
		return _postalCode;
	}
	
	public void setPostalCode(String newPostalCode) {
		this._postalCode = newPostalCode;
	}
	
	@Override
	public boolean equals(Object other) {
		return other == this // short circuit if same object
                || (other instanceof PostalCode // instanceof handles nulls
                && this._postalCode.equals(((PostalCode) other).getPostalCode()));
	}
}
