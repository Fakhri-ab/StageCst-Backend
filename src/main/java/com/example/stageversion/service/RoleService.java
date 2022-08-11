package com.example.stageversion.service;

import com.example.stageversion.dao.RoleDao;
import com.example.stageversion.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }

    public List<Role> getAllRole(){
        return (List<Role>) roleDao.findAll();
    }

    //public void  deleteRole(int idRole){
      //  this.roleDao.deleteById(idRole);
    //}
}
