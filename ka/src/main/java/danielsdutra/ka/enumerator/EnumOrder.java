package danielsdutra.ka.enumerator;

/**
 * Enumerator for sense and direction.
 * 
 * @author daniel_dutra
 */
public enum EnumOrder {

	/**
	 * For up or from smallest to largest.
	 */
	ASC("up"), 
	/**
	 * For down or from largest to smallest.
	 */
	DESC("down"), 
	;
	private EnumOrder(String value) {
		this.value = value;
	}
	public String getValue() {
		return this.value;
	}
	private String value;
}