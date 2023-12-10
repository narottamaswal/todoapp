package todo.app.constants;

public class ErrorConstants {
	ErrorConstants() {
	}

	public static final String INTERNAL_SERVER_ERROR_CODE = "500";
	public static final String INTERNAL_SERVER_ERROR_DESC = "Internal Server Error";

	public static final String AUTHENTICATION_ERROR_CODE = "401";
	public static final String AUTHENTICATION_ERROR_DESC = "Unauthorised Access";

	public static final String PAYMENT_NOT_COMPLETED_CODE = "401";
	public static final String PAYMENT_NOT_COMPLETED_DESC = "Payment not completed cannot reverse";

	public static final String BAD_REQUEST_ERROR_CODE = "400";
	public static final String BAD_REQUEST_ERROR_DESC = "Bad Request";

	public static final String MALFORMED_JSON_ERROR_CODE = "433";
	public static final String MALFORMED_JSON_ERROR_DESC = "Malformed Json";

	public static final String INVALID_TRANSACTION_ERROR_CODE = "404";
	public static final String INVALID_TRANSACTION_ERROR_DESC = "Invalid Transaction";

	public static final String ALREADY_PROCESSING = "604";
	public static final String ALREADY_PROCESSING_DESC = "Payment request is processing";

	public static final String INSUFFICIENT_BALANCE_ERROR_CODE = "202";
	public static final String INSUFFICIENT_BALANCE_ERROR_DESC = "Insufficient Balance";

	public static final String PAYMENT_ERROR_CODE = "603";
	public static final String PAYMENT_ERROR_DESC = "Payment Failed";

	public static final String FORM_ERROR_GENERAL_CODE = "600";

	public static final String MASTER_DATA_NOT_FOUND_ERROR_CODE = "601";
	public static final String MASTER_DATA_NOT_FOUND_ERROR_DESC = "Data Not Found";

	public static final String INVALID_PAYMENT_ERROR_CODE = "602";
	public static final String INVALID_PAYMENT_ERROR_DESC = "Payment already completed";

	public static final String DUPLICATE_PAYMENT_ERROR_CODE = "604";
	public static final String DUPLICATE_PAYMENT_ERROR_DESC = "Duplicate Payment";

	public static final String REVERSE_PAYMENT_ERROR_CODE = "605";
	public static final String REVERSE_PAYMENT_ERROR_DESC = "Reverse Payment Failed";

	public static final String ALREADY_REVERSE_PAYMENT_ERROR_CODE = "605";
	public static final String ALREADY_REVERSE_PAYMENT_ERROR_DESC = "Transaction is already reversed";

	public static final String REVERSE_PAYMENT_INCORRECT_POLICY_STATUS_ERROR_CODE = "606";
	public static final String REVERSE_PAYMENT_INCORRECT_POLICY_STATUS_ERROR_DESC = "Pan status should be Failed";

	public static final String GENERAL_INVALID_TRANSACTION_EC = "0001";
	public static final String GENERAL_INVALID_TRANSACTION_ED = "Invalid Transaction";

	public static final String GENERAL_INVALID_PRODUCT_TYPE_EC = "0009";
	public static final String GENERAL_INVALID_PRODUCT_TYPE_ED = "Invalid Product Type";

	public static final String DIGITAL_PAYMENT_STATUS_ERROR_CODE = "809";
	public static final String DIGITAL_PAYMENT_STATUS_ERROR_DESC = "Cannot proceed to make wallet payment as the earlier payment is done or is in pending state";

	public static final String INVALID_AGENT_CODE = "608";
	public static final String INVALID_AGENT_DESC = "Invalid Agent";

	public static final String AGENT_BLOCKED_CODE = "609";
	public static final String AGENT_BLOCKED_ERROR_DESC = "Agent is blocked";

	public static final String AGENT_ID_EMPTY_NULL_CODE = "601";
	public static final String AGENT_ID_EMPTY_NULL_DESC = "Agent id cannot be null or empty";

	public static final String AGENT_ID_EMPTY_NULL_CODE2 = "604";
	public static final String AGENT_ID_EMPTY_NULL_DESC2 = "Agent is not existing in SOR database, failed to create inventoryy";

	public static final String REQUEST_EMPTY_NULL_CODE = "600";
	public static final String REQUEST_EMPTY_NULL_DESC = "Request cannot be null or empty";

	public static final String NOT_FOUND = "404";
	public static final String INVALID_PARAM = "422";
	public static final String PARAM_MISSING = "401";
	public static final String MESSAGE_ERROR = "408";
	public static final String AGENT_NOT_FOUND = "Agent not found";
	public static final String AGENT_BLOCKED = "Agent is blocked";
	public static final String INSUFFICENT_BALANACE = "Insufficient Balanace";
	public static final String EXCEPTION_CALCULATING_COMMISSION = "Error while calling product service";

	// Digital Payment Codes

	public static final String DIGITAL_PAYMENT_INVALID_STATUS_ERROR_CODE = "705";
	public static final String DIGITAL_PAYMENT_INVALID_STATUS_ERROR_DESC = "Invalid Status For Digital Payment";
	public static final String DIGITAL_PAYMENT_CANNOT_REVERSE_ACTIVE_TRANSACTION = "Cannot Reverse Active Digital Payment Transaction";

	public static final String DIGITAL_PAYMENT_UPI_ID_MISSING_ERROR_CODE = "706";
	public static final String DIGITAL_PAYMENT_UPI_ID_MISSING_ERROR_DESC = "Payment Transaction Id missing for Digital Payment";

	public static final String INVALID_DIGITAL_PAYMENT_ERROR_CODE = "707";
	public static final String INVALID_DIGITAL_PAYMENT_ERROR_DESC = "Invalid Digital Payment Transaction";

}
