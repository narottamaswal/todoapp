package todo.app.configs;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"errors",
"timestamp",
"uri"
})
public class ErrorInfo {

    @JsonProperty("errors")
    private Errors messages;

    @JsonProperty("timestamp")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date timestamp;

    @JsonProperty("uri")
    private String uriRequested;

    public ErrorInfo( Errors messages,String uriRequested) {
		super();
		this.messages = messages;
		this.uriRequested = uriRequested;
		 this.timestamp = new Date();
	}

    public Date getTimestamp() {
        return timestamp;
    }

    public String getUriRequested() {
        return uriRequested;
    }

	public Errors getMessages() {
		return messages;
	}


    
}
