package co.com.DR.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.DR.Entity.User;
import co.com.DR.Repository.iUserRepository;
import co.com.DR.Service.iUserService;

@RestController
@RequestMapping("/test")
public class UserController {

	@Autowired
	private iUserService userService;
	
	iUserRepository userRepository;
	Optional<User> user;
	
	
	@GetMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public List<User> select(){
		List<User> usuarios = StreamSupport.stream(userService.findAll().spliterator(), false).collect(Collectors.toList());
		return usuarios;
	}
	
	@GetMapping("/findById/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Optional<User> findById(@PathVariable("id")int id){
		return userService.findById(id);
	}
	
	@GetMapping("/getAll")
	@CrossOrigin(origins = "http://localhost:4200")
	public Iterable<User> findAll(){
		return userService.findAll();
	}
	
	@PostMapping("/create")
	@CrossOrigin(origins = "http://localhost:4200")
	public User insert(@RequestBody User user) {
		return userService.save(user);
	}
	
	@PutMapping("/update/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public User update(@RequestBody User user, @PathVariable("id")int id) {
		System.out.println(user.toString());
		Optional<User> userO = userService.findById(id);
		userO.get().setNombre(user.getNombre());
		userO.get().setApellido(user.getApellido());
		userO.get().setCelular(user.getCelular());
		userService.save(user);
		return user;
	}
	
	@DeleteMapping("/deleteById/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public void delete(@PathVariable("id")int id) {
		userService.deleteById(id);
	}
	
}
