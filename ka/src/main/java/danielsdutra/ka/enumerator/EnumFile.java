package danielsdutra.ka.enumerator;

/**
 * Enumerator for files.
 * 
 * @author daniel_dutra
 */
public enum EnumFile {

	/**
	 * Is Unknown.
	 */
	IS_UNKNOWN("Is Unknown."), 
	/**
	 * It's Archive.
	 */
	IS_ARCHIVE("It's Archive."), 
	/**
	 * It's Directory.
	 */
	IS_DIRECTORY("It's Directory."), 
	;
	private EnumFile(String strValue) {
		this.strValue = strValue;
	}
	public String getValue() {
		return this.strValue;
	}
	private String strValue;
}