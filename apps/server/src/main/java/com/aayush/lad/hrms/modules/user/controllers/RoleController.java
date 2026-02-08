package com.aayush.lad.hrms.modules.user.controllers;

import com.aayush.lad.hrms.modules.user.dtos.role.read.RoleResponse;
import com.aayush.lad.hrms.modules.user.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@AllArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public ResponseEntity<List<RoleResponse>> getAll() {
        List<RoleResponse> roles = roleService.getAll();
        return ResponseEntity.ok(roles);
    }
}
