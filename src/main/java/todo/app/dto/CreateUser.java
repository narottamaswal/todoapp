package todo.app.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateUser {

	@JsonProperty("username")
	@NotBlank(message = "username cannot be blank or null")
	private String username;
	
	@JsonProperty("password")
	@NotBlank(message = "password cannot be blank or null")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
