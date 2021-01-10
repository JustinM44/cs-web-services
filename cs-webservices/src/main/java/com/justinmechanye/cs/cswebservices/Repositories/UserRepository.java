package com.justinmechanye.cs.cswebservices.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.justinmechanye.cs.cswebservices.Models.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	public User findByUsername(String username);
}
