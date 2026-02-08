package com.aayush.lad.hrms.modules.user.dtos.user.write;

import java.time.LocalDate;
import java.util.UUID;

import com.aayush.lad.hrms.modules.user.enums.Gender;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateUserByAdminRequest {

    @NotNull(message = "User ID is required")
    private UUID userId;

    @NotBlank(message = "First name is required")
    private String firstName;

    private String middleName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    private String contactNumber;

    private LocalDate dateOfBirth;

    private Gender gender;

    private LocalDate joiningDate;

    private UUID departmentId;

    private UUID designationId;

    private UUID managerId;
}
