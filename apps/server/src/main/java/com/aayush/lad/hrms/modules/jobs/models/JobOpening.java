package com.aayush.lad.hrms.modules.jobs.models;

import com.aayush.lad.hrms.modules.user.models.Designation;
import com.aayush.lad.hrms.modules.user.models.User;
import com.aayush.lad.hrms.shared.base_models.AuditableModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "job_openings")
@EqualsAndHashCode(callSuper = true)
public class JobOpening extends AuditableModel {

    @Column(nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "designation_id", nullable = false)
    private Designation designation;

    @Column(nullable = false)
    private float requiredExperience;

    private String jdUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "default_hr_id")
    private User defaultHr;

    @Column(nullable = false)
    private boolean isClosed = false;

    @ManyToMany
    @JoinTable(
            name = "job_opening_hrs",
            joinColumns = @JoinColumn(name = "job_opening_id"),
            inverseJoinColumns = @JoinColumn(name = "hr_id")
    )
    private Set<User> hrs = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "job_opening_reviewers",
            joinColumns = @JoinColumn(name = "job_opening_id"),
            inverseJoinColumns = @JoinColumn(name = "reviewer_id")
    )
    private Set<User> reviewers = new HashSet<>();

    @OneToMany(mappedBy = "jobOpening", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<JobOpeningShareAudit> shareAudits = new HashSet<>();

    @OneToMany(mappedBy = "jobOpening", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Referral> referrals = new HashSet<>();
}
