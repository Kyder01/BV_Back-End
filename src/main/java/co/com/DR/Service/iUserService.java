package co.com.DR.Service;

import java.util.List;
import java.util.Optional;

import co.com.DR.Entity.User;

public interface iUserService {
	
	public Iterable<User> findAll();
	public Optional<User> findById(int id);
	public User save(User user);
	public void deleteById(int id);
}
