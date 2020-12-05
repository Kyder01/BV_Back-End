package co.com.DR.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.DR.Entity.User;

@Repository
public interface iUserRepository extends JpaRepository<User, Integer> {
	
	

}
