
package net.sf.jranges.range;


public class RangeException extends RuntimeException {

	private static final long serialVersionUID = -6555274736122521475L;

	public RangeException() {
		
	}

	public RangeException(String message) {
		super(message);
		
	}
	
	public RangeException(Throwable cause) {
		super(cause);
	
	}

	public RangeException(String message, Throwable cause) {
		super(message, cause);
		
	}

}
