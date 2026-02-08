package com.aayush.lad.hrms.modules.user.mappers;

import com.aayush.lad.hrms.modules.user.dtos.department.read.DepartmentResponse;
import com.aayush.lad.hrms.modules.user.dtos.department.write.CreateDepartmentRequest;
import com.aayush.lad.hrms.modules.user.dtos.department.write.UpdateDepartmentRequest;
import com.aayush.lad.hrms.modules.user.models.Department;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DepartmentMapper {
    
    private final ModelMapper modelMapper;

    public Department toEntity(CreateDepartmentRequest request) {
        return modelMapper.map(request, Department.class);
    }

    public Department toEntity(UpdateDepartmentRequest request) {
        return modelMapper.map(request, Department.class);
    }

    public DepartmentResponse toResponse(Department department) {
        return modelMapper.map(department, DepartmentResponse.class);
    }

    public List<DepartmentResponse> toResponseList(List<Department> departments) {
        return departments.stream()
                .map(this::toResponse)
                .toList();
    }
}
