package com.aayush.lad.hrms.modules.user.mappers;

import com.aayush.lad.hrms.modules.user.dtos.user.read.*;
import com.aayush.lad.hrms.modules.user.dtos.user.read.internal.*;
import com.aayush.lad.hrms.modules.user.dtos.user.write.*;
import com.aayush.lad.hrms.modules.user.models.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final ModelMapper modelMapper;

    // User mappers
    public User toEntity(RegisterUserRequest request) {
        return modelMapper.map(request, User.class);
    }

    public UserDetailResponse toDetailResponse(User user) {
        return modelMapper.map(user, UserDetailResponse.class);
    }

    public UserSummaryResponse toSummaryResponse(User user) {
        return modelMapper.map(user, UserSummaryResponse.class);
    }

    public List<UserDetailResponse> toDetailResponseList(List<User> users) {
        return users.stream()
                .map(this::toDetailResponse)
                .toList();
    }

    public List<UserSummaryResponse> toSummaryResponseList(List<User> users) {
        return users.stream()
                .map(this::toSummaryResponse)
                .toList();
    }

    // Profile mappers
    public Profile toEntity(CreateUserProfileRequest request) {
        return modelMapper.map(request, Profile.class);
    }

    public Profile updateEntity(UpdateSelfUserRequest request, Profile profile) {
        modelMapper.map(request, profile);
        return profile;
    }

    public Profile updateEntity(UpdateUserByAdminRequest request, Profile profile) {
        modelMapper.map(request, profile);
        return profile;
    }

    public ProfileResponse toProfileResponse(Profile profile) {
        return modelMapper.map(profile, ProfileResponse.class);
    }

    // Role mappers
    public UserRoleResponse toUserRoleResponse(Role role) {
        return modelMapper.map(role, UserRoleResponse.class);
    }

    public List<UserRoleResponse> toUserRoleResponseList(List<Role> roles) {
        return roles.stream()
                .map(this::toUserRoleResponse)
                .toList();
    }

    // Department mappers
    public DepartmentSummaryResponse toDepartmentSummaryResponse(Department department) {
        return modelMapper.map(department, DepartmentSummaryResponse.class);
    }

    // Designation mappers
    public DesignationSummaryResponse toDesignationSummaryResponse(Designation designation) {
        return modelMapper.map(designation, DesignationSummaryResponse.class);
    }

    // Manager mappers
    public ManagerSummaryResponse toManagerSummaryResponse(User user) {
        return modelMapper.map(user, ManagerSummaryResponse.class);
    }

    // Notification mappers
    public NotificationResponse toNotificationResponse(Notification notification) {
        return modelMapper.map(notification, NotificationResponse.class);
    }

    public List<NotificationResponse> toNotificationResponseList(List<Notification> notifications) {
        return notifications.stream()
                .map(this::toNotificationResponse)
                .toList();
    }

    public Set<NotificationResponse> toNotificationResponseSet(Set<Notification> notifications) {
        return notifications.stream()
                .map(this::toNotificationResponse)
                .collect(Collectors.toSet());
    }
}
