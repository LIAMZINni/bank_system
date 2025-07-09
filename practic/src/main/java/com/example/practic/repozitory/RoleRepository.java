package com.example.practic.repozitory;

import com.example.practic.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String name);

    Role findByRoleId(int i);
}
