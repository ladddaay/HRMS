package com.aayush.lad.hrms.modules.user.dtos.user.read;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSummaryResponse {

    private UUID id;

    private String email;

    private String userName;

    private String firstName;

    private String lastName;

    private String avatarUrl;
}
