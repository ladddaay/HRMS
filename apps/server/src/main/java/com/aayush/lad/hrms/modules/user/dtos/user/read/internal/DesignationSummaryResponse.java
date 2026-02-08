package com.aayush.lad.hrms.modules.user.dtos.user.read.internal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DesignationSummaryResponse {

    private Long id;

    private String name;
}
