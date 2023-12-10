package todo.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import todo.app.dao.Users;

@Repository
public interface UsersRepo extends CrudRepository<Users, Integer> {

	public Users findById(String id);
	
	public Users findByUsername(String username);
	
	public Users findByUsernameAndId(String username, Long postId);

}