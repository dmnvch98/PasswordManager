package com.example.passwordmanager.repositories;

import com.example.passwordmanager.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
