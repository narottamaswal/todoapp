package todo.app.configs;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	private ResponseEntity<ErrorInfo> error(final String messages, String errorType, final HttpStatus httpStatus,
			String requestURI) {
		return new ResponseEntity<>(new ErrorInfo(new Errors(messages, errorType), requestURI), httpStatus);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorInfo> handleRuntimeException(HttpServletRequest request, final RuntimeException e) {
		log.error(e.getMessage(), e);
		return error(e.getMessage(), "not_found", HttpStatus.NOT_FOUND, request.getRequestURI());
	}

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ErrorInfo> handleInvalidReferralCodeException(HttpServletRequest request,
			ValidationException e) {
		return error(e.getMessage(), e.getErrorType(), HttpStatus.BAD_REQUEST, request.getRequestURI());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		log.error(ex.getMessage());
		Optional<FieldError> fieldError = ex.getBindingResult().getFieldErrors().stream().findFirst();
		return new ResponseEntity<>(
				new ErrorInfo(
						new Errors(fieldError.isPresent() ? fieldError.get().getDefaultMessage() : "",
								ErrorTypeConstants.PARAM_MISSING),
						((ServletWebRequest) request).getRequest().getRequestURI()),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = { ConstraintViolationException.class })
	protected ResponseEntity<ErrorInfo> handleConstraintViolation(ConstraintViolationException e,
			HttpServletRequest request) {
		log.error(e.getMessage());
		Optional<ConstraintViolation<?>> constraintViolation = e.getConstraintViolations().stream().findFirst();
		return error(constraintViolation.isPresent() ? constraintViolation.get().getMessage() : "",
				ErrorTypeConstants.PARAM_MISSING, HttpStatus.BAD_REQUEST, request.getRequestURI());

	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		log.error(ex.getMessage());
		return new ResponseEntity<>(new ErrorInfo(new Errors(ex.getMessage(), ErrorTypeConstants.PARAM_MISSING),
				((ServletWebRequest) request).getRequest().getRequestURI()), HttpStatus.BAD_REQUEST);
	}
}
