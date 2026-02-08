package com.aayush.lad.hrms.modules.user.repositories;

import com.aayush.lad.hrms.modules.user.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, UUID> {

    boolean existsByName(String name);
}

