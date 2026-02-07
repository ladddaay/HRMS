package com.aayush.lad.hrms.modules.jobs.models;

import com.aayush.lad.hrms.modules.jobs.enums.ReferralStatus;
import com.aayush.lad.hrms.modules.user.models.User;
import com.aayush.lad.hrms.shared.base_models.BaseModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "referral_status_audit")
@EqualsAndHashCode(callSuper = true)
public class ReferralStatusAudit extends BaseModel {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "referral_id", nullable = false)
    private Referral referral;

    @Column(nullable = false)
    private ReferralStatus movedTo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "moved_by_id", nullable = false)
    private User movedBy;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime movedAt;
}
