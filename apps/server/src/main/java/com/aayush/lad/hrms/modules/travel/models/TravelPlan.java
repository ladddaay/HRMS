package com.aayush.lad.hrms.modules.travel.models;

import com.aayush.lad.hrms.modules.user.models.User;
import com.aayush.lad.hrms.shared.base_models.AuditableModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "travel_plans")
@EqualsAndHashCode(callSuper = true)
public class TravelPlan extends AuditableModel {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String destination;

    private String description;

    private LocalDateTime startAt;

    private LocalDateTime endAt;

    private float maxExpenseAmountPerDay;

    @ManyToMany
    @JoinTable(
            name = "travel_plan_participants",
            joinColumns = @JoinColumn(name = "travel_plan_id"),
            inverseJoinColumns = @JoinColumn(name = "participant_id")
    )
    private Set<User> participants = new HashSet<>();

    @OneToMany(mappedBy = "travelPlan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<TravelPlanDocument> travelPlanDocuments = new HashSet<>();

    @OneToMany(mappedBy = "travelPlan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<TravelPlanExpense> expenses = new HashSet<>();
}
