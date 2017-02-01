package seedu.addressbook.data.person;

public class Block {
	private String _block;
	
	public Block(String block) {
		this._block = block;
	}

	public String getBlock() {
		return _block;
	}
	
	public void setBlock(String newBlock) {
		this._block = newBlock;
	}
	
	@Override
	public boolean equals(Object other) {
		return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && this._block.equals(((Block) other).getBlock()));
	}
}
