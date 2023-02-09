package com.omer.CRUDSpring.repositories;

import com.omer.CRUDSpring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
