package todo.app.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateTodo {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("title")
	@NotNull(message = "title cannot be blank or null")
	private String title;

	@JsonProperty("content")
	@NotNull(message = "content cannot be blank or null")
	private String content;

	@JsonProperty("username")
	@NotNull(message = "username cannot be blank or null")
	private String username;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
