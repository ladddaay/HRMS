package com.aayush.lad.hrms.modules.user.controllers;

import com.aayush.lad.hrms.modules.user.dtos.department.read.DepartmentResponse;
import com.aayush.lad.hrms.modules.user.dtos.department.write.CreateDepartmentRequest;
import com.aayush.lad.hrms.modules.user.dtos.department.write.UpdateDepartmentRequest;
import com.aayush.lad.hrms.modules.user.services.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> getAll() {
        List<DepartmentResponse> departments = departmentService.getAll();
        return ResponseEntity.ok(departments);
    }

    @PostMapping
    public ResponseEntity<DepartmentResponse> create(@Valid @RequestBody CreateDepartmentRequest request) {
        DepartmentResponse response = departmentService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponse> update(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateDepartmentRequest request) {
        request.setId(id);
        DepartmentResponse response = departmentService.update(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        departmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
