package com.tomik.RestApi.RestLastTask.services;

import com.tomik.RestApi.RestLastTask.dto.RoleDTO;
import com.tomik.RestApi.RestLastTask.models.Role;

import java.util.Set;

public interface RoleService {
    void saveAll(Set<Role> roles);
    Set<Role> findAllRoles();

    Role convertToRole(RoleDTO roleDTO);

    RoleDTO convertToRoleDTO(Role role);
}
