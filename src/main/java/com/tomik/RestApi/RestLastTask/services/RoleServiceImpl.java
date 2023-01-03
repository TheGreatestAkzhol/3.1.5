package com.tomik.RestApi.RestLastTask.services;

import com.tomik.RestApi.RestLastTask.dto.RoleDTO;
import com.tomik.RestApi.RestLastTask.models.Role;
import com.tomik.RestApi.RestLastTask.reposetories.RolesReposetories;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {
    private final RolesReposetories rolesReposetories;
    private final ModelMapper mapper;

    @Autowired
    public RoleServiceImpl(RolesReposetories rolesReposetories, ModelMapper mapper) {
        this.rolesReposetories = rolesReposetories;
        this.mapper = mapper;
    }
    @Transactional
    public void saveAll(Set<Role> roles) {
        rolesReposetories.saveAll(roles);
    }
    public Set<Role> findAllRoles() {
        return new HashSet<>(rolesReposetories.findAll());
    }

    @Override
    public Role convertToRole(RoleDTO roleDTO) {
        return mapper.map(roleDTO, Role.class);
    }

    @Override
    public RoleDTO convertToRoleDTO(Role role) {
        return mapper.map(role, RoleDTO.class);
    }

}
