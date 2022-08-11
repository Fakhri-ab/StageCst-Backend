package com.example.stageversion.controller;

import com.example.stageversion.entity.Role;
import com.example.stageversion.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping({"/createNewRole"})
    public Role createNewRole(@RequestBody Role role) {
        return roleService.createNewRole(role);
    }

    @GetMapping({"/getAllRole"})
    @ResponseBody
    public List<Role> getallRole(){
        return  (List<Role>) roleService.getAllRole();
    }

  //  @DeleteMapping("/deleteRole/{idRole}")
  //  @ResponseBody
  //  public void deleteRole(@PathVariable("idRole") int idRole) {
    //    roleService.deleteRole(idRole);
   // }
}
