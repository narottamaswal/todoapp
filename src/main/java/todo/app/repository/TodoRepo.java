package todo.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import todo.app.dao.TodosList;

@Repository
public interface TodoRepo extends CrudRepository<TodosList, Integer> {

	public TodosList findById(Long id);
	
	public List<TodosList> findByUserId(Long id);
	

}