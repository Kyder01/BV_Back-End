package co.com.DR.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.DR.Entity.User;
import co.com.DR.Repository.iUserRepository;

@Service
public class UserServiceImp implements iUserService{
	
	@Autowired
	private iUserRepository userRepository;

	@Override
	@Transactional
	public List<User> findAll() {
		return userRepository.findAll();
	}
//	public Iterable<User> findAll() {
//		return userRepository.findAll();
//	}

	@Override
	@Transactional
	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}	
//	public Optional<User> findById(int id) {
//		return userRepository.findById(id);
//	}

	@Override
	@Transactional
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		userRepository.deleteById(id);
	}
	
}
