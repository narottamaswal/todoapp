package todo.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import todo.app.configs.ValidationException;
import todo.app.dao.TodosList;
import todo.app.dao.Users;
import todo.app.dto.CreateTodo;
import todo.app.repository.TodoRepo;
import todo.app.repository.UsersRepo;

@RequestMapping("/todos")
@RestController
public class ToDoController {

	@Autowired
	TodoRepo todoRepo;

	@Autowired
	UsersRepo userRepo;
	
	public static boolean isEmptyNull(String val) {
		return (null == val || val.trim().length() == 0 || val.trim().equalsIgnoreCase("NULL"));
	}
	
	@GetMapping("/")
	public Map<String,Object>  getAll(@RequestParam(name = "username", required = true) String username) {
		Users user=userRepo.findByUsername(username);
		if(user==null) {
			throw new ValidationException("User not found", "400");
		}
		List<TodosList> list1=todoRepo.findByUserId(user.getId());
		Map<String,Object> map = new HashMap<>();
		map.put("todos", list1);
		return map;
	}

	@PostMapping("/create")
	public TodosList createToDo(@RequestBody CreateTodo createTodo) {
		Users user=userRepo.findByUsername(createTodo.getUsername());
		if(user==null) {
			throw new ValidationException("User not found", "400");
		}
		TodosList todosList=new TodosList();
		todosList.setDescription(createTodo.getContent());
		todosList.setTitle(createTodo.getTitle());
		todosList.setUserId(user.getId());
		todosList=todoRepo.save(todosList);
		return todosList;
	}

	@PostMapping("/update")
	public TodosList updateToDo(@RequestBody CreateTodo createTodo) {
		Users user=userRepo.findByUsername(createTodo.getUsername());
		if(user==null) {
			throw new ValidationException("User not found", "400");
		}
		if(createTodo.getId()==null) {
			throw new ValidationException("Id is required to update", "400");
		}
		TodosList todosList=todoRepo.findById(createTodo.getId());
		if(todosList==null) {
			throw new ValidationException("Todo not found", "400");
		}
		todosList.setDescription(createTodo.getContent());
		todosList.setTitle(createTodo.getTitle());
		todosList=todoRepo.save(todosList);
		return todosList;
	}

	@PostMapping("/delete")
	public boolean deleteToDo(@RequestBody CreateTodo createTodo) {
		Users user=userRepo.findByUsername(createTodo.getUsername());
		if(user==null) {
			throw new ValidationException("User not found", "400");
		}
		TodosList todosList=todoRepo.findById(createTodo.getId());
		if(todosList==null) {
			throw new ValidationException("Todo not found", "400");
		}
		todoRepo.delete(todosList);
		return true;
	}
}
