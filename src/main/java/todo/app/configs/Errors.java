
package todo.app.configs;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "error_type", "error_description" })
public class Errors {

	@JsonProperty("error_type")
	private String errorType = null;
	@JsonProperty("error_description")
	private String errorDescription = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<>();

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Errors() {
	}

	/**
	 *
	 * @param errorDescription
	 */
	public Errors(String errorDescription, String errorType) {
		super();
		this.errorDescription = errorDescription;
		this.errorType = errorType;
	}

	@JsonProperty("error_type")
	public String getErrorType() {
		return errorType;
	}

	@JsonProperty("error_type")
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	@JsonProperty("error_description")
	public String getErrorDescription() {
		return errorDescription;
	}

	@JsonProperty("error_description")
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("errorDescription", errorDescription)
				.append("additionalProperties", additionalProperties).toString();
	}

}
