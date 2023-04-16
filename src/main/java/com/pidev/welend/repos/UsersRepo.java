package com.pidev.welend.repos;

import java.util.List;
import java.util.Optional;

import com.pidev.welend.entities.UsersType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pidev.welend.entities.Users;



@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> {
	List<Users> findByRole(UsersType role);
	Optional<Users> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
	@Query (value= "Select * FROM users where email= :email", nativeQuery =true)
	Users getUserByEmail(@Param("email")String email);
	
}
