package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.skhu.entity.*;


public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);
}