package danielsdutra.ka.exception;

/**
 * Exception to control an unknown sort attempt. 
 * 
 * @author daniel_dutra
 */
public class ExceptionUnknownOrder extends Exception {

	/**
	 * Serial number.
	 */
	private static final long serialVersionUID = 9168614292349241696L;

	private static String msg = "Unknow order for organization.";
	
	public ExceptionUnknownOrder() {
		super(msg);
	}
	public ExceptionUnknownOrder(String msg) {
		super(msg);
	}
}
