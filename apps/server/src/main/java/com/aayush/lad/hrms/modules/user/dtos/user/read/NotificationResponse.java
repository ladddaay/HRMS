package com.aayush.lad.hrms.modules.user.dtos.user.read;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationResponse {

    private Long id;

    private String content;

    private Boolean isRead;

    private Long createdAt;
}
