package com.tomik.RestApi.RestLastTask.reposetories;

import com.tomik.RestApi.RestLastTask.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesReposetories extends JpaRepository<Role, Integer> {
}
