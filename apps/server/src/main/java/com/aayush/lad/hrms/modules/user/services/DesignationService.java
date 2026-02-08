package com.aayush.lad.hrms.modules.user.services;

import com.aayush.lad.hrms.modules.user.dtos.designation.read.DesignationResponse;
import com.aayush.lad.hrms.modules.user.dtos.designation.write.CreateDesignationRequest;
import com.aayush.lad.hrms.modules.user.dtos.designation.write.UpdateDesignationRequest;
import com.aayush.lad.hrms.modules.user.mappers.DesignationMapper;
import com.aayush.lad.hrms.modules.user.models.Designation;
import com.aayush.lad.hrms.modules.user.repositories.DesignationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DesignationService {

    private final DesignationRepository designationRepository;
    private final DesignationMapper designationMapper;

    public DesignationResponse create(CreateDesignationRequest request) {
        if (designationRepository.existsByName(request.getName())) {
            throw new IllegalArgumentException("Designation with name '" + request.getName() + "' already exists");
        }
        Designation designation = designationMapper.toEntity(request);
        Designation savedDesignation = designationRepository.save(designation);
        return designationMapper.toResponse(savedDesignation);
    }

    public List<DesignationResponse> getAll() {
        List<Designation> designations = designationRepository.findAll();
        return designationMapper.toResponseList(designations);
    }

    public DesignationResponse getById(UUID id) {
        Designation designation = designationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Designation not found with id: " + id));
        return designationMapper.toResponse(designation);
    }

    public DesignationResponse update(UpdateDesignationRequest request) {
        Designation designation = designationRepository.findById(UUID.fromString(request.getId().toString()))
                .orElseThrow(() -> new IllegalArgumentException("Designation not found with id: " + request.getId()));

        if (!designation.getName().equals(request.getName()) && 
            designationRepository.existsByName(request.getName())) {
            throw new IllegalArgumentException("Designation with name '" + request.getName() + "' already exists");
        }

        designation.setName(request.getName());
        Designation updatedDesignation = designationRepository.save(designation);
        return designationMapper.toResponse(updatedDesignation);
    }

    public void delete(UUID id) {
        if (!designationRepository.existsById(id)) {
            throw new IllegalArgumentException("Designation not found with id: " + id);
        }
        // TODO: soft delete
        designationRepository.deleteById(id);
    }
}
