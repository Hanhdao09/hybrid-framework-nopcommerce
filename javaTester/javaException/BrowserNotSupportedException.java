package javaException;

public class BrowserNotSupportedException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	public BrowserNotSupportedException(String browserName) {
		super(String.format("Browser with name $s is not supported", browserName));
	}

}
