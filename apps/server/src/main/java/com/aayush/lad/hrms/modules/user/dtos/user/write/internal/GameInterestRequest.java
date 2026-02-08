package com.aayush.lad.hrms.modules.user.dtos.user.write.internal;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public class GameInterestRequest {
    @NotNull(message = "Game ID is required")
    private UUID gameId;
}
