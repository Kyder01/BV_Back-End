package co.com.DR;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.IterableAssert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.DR.Entity.User;
import co.com.DR.Repository.iUserRepository;
import co.com.DR.Service.UserServiceImp;

@SpringBootTest
class BvBackEndApplicationTests {

	@Autowired
	private UserServiceImp userServiceImpMock;

	@Mock
	private iUserRepository userRepository;

//	@Test
//	public void findAllTest() {
//		Mockito.when(userRepository.findAll())
//				.thenReturn(Stream.of(new User(123, "Juan", "Perez", 321123), new User(456, "Jhon", "Smith", 654456))
//						.collect(Collectors.toList()));
//		assertEquals(2, userServiceImpMock.findAll().size());
//	}

//	@Test
//	public void findByIdTest() {
//		int id = 999;
//		boolean state = false;
//		Mockito.when(userRepository.findById(id)).thenReturn(Optional.empty());
//		assertEquals(Optional.empty(), userRepository.findById(id));
//	}

	@Test
	public void saveTest() {
		User user = new User(565, "Maria", "Goemz", 333555);
		Mockito.when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, userServiceImpMock.save(user));
	}

//	@Test
//	public void deleteByIdTest(User user) {
//		int id = 666;
//		User userD = new User(666, "Maria", "Goemz", 333555);
//		userRepository.save(userD);
//		verify(userServiceImpMock, userRepository.deleteById(id));
//		assertEquals(666, id);
//	}

}
