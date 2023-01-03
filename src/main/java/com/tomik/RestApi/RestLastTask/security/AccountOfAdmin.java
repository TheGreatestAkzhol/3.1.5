package com.tomik.RestApi.RestLastTask.security;

import com.tomik.RestApi.RestLastTask.models.Role;
import com.tomik.RestApi.RestLastTask.models.User;
import com.tomik.RestApi.RestLastTask.services.RoleService;
import com.tomik.RestApi.RestLastTask.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

/**
 * password - admin
 */
@Component
public class AccountOfAdmin {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AccountOfAdmin(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void admin() {
        User admin = new User("Ako","Serikbek",
                "admin", 22, "admin");
        Role roleUser  = new Role("ROLE_USER");
        Role roleAdmin  = new Role("ROLE_ADMIN");
        if (userService.userByUsername(admin.getUsername()).isEmpty()) {
            admin.setRoleList(new HashSet<>(Set.of(roleUser, roleAdmin)));
            roleService.saveAll(new HashSet<>(Set.of(roleUser, roleAdmin)));
            userService.save(admin);
        }
    }
}
