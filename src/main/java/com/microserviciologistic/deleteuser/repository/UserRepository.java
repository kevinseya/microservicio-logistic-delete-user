package com.microserviciologistic.deleteuser.repository;
import com.microserviciologistic.deleteuser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}