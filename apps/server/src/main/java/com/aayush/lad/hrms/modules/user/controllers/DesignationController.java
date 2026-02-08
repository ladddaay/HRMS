package com.aayush.lad.hrms.modules.user.controllers;

import com.aayush.lad.hrms.core.result.Result;
import com.aayush.lad.hrms.core.result.ResultMapper;
import com.aayush.lad.hrms.modules.user.dtos.designation.read.DesignationResponse;
import com.aayush.lad.hrms.modules.user.dtos.designation.write.CreateDesignationRequest;
import com.aayush.lad.hrms.modules.user.dtos.designation.write.UpdateDesignationRequest;
import com.aayush.lad.hrms.modules.user.services.DesignationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/designations")
@AllArgsConstructor
public class DesignationController {

    private final DesignationService designationService;

    @GetMapping
    public ResponseEntity<Result<List<DesignationResponse>>> getAll() {
        List<DesignationResponse> response = designationService.getAll();
        return ResultMapper.handle(HttpStatus.OK, response);
    }

    @PostMapping
    public ResponseEntity<Result<DesignationResponse>> create(
            @Valid @RequestBody CreateDesignationRequest request) {
        DesignationResponse response = designationService.create(request);
        return ResultMapper.handle(HttpStatus.CREATED, response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Result<DesignationResponse>> update(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateDesignationRequest request) {
        request.setId(id);
        DesignationResponse response = designationService.update(request);
        return ResultMapper.handle(HttpStatus.OK, response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result<Void>> delete(@PathVariable UUID id) {
        designationService.delete(id);
        return ResultMapper.handle(HttpStatus.NO_CONTENT);
    }
}
