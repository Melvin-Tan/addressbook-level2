package seedu.addressbook.data.person;

public class Unit {
	private String _unit;
	
	public Unit(String unit) {
		this._unit = unit;
	}

	public String getUnit() {
		return _unit;
	}
	
	public void setUnit(String newUnit) {
		this._unit = newUnit;
	}
	
	@Override
	public boolean equals(Object other) {
		return other == this // short circuit if same object
                || (other instanceof Unit // instanceof handles nulls
                && this._unit.equals(((Unit) other).getUnit()));
	}
}
