package com.microserviciologistic.deleteuser.repository;
import com.microserviciologistic.deleteuser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    @Modifying
    @Transactional
    @Query("UPDATE com.microserviciologistic.deleteuser.model.User u SET u.active = false WHERE u.id = :id")
    void softDeleteUser(@Param("id") UUID id);

}