package com.example.stageversion.dao;

import com.example.stageversion.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao extends JpaRepository<Role,String> {
    Role findByRoleName(String roleName);


}
