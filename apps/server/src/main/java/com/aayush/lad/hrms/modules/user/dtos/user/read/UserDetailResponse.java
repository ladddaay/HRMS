package com.aayush.lad.hrms.modules.user.dtos.user.read;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import com.aayush.lad.hrms.modules.user.dtos.user.read.internal.DepartmentSummaryResponse;
import com.aayush.lad.hrms.modules.user.dtos.user.read.internal.DesignationSummaryResponse;
import com.aayush.lad.hrms.modules.user.dtos.user.read.internal.GameInterestResponse;
import com.aayush.lad.hrms.modules.user.dtos.user.read.internal.ProfileResponse;
import com.aayush.lad.hrms.modules.user.dtos.user.read.internal.UserRoleResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDetailResponse {

    private UUID id;

    private String email;

    private String userName;

    private String firstName;

    private String middleName;

    private String lastName;

    private String contactNumber;

    private LocalDate joiningDate;

    private String avatarUrl;

    private ProfileResponse profile;

    private Set<UserRoleResponse> roles;

    private DepartmentSummaryResponse department;

    private DesignationSummaryResponse designation;

    private Set<GameInterestResponse> interestedInGames;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String createdBy;

    private String updatedBy;
}
