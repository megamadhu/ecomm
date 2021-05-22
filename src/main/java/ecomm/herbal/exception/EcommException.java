package ecomm.herbal.exception;

public class EcommException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EcommException() {
		super();
	}

	public EcommException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public EcommException(String message) {
		super(message);
	}

}
