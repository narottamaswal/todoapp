package todo.app.configs;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final transient String errorMsg;
	private final transient String errorType;

	public ValidationException(String errorMsg, String errorType) {
		super(errorMsg);
		this.errorMsg = errorMsg;
		this.errorType = errorType;
	}

	
	public String getErrorMsg() {
		return errorMsg;
	}

	public String getErrorType() {
		return errorType;
	}

}
