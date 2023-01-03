package com.tomik.RestApi.RestLastTask.reposetories;

import com.tomik.RestApi.RestLastTask.models.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersReposetories extends JpaRepository<User, Integer> {
    @EntityGraph(value = "User.role", type = EntityGraph.EntityGraphType.LOAD)
    Optional<User> findByUsername(String username);
}
