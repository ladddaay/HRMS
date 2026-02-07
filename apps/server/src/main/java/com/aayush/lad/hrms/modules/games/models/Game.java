package com.aayush.lad.hrms.modules.games.models;

import com.aayush.lad.hrms.shared.base_models.AuditableModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "games")
@EqualsAndHashCode(callSuper = true)
public class Game extends AuditableModel {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int slotDuration;

    @Column(nullable = false)
    private int maxSlotPlayers;

    @Column(nullable = false)
    private LocalTime openTime;

    @Column(nullable = false)
    private LocalTime closeTime;

    @Column(nullable = false)
    private int currentCycleId = 0;

    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<GameSlot> gameSlots = new HashSet<>();

    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<UserGameStat> userGameStats = new HashSet<>();

    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<InterestedPlayersQueue> interestedPlayersQueues = new HashSet<>();
}
